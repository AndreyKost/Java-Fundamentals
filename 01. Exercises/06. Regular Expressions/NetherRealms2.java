import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String numberRegex = "[+-]?\\d+\\.?\\d*";
        String operationRegex = "[*/]+";
        String delimiterRegex = ",\\s*";
        String healthRegex = "[^0-9*/+\\-.]";

        Map <String,List<Double>> demonsHash = new TreeMap<>();
        String[] demons = scanner.nextLine().split(delimiterRegex);

        for (int i = 0; i < demons.length; i++) {
            double health = 0;
            double damage = 0;

            List<Double> healthDamage = new ArrayList<>();
            String currentDemon = demons[i].replaceAll(" ","");
            Pattern healthPattern = Pattern.compile(healthRegex);
            Matcher healthFinder = healthPattern.matcher(currentDemon);

            while (healthFinder.find()) {
                health += healthFinder.group().charAt(0);
            }
            Pattern pattern = Pattern.compile(numberRegex);
            Matcher numbers = pattern.matcher(currentDemon);

            while(numbers.find()){
                damage += Double.parseDouble(numbers.group());
            }
            Pattern pattern1 = Pattern.compile(operationRegex);
            Matcher delimiters = pattern1.matcher(currentDemon);

            while(delimiters.find()){
                String signsSequence = delimiters.group();
                for (int j = 0; j < signsSequence.length(); j++) {
                    if (signsSequence.charAt(j) == '*'){
                        damage *= 2;
                    }
                    else if (signsSequence.charAt(j) == '/') {
                        damage /= 2;
                    }
                }
            }
            healthDamage.add(health);
            healthDamage.add(damage);

            demonsHash.put(currentDemon, healthDamage);
        }
        demonsHash.forEach((key, value) -> {
            System.out.print(key + " - ");
            System.out.printf("%.0f health, ", value.get(0));
            System.out.printf("%.2f damage%n", value.get(1));

        });
}

}