import java.util.*;

public class WordsSynonyms2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int wordsSynonymPairs=scanner.nextInt();
        Map<String, List<String>> wordSynonyms=new TreeMap<>();

        for (int i = 0; i <wordsSynonymPairs ; i++) {
            String word=scanner.next();
            String currentSynonym=scanner.next();

            List<String> synonyms= wordSynonyms.get(word);
            if(synonyms==null){
                synonyms=new ArrayList<>();
                wordSynonyms.put(word, synonyms);
            }
            synonyms.add(currentSynonym);

        }

        for (Map.Entry<String, List<String>> entry : wordSynonyms.entrySet()) {
            System.out.print(entry.getKey()+" - ");
            List<String> synonyms=entry.getValue();
            System.out.print(String.join(", ",synonyms));
            System.out.println();
        }


    }
}
