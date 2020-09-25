import java.util.*;

public class Ranking2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line =scanner.nextLine();
        Map<String, String> contests=new LinkedHashMap<>();
        Map<String, Map<String, Integer>> contestUsers=new TreeMap<>();

        while (!line.equals("end of contests")){
            String[] tokens=line.split(":");
            String contest=tokens[0];
            String password=tokens[1];
            contests.put(contest,password);
            line=scanner.nextLine();
        }
        String input=scanner.nextLine();

        while (!input.equals("end of submissions")){
            String[] tokens=input.split("=>");
            String contest=tokens[0];
            String password=tokens[1];
            String user=tokens[2];
            int points=Integer.parseInt(tokens[3]);

            if(contests.containsKey(contest) && contests.get(contest).equals(password)) {
                if (contestUsers.containsKey(user)){
                    if(contestUsers.get(user).containsKey(contest)){
                        if(contestUsers.get(user).get(contest)<points){
                            contestUsers.get(user).put(contest,points);
                        }
                    }
                    else {
                        contestUsers.get(user).put(contest,points);
                    }
                } else {
                    contestUsers.put(user, new TreeMap<>());
                    contestUsers.get(user).put(contest,points);
                }
            }
            input=scanner.nextLine();
        }

        Map<String, Integer> bestUser=new LinkedHashMap<>();

        int sumPoints=0;
        for (Map.Entry<String, Map<String, Integer>> stringMapEntry : contestUsers.entrySet()) {
            sumPoints=0;
            Map<String, Integer> points=stringMapEntry.getValue();
            for (Map.Entry<String, Integer> integerEntry : points.entrySet()) {
                sumPoints+=integerEntry.getValue();
            }
            bestUser.put(stringMapEntry.getKey(),sumPoints);
        }

        int max= Integer.MIN_VALUE;
        String name="";
        for (Map.Entry<String, Integer> entry : bestUser.entrySet()) {
            if(entry.getValue()>max){
                max=entry.getValue();
                name=entry.getKey();
            }
        }
        System.out.printf("Best candidate is %s with total %d points.%n",name,max);
        System.out.println("Ranking: ");
        for (Map.Entry<String, Map<String, Integer>> entry : contestUsers.entrySet()) {
            Map<String, Integer> users=entry.getValue();
            System.out.println(entry.getKey());
            users.entrySet().stream().sorted((first,second)->{
                int result=second.getValue().compareTo(first.getValue());
                return result;
            }).forEach((e)->{
                System.out.printf("#  %s -> %d%n",e.getKey(),e.getValue());
            });


        }


    }
}
