import java.util.*;

public class PracticeSessions {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line=scanner.nextLine();
        Map<String, List<String>> roadRacers=new LinkedHashMap<>();


        while (!line.equals("END")){
        String[] tokens=line.split("->");
        String command=tokens[0];
        if(command.equals("Add")){
            String road=tokens[1];
            String racer=tokens[2];
            if(roadRacers.containsKey(road)){
                roadRacers.get(road).add(racer);
            } else {
                roadRacers.put(road,new ArrayList<>());
                roadRacers.get(road).add(racer);
            }
        }
        if(command.equals("Move")){
            String currentRoad=tokens[1];
            String racer=tokens[2];
            String nextRoad=tokens[3];
            if(roadRacers.get(currentRoad).contains(racer)){
                roadRacers.get(nextRoad).add(racer);
                roadRacers.get(currentRoad).remove(racer);
            }
        }
        if(command.equals("Close")){
            String road=tokens[1];
            if(roadRacers.containsKey(road)){
                roadRacers.remove(road);
            }
        }

            line=scanner.nextLine();
        }

        System.out.println("Practice sessions:");
        roadRacers.entrySet().stream().sorted((first,second)->{
            int result=Integer.compare(second.getValue().size(),first.getValue().size());
            if(result==0){
                result=first.getKey().compareTo(second.getKey());
            }
            return result;
        }).forEach(e->{
            System.out.printf("%s%n",e.getKey());
            List<String> pts=e.getValue();
            for (int i = 0; i <pts.size() ; i++) {
                System.out.printf("++%s%n",pts.get(i));
            }


        });


    }
}
