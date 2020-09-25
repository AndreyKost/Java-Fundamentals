import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int number=Integer.parseInt(scanner.nextLine());
        List<String> attackedPlanets=new ArrayList<>();
        List<String> destroyedPlanets=new ArrayList<>();

        while (number>0) {
            String line = scanner.nextLine();
            StringBuilder word = new StringBuilder();
            int key = 0;


            for (int i = 0; i < line.length(); i++) {
                char symbol = line.charAt(i);
                if (symbol == 'A' || symbol == 'a' || symbol == 't' || symbol == 'T' || symbol == 'r' || symbol == 'R' || symbol == 's' || symbol == 'S') {
                    key++;
                }
            }

            for (int i = 0; i < line.length(); i++) {
                int n = line.charAt(i) - key;
                char symbol = (char) n;
                word.append(symbol);
            }

            String regex = "@(?<PlanetName>[A-Za-z]+)[^@\\-!:>]*:(?<Population>[0-9]+)[^@\\-!:>]*!(?<AttackType>[A]|[D])![^@\\-!:>]*->(?<Count>[0-9]+)";
            String text = word.toString();

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()){
                String planetName=matcher.group("PlanetName");
                int population=Integer.parseInt(matcher.group("Population"));
                String attackType=matcher.group("AttackType");
                int count=Integer.parseInt(matcher.group("Count"));
                if (attackType.equals("A")) {
                   attackedPlanets.add(planetName);
                }
                if(attackType.equals("D")){
                    destroyedPlanets.add(planetName);
                }
            }
            number--;
        }

        Collections.sort(attackedPlanets);
        Collections.sort(destroyedPlanets);

        System.out.println("Attacked planets: "+attackedPlanets.size());
        if(attackedPlanets.size()>0){
            for (String planet : attackedPlanets) {
                System.out.printf("-> %s%n",planet);
            }
        }
        System.out.println("Destroyed planets: "+destroyedPlanets.size());
        if(destroyedPlanets.size()>0){
            for(String planet : destroyedPlanets){
                System.out.printf("-> %s%n",planet);
            }
        }




    }
}
