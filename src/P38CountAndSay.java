public class P38CountAndSay {
    public static void main(String[] args) {
        P38CountAndSay entity = new P38CountAndSay();
        System.out.println();
        System.out.println(entity.countAndSay(1));
        System.out.println(entity.countAndSay(2));
        System.out.println(entity.countAndSay(3));
        System.out.println(entity.countAndSay(4));
        System.out.println(entity.countAndSay(10));
    }

    public String countAndSay(int n) {
        return say("1", n - 1);
    }

    private String say(String s, int times) {
        if (times == 0) {
            return s;
        } else {
            StringBuilder sb = new StringBuilder();
            char[] chars = s.toCharArray();
            char c = chars[0];
            int count = 1;
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == chars[i - 1]) {
                    count = count + 1;
                } else {
                    sb.append(count);
                    sb.append(c);
                    c = chars[i];
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(c);
            return say(sb.toString(), times - 1);
        }
    }
}
