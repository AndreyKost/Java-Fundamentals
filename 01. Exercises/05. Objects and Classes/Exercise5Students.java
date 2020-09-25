import java.nio.DoubleBuffer;
import java.util.*;

public class Exercise5Students {
    public static class Student {
        private String firstName;
        private String lastName;
        private double grade;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public double getGrade() {
            return grade;
        }

        public void setGrade(double grade) {
            this.grade=grade;
        }

        public Student(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        @Override
        public String toString(){
            return String.format("%s %s: %.2f"
            ,this.firstName
            ,this.lastName
            ,this.grade);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] commands = scanner.nextLine().split(" ");
            String firstName = commands[0];
            String lastName = commands[1];
            double grade = Double.parseDouble(commands[2]);
            Student student = new Student(firstName, lastName, grade);
            students.add(student);
        }

         students.sort(Comparator.comparing(Student::getGrade));
        for (int i =students.size()-1; i>=0 ; i--) {
            System.out.println(students.get(i).toString());
        }


    }
}
