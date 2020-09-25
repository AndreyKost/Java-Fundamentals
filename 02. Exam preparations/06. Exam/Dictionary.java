
import java.util.*;

public class Dictionary {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line=scanner.nextLine();
        String[] commands=line.split(" \\| ");

        Map<String, List<String>> dictionary=new TreeMap<>();

        for (String command : commands) {
            String[] tokens=command.split(": ");
            String name=tokens[0];

            if(dictionary.containsKey(name)){
                for (int i = 1; i <tokens.length ; i++) {
                    if(!dictionary.get(name).contains(tokens[i])){
                        dictionary.get(name).add(tokens[i]);
                    }
                }
            } else {
                dictionary.put(name,new ArrayList<>());
                for (int i = 1; i <tokens.length ; i++) {
                    dictionary.get(name).add(tokens[i]);
                }
            }
        }

        String anotherLine=scanner.nextLine();
        String endOrList=scanner.nextLine();
        String[] otherTokens=anotherLine.split("\\s+\\|\\s+");
        List<String> words=new ArrayList<>();
        for (String otherToken : otherTokens) {
            words.add(otherToken);
        }


        for (Map.Entry<String, List<String>> entry : dictionary.entrySet()) {
            if(words.contains(entry.getKey())){
                System.out.println(entry.getKey());
                List<String> miniWords=entry.getValue();
               miniWords.stream().sorted((first,second)->{
                   int result=Integer.compare(second.length(),first.length());
                   return result;
               }).forEach(e->{
                   System.out.printf(" -%s%n",e);
               });
            }
        }

        if(endOrList.equals("List")){
            for (Map.Entry<String, List<String>> entry : dictionary.entrySet()) {
                System.out.printf("%s ",entry.getKey());
            }

        }



    }
}
