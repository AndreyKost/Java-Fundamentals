import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int[] numbers= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e->Integer.parseInt(e)).toArray();
        int n=Integer.parseInt(scanner.nextLine());
        int sum;
        int symbol1=0;
        int symbol2=0;
        boolean isValid;


        for (int i = 0; i <numbers.length ; i++) {
            isValid=false;
            for (int j =i+1; j <numbers.length ; j++) {

                if (numbers[i]+numbers[j] == n) {
                    symbol1=numbers[i];
                    symbol2=numbers[j];
                    isValid=true;
                }

            }
            if(isValid) {
                System.out.printf("%d %d%n", symbol1, symbol2);
            }


        }




    }
}
