package lsieun.number.format;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class FormatUsingDecimalFormat {
    public static void main(String[] args) {
        double number = 3.237D;

        DecimalFormat format = new DecimalFormat("0.##");
        format.setRoundingMode(RoundingMode.HALF_UP);
        String str = format.format(number);
        System.out.println(str);
    }
}
