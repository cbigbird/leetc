package main.java.p100;

import java.util.Arrays;

public class P31NextPermutation { // Next Permutation
    public static void main(String[] args) {
        // [2,3,45,6,7,3]
        P31NextPermutation entity = new P31NextPermutation();
        int[] arr1 = new int[]{1,2,3};
        int[] arr2 = new int[]{3,2,1};
        int[] arr3 = new int[]{1,1,5};
        int[] arr4 = new int[]{2,3,45,6,7,3};
        int[] arr5 = new int[]{1,3,2};
        entity.nextPermutation(arr1);
        entity.nextPermutation(arr2);
        entity.nextPermutation(arr3);
        entity.nextPermutation(arr4);
        entity.nextPermutation(arr5);
        System.out.println();
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));
        System.out.println(Arrays.toString(arr5));
    }

    public void nextPermutation(int[] nums) {
        if (nums != null && nums.length > 0) {
            int i = nums.length - 1;
            for (; i > 0; i--) {
                if (nums[i -1] < nums[i]) {
                    for (int j = nums.length - 1; j > i - 1; j--) {
                        if (nums[i - 1] < nums[j]) {
                            int temp = nums[j];
                            nums[j] = nums[i - 1];
                            nums[i - 1] = temp;
                            break;
                        }
                    }
                    break;
                }
            }
            Arrays.sort(nums, i, nums.length);
        }
    }
}
