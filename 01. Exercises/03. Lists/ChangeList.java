import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split(" +"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("end")) {
            String[] strings = input.split(" +");


            if (strings[0].equalsIgnoreCase("Delete")) {
                int num = Integer.parseInt(strings[1]);
                while (numbers.contains(num)) {
                    numbers.remove(Integer.valueOf(num));
                }
            } else {
                int num2 = Integer.parseInt(strings[1]);
                int num1 = Integer.parseInt(strings[2]);
                if (num1>=0 && num1< numbers.size()) {
                    numbers.add(num1, num2);
                }
            }
            input=scanner.nextLine();
        }
        for (Integer num : numbers) {
            System.out.print(num + " ");
        }


    }
}