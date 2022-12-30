public class P44WildcardMatching {
    public static void main(String[] args) {
        P44WildcardMatching entity = new P44WildcardMatching();
        String s1 = "aa";
        String s2 = "aa";
        String s3 = "cb";
        String s4 = "abcdefghijklmn";
        String s5 = "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaab";
        String s6 = "aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba";
        String s8 = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
        String p1 = "a";
        String p2 = "*";
        String p3 = "?a";
        String p4 = "a*f?*mn";
        String p5 = "a*******b";
        String p6 = "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*";
        String p7 = "*b*aba*babaa*bbaba*a*aaba*b*aa**a*b*ba*a*a*";
        String p8 = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
        String p9 = "*aa*ba*a*bb*aa*ab*a*aaaaaa*a*aaaa*bbabb*b*b*aaaaaaaaa*a*ba*bbb*a*ba*bb*bb**a*b*bb";
//        System.out.println();
//        System.out.println(entity.isMatch(s1, p1));
//        System.out.println(entity.isMatch(s2, p2));
//        System.out.println(entity.isMatch(s3, p3));
//        System.out.println(entity.isMatch(s4, p4));
//        System.out.println(entity.isMatch(s5, p5));
//        System.out.println(entity.isMatch(s6, p6));
//        System.out.println(entity.isMatch(s6, p7));
//        System.out.println(entity.isMatch(s8, p8));
//        System.out.println(entity.isMatch(s8, p9));
        System.out.println();
        System.out.println(entity.isMatchII(s1, p1));
        System.out.println(entity.isMatchII(s2, p2));
        System.out.println(entity.isMatchII(s3, p3));
        System.out.println(entity.isMatchII(s4, p4));
        System.out.println(entity.isMatchII(s5, p5));
        System.out.println(entity.isMatchII(s6, p6));
        System.out.println(entity.isMatchII(s6, p7));
        System.out.println(entity.isMatchII(s8, p8));
        System.out.println(entity.isMatchII(s8, p9));
    }

    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        } else if (s.length() == 0) {
            return p.charAt(0) == '*' && isMatch(s, p.substring(1));
        } else if (p.charAt(0) != '*') {
            return (p.charAt(0) == '?' || p.charAt(0) == s.charAt(0))
                    && isMatch(s.substring(1), p.substring(1));
        } else if (p.charAt(p.length() - 1) != '*') {
            return (p.charAt(p.length() - 1) == '?' || p.charAt(p.length() - 1) == s.charAt(s.length() - 1))
                    && isMatch(s.substring(0, s.length() - 1), p.substring(0, p.length() - 1));
        } else if (p.charAt(0) == '*') {
            if (p.length() > 1 && p.charAt(1) == '*') {
                return isMatch(s, p.substring(1));
            } else {
                return isMatch(s.substring(1), p) || isMatch(s, p.substring(1));
            }
        } else {
            return false;
        }
    }

    public boolean isMatchII(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] match = new boolean[m + 1][n + 1];
        match[0][0] = true;
        for (int i = 0; i < n && p.charAt(i) == '*'; i++) {
            match[0][i + 1] = true;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p.charAt(j) == '*') {
                    match[i + 1][j + 1] = match[i][j + 1] || match[i + 1][j];
                } else {
                    if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
                        match[i + 1][j + 1] = match[i][j];
                    }
                }
            }
        }
        return match[m][n];
    }
}
