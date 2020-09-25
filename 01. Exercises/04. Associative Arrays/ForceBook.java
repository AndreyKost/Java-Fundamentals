import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input =scanner.nextLine();
        Map<String, List<String>> forseBook=new LinkedHashMap<>();


        while (!input.equalsIgnoreCase("Lumpawaroo")){
            String[] tokens=Arrays.stream(input.split("\\s+\\|\\s+|\\s+->\\s+")).toArray(String[]::new);


            if(input.contains("|")){
                String forceSide=tokens[0];
                String forceUser=tokens[1];
                boolean isEqual=false;
                for (Map.Entry<String, List<String>> entry : forseBook.entrySet()) {
                    List<String> users=entry.getValue();
                    for(String user : users){
                        if(user.equals(forceUser)){
                            isEqual=true;
                        }
                    }
                }

                if(!isEqual) {
                    if (forseBook.containsKey(forceSide)) {
                        forseBook.get(forceSide).add(forceUser);
                    } else {
                        forseBook.put(forceSide, new ArrayList<>());
                        forseBook.get(forceSide).add(forceUser);
                    }
                }

            } else {
                String forceUser=tokens[0];
                String forceSide=tokens[1];
                boolean isEqual=false;
                for (Map.Entry<String, List<String>> entry : forseBook.entrySet()) {
                        List<String> users=entry.getValue();
                        for(String user : users){
                            if(user.equals(forceUser)){
                                isEqual=true;
                                forseBook.get(entry.getKey()).remove(user);
                                if(forseBook.containsKey(forceSide)) {
                                    forseBook.get(forceSide).add(forceUser);
                                } else {
                                    forseBook.put(forceSide, new ArrayList<>());
                                    forseBook.get(forceSide).add(forceUser);
                                }
                                System.out.printf("%s joins the %s side!%n",forceUser,forceSide);
                            }
                            if(isEqual){
                                break;
                            }
                        }
                }

                if(!isEqual) {
                    if (forseBook.containsKey(forceSide)) {
                        forseBook.get(forceSide).add(forceUser);
                    } else {
                        forseBook.put(forceSide, new ArrayList<>());
                        forseBook.get(forceSide).add(forceUser);
                    }
                    System.out.printf("%s joins the %s side!%n",forceUser,forceSide);
                }
            }

            input=scanner.nextLine();
        }


        forseBook.entrySet().stream().sorted((first,second)->{
            int result=Integer.compare(second.getValue().size(),first.getValue().size());
            if(result==0){
                result=first.getKey().compareTo(second.getKey());
            }
                    return result;
                }
                ).forEach(entry-> {
                    if(entry.getValue().size()>0) {
                        System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
                    }
            List<String> strings=entry.getValue();
            Collections.sort(strings);
            for(String str : strings){
                System.out.printf("! %s%n",str);
            }

        });



    }
}
