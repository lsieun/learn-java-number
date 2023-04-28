package lsieun.number.format;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class NumberFormat {

    public static String succinct(double val) {
        return succinct(val, 3);
    }

    public static String succinct(double val, int precision) {
        return succinct(val, precision, RoundingMode.HALF_UP);
    }

    public static String succinct(double val, int precision, RoundingMode roundingMode) {
        if (precision <= 0) {
            return String.valueOf(val);
        }

        String pattern = "0." + "#".repeat(precision);
        DecimalFormat df = new DecimalFormat(pattern);
        df.setRoundingMode(roundingMode);
        return df.format(val);
    }
}
