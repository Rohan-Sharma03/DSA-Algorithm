import java.util.ArrayList;
import java.util.List;

class Permuations {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> result = new ArrayList<>();
        generatePermutations(nums, 0, new boolean[nums.length], new ArrayList<>(), result);
        // return result;
        System.out.println(result);
    }

    // Time complexity : O log(n! *n)
    // Space complexity : O (n)

    static void generatePermutations(int[] nums, int pos, boolean[] used, List<Integer> current,
            List<List<Integer>> result) {
        // If the current permutation is complete, add it to the result
        if (pos == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                // Choose an unused number, mark it as used, and add it to the current
                // permutation
                used[i] = true;
                current.add(nums[i]);
                System.out.println(i + " " + nums[i] + " " + current);
                // Recursively generate permutations for the next position
                generatePermutations(nums, pos + 1, used, current, result);

                // Backtrack: unmark the number as unused and remove it from the current
                // permutation
                used[i] = false;
                current.remove(current.size() - 1);
                System.out.println(i + " " + nums[i] + " " + current);
            }
        }
    }
}