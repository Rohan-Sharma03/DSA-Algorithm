class FindFirstAndLastIndex {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 3, 4, 7, 7, 7, 7, 7, 8, 8, 8 };
        findIndex(nums, 7);
    }

    static void findIndex(int[] nums, int num) {
        int left = 0, right = nums.length - 1, firstOc = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == num) {
                firstOc = mid;
                right = mid - 1;
            } else if (nums[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        left = 0;
        right = nums.length - 1;
        int lastOc = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == num) {
                lastOc = mid;
                left = mid + 1;
            } else if (nums[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(firstOc + " " + lastOc);
    }
}