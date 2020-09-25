import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
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
            if(playerCards1.get(0).equals(playerCards2.get(0))){
                playerCards1.remove(0);
                playerCards2.remove(0);
            } else if(playerCards1.get(0)>playerCards2.get(0)){
                playerCards1.add(playerCards1.get(0));
                playerCards1.add(playerCards2.get(0));
                playerCards1.remove(0);
                playerCards2.remove(0);
            } else {
                playerCards2.add(playerCards2.get(0));
                playerCards2.add(playerCards1.get(0));
                playerCards2.remove(0);
                playerCards1.remove(0);
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
