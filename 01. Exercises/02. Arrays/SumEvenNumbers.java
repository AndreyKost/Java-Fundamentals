import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int[] arr=new int[n];
        int sum=0;


        for (int i = 0; i <arr.length ; i++) {
            int num=Integer.parseInt(scanner.nextLine());
            arr[i]=num;
            if (arr[i]%2==0) {
                sum+=arr[i];
            }

        }

        System.out.println(sum);






    }
}
