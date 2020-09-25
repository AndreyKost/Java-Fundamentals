import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Judge2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<String, Map<String, Integer>> contestUsers = new LinkedHashMap<>();


        while (!line.equals("no more time")) {
            String[] tokens = line.split(" -> ");
            String username = tokens[0];
            String contest = tokens[1];
            int points = Integer.parseInt(tokens[2]);

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
        AtomicInteger num = new AtomicInteger();

        contestUsers.entrySet().stream().forEach(e -> {
            num.set(1);
            System.out.printf("%s: %d participants%n", e.getKey(), e.getValue().size());
            e.getValue().entrySet().stream().sorted((first, second) -> {
                int result = second.getValue().compareTo(first.getValue());
                if (result == 0) {
                    result = first.getKey().compareTo(second.getKey());
                }
                return result;
            }).forEach(element -> {
                System.out.printf("%d. %s <::> %d%n", num.getAndIncrement(), element.getKey(), element.getValue());
            });
        });

        Map<String, Integer> stats = new LinkedHashMap<>();
        for (Map.Entry<String, Map<String, Integer>> entry : contestUsers.entrySet()) {
            for (Map.Entry<String, Integer> pts : entry.getValue().entrySet()){
                stats.putIfAbsent(pts.getKey(),0);
                stats.put(pts.getKey(),stats.get(pts.getKey())+pts.getValue());
            }
        }
        System.out.println("Individual standings:");
        num.set(1);
        stats.entrySet().stream().sorted((first, second) -> {
            int result = second.getValue().compareTo(first.getValue());
            if(result==0){
                result=first.getKey().compareTo(second.getKey());
            }
            return result;
        }).forEach(e -> {
            System.out.printf("%d. %s -> %d%n", num.getAndIncrement(), e.getKey(), e.getValue());
        });


    }
}
