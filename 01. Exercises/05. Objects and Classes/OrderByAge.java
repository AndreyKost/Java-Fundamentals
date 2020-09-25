import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {
    public static class Person {
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        private String name;
        private String id;
        private int age;

        public Person(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        @Override
        public String toString() {
            return String.format("%s with ID: %s is %d years old."
                    , this.name
                    , this.id
                    , this.age);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> persons = new ArrayList<>();

        String line = scanner.nextLine();
        while (!line.equals("End")) {
            String[] tokens = line.split(" ");
            String name = tokens[0];
            String id = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            Person person = new Person(name, id, age);
            persons.add(person);
            line=scanner.nextLine();
        }

        persons.sort(Comparator.comparing(Person::getAge));
        for(Person person : persons){
            System.out.println(person.toString());
        }


    }
}
