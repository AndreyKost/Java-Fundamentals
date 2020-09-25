import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGameOtherCondition {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<Integer> playerCards1= Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> playerCards2=Arrays.stream(scanner.nextLine()
        .split(" "))
        .map(Integer::parseInt)
        .collect(Collectors.toList());

      // int count=playerCards1.size();
       int sum1=0;
       int sum2=0;

       while (playerCards1.size()>0 && playerCards2.size()>0){
           int maxCards1=Integer.MIN_VALUE;
           int maxCards2=Integer.MIN_VALUE;
           for (int i = 0; i <playerCards1.size() ; i++) {
               if(playerCards1.get(i)>=maxCards1){
                   maxCards1=playerCards1.get(i);
               }
           }
           for(int i=0;i<playerCards2.size();i++){
               if(playerCards2.get(i)>=maxCards2){
                   maxCards2=playerCards2.get(i);
               }
           }
           if(maxCards1>maxCards2){
               playerCards1.add(maxCards2);
               playerCards2.remove(Integer.valueOf(maxCards2));
           } else if(maxCards2>maxCards1){
               playerCards2.add(maxCards1);
               playerCards1.remove(Integer.valueOf(maxCards1));
           } else {
               playerCards1.remove(Integer.valueOf(maxCards1));
               playerCards2.remove(Integer.valueOf(maxCards2));
           }
       }

        for (int i = 0; i <playerCards1.size() ; i++) {
            sum1+=playerCards1.get(i);
        }
        for (int i = 0; i <playerCards2.size() ; i++) {
            sum2+=playerCards2.get(i);
        }

        if(sum1>sum2){
            System.out.printf("First player wins! Sum: %d",sum1);
        } else {
            System.out.printf("Second player wins! Sum: %d",sum2);
        }




    }
}
