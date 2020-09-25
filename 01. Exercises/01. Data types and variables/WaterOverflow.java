import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int capacity=255;
        int sum=0;


        for (int i = 0; i <n ; i++) {
            int num=Integer.parseInt(scanner.nextLine());


            if (num+sum>capacity) {
                System.out.println("Insufficient capacity!");
            }else {
                sum+=num;
            }

            
        }

        System.out.printf("%d",sum);


    }
}
