import java.util.Scanner;

public class EqualSums2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] inputElements=scanner.nextLine().split(" ");
        int[] numbers=new int[inputElements.length];

        for (int i = 0; i <inputElements.length ; i++) {
            numbers[i]=Integer.parseInt(inputElements[i]);
        }

        String output="no";
        for (int i = 0; i <numbers.length ; i++) {
            int leftSum=0;
            int rightSum=0;

            for (int l = 0; l <i ; l++) {
                leftSum+=numbers[l];
            }

            for (int r =i+1; r <numbers.length ; r++) {
                rightSum+=numbers[r];
            }

            if (leftSum == rightSum) {
                output=i+" ";
            }

            //System.out.println("Left: "+leftSum);
            //System.out.println("Right: "+rightSum);


        }

        System.out.println(output);

    }
}
