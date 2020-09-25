import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> wordCounts=new LinkedHashMap<>();
        String[] words = scanner.nextLine().split(" ");
        String line = "";
        for (int i = 0; i < words.length; i++) {
            line = line + "" + words[i];
        }


        for (int i = 0; i <line.length() ; i++) {
            char symbol=line.charAt(i);
            if(wordCounts.containsKey(symbol)){
                Integer count=wordCounts.get(symbol);
                wordCounts.put(symbol,count+1);
            } else {
                wordCounts.put(symbol,1);
            }
        }

        for (Map.Entry<Character, Integer> entry : wordCounts.entrySet()) {
            System.out.printf("%s -> %d%n",entry.getKey(), entry.getValue());
        }


    }
}
