public class BinarySearchInRoatededSortedArray {
    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 6, 7, 8, 1, 2 };
        int target = 2;
        int minIdx = minIndex(nums);
        System.out.println(minIdx);
        int ans = BinarySearch(nums, 0, minIdx - 1, target);
        if (ans == -1) {
            ans = BinarySearch(nums, minIdx, nums.length - 1, target);
        }
        System.out.println(ans);

    }

    private static int BinarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    static int minIndex(int nums[]) {
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
