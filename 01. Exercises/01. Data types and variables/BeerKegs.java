import org.omg.CORBA.INTERNAL;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        double max= Double.MIN_VALUE;
        double formula=0;
        String str="";

        for (int i = 0; i <n ; i++) {
            String model=scanner.nextLine();
            double radius=Double.parseDouble(scanner.nextLine());
            int height=Integer.parseInt(scanner.nextLine());
             formula=Math.PI*radius*radius*height;
            if (formula>max) {
                max=formula;
                str=model;
            }


        }

        System.out.println(str);


    }
}
