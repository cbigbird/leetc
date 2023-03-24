package main.java.p100;

import java.util.*;

public class P49GroupAnagrams {
    public static void main(String[] args) {
        String[] arr1 = new String[]{"eat","tea","tan","ate","nat","bat"};
        String[] arr2 = new String[]{""};
        String[] arr3 = new String[]{"a"};
        P49GroupAnagrams entity = new P49GroupAnagrams();
        System.out.println();
        System.out.println(entity.groupAnagrams(arr1));
        System.out.println(entity.groupAnagrams(arr2));
        System.out.println(entity.groupAnagrams(arr3));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        String[] arr = new String[len];
        char[] chars;
        for (int i = 0; i < len; i++) {
            chars = strs[i].toCharArray();
            Arrays.sort(chars);
            arr[i] = new String(chars);
        }

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.get(arr[i]) == null) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}
