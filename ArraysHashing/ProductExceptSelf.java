package ArraysHashing;
import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println("Original array: " + Arrays.toString(arr));
        System.out.println("Product except self: " + Arrays.toString(productExceptSelf(arr)));

    }

    public static int[] productExceptSelf(int[] nums) {
        // output will store the final answer
        int[] output = new int[nums.length];
        int right = 1; // set each to 1
        int left = 1;
        // first store all the 'prefix' values
        // in the array starting with 1
        // array will be missing last prefix
        // value and will have an extra 1
        // at the beginning
        for (int i = 0; i < nums.length; i++) {
            output[i] = left;
            left *= nums[i];
        }
        // then iterate backwards through
        // the array from right to left
        // use the prefix values to find the 'postfix'
        // not including itself
        for(int i = nums.length - 1; i >= 0; i--) {
            output[i] *= right;
            right *= nums[i];
        }
        return output;
    }
}
