import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String regex=">>(?<Furniture>[A-Za-z]+)<<(?<Price>\\d+[\\.0-9]*)!(?<Quantity>\\d+)\\b";
        String line=scanner.nextLine();


        double sum=0.0;

        System.out.println("Bought furniture: ");
        while (!line.equals("Purchase")){
            Pattern pattern= Pattern.compile(regex);
            Matcher matcher=pattern.matcher(line);

            if(matcher.find()) {
                String furniture = matcher.group(1);
                double price = Double.parseDouble(matcher.group(2));
                int quantity = Integer.parseInt(matcher.group(3));
                System.out.println(furniture);
                sum += price * (quantity * 1.0);
            }
            line=scanner.nextLine();
        }
        System.out.printf("Total money spend: %.2f",sum);









    }
}
