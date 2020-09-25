import java.util.*;

public class WordsSynonyms {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        List<String> synonyms=new ArrayList<>();
        Map<String, List<String>> wordsSynonyms=new TreeMap<>();
        while (n>0){
            String word=scanner.nextLine();
            String synonym=scanner.nextLine();
            synonyms.add(synonym);
            if(wordsSynonyms.containsKey(word)){
                wordsSynonyms.put(word,synonyms);
            } else {
                wordsSynonyms.put(word,synonyms);
            }

            n--;
        }


        for (Map.Entry<String, List<String>> entry : wordsSynonyms.entrySet()) {
            System.out.print(entry.getKey()+" - ");
            synonyms=entry.getValue();
            System.out.print(String.join(", ",synonyms));
        }


    }
}
