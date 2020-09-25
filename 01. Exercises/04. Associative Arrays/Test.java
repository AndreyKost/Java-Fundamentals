import java.util.LinkedHashMap;
import java.util.Map;



public class Test {
    public static void main(String[] args) {
        LinkedHashMap<String, Double> fruits=new LinkedHashMap<>();
        fruits.put("Banana", 2.20);
        fruits.put("kiwi", 4.50);
        for(Map.Entry<String, Double> entry : fruits.entrySet()){
            System.out.printf("%s -> %.2f%n",entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, Double> entry : fruits.entrySet()) {

        }


    }
}
