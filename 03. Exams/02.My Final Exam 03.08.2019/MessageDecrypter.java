import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageDecrypter {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        String regex="^([$%])([A-Z][a-z]{2,})\\1: \\[(\\d+)\\]\\|\\[(\\d+)\\]\\|\\[(\\d+)\\]\\|$";


        while (n>0){
            String line=scanner.nextLine();
            Pattern pattern=Pattern.compile(regex);
            Matcher matcher=pattern.matcher(line);

            if(matcher.find()){
                String tag=matcher.group(2);
                String n1=matcher.group(3);
                String n2=matcher.group(4);
                String n3=matcher.group(5);
                String newWord=transform(n1,n2,n3);
                System.out.printf("%s: %s%n",tag,newWord);

            } else {
                System.out.println("Valid message not found!");
            }



            n--;
        }


    }

    private static String transform(String n1, String n2, String n3) {
        StringBuilder newWord=new StringBuilder();
        int number1=Integer.parseInt(n1);
        int number2=Integer.parseInt(n2);
        int number3=Integer.parseInt(n3);
        char ch1=(char)number1;
        char ch2=(char)number2;
        char ch3=(char)number3;
        newWord.append(ch1);
        newWord.append(ch2);
        newWord.append(ch3);

        return newWord.toString();
    }
}
