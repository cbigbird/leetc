package main.java.p100;

import java.util.HashMap;
import java.util.Map;

class P13RomanToInteger {
    public static void main(String[] args) {
        P13RomanToInteger entity = new P13RomanToInteger();
        int i1994 = entity.romanToInt("MCMXCIV");
        int i3 = entity.romanToInt("III");
        int i58 = entity.romanToInt("LVIII");
        int i1 = entity.romanToInt("I");
        System.out.println(entity.romanToInt("MCMXCIV"));
        System.out.println(entity.romanToInt("III"));
        System.out.println(entity.romanToInt("LVIII"));
        System.out.println(entity.romanToInt("I"));
        System.out.println(entity.romanToInt2("MCMXCIV"));
        System.out.println(entity.romanToInt2("III"));
        System.out.println(entity.romanToInt2("LVIII"));
        System.out.println(entity.romanToInt2("I"));
    }

    public int romanToInt(String s) {
        int result = 0;
        Map<String, Integer> map = new HashMap();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i < chars.length - 1) {
                StringBuilder sb = new StringBuilder();
                Integer value = map.get(sb.append(chars[i]).append(chars[i + 1]).toString());
                if (value != null) {
                    result = result + value;
                    i++;
                    continue;
                }
            }
            result = result + map.get(String.valueOf(chars[i]));
        }
        return result;
    }

    public int romanToInt2 (String s) {
        int result = 0;
        int[] roman = new int[128];
        roman['I'] = 1;
        roman['V'] = 5;
        roman['X'] = 10;
        roman['L'] = 50;
        roman['C'] = 100;
        roman['D'] = 500;
        roman['M'] = 1000;
        for (int i = 0; i < s.length() - 1; i++) {
            if (roman[s.charAt(i)] < roman[s.charAt(i + 1)]) {
                result = result - roman[s.charAt(i)];
            } else {
                result = result + roman[s.charAt(i)];
            }
        }
        result = result + roman[s.charAt(s.length() - 1)];
        return result;
    }
}