package main.java.p100;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class P56MergeIntervals {
    public static void main(String[] args) {
        P56MergeIntervals entity = new P56MergeIntervals();
        int[][] a1 = new int[][] {
                new int[]{1,3},
                new int[]{2,6},
                new int[]{8,10},
                new int[]{15,18},
        };
        int[][] a2 = new int[][] {
                new int[]{1,4},
                new int[]{4,5},
        };
        int[][] a3 = new int[][] {
                new int[]{1,3},
                new int[]{4,5},
                new int[]{10,18},
                new int[]{0,16},
        };
        int[][] a4 = new int[][] {
                new int[]{362,367},new int[]{314,315},new int[]{133,138},new int[]{434,443},new int[]{202,203},new int[]{144,145},new int[]{229,235},new int[]{205,212},new int[]{314,323},new int[]{128,129},new int[]{413,414},new int[]{342,345},new int[]{43,49},new int[]{333,342},new int[]{173,178},new int[]{386,391},new int[]{131,133},new int[]{157,163},new int[]{187,190},new int[]{186,186},new int[]{17,19},new int[]{63,69},new int[]{70,79},new int[]{386,391},new int[]{98,102},new int[]{236,239},new int[]{195,195},new int[]{338,338},new int[]{169,170},new int[]{151,153},new int[]{409,416},new int[]{377,377},new int[]{90,96},new int[]{156,165},new int[]{182,186},new int[]{371,372},new int[]{228,233},new int[]{297,306},new int[]{56,61},new int[]{184,190},new int[]{401,403},new int[]{221,228},new int[]{203,212},new int[]{39,43},new int[]{83,84},new int[]{66,68},new int[]{80,83},new int[]{32,32},new int[]{182,182},new int[]{300,306},new int[]{235,238},new int[]{267,272},new int[]{458,464},new int[]{114,120},new int[]{452,452},new int[]{372,375},new int[]{275,280},new int[]{302,302},new int[]{5,9},new int[]{54,62},new int[]{237,237},new int[]{432,439},new int[]{415,421},new int[]{340,347},new int[]{356,358},new int[]{165,168},new int[]{15,17},new int[]{259,265},new int[]{201,204},new int[]{192,197},new int[]{376,383},new int[]{210,211},new int[]{362,367},new int[]{481,488},new int[]{59,64},new int[]{307,315},new int[]{155,164},new int[]{465,467},new int[]{55,60},new int[]{20,24},new int[]{297,304},new int[]{207,210},new int[]{322,328},new int[]{139,142},new int[]{192,195},new int[]{28,36},new int[]{100,108},new int[]{71,76},new int[]{103,105},new int[]{34,38},new int[]{439,441},new int[]{162,168},new int[]{433,433},new int[]{368,369},new int[]{137,137},new int[]{105,112},new int[]{278,280},new int[]{452,452},new int[]{131,132},new int[]{475,480},new int[]{126,129},new int[]{95,104},new int[]{93,99},new int[]{394,403},new int[]{70,78}
        };
        System.out.println(System.currentTimeMillis());
//        System.out.println(entity.merge(a1));
//        System.out.println(entity.merge(a2));
//        System.out.println(entity.merge(a3));
        System.out.println(entity.merge(a4));
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        List<Pair<Integer, Boolean>> points = new ArrayList<>();
        for (int[] p : intervals) {
            points.add(new Pair<>(p[0], true));
            points.add(new Pair<>(p[1], false));
        }
        points.sort((a, b) -> {
            if (Objects.equals(a.key, b.key)) {
                if (Objects.equals(a.value, b.value)) {
                    return 0;
                } else {
                    return a.value ? -1 : 1;
                }
            } else {
                return a.key - b.key;
            }
        });
        Pair<Integer, Boolean> pair;
        int left = -1;
        int right = -1;
        for (int l = 0, r = 0, i = 0; i < points.size(); i++) {
            pair = points.get(i);
            if (pair.value) { // left point
                l = l + 1;
                left = left < 0 ? pair.key : left;
            } else { // right point
                r = r + 1;
                right = pair.key;
            }
            if (l == r) {
                result.add(new int[]{left, right});
                left = -1;
                right = -1;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    private class Pair<K, V> {
        private K key;
        private V value;
        public Pair(K k, V v) {
            this.key = k;
            this.value = v;
        }
    }
}
