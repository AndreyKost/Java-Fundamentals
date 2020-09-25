import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] arr= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e->Integer.parseInt(e)).toArray();
        int rightElement=0;
        int leftElement=0;
        int rightSum=0;
        int leftSum=0;
        int[] rightArray=new int[arr.length-1];
        int[] leftArray=new int[arr.length-1];

        for (int i = 0; i <arr.length ; i++) {
            rightSum=0;
            leftSum=0;
            for (int j =i+1 ; j <arr.length ; j++) {
                rightSum+=arr[j];
                rightArray[i]=rightSum;
            }
            for (int b =arr.length-i-2; b>=0 ; b--) {
                leftSum+=arr[b];
                leftArray[i]=leftSum;
            }


        }

        for (int i = 0; i < rightArray.length; i++) {
            System.out.printf("%d ", rightArray[i]);
        }

        for (int j = 0; j <leftArray.length ; j++) {
            System.out.printf("%d ",leftArray[j]);
        }





        /*boolean isValid=false;
        int symbol=0;

        for (int i = 0; i <rightArray.length ; i++) {
            //System.out.printf("%d ",rightArray[i]);
            for (int j = 0; j <leftArray.length ; j++) {
                if (rightArray[i] == leftArray[j]) {
                    symbol=i;
                    isValid=true;
                }
                //System.out.printf("%d ",leftArray[i]);
            }
        }

        if (isValid) {
            System.out.println(symbol);
        } else {
            System.out.printf("no");
        }*/






    }
}
