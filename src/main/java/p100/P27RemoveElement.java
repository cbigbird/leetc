package main.java.p100;

import java.util.Arrays;

public class P27RemoveElement {
    public static void main(String[] args) {
        P27RemoveElement entity = new P27RemoveElement();
        int[] arr1 = new int[]{};
        int[] arr2 = new int[]{1};
        int[] arr3 = new int[]{3,2,2,3};
        int[] arr4 = new int[]{0,1,2,2,3,0,4,2};
        int a1 = entity.removeElement(arr1, 1);
        int a2 = entity.removeElement(arr2, 2);
        int a3 = entity.removeElement(arr3, 3);
        int a4 = entity.removeElement(arr4, 2);
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

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int num : nums) {
            if (num != val) {
                nums[i] = num;
                i = i + 1;
            }
        }
        return i;
    }
}
