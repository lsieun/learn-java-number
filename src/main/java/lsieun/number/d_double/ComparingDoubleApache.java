package lsieun.number.d_double;

import org.apache.commons.math3.util.Precision;

public class ComparingDoubleApache {
    public static void main(String[] args) {
        double d1 = 0;
        for (int i = 1; i <= 8; i++) {
            d1 += 0.1;
        }

        double d2 = 0.1 * 8;

        System.out.println(d1);
        System.out.println(d2);

        double epsilon = 0.000001d;

        boolean flag1 = Precision.equals(d1, d2, epsilon);
        boolean flag2 = Precision.equals(d1, d2);
        System.out.println("flag1: " + flag1);
        System.out.println("flag2: " + flag2);
    }
}
