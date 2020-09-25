import java.util.Scanner;

public class ConcatNames {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String firstName=scanner.nextLine();
        String secondName=scanner.nextLine();
        String delimitur=scanner.nextLine();

        String result=firstName+delimitur+secondName;
        //System.out.printf("%s%s%s",firstName,delimitur,secondName);
        System.out.println(result);




    }
}
