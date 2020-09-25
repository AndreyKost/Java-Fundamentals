import java.util.Scanner;

public class SumOfChars {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int sum=0;
        String str="";


        for (int i = 0; i <n ; i++) {
            str=scanner.nextLine();
            int ascii=str.charAt(0);// moje i  char ascii=str.charAt(0)
            sum+=ascii;
        }

        System.out.printf("The sum equals: %d",sum);



    }
}
