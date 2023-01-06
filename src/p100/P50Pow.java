package p100;

import java.util.ArrayList;
import java.util.List;

public class P50Pow {
    public static void main(String[] args) {
        P50Pow entity = new P50Pow();
        System.out.println();
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Math.abs(-2147483648L));
//        System.out.println(entity.split(3));

        System.out.println(entity.myPow(2.00000, 0)); // 1.0
        System.out.println(entity.myPow(2.00000, 1)); // 2.0
        System.out.println(entity.myPow(2.00000, 10)); // 1024.00000
        System.out.println(entity.myPow(2.10000, 3)); // 9.26100
        System.out.println(entity.myPow(2.00000, -2)); // 0.25000
        System.out.println(entity.myPow(34.00515, -3)); // 2.543114507074558E-5
        System.out.println(entity.myPow(2.00000, -2147483648)); // 0.0
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            int offset =  n % 2 == 0 ? 0 : 1;
            double result = offset == 0 ? 1 : x;
            List<Integer> list = split(Math.abs((long)n) - offset);
            int index = list.size() - 1;
            double temp = x;
            for (int i = 1; index > -1 && i <= list.get(0); i++) {
                temp = temp * temp;
                if (i == list.get(index)) {
                    result = result * temp;
                    if (index > 0) {
                        index = index - 1;
                    } else {
                        break;
                    }
                }
            }
            return n > 0 ? result : 1 / result;
        }
    }

    private List<Integer> split(long n) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        long curr = 1;
        long next;
        while (n > 0) {
            next = curr * 2;
            if (n < next) {
                result.add(i);
                n = n - curr;
                i = 0;
                curr = 1;
            } else {
                curr = next;
                i = i + 1;
            }
        }
        return result;
    }
}
