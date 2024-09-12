package ArraysHashing;

import java.util.*;

public class DuplicateInteger {
    public static void main(String args[]) {
        int[] nums = {1, 2, 3, 3};
        boolean ans = hasDuplicate(nums);
        System.out.println("Array " + Arrays.toString(nums) + " has duplicate?: " + ans);
    }
    public static boolean hasDuplicate(int[] nums) {
        Set<Integer> occurs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (occurs.contains(nums[i])) {
                return true;
            }
            occurs.add(nums[i]);
        } 
        return false;
    }
}