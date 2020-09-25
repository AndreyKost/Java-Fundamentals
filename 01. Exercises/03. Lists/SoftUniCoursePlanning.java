import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> lessonsSoftUni = Arrays.stream(scanner.nextLine()
                .split(", "))
                .collect(Collectors.toList());

        //String[] commands = scanner.nextLine().split(":");

        String input = scanner.nextLine();


        while (!input.equals("course start")) {

            String[] commands = input.split(":");

            String lessonTitle1 = "";
            String lessonTitle2 = "";
            int index1 = 0;
            int index2 = 0;

            if (commands[0].equals("Add")) {
                lessonTitle1 = commands[1];
                if (!lessonsSoftUni.contains(lessonTitle1)) {
                    lessonsSoftUni.add(lessonTitle1);
                }
            }
            if (commands[0].equals("Insert")) {
                lessonTitle1 = commands[1];
                index1 = Integer.parseInt(commands[2]);
                if (!lessonsSoftUni.contains(lessonTitle1)) {
                    lessonsSoftUni.add(index1, lessonTitle1);
                }
            }
            if (commands[0].equals("Remove")) {
                lessonTitle1 = commands[1];
                if (lessonsSoftUni.contains(lessonTitle1)) {
                    index1 = lessonsSoftUni.indexOf(lessonTitle1);
                    if (lessonsSoftUni.get(index1 + 1).equals(lessonTitle1 + "-Exercise")) {
                        lessonsSoftUni.remove(index1);
                        lessonsSoftUni.remove(index1);
                    } else {
                        lessonsSoftUni.remove(index1);
                    }
                }
            }
            if (commands[0].equals("Swap")) {
                lessonTitle1 = commands[1];
                lessonTitle2 = commands[2];
                if (lessonsSoftUni.contains(lessonTitle1) && lessonsSoftUni.contains(lessonTitle2)) {
                    index1 = lessonsSoftUni.indexOf(lessonTitle1);
                    index2 = lessonsSoftUni.indexOf(lessonTitle2);
                    if (index2 < lessonsSoftUni.size() - 1) {
                        if (lessonsSoftUni.get(index1 + 1).equals(lessonTitle1 + "-Exercise") && !(lessonsSoftUni.get(index2 + 1).equals(lessonTitle2 + "-Exercise"))) {
                            lessonsSoftUni.set(index2, lessonsSoftUni.get(index1));
                            lessonsSoftUni.add(index2 + 1, lessonsSoftUni.get(index1 + 1));
                            lessonsSoftUni.set(index1, lessonTitle2);
                            lessonsSoftUni.remove(lessonsSoftUni.indexOf(lessonTitle2)+1);
                        } else
                        if (!(lessonsSoftUni.get(index1 + 1).equals(lessonTitle1 + "-Exercise")) && lessonsSoftUni.get(index2 + 1).equals(lessonTitle2 + "-Exercise")) {
                            lessonsSoftUni.set(index1, lessonsSoftUni.get(index2));
                            lessonsSoftUni.add(index1 + 1, lessonsSoftUni.get(index2 + 1));
                            lessonsSoftUni.set(index2+1,lessonTitle1);
                            lessonsSoftUni.remove(lessonsSoftUni.indexOf(lessonTitle1)+1);
                        } else
                        if (lessonsSoftUni.get(index1 + 1).equals(lessonTitle1 + "-Exercise") && lessonsSoftUni.get(index2 + 1).equals(lessonTitle2 + "-Exercise")) {
                            lessonsSoftUni.set(index1, lessonsSoftUni.get(index2));
                            lessonsSoftUni.add(index1 + 1, lessonsSoftUni.get(index2 + 1));
                            lessonsSoftUni.set(index2+1,lessonTitle1);
                            lessonsSoftUni.set(index2 + 2, lessonTitle1 + "-Exercise");
                        } else
                        if (!(lessonsSoftUni.get(index1 + 1).equals(lessonTitle1 + "-Exercise")) && !(lessonsSoftUni.get(index2 + 1).equals(lessonTitle2 + "-Exercise"))) {
                            lessonsSoftUni.set(index1, lessonsSoftUni.get(index2));
                            lessonsSoftUni.set(index2, lessonTitle1);
                        }
                    } else {
                        if (lessonsSoftUni.get(index1 + 1).equals(lessonTitle1 + "-Exercise")) {
                            lessonsSoftUni.set(index2, lessonsSoftUni.get(index1));
                            lessonsSoftUni.add(index2 + 1, lessonsSoftUni.get(index1 + 1));
                            lessonsSoftUni.set(index1, lessonTitle2);
                            lessonsSoftUni.remove(lessonsSoftUni.indexOf(lessonTitle2)+1);
                        } else {
                            lessonsSoftUni.set(index1, lessonsSoftUni.get(index2));
                            lessonsSoftUni.set(index2, lessonTitle1);
                        }

                    }
                }
            }
                if (commands[0].equals("Exercise")) {
                    lessonTitle1 = commands[1];
                    if (lessonsSoftUni.contains(lessonTitle1)) {
                        index1 = lessonsSoftUni.indexOf(lessonTitle1);
                        lessonsSoftUni.add(index1 + 1, lessonTitle1 + "-Exercise");
                    } else {
                        lessonsSoftUni.add(lessonTitle1);
                        lessonsSoftUni.add(lessonTitle1 + "-Exercise");
                    }
                }

                input = scanner.nextLine();

            }

            for (int i = 0; i < lessonsSoftUni.size(); i++) {
                System.out.printf("%d.%s%n", i + 1, lessonsSoftUni.get(i));
            }


        }
    }

