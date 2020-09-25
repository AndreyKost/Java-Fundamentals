import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        for (int ch = 1; ch <= number; ch++) {
            int sum = 0;
            int digit = ch;
            while (digit > 0) {
                sum += digit % 10;
                digit = digit / 10;
            }
            if (sum ==5 || sum==7 || sum==11) {
                System.out.printf("%d -> True%n",ch);
            } else {
                System.out.printf("%d -> False%n",ch);
            }


        }



    }
}
