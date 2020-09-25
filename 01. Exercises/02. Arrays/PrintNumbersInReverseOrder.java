import java.util.Scanner;

public class PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int[] arr=new int[n];

        for (int i = 0; i <arr.length ; i++) {
            int number=Integer.parseInt(scanner.nextLine());
            arr[i]=number;
        }


        for (int i =arr.length-1; i >=0 ; i--) {
            System.out.printf("%s ",arr[i]);

        }



    }
}
