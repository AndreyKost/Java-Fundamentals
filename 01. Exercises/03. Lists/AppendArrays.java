import java.util.*;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<String> tokens= Arrays.stream(scanner.nextLine()
                .split("|"))
                .collect(Collectors.toList());

        List<String> output=new ArrayList<>();

        for (int i =tokens.size()-1; i>=0 ; i--) {
            String[] numbers=tokens.get(i).split("\\s+");
            for (int j = 0; j <numbers.length ; j++) {
                if(!numbers[j].equals("")){
                    output.add(numbers[j]);
                }
            }

        }

        String print = output.toString().trim();
        System.out.println(print.replaceAll("\\[|,|\\]", ""));






    }
}
