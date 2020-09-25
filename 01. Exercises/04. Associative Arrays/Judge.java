import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<String, Map<String, Integer>> userContests = new LinkedHashMap<>();
        Map<String, Map<String, Integer>> contestUsers=new LinkedHashMap<>();


        while (!line.equals("no more time")) {
            String[] tokens = line.split(" -> ");
            String username = tokens[0];
            String contest = tokens[1];
            int points = Integer.parseInt(tokens[2]);


            if (userContests.containsKey(username)) {
                if (userContests.get(username).containsKey(contest)) {
                    if (userContests.get(username).get(contest) < points) {
                        userContests.get(username).put(contest, points);
                    }
                } else {
                    userContests.get(username).put(contest, points);
                }

            } else {
                userContests.put(username, new TreeMap<>());
                userContests.get(username).put(contest, points);
            }

            if (contestUsers.containsKey(contest)) {
                if (contestUsers.get(contest).containsKey(username)) {
                    if (contestUsers.get(contest).get(username) < points) {
                        contestUsers.get(contest).put(username, points);
                    }
                } else {
                    contestUsers.get(contest).put(username, points);
                }

            } else {
                contestUsers.put(contest, new TreeMap<>());
                contestUsers.get(contest).put(username, points);
            }

            line = scanner.nextLine();
        }
        AtomicInteger num=new AtomicInteger();

        contestUsers.entrySet().stream().forEach(e->{
            num.set(1);
            System.out.printf("%s: %d participants%n",e.getKey(),e.getValue().size());
            e.getValue().entrySet().stream().sorted((first,second)->{
                int result=second.getValue().compareTo(first.getValue());
                if(result==0){
                    result=first.getKey().compareTo(second.getKey());
                }
                return result;
            }).forEach(element->{
                System.out.printf("%d. %s <::> %d%n",num.getAndIncrement(),element.getKey(),element.getValue());
            });
        });


        int totalSum = 0;
        Map<String, Integer> indvidualStats = new TreeMap<>();
        for (Map.Entry<String, Map<String, Integer>> stringMapEntry : userContests.entrySet()) {
            totalSum = 0;
            Map<String, Integer> stats = stringMapEntry.getValue();
            for (Map.Entry<String, Integer> integerEntry : stats.entrySet()) {
                totalSum += integerEntry.getValue();
            }
            indvidualStats.put(stringMapEntry.getKey(), totalSum);
        }

        System.out.println("Individual standings:");
        num.set(1);
        indvidualStats.entrySet().stream().sorted((first, second) -> {
            int result = second.getValue().compareTo(first.getValue());
            return result;
        }).forEach(e -> {
            System.out.printf("%d. %s -> %d%n",num.getAndIncrement(), e.getKey(), e.getValue());
        });



    }
}

