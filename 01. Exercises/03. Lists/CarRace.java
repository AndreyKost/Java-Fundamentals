import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<Integer> timeNumbers= Arrays.stream(scanner.nextLine()
        .split(" "))
        .map(Integer::parseInt)
        .collect(Collectors.toList());

        double sum1=0;
        double sum2=0;

        for (int i = 0; i <timeNumbers.size()/2 ; i++) {
            if(timeNumbers.get(i)==0){
                sum1*=0.8;
            } else {
                sum1 += timeNumbers.get(i);
            }
        }

        for (int i=timeNumbers.size()-1; i>timeNumbers.size()/2 ; i--) {
            if(timeNumbers.get(i)==0){
                sum2*=0.8;
            } else {
                sum2 += timeNumbers.get(i);
            }
        }



        if(sum1<=sum2){
            System.out.printf("The winner is left with total time: %.1f",sum1);
        } else {
            System.out.printf("The winner is right with total time: %.1f",sum2);
        }




        



    }
}
