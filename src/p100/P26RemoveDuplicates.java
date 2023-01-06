package p100;

import java.util.Arrays;

public class P26RemoveDuplicates {
    public static void main(String[] args) {
        P26RemoveDuplicates entity = new P26RemoveDuplicates();
        int[] arr1 = new int[]{};
        int[] arr2 = new int[]{1};
        int[] arr3 = new int[]{1,1,2};
        int[] arr4 = new int[]{0,0,1,1,1,2,2,3,3,4};
        int a1 = entity.removeDuplicates(arr1);
        int a2 = entity.removeDuplicates(arr2);
        int a3 = entity.removeDuplicates(arr3);
        int a4 = entity.removeDuplicates(arr4);
        System.out.println();
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        } else {
            int from = 1;
            int to = 1;
            for (; from < nums.length; from++) {
                if (nums[from] != nums[to - 1]) {
                    nums[to] = nums[from];
                    to = to + 1;
                }
            }
            return to;
        }
    }
}
