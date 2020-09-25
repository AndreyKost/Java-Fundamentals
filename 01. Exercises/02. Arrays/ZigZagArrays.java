import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int[] array1=new int[n];
        int[] array2=new int[n];


        for (int i = 1; i <=n ; i++) {
           int num1=scanner.nextInt();
           int num2=scanner.nextInt();

           if(i%2!=0){
             array1[i-1]=num1;
             array2[i-1]=num2;
           } else {
               array1[i-1]=num2;
               array2[i-1]=num1;
           }

        }

        for (int i = 0; i <n ; i++) {
            System.out.printf("%d ",array1[i]);
        }

        System.out.println();

        for (int i = 0; i <n ; i++) {
            System.out.printf("%d ",array2[i]);
        }


    }
}


