package main.java.p100;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class P43MultiplyStrings {
    public static void main(String[] args) {
        P43MultiplyStrings e = new P43MultiplyStrings();
        String[] arr1 = new String[]{"2", "3"}; // 6
        String[] arr2 = new String[]{"123", "456"}; // 56088
        String[] arr3 = new String[]{"12304958690706845736126749659076980369670708", "627348459560795874638398"};
        System.out.println();
        System.out.println(e.multiply(arr1[0], arr1[1]));
        System.out.println(e.multiply(arr2[0], arr2[1]));
        System.out.println(e.multiply(arr3[0], arr3[1]));
    }

    public String multiply(String num1, String num2) {
        StringBuffer sb = new StringBuffer();
        if (Objects.equals(num1, "0") || Objects.equals(num2, "0")) {
            return "0";
        } else {
            List<Integer> result = new ArrayList();
            List<Integer> current = new ArrayList();
            int add = 0;
            int num = 0;
            int offset = 0;
            for (int i = num2.length() - 1; i > -1 ; i--) {
                // multiply
                current.clear();
                for (int j = num1.length() - 1; j > -1; j--) {
                    num = (num2.charAt(i) - '0') * (num1.charAt(j) - '0') + add;
                    current.add(num % 10);
                    add = num / 10;
                }
                if (add > 0) {
                    current.add(add);
                }
                // add
                add = 0;
                for (int k = offset; k < result.size(); k++) {
                    num = result.get(k) + current.get(k - offset) + add;
                    result.set(k, num % 10);
                    add = num / 10;
                }
                for (int k = result.size(); k < current.size() + offset; k++) {
                    num = current.get(k - offset) + add;
                    result.add(num % 10);
                    add = num / 10;
                }
                if (add > 0) {
                    result.add(add);
                }
                add = 0;
                offset = offset + 1;
            }

            for (int i = result.size() - 1; i > -1; i--) {
                sb.append(result.get(i));
            }
            return sb.toString();
        }
    }
}
