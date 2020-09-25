

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        TreeMap<String, Integer> materials=new TreeMap<>();
        materials.put("shards",0);
        materials.put("fragments",0);
        materials.put("motes",0);
        Map<String, Integer> junk=new TreeMap<>();
        List<String> normalWords=new ArrayList<>();
        boolean end=false;

        while (!end){
            String[] commands=scanner.nextLine().toLowerCase().split(" ");


            for (int i=0;i<commands.length;i+=2) {
                Integer value=Integer.parseInt(commands[i]);
                String key=commands[i+1];


                if(materials.containsKey(key)){
                    Integer count=materials.get(key);
                    materials.put(key,count+value);
                    if(materials.get(key)>=250){
                        materials.put(key,materials.get(key)-250);
                        if(key.equalsIgnoreCase("Shards")){
                            System.out.println("Shadowmourne obtained!");
                            end=true;
                        }
                        if(key.equalsIgnoreCase("Fragments")){
                            System.out.println("Valanyr obtained!");
                            end=true;
                        }
                        if(key.equalsIgnoreCase("Motes")){
                            System.out.println("Dragonwrath obtained!");
                            end=true;
                        }
                    }
                } else {
                    if(junk.containsKey(key)){
                        Integer count=junk.get(key);
                        junk.put(key,count+value);
                    }else {
                        junk.put(key, value);
                    }
                }

                if(end){
                    break;
                }
            }
        }



        materials.entrySet().stream().sorted((c1, c2) ->{if (c1.getValue() == c2.getValue()){return c1.getKey().compareTo(c2.getKey());}
        else {return c2.getValue() - c1.getValue();}}).forEach(p-> System.out.printf("%s: %d%n",p.getKey(),p.getValue()));

        junk.entrySet().forEach(p -> System.out.println(p.getKey() + ": " + p.getValue()));

    }
}
