import java.util.*;

public class LegendaryFarming2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String winner = "";
        boolean end = false;
        int n = 0;
        TreeMap<String, Integer> materials = new TreeMap<>();
        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);
        TreeMap<String, Integer> junk = new TreeMap<>();
        while (!end) {
            String[] input = scan.nextLine().toLowerCase().split("\\s+");

            for (int i = 0; i < input.length; i += 2) {
                n = Integer.parseInt(input[i]);
                String material = input[i + 1];
                if (materials.containsKey(material)){
                    materials.put(material,materials.get(material)+n);
                    if (materials.get(material) >= 250) {
                        materials.put(material,materials.get(material)-250);
                        end = true;
                        if (material.equalsIgnoreCase("shards")){
                            winner="Shadowmourne";
                        }else  if (material.equals("fragments")){
                            winner = "Valanyr";
                        }else if (material.equals("motes")){
                            winner="Dragonwrath";
                        }
                    }
                }else {
                    if (junk.containsKey(material)) {
                        junk.put(material, junk.get(material) + n);
                    } else {
                        junk.put(material, n);
                    }
                }


                if (end) break;
            }

        }
        System.out.println(winner + " obtained!");
        materials.entrySet().stream().sorted((first, second)-> {
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
