import java.util.*;

public class MessageManager {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int capacity=Integer.parseInt(scanner.nextLine());

        Map<String, List<Integer>> userMessages=new LinkedHashMap<>();

        String line=scanner.nextLine();
        while (!line.equals("Statistics")){
            String[] tokens=line.split("=");
            String command=tokens[0];
            if(command.equals("Add")){
                String userName=tokens[1];
                int sent=Integer.parseInt(tokens[2]);
                int received=Integer.parseInt(tokens[3]);
                if(!userMessages.containsKey(userName)){
                    userMessages.put(userName,new ArrayList<>());
                    userMessages.get(userName).add(sent);
                    userMessages.get(userName).add(received);
                }
            }
            if(command.equals("Message")){
                String sender=tokens[1];
                String receiver=tokens[2];
                if(userMessages.containsKey(sender) && userMessages.containsKey(receiver)){
                    int senderSentMsg=userMessages.get(sender).get(0)+1;
                    userMessages.get(sender).set(0,senderSentMsg);
                    if(userMessages.get(sender).get(0)+userMessages.get(sender).get(1)>=capacity){
                        userMessages.remove(sender);
                        System.out.printf("%s reached the capacity!%n",sender);
                    }
                    int receiverRecMsg=userMessages.get(receiver).get(1)+1;
                    userMessages.get(receiver).set(1,receiverRecMsg);
                    if(userMessages.get(receiver).get(0)+userMessages.get(receiver).get(1)>=capacity){
                        userMessages.remove(receiver);
                        System.out.printf("%s reached the capacity!%n",receiver);
                    }
                }

            }
            if(command.equals("Empty")){
                String userName=tokens[1];
                if(userName.equals("All")){
                    userMessages.clear();
                } else {
                    userMessages.remove(userName);
                }

            }


            line=scanner.nextLine();
        }

        System.out.println("Users count: "+userMessages.size());
        userMessages.entrySet().stream().sorted((first,second)->{
            int result=second.getValue().get(1).compareTo(first.getValue().get(1));
            if(result==0){
                result=first.getKey().compareTo(second.getKey());
            }
            return result;
        }).forEach(e->{
            System.out.printf("%s - %d%n",e.getKey(),e.getValue().get(0)+e.getValue().get(1));


        });



    }
}
