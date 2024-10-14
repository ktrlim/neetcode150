package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeIntegerSum {
    public static void main(String[] args) {
        int [] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> sol = threeSum(nums);
        List<List<Integer>> listOfLists = new ArrayList<>();

        // print
        for (List<Integer> list : sol) {
            System.out.print("[");
            for (Integer num : list) {
                System.out.print(num + "  ");
            }
            System.out.println("]");
        }
    }

    public static  List<List<Integer>> threeSum(int[] nums) {
        Set<Integer> seen = new HashSet<>(); // stores numbers already seen
        Set<String> seenSolutions= new HashSet<>(); // stores solutions already seen
        List<List<Integer>> res = new ArrayList<>(); // answer
        Arrays.sort(nums); // sort the list of numbers from least to greatest

        for (int i = 0; i < nums.length; i ++){
            if (!seen.contains(nums[i])) { // do not continue if already checked
                seen.add(nums[i]);
                int left = i + 1; // start left directly behind i
                int right = nums.length - 1; // start right at end of list
                while(left < right) { // while loop to move the right/left pointers
                    int sum = nums[left] + nums[right] + nums[i];
                    if (sum < 0) { // move left pointer to get a greater number
                        left++;
                    } else if (sum > 0) { // move right pointer to get a lesser number
                        right--;
                    } else {
                        // make sure solutions hasn't been seen before by sorting
                        int[] sol = {nums[i], nums[left], nums[right]};
                        Arrays.sort(sol);
                        if (!seenSolutions.contains(Arrays.toString(sol))) {
                            seenSolutions.add(Arrays.toString(sol));
                            res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                            
                        }
                        // increase right and left pointers to continue searching
                        right--;
                        left++;
                    }
                }
                
            }
        }
        return res;
    }
}   
