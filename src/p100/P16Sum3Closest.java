package p100;

import java.util.Arrays;

public class P16Sum3Closest {
    public static void main(String[] args) {
        P16Sum3Closest entity = new P16Sum3Closest();
        int[] arr1 = {-1,2,1,-4};
        int[] arr2 = {0,0,0};
        int[] arr3 = {1,1,1,0};
        int[] arr4 = {2,3,8,9,10};
        System.out.println();
        System.out.println(entity.threeSumClosest(arr1, 1));
        System.out.println(entity.threeSumClosest(arr2, 1));
        System.out.println(entity.threeSumClosest(arr3, -100));
        System.out.println(entity.threeSumClosest(arr4, 16));
    }
    public int threeSumClosest(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int l, r, diff;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                l = i + 1;
                r = nums.length - 1;
                while (l < r) {
                    diff = nums[i] + nums[l] + nums[r] - target;
                    if (diff == 0) {
                        return target;
                    } else {
                        if (Math.abs(minDiff) > Math.abs(diff)) {
                            minDiff = diff;
                        }
                        if (diff < 0) {
                            do {
                                l = l + 1;
                            } while (nums[l] == nums[l - 1] && l < r);
                        } else {
                            do {
                                r = r - 1;
                            } while (nums[r] == nums[r + 1] && l < r);
                        }
                    }
                }
            }
        }
        return minDiff + target;
    }
}
