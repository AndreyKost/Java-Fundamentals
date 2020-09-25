import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] commands =scanner.nextLine().split(",\\s*");
        List<String> tokens=new ArrayList<>();
        for (int i = 0; i <commands.length ; i++) {
            if(isValidName(commands[i])){
                tokens.add(commands[i]);
            }
        }
        double health=0;
        Map<String, List<Double>> demonsHash = new TreeMap<>();


        for (String token : tokens) {
            String currentDemon = token.replaceAll(" ","");
            List<Double> healthDamage = new ArrayList<>();
            health=calcHealth(currentDemon);
            String regex="([+-]?\\d+\\.?\\d*)";
            Pattern pattern=Pattern.compile(regex);
            Matcher matcher=pattern.matcher(currentDemon);
            double sum=0;
            while (matcher.find()){
                sum+=Double.parseDouble(matcher.group(1));
            }
            for (int i = 0; i <currentDemon.length() ; i++) {
                char symbol=currentDemon.charAt(i);
                if(symbol=='*'){
                    sum*=2;
                }
                if(symbol=='/'){
                    sum/=2;
                }
            }

            healthDamage.add(health);
            healthDamage.add(sum);
            demonsHash.put(currentDemon,healthDamage);


        }

        demonsHash.forEach((key, value) -> {
            System.out.print(key + " - ");
            System.out.printf("%.0f health, ", value.get(0));
            System.out.printf("%.2f damage%n", value.get(1));

        });


    }

    private static double calcHealth(String token) {
        double health=0;
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
