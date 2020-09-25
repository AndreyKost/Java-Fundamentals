import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        int sum = 0;

        while (numbers.size() > 0) {

            int index = Integer.parseInt(scanner.nextLine());

            if (index == 0 && numbers.size() == 1) {
                sum += numbers.get(0);
                numbers.remove(0);
                break;
            }

            if (index < 0) {
                int number = numbers.get(0);
                sum += number;
                numbers.remove(0);
                numbers.add(0,numbers.get(numbers.size()-1));

                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) <= number) {
                        numbers.set(i, numbers.get(i) + number);
                    } else {
                        numbers.set(i, numbers.get(i) - number);
                    }
                }
            }

            if(index>=numbers.size()){
                int number = numbers.get(numbers.size()-1);
                sum += number;
                numbers.remove(numbers.size()-1);
                numbers.add(numbers.get(0));

                for (int i = 0; i < numbers.size(); i++) {
                    if (number >= numbers.get(i)) {
                        numbers.set(i, numbers.get(i) + number);
                    } else  {
                        numbers.set(i, numbers.get(i) - number);
                    }
                }

            }
            if (index >= 0 && index < numbers.size()) {
                int number = numbers.get(index);
                sum += number;

                for (int i = 0; i < numbers.size(); i++) {
                    if (number >= numbers.get(i)) {
                        numbers.set(i, numbers.get(i) + number);
                    } else {
                        numbers.set(i, numbers.get(i) - number);
                    }
                }

                numbers.remove(index);
            }
        }
        System.out.println(sum);
    }
}