import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab6Students2 {
    public static class Student {
        private String firstName;
        private String lastName;
        private int age;

        public Student(String firstName, String lastName, int age, String homeTown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.homeTown = homeTown;
        }

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

    private static boolean isSuchStudenExisting(List<Student> students, String firstName, String lastName) {
        for(Student student : students){
            if(student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
                return true;
            }
        }
        return  false;
    }

    private static Student getStudent(List<Student> students, String firstName, String lastName){
        Student existingStudent= null;
        for(Student student : students){
            if(student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
                existingStudent=student;
            }
        }
        return  existingStudent;
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

           if(isSuchStudenExisting(students,firstName,lastName)){
               Student student=getStudent(students,firstName,lastName);
               student.setFirstName(firstName);
               student.setLastName(lastName);
               student.setAge(age);
               student.setHometown(homeTown);
           } else {
               Student student=new Student(firstName,lastName,age,homeTown);
               students.add(student);
           }

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
