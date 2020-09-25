import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line=scanner.nextLine();
        //String regex="([^0-9]+)(\\d)";
        String regexWords="([^0-9]+)";
        String regexnNums="(\\d+)";

        Pattern patternWords=Pattern.compile(regexWords);
        Matcher matcherWords=patternWords.matcher(line);

        Pattern patternNums=Pattern.compile(regexnNums);
        Matcher matcherNums=patternNums.matcher(line);

        StringBuilder word=new StringBuilder();
        while(matcherWords.find() && matcherNums.find()){
            String text=matcherWords.group(1);
            int n=Integer.parseInt(matcherNums.group(1));
            StringBuilder newWord=new StringBuilder();
            for (int i = 0; i <n ; i++) {
                newWord.append(text.toUpperCase());
            }
            word.append(newWord);
        }

        int n=transform(word.toString());
        System.out.printf("Unique symbols used: %d%n",n);
        System.out.println(word);
    }

    private static int transform(String text) {
        String text1=text.toUpperCase();
        String newWord="";
        for (int i = 0; i <text1.length() ; i++) {
            String key="";
            key+=text1.charAt(i);
            if(!newWord.contains(key)){
                newWord+=key;
            }
        }
        return newWord.length();
    }
}
