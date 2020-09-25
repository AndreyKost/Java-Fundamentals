import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line=scanner.nextLine();
        Map<String, Integer> resourcesSum=new LinkedHashMap<>();

        while (!line.equals("stop")){
            int quantity=Integer.parseInt(scanner.nextLine());
            if(resourcesSum.containsKey(line)){
                Integer currentSum=resourcesSum.get(line);
                resourcesSum.put(line,currentSum+quantity);
            } else {
                resourcesSum.put(line,quantity);
            }

            line=scanner.nextLine();
        }


        for (Map.Entry<String, Integer> entry : resourcesSum.entrySet()) {
            System.out.printf("%s -> %d%n",entry.getKey(), entry.getValue());
        }


    }
}
