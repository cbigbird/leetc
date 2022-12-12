import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P32LongestValidParentheses { // Longest Valid Parentheses
    public static void main(String[] args) {
        String s1 = "";
        String s2 = "(()";
        String s3 = ")()())";
        String s4 = "((())))()()()(()(()()()()())";
        String s5 = ")))))))))";
        P32LongestValidParentheses entity = new P32LongestValidParentheses();
        System.out.println();
        System.out.println(entity.longestValidParentheses(s1));
        System.out.println(entity.longestValidParentheses(s2));
        System.out.println(entity.longestValidParentheses(s3));
        System.out.println(entity.longestValidParentheses(s4));
        System.out.println(entity.longestValidParentheses(s5));
        System.out.println();
        System.out.println(entity.longestValidParentheses2(s1));
        System.out.println(entity.longestValidParentheses2(s2));
        System.out.println(entity.longestValidParentheses2(s3));
        System.out.println(entity.longestValidParentheses2(s4));
        System.out.println(entity.longestValidParentheses2(s5));
    }

    public int longestValidParentheses(String s) {
        int result = 0;
        if (s != null && s.length() > 0) {
            char[] chars = s.toCharArray();
            Deque<Integer> stack = new ArrayDeque<>();
            char c;
            for (int i = 1; i < chars.length + 1; i++) {
                c = chars[i - 1];
                if (c == '(') {
                    stack.push(-i);
                } else if (stack.isEmpty() || stack.peek() >= 0) {
                    stack.push(i);
                } else {
                    stack.pop();
                }
            }
            int prev = 0;
            int curr = s.length() + 1;
            while (!stack.isEmpty()) {
                prev = Math.abs(stack.pop());
                result = Math.max(result, curr - prev - 1);
                curr = prev;
            }
            result = Math.max(result, curr - 1);
        }
        return result;
    }

    public int longestValidParentheses2(String s) {
        String t = ")" + s;
        int[] dp = new int[t.length()];
        for (int i = 2; i < t.length(); i++) {
            if (t.charAt(i - dp[i - 1] - 1) == '(' && t.charAt(i) == ')') {
                dp[i] = dp[i - dp[i - 1] - 2] + dp[i - 1] + 2;
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
