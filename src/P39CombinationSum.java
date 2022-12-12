import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P39CombinationSum {
    public static void main(String[] args) {
        P39CombinationSum entity = new P39CombinationSum();
        int[] arr1 = new int[]{2,3,6,7};
        int[] arr2 = new int[]{2,3,5};
        int[] arr3 = new int[]{2};
        int[] arr4 = new int[]{3,5,8};
        int n1 = 7;
        int n2 = 8;
        int n3 = 1;
        int n4 = 11;
        System.out.println();
        List<List<Integer>> r1 = entity.combinationSum(arr1, n1);
        System.out.println(r1);
        List<List<Integer>> r2 = entity.combinationSum(arr2, n2);
        System.out.println(r2);
        List<List<Integer>> r3 = entity.combinationSum(arr3, n3);
        System.out.println(r3);
        List<List<Integer>> r4 = entity.combinationSum(arr4, n4);
        System.out.println(r4);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        comb(candidates, 0, target, result, new ArrayList<>());
        return result;
    }

    private void comb(int[] candidates, int from, int target, List<List<Integer>> result, List<Integer> curr) {
        if (target == 0) {
            result.add(curr);
        } else if (candidates != null && candidates.length > 0 && from < candidates.length) {
            List<Integer> list;
            for (int i = 0; candidates[from] * i <= target; i++) {
                list = new ArrayList<>(curr);
                for (int x = 0; x < i; x++) {
                    list.add(candidates[from]);
                }
                comb(candidates, from + 1, target - candidates[from] * i, result, list);
            }
        }
    }
}
