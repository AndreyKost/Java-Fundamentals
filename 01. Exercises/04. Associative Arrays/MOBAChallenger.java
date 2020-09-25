import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MOBAChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<String, Map<String, Integer>> playerPool = new TreeMap<>();

        while (!line.equals("Season end")) {
            String[] tokens = line.split("\\s+->\\s+|\\s+vs\\s+");
            if (line.contains(" -> ")) {
                String player = tokens[0].replaceAll("\\s+","");
                String position = tokens[1].replaceAll("\\s+","");;
                int skill = Integer.parseInt(tokens[2]);

                if (playerPool.containsKey(player)) {
                    if (playerPool.get(player).containsKey(position)) {
                        if (playerPool.get(player).get(position) < skill) {
                            playerPool.get(player).put(position, skill);
                        }
                    } else {
                        playerPool.get(player).put(position, skill);
                    }
                } else {
                    playerPool.put(player, new TreeMap<>());
                    playerPool.get(player).put(position, skill);
                }
            } else {
                String player1 = tokens[0].replaceAll("\\s+","");;
                String player2 = tokens[1].replaceAll("\\s+","");;
                if (playerPool.containsKey(player1) && playerPool.containsKey(player2)) {
                    for (Map.Entry<String, Integer> entry1 : playerPool.get(player1).entrySet()) {
                        for (Map.Entry<String, Integer> entry2 : playerPool.get(player2).entrySet()) {
                            if (entry1.getKey().equals(entry2.getKey())) {
                                if (entry1.getValue() > entry2.getValue()) {
                                    playerPool.remove(player2);
                                } else if (entry1.getValue() < entry2.getValue()) {
                                    playerPool.remove(player1);
                                }
                            }
                        }
                    }
                }
            }
            line = scanner.nextLine();
        }

        Map<String, Integer> stats=new TreeMap<>();
        int sum=0;
        for (Map.Entry<String, Map<String, Integer>> entry : playerPool.entrySet()) {
            sum=0;
            for(Map.Entry<String, Integer> pts : entry.getValue().entrySet()){
                sum=0;
                sum+=pts.getValue();
                if (stats.containsKey(entry.getKey())) {
                    stats.put(entry.getKey(),stats.get(entry.getKey())+sum);
                }
                else {
                    stats.put(entry.getKey(),sum);
                }
            }
        }

        stats.entrySet().stream().sorted((first,second)->{
            int result=second.getValue().compareTo(first.getValue());
            if(result==0){
                result=first.getKey().compareTo(second.getKey());
            }
            return result;
        }).forEach(e->{
            System.out.printf("%s: %d skill%n",e.getKey(),e.getValue());

            playerPool.get(e.getKey()).entrySet().stream().sorted((e1,e2)->{
                int res=e2.getValue().compareTo(e1.getValue());
                if(res==0){
                    res=e1.getKey().compareTo(e2.getKey());
                }
                return res;
            }).forEach(element->{
                System.out.printf("- %s <::> %d%n",element.getKey(),element.getValue());
            });
        });




    }
}
