import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] commands =scanner.nextLine().split(",\\s*");
        List<String> tokens=new ArrayList<>();
        for (int i = 0; i <commands.length ; i++) {
            if(isValidName(commands[i])){
                String rightname=commands[i].replaceAll(" ","");
                tokens.add(commands[i]);
            }
        }
        int health=0;
        Map<String, Integer> soldiersHealth=new TreeMap<>();
        Map<String, Double> soldiersDamage=new TreeMap<>();


        for (String token : tokens) {
            health=calcHealth(token);
            String regex="(-*\\d+\\.*\\d*)";
            Pattern pattern=Pattern.compile(regex);
            Matcher matcher=pattern.matcher(token);
            double sum=0;
            while (matcher.find()){
                sum+=Double.parseDouble(matcher.group(1));
            }
            for (int i = 0; i <token.length() ; i++) {
                char symbol=token.charAt(i);
                if(symbol=='*'){
                    sum*=2;
                }
                if(symbol=='/'){
                    sum/=2;
                }
            }

            soldiersHealth.put(token,health);
            soldiersDamage.put(token,sum);

        }

        for (Map.Entry<String, Integer> entry : soldiersHealth.entrySet()) {
            for (Map.Entry<String, Double> doubleEntry : soldiersDamage.entrySet()) {
                if(entry.getKey().equals(doubleEntry.getKey())){
                    System.out.printf("%s - %d health, %.2f damage %n",entry.getKey(),entry.getValue(),doubleEntry.getValue());
                }
            }

        }


    }

    private static int calcHealth(String token) {
        int health=0;
        for (int i = 0; i <token.length() ; i++) {
            char symbol=token.charAt(i);
            if(((!Character.isDigit(symbol)) && symbol!='+' && symbol!='-' && symbol!='*' && symbol!='/') && symbol!='.'){
                health+=symbol;
            }
        }
        return  health;

    }

    private static boolean isValidName(String name) {
        boolean isValid=false ;
        for (int i = 0; i <name.length() ; i++) {
            if (!Character.isDigit(name.charAt(i))){
                isValid=true;
            }
        }
        return isValid;
    }
}
