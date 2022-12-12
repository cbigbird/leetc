public class P33SearchInRotatedSortedArray {
    public static void main(String[] args) {
        P33SearchInRotatedSortedArray entity = new P33SearchInRotatedSortedArray();
        int[] arr1 = new int[]{4,5,6,7,0,1,2};
        int[] arr2 = new int[]{4,5,6,7,0,1,2};
        int[] arr3 = new int[]{1};
        int[] arr4 = new int[]{3,1};
        int a1 = 0;
        int a2 = 3;
        int a3 = 0;
        int a4 = 1;
        System.out.println();
//        System.out.println(entity.search(arr1, a1));
//        System.out.println(entity.search(arr2, a2));
//        System.out.println(entity.search(arr3, a3));
        System.out.println(entity.search(arr4, a4));
    }

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int m;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[l] <= nums[m]) {
                if (nums[l] <= target && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (nums[m] < target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}
