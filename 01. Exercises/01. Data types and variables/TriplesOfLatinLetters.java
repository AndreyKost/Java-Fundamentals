import java.util.Scanner;

public class TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());

        /*for (int i = 0; i <n ; i++) {
            char firstChar=(char)('a'+i);
            for (int j = 0; j <n ; j++) {
                char secondChar=(char)('b'+i);
                for (int k = 0; k <n ; k++) {
                    char thirdChar=(char)('c'+i);
                    System.out.printf("%c%c%c%n",firstChar,secondChar,thirdChar);

                }
            }
        }*/

        for(char a='a';a<'a'+n;a++){
            for(char b='a';b<'a'+n;b++){
                for(char c='a';c<'a'+n;c++){
                    System.out.printf("%c%c%c%n",a,b,c);
                }
            }
        }
                
                



    }
}
