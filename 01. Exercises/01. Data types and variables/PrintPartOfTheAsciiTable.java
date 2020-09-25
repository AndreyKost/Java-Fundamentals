import java.util.Scanner;

public class PrintPartOfTheAsciiTable {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=Integer.parseInt(scanner.nextLine());
        int b=Integer.parseInt(scanner.nextLine());

        for (int i = a; i <=b ; i++) {
            //String ascii=Integer.toString(i);
            char ascii=(char)i;
            System.out.printf("%c ",ascii);

        }









    }
}
