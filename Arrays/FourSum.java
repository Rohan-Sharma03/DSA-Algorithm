import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
    public static void main(String args[]) {

        // # Approach 1 (without lexicography sorting)
        int[] nums = { 1, 0, -1, 0, -2, 2 };
        int target = 0;
        // Storing values in set to avoid duplicate possibilities of the answer
        Set<List<Integer>> ansSet = new HashSet<>();
        // sorting given array to get answer in proper order
        Arrays.sort(nums);
        // lenght of given array.
        int n = nums.length;
        // Iterate over the nums to get combination of the values which statisfies the
        // answer. (value of num1 and num2 are brute forced)
        // brute force the value of num1
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicate values
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // brute force the value of num2
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicate values
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // using idea of binary search to find the value of num3 and num4
                int left = j + 1; // assumed num3
                int right = n - 1; // asummed num4
                // using long, as the sum might exceed the value of int
                long newTarget = (long) target - nums[i] - nums[j];
                // serch the value of target with sum of ppossible num3 and num4 value.
                while (left < right) {
                    long sum = (long) nums[left] + nums[right];
                    // if value found add it to set.
                    if (sum == newTarget) {
                        ansSet.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // skip duplicate
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        // skip duplicate
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    }
                    // then move the left ptr to right
                    else if (sum < newTarget) {
                        left++;
                    }
                    // else move the right ptr to left
                    else {
                        right--;
                    }
                }
            }
        }
        // return answer
        // return new ArrayList<>(ansSet);
        System.out.println(new ArrayList<>(ansSet));

        // # Approach 2 (without lexicography sorting)
        // Set<ArrayList<Integer>> ansSet = new HashSet<>();

        // Arrays.sort(nums);
        // int n = nums.length;
        // for (int i = 0; i < n; i++) {
        // for (int j = i + 1; j < n; j++) {
        // if (j == i + 1 || nums[j] != nums[j - 1]) {
        // int k = j + 1;
        // int l = n - 1;

        // int newTarget = target - nums[i] - nums[j];
        // while (k < l) {
        // if (nums[k] + nums[l] == newTarget) {
        // ArrayList<Integer> quadruplets = new ArrayList<>(
        // Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
        // ansSet.add(quadruplets);
        // while (k < l && nums[k] == nums[l])
        // k++;
        // while (k < l && nums[l] == nums[l - 1])
        // l--;
        // k++;
        // l--;
        // } else if (nums[k] + nums[l] < newTarget) {
        // k++;
        // } else {
        // l--;
        // }
        // }
        // }
        // }
        // }

        // // Convert the Set to an ArrayList and sort it lexicographically
        // List<List<Integer>> ansList = new ArrayList<>(ansSet);
        // Collections.sort(ansList, (a, b) -> {
        // for (int i = 0; i < a.size(); i++) {
        // if (!a.get(i).equals(b.get(i))) {
        // return a.get(i) - b.get(i);
        // }
        // }
        // return 0;
        // });
        // System.out.println(ansList);
        // // return ansList;

    }
}
