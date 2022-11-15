import java.util.ArrayList;
import java.util.List;

class P12IntegerToRoman {
    public static void main(String[] args) {
        P12IntegerToRoman entity = new P12IntegerToRoman();
        String s = entity.intToRoman(1994);
        String s2 = entity.intToRoman_Greedy(1994);
        String s3 = entity.intToRoman_HashTable(1994);
        System.out.println(s);
        System.out.println(s2);
        System.out.println(s3);
    }

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();

        String[] chars = {"I", "V", "X", "L", "C", "D", "M"};
        int pre = (chars.length - 1) / 2;
        String[][] roman = new String[pre + 1][10];
        for (int i = 0; i < pre; i++) {
            roman[i] = getRomanNumbs(chars[i * 2], chars[i * 2 + 1], chars[i * 2 + 2]);
        }
        roman[pre] = getRomanNumbs(chars[chars.length - 1]);

        int[] numbs = genIntNumbs(num);
        for (int i = numbs.length - 1; i > -1; i--) {
            result.append(roman[i][numbs[i]]);
        }

        return result.toString();
    }

    private String[] getRomanNumbs(String I, String V, String X) {
        return new String[]{"", I, I + I, I + I + I, I + V, V, V + I, V + I + I, V + I + I + I, I + X};
    }

    private String[] getRomanNumbs(String I) {
        return new String[]{"", I, I + I, I + I + I};
    }

    private int[] genIntNumbs(int n) {
        List<Integer> list = new ArrayList<>();
        processInt(n, list);
        return list.stream().mapToInt(i->i).toArray();
    }

    private void processInt(int n, List<Integer> result) {
        if (n < 10) {
            result.add(n);
        } else {
            result.add(n % 10);
            processInt(n / 10, result);
        }
    }

    ////////////////////////////
    public String intToRoman_Greedy(int num) {
        String result = "";
        int[] ints = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strings = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < ints.length; i++) {
            while (num >= ints[i]) {
                num = num - ints[i];
                result = result + strings[i];
            }
        }
        return result;
    }

    public String intToRoman_HashTable(int num) {
        String[] M = {"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num / 1000] + C[num % 1000 / 100] + X[num % 100 / 10] + I[num % 10];
    }
}