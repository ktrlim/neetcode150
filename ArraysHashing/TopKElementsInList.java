package ArraysHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Given an integer array nums and an integer k,
// return the k most frequent elements within the array.

// The test cases are generated such that the answer is always unique.

// You may return the output in any order.

public class TopKElementsInList {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,3};
        int k = 2;
        int[] res = topKFrequent(nums, k);
        System.out.println("Original array: " + Arrays.toString(nums) + " and top " + k + " elements " + Arrays.toString(res));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        // map to store counts
        HashMap<Integer, Integer> counts = new HashMap<>();
        // list to store freq
        // length is +1 in case a nums arr has all same
        // 0 not used
        List<Integer>[] freq = new List[nums.length + 1];
        
        // initialize the freq list
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        // count how many times each element is seen
        // and store in hash map
        for (int i = 0; i < nums.length; i++) {
            if (!counts.containsKey(nums[i])) {
                counts.put(nums[i], 1);
            } else {
                counts.put(nums[i], counts.get(nums[i]) + 1);
            }
        }
        
        // add the elements from nums to the freq map
        // using the freq as the key
        // [k, v] -> [freq, list of elements with freq]
        for (Map.Entry<Integer, Integer> entry: counts.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] ans = new int[k];
        int index = 0; // index for ans starts at 0

        // go backwards in freq list and gather most freq elememts
        // stop when k elements are found
        for(int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n : freq[i]) { // itereates through lists at each freq
                ans[index++] = n;
                // after adding an element to ans check if k elements have been added
                if (index == k) {
                    return ans;
                }
            }
        }

        return ans;
    }
}
