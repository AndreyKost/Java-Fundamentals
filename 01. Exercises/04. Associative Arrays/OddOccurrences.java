import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] words=scanner.nextLine().split(" ");
        Map<String, Integer> oddWords=new LinkedHashMap<>();

        for (String word : words ) {
            word=word.toLowerCase();
            if(oddWords.containsKey(word)){
                Integer count=oddWords.get(word);
                oddWords.put(word,count+1);
            } else {
                oddWords.put(word,1);
            }
        }

        List<String> odd=new ArrayList<>();
        for (Map.Entry<String, Integer> entry : oddWords.entrySet()) {
            if(entry.getValue()%2!=0){
                //System.out.printf("%s, ",entry.getKey());
                odd.add(entry.getKey());
            }
        }

        for (int i = 0; i <odd.size()-1 ; i++) {
            System.out.printf("%s, ",odd.get(i));
        }
        System.out.printf(odd.get(odd.size()-1));

    }
}
