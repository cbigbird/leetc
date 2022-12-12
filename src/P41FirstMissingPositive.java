import java.util.HashMap;
import java.util.Map;

public class P41FirstMissingPositive {
    public static void main(String[] args) {
        P41FirstMissingPositive entity = new P41FirstMissingPositive();
        int[] arr1 = new int[]{1,2,0};
        int[] arr2 = new int[]{3,4,-1,1};
        int[] arr3 = new int[]{7,8,9,11,12};
        int[] arr4 = new int[]{1,2,3,10,2147483647,9};
        System.out.println();
        System.out.println(entity.firstMissingPositive(arr1));
        System.out.println(entity.firstMissingPositive(arr2));
        System.out.println(entity.firstMissingPositive(arr3));
        System.out.println(entity.firstMissingPositive(arr4));
        System.out.println();
        System.out.println(entity.firstMissingPositiveII(arr1));
        System.out.println(entity.firstMissingPositiveII(arr2));
        System.out.println(entity.firstMissingPositiveII(arr3));
        System.out.println(entity.firstMissingPositiveII(arr4));
    }

    public int firstMissingPositive(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i > 0) {
                min = Math.min(min, i);
                max = Math.max(max, i);
            }
        }
        if (min > max || min > 1) {
            return 1;
        } else {
            Map<Integer, Boolean> exist = new HashMap<>();
            for (int i : nums) {
                if (i > 0) {
                    exist.put(i, true);
                }
            }
            for (int i = min; i <= max; i++) {
                if (!exist.getOrDefault(i, false)) {
                    return i;
                }
            }
            return max + 1;
        }
    }

    public int firstMissingPositiveII(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            // should have these:
            // nums[i] = i + 1
            // nums[i] - 1 = i
            // nums[nums[i] - 1] = nums[i]
            while (nums[i] > 0 && nums[i] - 1 < nums.length && nums[nums[i] - 1] != nums[i]) {
                temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
