import java.util.ArrayList;
import java.util.List;

public class TargetSumSelection {
    public static void main(String[] args) {
        int nums[] = { 10, 20, 30, 40, 50 };
        int target = 60;
        List<List<Integer>> res = new ArrayList<>();
        generatePermutations(nums, 0, target, new ArrayList<>(), res);
        System.out.println(res);
    }

    // Function to generate permutations with a target sum
    private static void generatePermutations(int[] nums, int pos, int target, ArrayList<Integer> current,
            List<List<Integer>> res) {
        // If the target becomes negative, stop this branch of recursion
        if (target < 0) {
            return;
        }

        // If we have processed all elements in nums
        if (pos == nums.length) {
            // If the target is now 0, we have found a valid permutation
            if (target == 0) {
                // Add the current permutation to the result list
                res.add(new ArrayList<>(current));
            }
            return;
        }

        // Include the pos'th element in the current permutation
        current.add(nums[pos]);
        generatePermutations(nums, pos + 1, target - nums[pos], current, res);

        // Backtrack: Remove the last added element to explore other possibilities
        current.remove(current.size() - 1);

        // Exclude the pos'th element from the current permutation
        generatePermutations(nums, pos + 1, target, current, res);
    }
}
