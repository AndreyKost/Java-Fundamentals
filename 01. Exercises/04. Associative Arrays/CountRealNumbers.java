import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {
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
