import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine();
        Map<String, Double> productsPrice=new LinkedHashMap<>();
        Map<String, Double> productsQuantity=new LinkedHashMap<>();

        while(!input.equalsIgnoreCase("buy")){
            String[] tokens=input.split(" ");
            String product=tokens[0];
            Double price=Double.parseDouble(tokens[1]);
            Double quantity=Double.parseDouble(tokens[2]);
            if(productsPrice.containsKey(product)){
                productsPrice.put(product,price);
            } else {
                productsPrice.put(product,price);
            }

            if(productsQuantity.containsKey(product)){
                Double count=productsQuantity.get(product);
                productsQuantity.put(product,count+quantity);
            } else {
                productsQuantity.put(product,quantity);
            }
            input=scanner.nextLine();
        }


        for (Map.Entry<String, Double> entry : productsPrice.entrySet()) {
            for (Map.Entry<String, Double> doubleEntry : productsQuantity.entrySet()) {
                if(entry.getKey().equalsIgnoreCase(doubleEntry.getKey())){
                    productsQuantity.put(doubleEntry.getKey(),doubleEntry.getValue()*entry.getValue());
                }
            }
        }

        for (Map.Entry<String, Double> doubleEntry : productsQuantity.entrySet()) {
            System.out.printf("%s -> %.2f%n",doubleEntry.getKey(),doubleEntry.getValue());
        }


    }
}
