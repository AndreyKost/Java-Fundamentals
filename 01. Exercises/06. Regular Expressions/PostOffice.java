
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line=scanner.nextLine();

        String regexWords="([#$%*&])([A-Z]+)\\1";
        String regexNumbers="(\\d{2}:\\d{2})";
        String[] tokens=line.split("\\|");
        String ws=tokens[0];
        String nums=tokens[1];
        String givenWords=tokens[2];

        String[] wordsToCheck=tokens[2].split(" ");

        Pattern patternWords=Pattern.compile(regexWords);
        Matcher matcherWords=patternWords.matcher(ws);

        Pattern patterNumbers=Pattern.compile(regexNumbers);
        Matcher matcherNumbers=patterNumbers.matcher(nums);

        int numberOfcoordinates=0;
        String s="";
        if(matcherWords.find()){
            String letters=matcherWords.group(2);
            s=letters;
            numberOfcoordinates=letters.length(); //5
        }
        List<String> keys=new ArrayList<>();
        while ( matcherNumbers.find()){
            String asciiKeys=matcherNumbers.group(1);
            keys.add(asciiKeys);

        }

        List<String> w=transformToWord(keys,s,wordsToCheck);
        List<String> wBetter=new ArrayList<>();
        for (int i = 0; i <w.size() ; i++) {
            if(!wBetter.contains(w.get(i))){
                wBetter.add(w.get(i));
            }
        }

        for (int i = 0; i <wBetter.size() ; i++) {
            System.out.println(wBetter.get(i));
        }



    }

    private static List<String> transformToWord(List<String> asciiKeys, String s,String[] wordsToCheck) {
        String woooord = "";
        List<String> words=new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int n=(int)s.charAt(i);
            for (String key : asciiKeys) {
                String[] tokens = key.split(":");
                int asciiNum = Integer.parseInt(tokens[0]);
                int repeatLetter = Integer.parseInt(tokens[1]) + 1;
                if(n==asciiNum) {
                    char c = (char) asciiNum;
                    woooord = "";

                    for (int j = 0; j < wordsToCheck.length; j++) {
                        if (wordsToCheck[j].charAt(0) == c && wordsToCheck[j].length() == repeatLetter) {
                            woooord = wordsToCheck[j];
                        }
                    }
                    words.add(woooord);
                }
            }



        }

        return  words;
    }
}
