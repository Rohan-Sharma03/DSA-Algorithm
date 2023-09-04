import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public static void main(String args[]) {
        int nums[] = { -1, 0, 1, 2, -1, -4 };

        // #Approach 1 (brute force)
        /*
         * 
         * 
         * // used to save the triplet and avoid duplicate combinations
         * Set<List<Integer>> set = new HashSet<>();
         * int n = nums.length;
         * // Iterate over each possible combination of triplet.
         * for (int i = 0; i < n; i++) {
         * for (int j = i + 1; j < n; j++) {
         * for (int k = j + 1; k < n; k++) {
         * // check if the sum of the current triplet is 0, if so add it to set.
         * if (nums[i] + nums[j] + nums[k] == 0) {
         * List<Integer> triplet = new ArrayList<>();
         * // conversion of array to array list
         * triplet = Arrays.asList(nums[i], nums[j], nums[k]);
         * // sorting tiplet list ot avoid confusion in finding duplicate.
         * Collections.sort(triplet);
         * // adding to set
         * set.add(triplet);
         * }
         * }
         * }
         * }
         * // retruning set as array list
         * return new ArrayList<>(set);
         * 
         */

        // Approach 2 (HashSet)
        /*
         * 
         * 
         * // Sorting nums to avoid duplication of triplet.
         * Arrays.sort(nums);
         * // List to store answer i.e., triplets
         * List<List<Integer>> res = new ArrayList<>();
         * // Map to store the index position of the values in nums.
         * HashMap<Integer, Integer> map = new HashMap<>();
         * int n = nums.length;
         * // Adding values to the map
         * for (int i = 0; i < n; i++) {
         * map.put(nums[i], i);
         * }
         * // Here we have fixed the target value as 0 and need to find the third value
         * as num1 and num2 can be brute-forced.
         * for (int i = 0; i < n - 2; i++) {
         * // Break if the first value is greater than 0
         * if (nums[i] > 0) break;
         * for (int j = i + 1; j < n - 1; j++) {
         * // Finding the third value.
         * int target = 0 - nums[i] - nums[j];
         * // Check if the value of the generated number is in the map and its index
         * position is greater than j (i.e., second number).
         * if (map.containsKey(target) && map.get(target) > j) {
         * res.add(Arrays.asList(nums[i], nums[j], target));
         * // get the value of j as of current second number.
         * j = map.get(nums[j]);
         * }
         * }
         * // get the value of j as of current first number.
         * i=map.get(nums[i]);
         * }
         * // Returning the result
         * System.out.println(res);
         */

        // #Appraoch 3 (two Ptr)
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // Sort the input array in ascending order.
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) { // Avoid duplicate triplets by skipping identical numbers.
                int j = i + 1; // Pointer to the element immediately to the right of nums[i].
                int k = n - 1; // Pointer to the last element in the array.
                int target = 0 - nums[i]; // Calculate the target value for the triplet sum.
                while (j < k) {
                    if (nums[j] + nums[k] == target) { // If a triplet is found with the desired sum.
                        List<Integer> triplet = new ArrayList<>();
                        triplet = Arrays.asList(nums[i], nums[j], nums[k]); // Create a triplet and add it to the
                                                                            // result.
                        res.add(triplet);
                        while (j < k && nums[j] == nums[j + 1])
                            j++; // Skip duplicates of nums[j].
                        while (j < k && nums[k] == nums[k - 1])
                            k--; // Skip duplicates of nums[k].
                        j++; // Move the left pointer to the right.
                        k--; // Move the right pointer to the left.
                    } else if (nums[j] + nums[k] < target) {
                        j++; // If the sum is less than the target, move the left pointer to the right.
                    } else {
                        k--; // If the sum is greater than the target, move the right pointer to the left.
                    }
                }
            }
        }
        System.out.println(res);
        // return res; // Return the list of valid triplets.

    }
}
