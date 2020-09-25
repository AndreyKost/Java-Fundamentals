import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SeizeTheFire {

    static boolean typeOfFireValid(String typeOfFire, int fireToPutOut){
        if(typeOfFire.equals("High")){
            if(fireToPutOut>=81 && fireToPutOut<=125){
                return true;
            }
        } else if(typeOfFire.equals("Medium")){
            if(fireToPutOut>=51 && fireToPutOut<=80){
                return  true;
            }
        } else {
            if(fireToPutOut>=1 && fireToPutOut<=50){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        /*List<String> cells= Arrays.stream(scanner.nextLine()
                .split("#"))
                .collect(Collectors.toList());*/
        String[] cells=scanner.nextLine().split("#");
        int amountOfWater=Integer.parseInt(scanner.nextLine());
        double effort=0;
        double totalEffort=0;
        int totalFire=0;
        List<Integer> numbers=new ArrayList<>();

        for(String cell : cells){
            String[] commands=cell.split(" = ");
            String typeOfFire=commands[0];
            int fireToPutOut=Integer.parseInt(commands[1]);

            if(typeOfFireValid(typeOfFire,fireToPutOut)){
                if(amountOfWater-fireToPutOut>=0) {
                    amountOfWater -= fireToPutOut;
                    effort = fireToPutOut * 0.25;
                    totalEffort += effort;
                    totalFire+=fireToPutOut;
                    numbers.add(fireToPutOut);
                }
            }




        }

        System.out.println("Cells:");
        for(Integer number : numbers){
            System.out.println(" - "+number);
        }
        System.out.printf("Effort: %.2f%n",totalEffort);
        System.out.printf("Total Fire: %d",totalFire);

    }
}
