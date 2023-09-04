public class MajorityElements {
    public static void main(String args[]) {
        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement(nums));
    }

    static int majorityElement(int[] nums) {
        // variables to hold the essential values.
        int candidate = nums[0];
        int cnt = 1;
        int n = nums.length;
        // Iterating over the candidates in nums using moores voting algorithm
        for (int i = 0; i < n; i++) {
            if (candidate == nums[i]) {
                cnt++;
            } else {
                cnt--;
            }

            if (cnt == 0) {
                candidate = nums[i];
                cnt = 1;
            }
        }
        // verify the candidate's count
        cnt = 0;
        for (int i = 0; i < n; i++) {
            if (candidate == nums[i]) {
                cnt++;
            }
        }
        // if the count of particular candidate is greator then n/2 then we found the
        // answer else return -1.
        if (cnt > nums.length / 2) {
            return candidate;
        }
        // if answer not found simply return -1.
        return -1;
    }

}
