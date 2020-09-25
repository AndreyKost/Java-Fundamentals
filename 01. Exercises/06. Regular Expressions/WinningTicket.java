import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String line=scanner.nextLine();
        String line1=line.replaceAll("\\s+","");
        String[] tokens=line1.split(",");

        for (int i = 0; i <tokens.length ; i++) {
            String text=tokens[i];

            if(text.length()==20){
                String text1=text.substring(0,10);
                String text2=text.substring(10,20);
                String regex="([$]{6,10}|[@]{6,10}|[#]{6,10}|[\\^]{6,10})";

                Pattern pattern1=Pattern.compile(regex);
                Matcher matcher1=pattern1.matcher(text1);
                Matcher matcher2=pattern1.matcher(text2);

                if(matcher1.find() && matcher2.find()){
                    String leftSide=matcher1.group(1);
                    String rightSide=matcher2.group(1);

                    /*if(rightSide.length()!=10) {
                        System.out.printf("ticket \"%s\" - %d%c%n", text, rightSide.length(), rightSide.charAt(0));
                    } else {
                        System.out.printf("ticket \"%s\" - %d%c Jackpot!%n", text, rightSide.length(), rightSide.charAt(0));
                    }*/

                    if (leftSide.charAt(0) == rightSide.charAt(0) && leftSide.length() <= rightSide.length())
                    {
                        if(rightSide.length()!=10) {
                            System.out.printf("ticket \"%s\" - %d%c%n", text, leftSide.length(), leftSide.charAt(0));
                        } else {
                            System.out.printf("ticket \"%s\" - %d%c Jackpot!%n", text, leftSide.length(), leftSide.charAt(0));
                        }

                    }
                    else if (leftSide.charAt(0) == rightSide.charAt(0) && leftSide.length() > rightSide.length())
                    {
                        if(rightSide.length()!=10) {
                        System.out.printf("ticket \"%s\" - %d%c%n", text, rightSide.length(), leftSide.charAt(0));
                    } else {
                        System.out.printf("ticket \"%s\" - %d%c Jackpot!%n", text, rightSide.length(), leftSide.charAt(0));
                    }
                    }



                } else {
                    System.out.printf("ticket \"%s\" - no match%n",text);
                }


            } else {
                System.out.println("invalid ticket");
            }

        }




    }
}
