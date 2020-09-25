import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Race {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine();
        String[] participants=input.split(", ");
        Map<String, Integer> racers=new LinkedHashMap<>();

        for(String particapant : participants){
            racers.put(particapant,0);
        }

        String regex="([A-Za-z])|([0-9])";
        String line=scanner.nextLine();

        StringBuilder name=new StringBuilder();
        StringBuilder digits=new StringBuilder();

        while (!line.equals("end of race")){

            Pattern pattern=Pattern.compile(regex);
            Matcher matcher=pattern.matcher(line);

            while (matcher.find()){
                if (matcher.group(1) != null) {
                    name.append(matcher.group(1));
                }
                if (matcher.group(2) != null) {
                    digits.append(matcher.group(2));
                }
            }
            String nameOfRacer=name.toString();
            String numbers=digits.toString();
            int sum=0;
            for(int i=0; i<digits.length();i++){
                int n=digits.charAt(i)-'0';
                sum+=n;
            }

            if(racers.containsKey(nameOfRacer)){
                racers.put(nameOfRacer,racers.get(nameOfRacer)+sum);
            }

            name.setLength(0);
            digits.setLength(0);

            line=scanner.nextLine();
        }

        List<String> names=new LinkedList<>();

        racers.entrySet().stream().sorted((first,second)->{
            int result=second.getValue().compareTo(first.getValue());
            return  result;
        }).limit(3).forEach(entry->names.add(entry.getKey()));


        System.out.printf("1st place: %s%n" + "2nd place: %s%n"+"3rd place: %s%n",names.get(0),names.get(1),names.get(2));

    }
}
