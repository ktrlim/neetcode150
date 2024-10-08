package Misc;


import java.util.*;

public class SummaryRanges2 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        List<String> res = summaryRanges(nums);
        for (String s : res) {
            System.out.print(s + " ");
        }
    }
    // 0, 1, 2, 4, 5, 7
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums.length == 0) return res;
        int start = 0; // index of starting pointer
        // end pointer is always 1 ahead of start
        for (int end = 1; end <= nums.length; end++) { // end pointer starts at 1
            // if stmt checks that end is within bounds (gets rid of length 1 array case)
            // then checks if there is a jump
            if(end == nums.length || nums[end] != nums[end - 1] + 1 ) {
                if(start == end - 1) { // if no range just add number itself
                    res.add(Integer.toString(nums[start]));
                }
                else { // if there is a range (start !- end - 1 add arrow)
                    res.add(Integer.toString(nums[start]) + "->" + Integer.toString(nums[end - 1]));
                }
                start = end;
            }
        }
            
        return res;
    }
}