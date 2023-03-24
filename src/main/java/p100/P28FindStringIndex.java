package main.java.p100;

public class P28FindStringIndex {
    public static void main(String[] args) {
        P28FindStringIndex entity = new P28FindStringIndex();
        System.out.println();
        System.out.println(entity.strStr("sadbutsad", "sad"));
        System.out.println(entity.strStr("leetcode", "leeto"));
        System.out.println(entity.strStr("whatthefuckisgoingon", "go"));
        System.out.println(entity.strStr("aaa", "aaa"));
        System.out.println(entity.strStr("mississippi", "issip"));
    }

    public int strStr(String haystack, String needle) {
        return find(haystack.toCharArray(), needle.toCharArray(), 0);
    }

    private int find(char[] haystack, char[] needle, int from) {
        for (int i = 0; i < needle.length; i++) {
            if (from > haystack.length - needle.length) {
                return -1;
            } else if (haystack[from + i] != needle[i]) {
                return find(haystack, needle, from + 1);
            }
        }
        return from;
    }
}
