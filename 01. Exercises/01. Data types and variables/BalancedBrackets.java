import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        boolean isValid=false;
        int count1=0;
        int count2=0;
        boolean flag1=false;
        boolean flag2=false;
        int count3=0;

        for (int i = 1; i <=n ; i++) {
            String pattern=scanner.nextLine();


            if (pattern.equals("(")) {
                count1++;
                if (flag1) {
                    count3++;
                }
                flag1=true;
                flag2=true;
            }
            if (pattern.equals(")")) {
                count2++;
                flag1=false;
                flag2=false;
            } else {
                flag1=false;
                flag2=false;
            }


        }

                if (count1 == count2) {
                isValid=true;
                }

                if ((isValid && count3>0) && !flag2) {
                System.out.println("BALANCED");
                } else {
                System.out.println("UNBALANCED");
                }



    }
}
