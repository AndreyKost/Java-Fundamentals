import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int[] numbers= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e->Integer.parseInt(e)).toArray();
        int count=0;
        int max=Integer.MIN_VALUE;
        int symbol=0;

        for (int i = 0; i <numbers.length ; i++) {
            count=0;
            for (int j = i+1; j <numbers.length ; j++) {
                if (numbers[i] == numbers[j]) {
                    count++;
                    if (count>max) {
                        max=count;
                        symbol=numbers[i];
                    }
                } else {
                    break;
                }
            }

        }

        for (int i = 0; i <=max ; i++) {
            System.out.printf("%d ",symbol);
        }




    }
}
