public class P35SearchInsertPosition { // Search Insert Position
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,3,5,6};
        int[] arr2 = new int[]{1,3,5,6};
        int[] arr3 = new int[]{1,3,5,6};
        int[] arr4 = new int[]{1,3};
        int a1 = 1;
        int a2 = 2;
        int a3 = 7;
        int a4 = 2;
        P35SearchInsertPosition entity = new P35SearchInsertPosition();
        System.out.println();
        System.out.println(entity.searchInsert(arr1, a1));
        System.out.println(entity.searchInsert(arr2, a2));
        System.out.println(entity.searchInsert(arr3, a3));
        System.out.println(entity.searchInsert(arr4, a4));
    }

    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (target < nums[l]) {
                return l;
            } else if (target > nums[r]) {
                return r + 1;
            } else if (target == nums[m]) {
                return m;
            } else if (nums[l] <= target && target < nums[m]) {
                r = m - 1;
            } else if (nums[m] < target && target <= nums[r]) {
                l = m + 1;
            } else {
                break;
            }
        }
        return m;
    }
}
