import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] array= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e->Integer.parseInt(e)).toArray();


        for (int i = 0; i <array.length ; i++) {
            boolean isValid=true;
            for (int j = i+1; j <array.length ; j++) {

                if (array[i]<=array[j]) {
                    isValid=false;
                }
            }

            if (isValid) {
                System.out.printf("%d ",array[i]);
            }

        }


    }
}
