package p100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P17LetterCombinations {
    public static void main(String[] args) {
        P17LetterCombinations entity = new P17LetterCombinations();
        System.out.println();
        System.out.println(entity.letterCombinations(""));
        System.out.println(entity.letterCombinations("2"));
        System.out.println(entity.letterCombinations("23"));
        System.out.println(entity.letterCombinations("234"));
        System.out.println();
        System.out.println(entity.letterCombinations2(""));
        System.out.println(entity.letterCombinations2("2"));
        System.out.println(entity.letterCombinations2("23"));
        System.out.println(entity.letterCombinations2("234"));
        System.out.println();
        System.out.println(entity.letterCombinations3(""));
        System.out.println(entity.letterCombinations3("2"));
        System.out.println(entity.letterCombinations3("23"));
        System.out.println(entity.letterCombinations3("234"));
    }

    public List<String> letterCombinations(String digits) {
        char[][] dict = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'},
        };
        if (digits.length() == 0) {
            return new ArrayList<>(0);
        }

        char[] chars = digits.toCharArray();
        char[] characters = null;
        char[][] current = null;
        char[][] next = null;
        int index;
        for(int i = 0; i < chars.length; i++) {
            characters = dict[chars[i] - 50];
            if (i == 0) {
                current = new char[characters.length][];
                for(int j = 0; j < characters.length; j++) {
                    current[j] = new char[]{characters[j]};
                }
                next = current;
            } else {
                current = next;
                next = new char[current.length * characters.length][];
                for (int j = 0; j < current.length; j++) {
                    for (int k = 0; k < characters.length; k++) {
                        index = j * characters.length + k;
                        next[index] = Arrays.copyOf(current[j], current[0].length + 1);
                        next[index][current[0].length] = characters[k];
                    }
                }
            }
        }

        List<String> result = new ArrayList<>(next.length);
        for (char[] cs : next) {
            result.add(new String(cs));
        }

        return result;
    }

    public List<String> letterCombinations2(String digits) {
        if (digits.isEmpty())
            return new ArrayList<>();

        List<String> ans = new ArrayList<>();

        dfs(digits, 0, new StringBuilder(), ans);
        return ans;
    }

    public List<String> letterCombinations3(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        result.add("");
        for (char digit : digits.toCharArray()) {
            List<String> temp = new ArrayList<>();
            for (char c : digitToLetters[digit - '0'].toCharArray()) {
                for (String s : result) {
                    temp.add(s + c);
                }
            }
            result = temp;
        }

        return result;
    }

    private static final String[] digitToLetters = {"",    "",    "abc",  "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private void dfs(String digits, int i, StringBuilder sb, List<String> ans) {
        if (i == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        for (final char c : digitToLetters[digits.charAt(i) - '0'].toCharArray()) {
            sb.append(c);
            dfs(digits, i + 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
