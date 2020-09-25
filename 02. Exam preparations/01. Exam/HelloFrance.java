import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HelloFrance {

    static boolean isValid(String type, double price){
        if(type.equals("Clothes")){
            if(price>50){
                return  false;
            }
        }
        if(type.equals("Shoes")){
            if(price>35){
                return  false;
            }
        }
        if(type.equals("Accessories")){
            if(price>20.50){
                return  false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] items=scanner.nextLine().split("\\|");
        double budget=Double.parseDouble(scanner.nextLine());
        List<Double> newPrices=new ArrayList<>();
        double firstBudget=budget;

        for(String item : items){
            String[] tokens=item.split("->");
            String type=tokens[0];
            double price=Double.parseDouble(tokens[1]);

            if(isValid(type,price)){
                if(budget-price>=0) {
                    budget -= price;
                    double newprice=price+price*0.4;
                    newPrices.add(newprice);
                }
            }

        }
        double sell=0;
        for(int i=0;i<newPrices.size();i++){
            sell+=newPrices.get(i);
        }
        for (int i = 0; i <newPrices.size() ; i++) {
            System.out.printf("%.2f ",newPrices.get(i));
        }
        System.out.println();
        System.out.printf("Profit: %.2f%n",((budget+sell)-firstBudget));
        if(budget+sell>=150){
            System.out.println("Hello, France!");
        } else {
            System.out.println("Time to go.");
        }


    }
}
