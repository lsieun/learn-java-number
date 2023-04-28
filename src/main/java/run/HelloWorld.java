package run;

import lsieun.number.format.NumberFormat;

import java.math.RoundingMode;

public class HelloWorld {
    public static void main(String[] args) {
        double [] array = {
                1.0D,
                0.0D,
                Math.PI
        };

        for (double val : array) {
            String str = NumberFormat.succinct(val, 3, RoundingMode.HALF_UP);
            System.out.println(str);
        }
    }
}
