import java.util.*;

public class Concert {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Map<String, List<String>> bandMembers=new LinkedHashMap<>();
        Map<String, Integer> bandTime=new LinkedHashMap<>();
        String line=scanner.nextLine();

        while (!line.equals("start of concert")){
            String[] tokens=line.split("; ");
            String command=tokens[0];
            String bandName=tokens[1];

            if(command.equals("Add")){
                String[] members=tokens[2].split(", ");
                if(bandMembers.containsKey(bandName)){
                    for (int i = 0; i <members.length ; i++) {
                        if(!bandMembers.get(bandName).contains(members[i])){
                            bandMembers.get(bandName).add(members[i]);
                        }
                    }
                } else {
                    bandMembers.put(bandName,new ArrayList<>());
                    for (int i = 0; i <members.length ; i++) {
                    bandMembers.get(bandName).add(members[i]);
                    }
                }
                if(!bandTime.containsKey(bandName)){
                    bandTime.put(bandName,0);
                }
            } else {
                int time=Integer.parseInt(tokens[2]);
                if(bandTime.containsKey(bandName)){
                    bandTime.put(bandName,bandTime.get(bandName)+time);
                } else {
                    bandTime.put(bandName,time);

                }
            }
            line=scanner.nextLine();
        }

        String bandToInsert=scanner.nextLine();

        int totalTime=0;
        for (Map.Entry<String, Integer> entry : bandTime.entrySet()) {
            totalTime+=entry.getValue();
        }
        System.out.printf("Total time: %d%n",totalTime);

        bandTime.entrySet().stream().sorted((first,second)->{
            int result=second.getValue().compareTo(first.getValue());
            if(result==0){
                result=first.getKey().compareTo(second.getKey());
            }
            return result;
        }).forEach(e->{
            System.out.printf("%s -> %d%n",e.getKey(),e.getValue());
        });

        System.out.println(bandToInsert);
        for (Map.Entry<String, List<String>> entry : bandMembers.entrySet()) {
            if(entry.getKey().equals(bandToInsert)){
                List<String> gets=entry.getValue();
                for (String get : gets) {
                    System.out.printf("=> %s%n",get);
                }
            }
        }




    }
}
