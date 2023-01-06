package p100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P46Permutations {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3};
        int[] arr2 = new int[]{0,1};
        int[] arr3 = new int[]{1};
        P46Permutations entity = new P46Permutations();
        System.out.println();
        System.out.println(entity.permute(arr1));
        System.out.println(entity.permute(arr2));
        System.out.println(entity.permute(arr3));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 1) {
            result.add(Arrays.asList(nums[0]));
        } else {
            List<List<Integer>> combs;
            List<Integer> temp;
            int[] array;
            int len = nums.length;
            for(int i = 0; i < len; i++) {
                array = new int[len - 1];
                System.arraycopy(nums, 0, array, 0,  i);
                System.arraycopy(nums, i + 1, array, i,  len - i - 1);
                combs = permute(array);
                for (List<Integer> list : combs) {
                    temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.addAll(list);
                    result.add(temp);
                }
            }
        }
        return result;
    }
}
