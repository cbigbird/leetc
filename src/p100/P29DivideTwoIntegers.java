package p100;

public class P29DivideTwoIntegers { // Divide Two Integers
    public static void main(String[] args) {
        P29DivideTwoIntegers entity = new P29DivideTwoIntegers();
        System.out.println(entity.divide(10, 3));
        System.out.println(entity.divide(7, -3));
        System.out.println(entity.divide(1, 1));
        System.out.println(entity.divide(-2147483648, -1));
        System.out.println(entity.divide(-2147483648, 1));
        System.out.println(entity.divide(-2147483648, 2));
    }

    public int divide(int dividend, int divisor) {
        long result = (long)dividend / (long)divisor;
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int)result;
        }
    }
}
