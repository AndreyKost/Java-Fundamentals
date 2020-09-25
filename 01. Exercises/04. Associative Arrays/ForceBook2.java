import java.util.*;

public class ForceBook2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input =scanner.nextLine();
        Map<String, List<String>> forseBook=new LinkedHashMap<>();


        while (!input.equalsIgnoreCase("Lumpawaroo")){
            String[] tokens=input.split(" ");
            String symbol=tokens[1];
            if(symbol.equalsIgnoreCase("|")){
                String[] commands=scanner.nextLine().split(" | ");
                String forceSide=commands[0];
                String forceUser=commands[1];
                boolean isEqual=false;

                for (Map.Entry<String, List<String>> entry : forseBook.entrySet()) {
                    List<String> names=entry.getValue();
                    for(String name : names){
                        if(name.equalsIgnoreCase(forceUser)){
                            isEqual=true;
                            //forseBook.get(entry.getKey()).remove(name);
                        }
                    }
                }
                if(!isEqual){
                    if(forseBook.containsKey(forceSide)){
                        forseBook.get(forceSide).add(forceUser);
                    } else {
                        forseBook.put(forceSide,new ArrayList<>());
                        forseBook.get(forceSide).add(forceUser);
                    }
                }
            } else {
                String[] commands=scanner.nextLine().split(" -> ");
                String forceUser=commands[0];
                String forceSide=commands[1];
                for (Map.Entry<String, List<String>> entry : forseBook.entrySet()) {
                    List<String> names=entry.getValue();
                    for(String name : names){
                        if(name.equalsIgnoreCase(forceUser)){
                            forseBook.get(entry.getKey()).remove(name);
                        }
                    }
                }
                if(forseBook.containsKey(forceSide)){
                    forseBook.get(forceSide).add(forceUser);
                } else {
                    forseBook.put(forceSide,new ArrayList<>());
                    forseBook.get(forceSide).add(forceUser);
                }

                System.out.printf("%s joins the %s side!%n",forceUser, forceSide);
            }

            input=scanner.nextLine();
        }

        System.out.println("dsfAFA");


    }
}
