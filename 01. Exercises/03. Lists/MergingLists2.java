import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists2 {
    
    public static List<Integer> getRemainingElements(List<Integer> longerList, List<Integer> shorterList){
        List<Integer> nums=new ArrayList<>();
        for (int i = shorterList.size(); i <longerList.size(); i++) {
            nums.add(longerList.get(i));
        }
        return nums;
        
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String values1=scanner.nextLine();
        List<Integer> nums1= Arrays.stream(values1.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String values2=scanner.nextLine();
        List<Integer> nums2=Arrays.stream(values2.split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> resultsNums=new ArrayList<>();

        for (int i = 0; i <Math.min(nums1.size(),nums2.size()) ; i++) {
            resultsNums.add(nums1.get(i));
            resultsNums.add(nums2.get(i));
        }

        if(nums1.size()> nums2.size()){
            resultsNums.addAll(getRemainingElements(nums1,nums2));
        } else if(nums2.size()> nums1.size()){
            resultsNums.addAll(getRemainingElements(nums2,nums1));
        }

        System.out.println(resultsNums.toString().replaceAll(("[\\[\\]]"), ""));



    }
}
