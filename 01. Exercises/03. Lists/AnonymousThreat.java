import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String> words= Arrays.stream(scanner.nextLine()
                .split(" "))
                .collect(Collectors.toList());

        List<String> words2=new ArrayList<>();

        String[] tokens=scanner.nextLine().split(" ");

        while(!tokens[0].equals("3:1")){

            if(tokens[0].equals("merge")){
                int startIndex=Integer.parseInt(tokens[1]);
                int endIndex=Integer.parseInt(tokens[2]);
                String str="";

                    if(endIndex>=words.size()) {
                        endIndex = words.size() - 1;
                    }
                    if(startIndex<0){
                        startIndex=0;
                    }
                    if(startIndex<endIndex) {
                        for (int i = startIndex; i <= endIndex; i++) {
                            str += words.get(startIndex);
                            words.remove(startIndex);
                        }
                        words.add(startIndex, str);
                    }
            } else {
                int index=Integer.parseInt(tokens[1]);
                int partitions=Integer.parseInt(tokens[2]);
                boolean result=words.get(index).length()%partitions==0;
                String st="";

                if(result){
                    String word=words.get(index);
                    int division=words.get(index).length()/partitions;
                    int b=index;
                    words.remove(b);
                        for (int a = 0; a < division * partitions; a = a + division) {
                            st="";
                            int j=0;
                            while(j<division){
                                st = st + "" + word.charAt(a+j);
                                j++;
                            }
                            words.add(b,st);
                            words2.add(st);
                            b++;
                        }

                } else {
                    String word=words.get(index);
                    List<String> symbols=new ArrayList<>();
                    for (int i = 0; i <word.length() ; i++) {
                        String symbol="";
                        symbol=symbol+word.charAt(i);
                        symbols.add(symbol);
                    }
                    int b=index;
                    int division=words.get(index).length()/partitions;
                    int insteadOfDevision=division;
                    words.remove(b);
                    for (int a = 0; a <partitions-1 ; a++) {
                        st="";
                        int j=0;
                        while(j<division){
                            st=st+""+symbols.get(j);
                            j++;
                        }
                        while(division>0){
                            symbols.remove(0);
                            division--;
                        }
                        division=insteadOfDevision;
                        words.add(b,st);
                        words2.add(st);
                        b++;
                    }
                    st="";
                    for (int a = 0; a <symbols.size() ; a++) {
                        st=st+""+symbols.get(a);
                    }
                    words.add(b,st);
                }

            }

             tokens=scanner.nextLine().split(" ");
        }

        for(String word : words){
            System.out.print(word +" ");
        }


    }
}
