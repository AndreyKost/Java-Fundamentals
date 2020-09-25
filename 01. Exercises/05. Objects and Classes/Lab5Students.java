import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab5Students {
    public static class Student {
        private String firstName;
        private String lastName;
        private int age;
        private String homeTown;

        private String getFirstName() {
            return firstName;
        }

        private void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        private String getLastName() {
            return lastName;
        }

        private void setLastName(String lastName) {
            this.lastName = lastName;
        }

        private int getAge() {
            return age;
        }

        private void setAge(int age) {
            this.age = age;
        }

        private String getHomeTownown() {
            return homeTown;
        }

        private void setHometown(String hometown) {
            this.homeTown = hometown;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        String line = scanner.nextLine();
        while (!line.equals("end")) {
            String[] tokens = line.split(" ");
            String firstName = tokens[0];
            String lastName = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            String homeTown = tokens[3];

            Student student = new Student();
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setAge(age);
            student.setHometown(homeTown);
            students.add(student);
            line=scanner.nextLine();
        }

        String city = scanner.nextLine();

        for (Student student : students) {
            if (student.getHomeTownown().equals(city)) {
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }


    }
}
