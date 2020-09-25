import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String digits=scanner.nextLine();
        int sum=0;

        for (int i = 0; i <digits.length() ; i++) {
            if (Character.isDigit(digits.charAt(i))){
                int num=digits.charAt(i)-'0';
                sum+=num;

            }

        }

        System.out.printf("%d",sum);


    }
}
