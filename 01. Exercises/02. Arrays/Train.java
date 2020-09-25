import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int[] nums=new int[n];
        int sum=0;

        for (int i = 0; i <nums.length ; i++) {
            int number=Integer.parseInt(scanner.nextLine());
            nums[i]=number;
            sum+=nums[i];
        }

        for (int i = 0; i <nums.length ; i++) {
            System.out.printf("%d ",nums[i]);
        }

        System.out.println();
        System.out.println(sum);



    }
}
