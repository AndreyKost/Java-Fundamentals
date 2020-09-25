import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line=scanner.nextLine();
        String regex="(^[A-Za-z0-9]{25}$|^[A-Za-z0-9]{16}$)";
        String[] tokens=line.split("&");

        List<String> keys=new ArrayList<>();

        for (String token : tokens) {
            Pattern pattern=Pattern.compile(regex);
            Matcher matcher=pattern.matcher(token);

            if(matcher.find()){
                String k=matcher.group(1).toUpperCase();
                String key=transform(k);

                if(key.length()==16){
                    String key1=key.substring(0,4);
                    String key2=key.substring(4,8);
                    String key3=key.substring(8,12);
                    String key4=key.substring(12,16);
                    String majorKey=key1+"-"+key2+"-"+key3+"-"+key4;
                    keys.add(majorKey);
                }
                if(key.length()==25){
                    String key1=key.substring(0,5);
                    String key2=key.substring(5,10);
                    String key3=key.substring(10,15);
                    String key4=key.substring(15,20);
                    String key5=key.substring(20,25);
                    String majorKey=key1+"-"+key2+"-"+key3+"-"+key4+"-"+key5;
                    keys.add(majorKey);
                }
            }
        }

        for (int i = 0; i <keys.size() ; i++) {
            if(i!= keys.size()-1){
                System.out.printf("%s, ",keys.get(i));
            } else {
                System.out.printf("%s",keys.get(i));
            }
        }

    }

    private static String transform(String k) {
        StringBuilder newWord=new StringBuilder();
        for (int i = 0; i <k.length() ; i++) {
            String s="";
            char c=k.charAt(i);
            if(Character.isDigit(c)){
                s+=c;
                int n=Integer.parseInt(s);
                int number=9-n;
                newWord.append(number);
            } else {
                newWord.append(c);
            }
        }
        return newWord.toString();
    }
}
