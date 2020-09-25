import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] array1= Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e->Integer.parseInt(e))
                .toArray();

        int[] array2=new int[array1.length];

        int n=Integer.parseInt(scanner.nextLine());
        int result=0;
        if(n<array1.length-1){
        result=n;
        } else {
            result=array1.length-n;
        }
        int temp=0;

        if (result ==0) {
            for (int i = 0; i <array1.length ; i++) {
                System.out.printf("%d ",array1[i]);
            }
        }

        if(result>0) {
            for (int i = 0; i < array1.length; i++) {
                for (int j = result; result >= 0; result--) {
                    System.out.printf("%d ", array1[array1.length - 1 - result]);
                }
            }
            result=n;
            for (int i = 0; i <result ;i++ ) {
                System.out.printf("%d ",array1[i]);

            }
        }


       /*result=n-1;
        if(result>=0) {
            for (int i = 0; i < array1.length; i++) {
                for (int j = result; result >=0 ; result--) {
                    System.out.printf("%d ",array1[result]);

                }

            }
        }*/

        /*for (int i = 0; i <array2.length ; i++) {
            System.out.printf("%d ",array2[i]);
        }
*/


}
}
