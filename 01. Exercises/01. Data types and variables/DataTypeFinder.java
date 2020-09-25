import java.util.Scanner;

public class DataTypeFinder {
/*    boolean tryParseInt (String value){
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    boolean tryParseDouble (String value){
        try{
            Double.parseDouble(value);
            return  true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String type = "";

        while (!input.equalsIgnoreCase("End")) {

            boolean isInt=true;

            try {
                Integer.parseInt(input);
            } catch (NumberFormatException ex){
                isInt=false;
            }

            boolean isDouble=true;

            try {
                Double.parseDouble(input);
            } catch (NumberFormatException ex){
                isDouble=false;
            }

            if (isInt) {
                type="integer type";
            } else if (isDouble) {
                type="floating point type";
            } else if(input.length()==1){
                type="character type";
            } else if (input.equalsIgnoreCase("True") || input.equalsIgnoreCase("False")) {
                type="boolean type";
            } else {
                type="string type";
            }



            System.out.printf("%s is %s%n", input, type);

            input = scanner.nextLine();
        }


    }
}
