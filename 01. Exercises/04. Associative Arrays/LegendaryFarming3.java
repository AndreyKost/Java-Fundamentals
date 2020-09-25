import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
public class LegendaryFarming3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean end = false;
        Map<String, Integer> keyMaterials = new TreeMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        Map<String, Integer> junk = new TreeMap<>();
        while (!end) {
            String[] tokens = scanner.nextLine().toLowerCase().split(" ");
            for (int i = 0; i < tokens.length; i+=2) {
                int value = Integer.parseInt(tokens[i]);
                String material = tokens[i + 1];

                if (keyMaterials.containsKey(material)) {
                    keyMaterials.put(material,keyMaterials.get(material) + value);
                    if (keyMaterials.get(material) >= 250) {
                        end = true;
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        if (material.equalsIgnoreCase("shards")) {
                            System.out.println("Shadowmourne obtained!");
                        } else if (material.equalsIgnoreCase("fragments")) {
                            System.out.println("Valanyr obtained!");
                        } else if (material.equalsIgnoreCase("motes")) {
                            System.out.println("Dragonwrath obtained!");
                        }
                    }

                } else {
                    if (junk.containsKey(material)) {
                        junk.put(material, junk.get(material) + value);
                    } else {
                        junk.put(material, value);
                    }
                }
                if (end) {
                    break;
                }
            }
        }

        keyMaterials.entrySet().stream().sorted((first, second)-> {
            int result= second.getValue().compareTo(first.getValue());
            if(result==0){
                result= first.getKey().compareTo(second.getKey());
            }
            return result;
        }).forEach(entry -> {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        });

        for (Map.Entry<String, Integer> entry : junk.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }


    }
}
