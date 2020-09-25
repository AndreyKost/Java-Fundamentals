import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> wordCounts = new TreeMap<>();
        String[] words = scanner.nextLine().split(" ");
        for (String word : words) {
            if (wordCounts.containsKey(word)) {
                Integer count = wordCounts.get(word);
                wordCounts.put(word, count + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }


    }
}
