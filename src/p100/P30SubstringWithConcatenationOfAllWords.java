package p100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P30SubstringWithConcatenationOfAllWords { // Substring with Concatenation of All Words
    public static void main(String[] args) {
        P30SubstringWithConcatenationOfAllWords entity = new P30SubstringWithConcatenationOfAllWords();
        System.out.println();
        System.out.println(entity.findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
        System.out.println(entity.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}));
        System.out.println(entity.findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (s != null && words != null && words.length > 0) {
            int len = words[0].length();
            int sentenceLen = len * words.length;
            if (s.length() >= sentenceLen) {
                Map<String, Integer> map = new HashMap<>();
                for (String word : words) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }
                for (int from = 0; from <= s.length() - words.length * len; from++) {
                    if (find(s, from, from + sentenceLen, len, map)) {
                       result.add(from);
                    }
                }
            }
        }
        return result;
    }

    private boolean find(String s, int from, int to, int len, Map<String, Integer> words) {
        if (s == null || to > s.length()) {
            return false;
        } else if (from == to) {
            return true;
        } else {
            boolean result = false;
            String candidate = s.substring(from, from + len);
            if (words.getOrDefault(candidate, -1) > 0) {
                words.put(candidate, words.get(candidate) - 1);
                result = find(s, from + len, to, len, words);
                words.put(candidate, words.get(candidate) + 1);
            }
            return result;
        }
    }
}
