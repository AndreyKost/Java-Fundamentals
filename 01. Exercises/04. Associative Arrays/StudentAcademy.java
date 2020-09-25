import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentGrades = new LinkedHashMap<>();
        Map<String, Double> newstudentsGrades=new LinkedHashMap<>();

        while (n > 0) {
            String student = scanner.nextLine();
            Double grade = Double.parseDouble(scanner.nextLine());

            if (studentGrades.containsKey(student)) {
                studentGrades.get(student).add(grade);
            } else {
                studentGrades.put(student, new ArrayList<>());
                studentGrades.get(student).add(grade);
            }
            n--;
        }
        for (Map.Entry<String, List<Double>> entry : studentGrades.entrySet()) {
            List<Double> grades = entry.getValue();
            double sum = 0;
            double average = 0;
            for (Double grade : grades) {
                sum += grade;
            }
            average = sum / grades.size() * 1.0;
            if (average >= 4.50){
                newstudentsGrades.put(entry.getKey(),average);
            }
        }

        newstudentsGrades.entrySet().stream().sorted((e1,e2)-> Double.compare(e2.getValue(),e1.getValue()))
                .forEach(entry->{
                    System.out.printf("%s -> %.2f%n",entry.getKey(), entry.getValue());
                });


    }
}
