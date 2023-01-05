import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P47PermutationsII {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,1,2};
        int[] arr2 = new int[]{1,2,3};
        int[] arr3 = new int[]{1,1,1,2};
        P47PermutationsII entity = new P47PermutationsII();
        System.out.println();
        System.out.println(entity.permuteUnique(arr1));
        System.out.println(entity.permuteUnique(arr2));
        System.out.println(entity.permuteUnique(arr3));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length == 1) {
            result.add(Arrays.asList(nums[0]));
        } else {
            List<List<Integer>> combs;
            List<Integer> temp;
            int[] array;
            int len = nums.length;
            for(int i = 0; i < len; i++) {
                if (i == 0 || nums[i] != nums[i - 1]) {
                    array = new int[len - 1];
                    System.arraycopy(nums, 0, array, 0,  i);
                    System.arraycopy(nums, i + 1, array, i,  len - i - 1);
                    combs = permuteUnique(array);
                    for (List<Integer> list : combs) {
                        temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.addAll(list);
                        result.add(temp);
                    }
                }
            }
        }
        return result;
    }
}
