import java.util.Scanner;

public class FromLeftToTheRight2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int sum=0;


        for (int i = 0; i <n ; i++) {
            String nums=scanner.nextLine();
            String symbol=" ";
            String[] splitNumbers=nums.split(symbol);

            long leftNum=Integer.parseInt(splitNumbers[0]);
            long rightNum=Integer.parseInt(splitNumbers[1]);

            long biggerNumber=Math.abs(rightNum);

            if (leftNum > rightNum) {
                biggerNumber=Math.abs(leftNum);
            }


            while (biggerNumber!=0){
                sum+=biggerNumber%10;
                biggerNumber=biggerNumber/10;

            }

            System.out.println(sum);
            sum=0;

        }





    }
}
