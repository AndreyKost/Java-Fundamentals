import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        Map<String, String> parkingPlaces=new LinkedHashMap<>();


        while (n>0){
            String line=scanner.nextLine();
            String[] tokens=line.split(" ");
            String command=tokens[0];
            String customer=tokens[1];

            if(command.equalsIgnoreCase("register")){
                String licensePlate=tokens[2];
                if(parkingPlaces.containsKey(customer)){
                    System.out.printf("ERROR: already registered with plate number %s%n",licensePlate);
                } else {
                    parkingPlaces.put(customer,licensePlate);
                    System.out.printf("%s registered %s successfully%n",customer,licensePlate);
                }
            } else {
                if(parkingPlaces.containsKey(customer)){
                    parkingPlaces.remove(customer);
                    System.out.printf("%s unregistered successfully%n",customer);
                } else {
                    System.out.printf("ERROR: user %s not found%n",customer);
                }
            }
            n--;
        }


        for (Map.Entry<String, String> entry : parkingPlaces.entrySet()) {
            System.out.printf("%s => %s%n",entry.getKey(), entry.getValue());
        }


    }
}
