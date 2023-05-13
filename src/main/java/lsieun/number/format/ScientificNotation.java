package lsieun.number.format;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ScientificNotation {
    public static void main(String[] args) {
        NumberFormat numFormat = new DecimalFormat("0.###E0");

        double[] array = {
                0,
                Math.PI,
                Math.PI / 1000,
                Integer.MAX_VALUE,
                Integer.MIN_VALUE
        };

        for (double item : array) {
            String str = numFormat.format(item);
            System.out.println(str);
        }
    }
}
