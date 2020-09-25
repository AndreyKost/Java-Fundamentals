import java.util.Scanner;

public class DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int key=Integer.parseInt(scanner.nextLine());
        int n=Integer.parseInt(scanner.nextLine());
        int sum=0;
        String message="";

        for (int i = 1; i <=n ; i++) {
            char symbol=scanner.nextLine().charAt(0);
            int  ascii=symbol;
            sum+=key+ascii;
            char newSymbol=(char)sum;
            message=message+newSymbol;
            sum=0;

        }

        System.out.println(message);


    }
}
