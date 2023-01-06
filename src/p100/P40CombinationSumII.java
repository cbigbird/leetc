package p100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P40CombinationSumII {
    public static void main(String[] args) {
        P40CombinationSumII entity = new P40CombinationSumII();
        int[] arr1 = new int[] {10,1,2,7,6,1,5};
        int[] arr2 = new int[] {2,5,2,1,2};
        int[] arr3 = new int[] {1,1,2};
        int[] arr4 = new int[] {14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,
                16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,
                21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
        int target1 = 8;
        int target2 = 5;
        int target3 = 2;
        int target4 = 27;
        System.out.println();
        List<List<Integer>> result1 = entity.combinationSum2(arr1, target1);
        System.out.println(result1);
        List<List<Integer>> result2 = entity.combinationSum2(arr2, target2);
        System.out.println(result2);
        List<List<Integer>> result3 = entity.combinationSum2(arr3, target3);
        System.out.println(result3);
        List<List<Integer>> result4 = entity.combinationSum2(arr4, target4);
        System.out.println(result4);
        System.out.println();
        List<List<Integer>> result11 = entity.combinationSumII(arr1, target1);
        System.out.println(result11);
        List<List<Integer>> result12 = entity.combinationSumII(arr2, target2);
        System.out.println(result12);
        List<List<Integer>> result13 = entity.combinationSumII(arr3, target3);
        System.out.println(result13);
        List<List<Integer>> result14 = entity.combinationSumII(arr4, target4);
        System.out.println(result14);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        for (int n = 1; n <= candidates.length; n++) {
            nSum(candidates, 0, candidates.length - 1, n, target, new ArrayList<>(), result);
        }
        return result;
    }

    private void nSum(int[] candidates, int l, int r, int n, int target, List<Integer> path, List<List<Integer>> result) {
        if (candidates[l] > target) {
            return;
        } else if (n == 1) {
            for (int i = l; i <= r; i ++) {
                if (candidates[i] == target) {
                    path.add(candidates[i]);
                    result.add(path);
                    break;
                }
            }
        } else if (n == 2) {
            List<Integer> list;
            while (l < r) {
                final long sum = candidates[l] + candidates[r];
                if (sum == target) {
                    list = new ArrayList<>(path);
                    list.add(candidates[l]);
                    list.add(candidates[r]);
                    result.add(list);
                    l = l + 1;
                    r = r - 1;
                    while (candidates[l] == candidates[l - 1] && l < r) {
                        l = l + 1;
                    }
                    while (candidates[r] == candidates[r + 1] && l < r) {
                        r = r - 1;
                    }
                } else if (sum < target) {
                    l = l + 1;
                } else {
                    r = r - 1;
                }
            }
        } else {
            for (int i = l; i < r; i++) {
                if (i == l || candidates[i] != candidates[i - 1]) {
                    path.add(candidates[i]);
                    nSum(candidates, i + 1, r, n - 1, target - candidates[i], path, result);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    public List<List<Integer>> combinationSumII(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] candidates, int s, int target, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
        } else if (target > 0) {
            for (int i = s; i < candidates.length; i++) {
                if (i == s || candidates[i] != candidates[i - 1]) {
                    path.add(candidates[i]);
                    dfs(candidates, i + 1, target - candidates[i], path, result);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}
