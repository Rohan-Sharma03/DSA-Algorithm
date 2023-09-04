import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public static void main(String args[]) {
        int target = 17;
        int nums[] = { 2, 7, 11, 15 };
        // array to hold ans
        int ans[] = new int[2];
        // hash map to keep track of the correponding pair to match with traget.
        Map<Integer, Integer> map = new HashMap<>();
        // Iterate over the nums to find pair
        for (int i = 0; i < nums.length; i++) {
            int sno = target - nums[i];
            // if map contains the key for statisfying target value, if value found, update
            // answer array values accordingly.
            if (map.containsKey(sno)) {
                ans[0] = map.get(sno);
                ans[1] = i;
                break;
            }
            // else put the values into map.
            map.put(nums[i], i);
        }
        // return answer
        System.out.println(Arrays.toString(ans));
    }
}