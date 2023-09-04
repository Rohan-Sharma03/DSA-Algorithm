class FindMinIndex {
    public static void main(String args[]) {
        int[] nums = { 4, 7, 8, 2, 3 };
        // int[] nums = { 2, 3, 4, 7, 8 };
        System.out.println(findMin(nums));
    }

    private static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}