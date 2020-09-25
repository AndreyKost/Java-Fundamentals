import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String regex="^%([A-Z][a-z]+)%[^|$%.]*<(\\w+)>[^|$%.]*\\|([0-9]+)\\|[^|$%.]*?([0-9]+\\.*[0-9]+)\\$$";
        String line=scanner.nextLine();
        Map<String, String> products=new LinkedHashMap<>();
        Map<String, Double> prices=new LinkedHashMap<>();
        double sum=0;

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

                products.put(customer,product);
                prices.put(customer,sum);
            }
            line=scanner.nextLine();
        }

        double totalSum=0;
        for (Map.Entry<String, String> stringEntry : products.entrySet()) {
            for (Map.Entry<String, Double> entry : prices.entrySet()) {
                if(stringEntry.getKey().equals(entry.getKey())){
                    System.out.printf("%s: %s - %.2f%n",stringEntry.getKey(),stringEntry.getValue(),entry.getValue());
                }
            }
        }
        for (Map.Entry<String, Double> entry : prices.entrySet()) {
            totalSum+=entry.getValue();
        }

        System.out.printf("Total income: %.2f",totalSum);


    }
}
