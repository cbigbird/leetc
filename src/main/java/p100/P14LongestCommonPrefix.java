package main.java.p100;

public class P14LongestCommonPrefix {
    public static void main(String[] args) {
        P14LongestCommonPrefix entity = new P14LongestCommonPrefix();
        String[] strs1 = {"flower","flow","flight"};
        String[] strs2 = {"dog","racecar","car"};
        String[] strs3 = {"","flow","flight"};
        String[] strs4 = {};
        String[] strs5 = {"abcdefg"};
        System.out.println(entity.longestCommonPrefix(strs1));
        System.out.println(entity.longestCommonPrefix(strs2));
        System.out.println(entity.longestCommonPrefix(strs3));
        System.out.println(entity.longestCommonPrefix(strs4));
        System.out.println(entity.longestCommonPrefix(strs5));
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else {
            int minLength = Integer.MAX_VALUE;
            for (String str : strs) {
                if (minLength > str.length()) {
                    minLength = str.length();
                }
            }
            int len = 0;
            for (int i = 0; i < minLength ; i++) {
                char c = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (c != strs[j].charAt(i)) {
                        return strs[0].substring(0, len);
                    }
                }
                len = len + 1;
            }
            return strs[0].substring(0, len);
        }
    }
}
