import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line=scanner.nextLine();
        Map<String, List<String>> courses=new LinkedHashMap<>();


        while (!line.equalsIgnoreCase("end")){
            String[] tokens=line.split(" : ");
            String course=tokens[0];
            String student=tokens[1];

            if(courses.containsKey(course)){
                courses.get(course).add(student);
            } else {
                courses.put(course,new ArrayList<>());
                courses.get(course).add(student);
            }
            line=scanner.nextLine();
        }

        courses.entrySet().stream().sorted((left,right)-> Integer.compare(right.getValue().size(),left.getValue().size()))
                .forEach(entry->{
                    System.out.printf("%s: %d%n",entry.getKey(), entry.getValue().size());
                    List<String> studyCourses=entry.getValue();
                    Collections.sort(studyCourses);
                    for(String studyCourse : studyCourses){
                        System.out.printf("-- %s%n",studyCourse);
                    }
                });

        /*for (Map.Entry<String, List<String>> entry : courses.entrySet()) {
            System.out.printf("%s: %d%n",entry.getKey(), entry.getValue().size());
            List<String> studyCourses=entry.getValue();
            for(String studyCourse : studyCourses){
                System.out.printf("-- %s%n",studyCourse);
            }
        }*/


    }
}
