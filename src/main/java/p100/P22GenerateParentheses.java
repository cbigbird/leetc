package main.java.p100;

import java.util.ArrayList;
import java.util.List;

public class P22GenerateParentheses {
    public static void main(String[] args) {
        P22GenerateParentheses entity = new P22GenerateParentheses();
        System.out.println();
        System.out.println(entity.generateParenthesis(1));
        System.out.println(entity.generateParenthesis(2));
        System.out.println(entity.generateParenthesis(3));
        System.out.println(entity.generateParenthesis(4));
        System.out.println(entity.generateParenthesis(5));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, n, new StringBuffer(), result);
        return result;
    }

    private void dfs(int l, int r, StringBuffer sb, List<String> result) {
        System.out.println("dfs: " + l + ", " + r + ", " + sb.toString() + "");
        if (l == 0 && r == 0) {
            result.add(sb.toString());
        }
        if (l > 0) {
            sb.append("(");
            dfs(l - 1, r, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (l < r) {
            sb.append(")");
            dfs(l, r - 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
