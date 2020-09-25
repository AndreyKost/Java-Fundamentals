import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CompanyRoster {
    public static class Department{
        private String name;
        List<Employee> employees;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Department(){
            this.employees = new ArrayList<>();
        }

        public Department(String name){
            this();
            this.name = name;
        }

        public List<Employee> getEmployees(){
            return employees;
        }

        public void setEmployees(List<Employee> employees){
            this.employees=employees;
        }
        public void addEmployee(Employee e){
            this.employees.add(e);
        }

        public double getAverage(){
            double res=0.0;
            for(Employee e : this.employees){
                res+=e.getSalary();
            }
            return res/this.employees.size();
        }



    }

    public static class Employee{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        private double salary;
        private String position;
        private String email="n/a";
        private int age=-1;

        public Employee(String name, double salary, String position) {
            this.name = name;
            this.salary = salary;
            this.position = position;
        }



    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        LinkedHashMap<String,Department> departments=new LinkedHashMap<>();
        int n=Integer.parseInt(scanner.nextLine());

        while(n-- > 0){
            String[] params=scanner.nextLine().split(" ");
            Employee employee = new Employee(params[0], Double.parseDouble(params[1]), params[2]);

            if(params.length==5){
                try {
                    int age=Integer.parseInt(params[4]);
                    employee.setAge(age);
                }
                catch (Exception e){
                    employee.setEmail(params[4]);
                }
            } else if(params.length>5){
                employee.setEmail(params[4]);
                employee.setAge(Integer.parseInt(params[5]));
            }

            if(!departments.containsKey(params[3])){
                departments.put(params[3], new Department(params[3]));
            }

            departments.get(params[3]).addEmployee(employee);
        }

        List<Department> sortedJobs=departments.values().stream().sorted(((o1,o2)-> Double.compare(o2.getAverage(),o1.getAverage())))
                .collect(Collectors.toList());
        Department bestJob=sortedJobs.get(0);
        System.out.println(String.format("Highest Average Salary: %s",bestJob.getName()));


        List<Employee> sortedEmployees = bestJob.getEmployees().stream().sorted(((o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary()))).collect(Collectors.toList());

        for(Employee e : sortedEmployees) {
            System.out.println(String.format("%s %.2f %s %d", e.getName(), e.getSalary(), e.getEmail(), e.getAge()));
        }


    }
}
