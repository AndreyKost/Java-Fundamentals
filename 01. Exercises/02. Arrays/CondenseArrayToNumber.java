import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int[] numbers1 = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        while(numbers1.length>1) {
            int sum = 0;

            int[] condensed = new int[numbers1.length - 1];
            for (int i = 0; i < condensed.length; i++) {
                condensed[i] = numbers1[i] + numbers1[i + 1];
            }
            numbers1=condensed;
        }
        System.out.println(numbers1[0]);



    }
}
