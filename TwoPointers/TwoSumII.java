package TwoPointers;

import java.util.Arrays;

public class TwoSumII {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] solution = twoSum(nums, 3);
        System.out.print("The index of the elements that sum to 3 for " + Arrays.toString(nums) + " are " );
        for(int n : solution) {
            System.out.print(n + " ");
        }

    }
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] solution = new int[2];
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                // index doesnt start at 0 for solution so + 1
                solution[0] = left + 1;
                solution[1] = right + 1;
                break;
            }
        }
        return solution;
    }
}
