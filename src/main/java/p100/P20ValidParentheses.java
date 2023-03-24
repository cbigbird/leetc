package main.java.p100;

import java.util.ArrayDeque;
import java.util.Deque;

public class P20ValidParentheses {
    public static void main(String[] args) {
        P20ValidParentheses entity = new P20ValidParentheses();
        System.out.println();
        System.out.println(entity.isValid("()"));
        System.out.println(entity.isValid("()[]{}"));
        System.out.println(entity.isValid("(]"));
        System.out.println(entity.isValid("{[(()()[][{}])]}"));
        System.out.println();
        System.out.println(entity.isValid2("()"));
        System.out.println(entity.isValid2("()[]{}"));
        System.out.println(entity.isValid2("(]"));
        System.out.println(entity.isValid2("{[(()()[][{}])]}"));
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        char current;
        char another;
        for (int i = 0; i < chars.length; i++) {
            current = chars[i];
            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else if (stack.size() > 0) {
                another = stack.pop();
                if ((another == '(' && current != ')') || (another == '[' && current != ']') || (another == '{' && current != '}')) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.size() == 0;
    }

    public boolean isValid2(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
