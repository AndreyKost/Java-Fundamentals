import java.util.*;
import java.util.stream.Collectors;

public class TheFinalQuest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String> words= Arrays.stream(scanner.nextLine()
        .split(" "))
        .collect(Collectors.toList());

        String line=scanner.nextLine();

        while(!line.equals("Stop")){
            String[] commands=line.split(" ");
            String command=commands[0];

            if(command.equals("Delete")){
                int index=Integer.parseInt(commands[1]);
                if(index >=0 && index<words.size()-1){
                    words.remove(index+1);
                }
            } else if(command.equals("Swap")){
                String word1=commands[1];
                String word2=commands[2];
                if(words.contains(word1) && words.contains(word2)){
                    int index1=words.indexOf(word1);
                    int index2=words.indexOf(word2);
                    words.set(index1,word2);
                    words.set(index2,word1);
                }
            } else if(command.equals("Put")){
                String word=commands[1];
                int index=Integer.parseInt(commands[2]);
                 if(index-1>=0 && index-1<=words.size()){
                    words.add(index-1,word);
                }
            } else if(command.equals("Sort")){
                Collections.sort(words);
                Collections.reverse(words);
            } else if(command.equals("Replace")){
                String word1=commands[1];
                String word2=commands[2];
                if(words.contains(word2)){
                    int index=words.indexOf(word2);
                    words.set(index,word1);
                }
            }
            line=scanner.nextLine();
        }


        for(int i=0;i<words.size()-1;i++){
            System.out.printf("%s ",words.get(i));
        }
        System.out.printf("%s",words.get(words.size()-1));


    }
}
