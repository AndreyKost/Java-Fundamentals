import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        //String[] str=scanner.nextLine().split("!");
        String input = scanner.nextLine();
        int count = 0;
        int max = Integer.MIN_VALUE;
        boolean isValid = false;
        int[] arr = new int[input.length()];
        int min = Integer.MAX_VALUE;
        int bestSequenceIndex=0;
        int bestSequenceSum=Integer.MIN_VALUE;
        int numberOfSequence=0;
        int sum=0;

        while (!input.equals("Clone them!")) {
            numberOfSequence++;
            String[] dnaSequences = input.split("!");
            int[] dna = new int[size];
            for (int i = 0; i < dnaSequences.length; i++) {
                dna[i] = Integer.parseInt(dnaSequences[i]);
            }

            for (int i = 0; i <dna.length ; i++) {
                sum+=dna[i];
            }

            for (int i = 0; i < dna.length; i++) {
                count = 0;
                for (int j = i + 1; j < dna.length; j++) {
                    if (dna[i] == dna[j] && dna[i] == 1) {
                        count++;
                        if (count >= max && i < min) {
                            bestSequenceSum=sum;
                            bestSequenceIndex=numberOfSequence;
                            min = i;
                            max = count;
                            arr = dna;
                            isValid = true;
                        } else if(count>= max && i<=min){
                            if(sum>bestSequenceSum){
                                bestSequenceSum=sum;
                                bestSequenceIndex=numberOfSequence;
                                min = i;
                                max = count;
                                arr = dna;
                                isValid = true;
                            }
                        }
                    } else {
                        break;
                    }

                }

            }
            sum=0;

            input = scanner.nextLine();

        }

        if (isValid) {
            System.out.printf("Best DNA sample %d with sum: %d.%n",bestSequenceIndex,bestSequenceSum);
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("%d ", arr[i]);
            }
        }


    }
}
