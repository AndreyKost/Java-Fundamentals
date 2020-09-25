import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String regex="^%([A-Z][a-z]*)%[^|$%.]*<(\\w+)>[^|$%.]*\\|([0-9]+)\\|[^|$%.]*?([0-9]+\\.*[0-9]*)\\$$";
        String line=scanner.nextLine();

        double sum=0;
        double totalSum=0;
        while (!line.equals("end of shift")){

            String text=line;
            Pattern pattern=Pattern.compile(regex);
            Matcher matcher=pattern.matcher(text);

            while (matcher.find()){
                String customer=matcher.group(1);
                String product=matcher.group(2);
                int count=Integer.parseInt(matcher.group(3));
                double price=Double.parseDouble(matcher.group(4));
                sum=(count*1.0)*price;
                totalSum+=sum;
                System.out.printf("%s: %s - %.2f%n",customer,product,sum);
            }
            line=scanner.nextLine();
        }
        System.out.printf("Total income: %.2f",totalSum);



    }
}
