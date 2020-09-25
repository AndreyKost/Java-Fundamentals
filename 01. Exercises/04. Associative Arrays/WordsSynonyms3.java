import java.util.*;

public class WordsSynonyms3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, Integer> realNumbers = new TreeMap<>();
        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        for (int number : numbers) {
            if (realNumbers.containsKey(number)) {
                Integer count = realNumbers.get(number);
                realNumbers.put(number, count + 1);
            } else {
                realNumbers.put(number, 1);
            }
        }


        for (Map.Entry<Integer, Integer> entry : realNumbers.entrySet()) {
            System.out.printf("%d -> %d%n",entry.getKey(), entry.getValue());
        }
    }
}
