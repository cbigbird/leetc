package p100;

import java.util.Arrays;

public class P34FindFirstAnfLastPotionOfElement {
    public static void main(String[] args) {
        P34FindFirstAnfLastPotionOfElement entity = new P34FindFirstAnfLastPotionOfElement();
        System.out.println();
        int[] arr1 = new int[] {5,7,7,8,8,10};
        int[] arr2 = new int[] {5,7,7,8,8,10};
        int[] arr3 = new int[] {};
        int[] arr4 = new int[] {2,2};
        int a1 = 8;
        int a2 = 6;
        int a3 = 0;
        int a4 = 2;
        System.out.println(Arrays.toString(entity.searchRange(arr1, a1)));
        System.out.println(Arrays.toString(entity.searchRange(arr2, a2)));
        System.out.println(Arrays.toString(entity.searchRange(arr3, a3)));
        System.out.println(Arrays.toString(entity.searchRange(arr4, a4)));
    }
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int m;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == target) {
                l = m;
                r = m;
                while (l > 0 && nums[l - 1] == target) {
                    l = l - 1;
                }
                while (r < nums.length - 1 && nums[r + 1] == target) {
                    r = r + 1;
                }
                return new int[]{l, r};
            } else if (nums[l] <= target && target < nums[m]) {
                r = m - 1;
            } else if (nums[m] < target && target <= nums[r]) {
                l = m + 1;
            } else {
                break;
            }
        }
        return new int[]{-1, -1};
    }
}
