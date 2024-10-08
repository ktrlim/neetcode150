package Misc;
import java.util.*;

public class SummaryRanges {
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
        
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            while (i + 1< nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (start != nums[i])
                res.add(Integer.toString(start) + "->" + Integer.toString(nums[i]));
            else
                res.add(Integer.toString(start));
        }
        return res;
    }
}

