import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        Map<String, Integer> userPointes = new LinkedHashMap<>();
        Map<String, Integer> languagePoints = new LinkedHashMap<>();
        while (!line.equalsIgnoreCase("exam finished")) {
            String[] tokens = line.split("-");
            String username = tokens[0];
            String language = tokens[1];

            if (!language.equalsIgnoreCase("banned")) {
                int points = Integer.parseInt(tokens[2]);
                if (userPointes.containsKey(username)) {
                    Integer count=userPointes.get(username);
                    if(count<points) {
                        userPointes.put(username,points);
                    }
                    } else {
                    userPointes.put(username, points);
                }

                if (languagePoints.containsKey(language)) {
                    languagePoints.put(language, languagePoints.get(language) + 1);
                } else {
                    languagePoints.put(language, 1);
                }
            } else {
                if (userPointes.containsKey(username)) {
                    userPointes.remove(username);
                }
            }
            line = scanner.nextLine();
        }

        System.out.println("Results: ");
        userPointes.entrySet().stream().sorted((first, second) -> {
            int result = second.getValue().compareTo(first.getValue());
            if (result == 0) {
                result = first.getKey().compareTo(second.getKey());
            }
            return result;
        }).forEach(entry -> {
            System.out.printf("%s | %d%n", entry.getKey(), entry.getValue());

        });

        System.out.println("Submissions: ");
        languagePoints.entrySet().stream().sorted((first, second) -> {
            int result = second.getValue().compareTo(first.getValue());
            if (result == 0) {
                result = first.getKey().compareTo(second.getKey());
            }
            return result;
        }).forEach(entry -> {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        });


    }
}







