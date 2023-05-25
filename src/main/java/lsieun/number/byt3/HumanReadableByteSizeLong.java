package lsieun.number.byt3;

import java.text.DecimalFormat;

import static lsieun.number.byt3.HumanReadableConst.*;
import static lsieun.number.byt3.HumanReadableData.DATA_MAP_BINARY_PREFIXES;

public class HumanReadableByteSizeLong {
    private static final DecimalFormat DEC_FORMAT = new DecimalFormat("#.##");

    private static String formatSize(long size, long divider, String unitName) {
        return DEC_FORMAT.format((double) size / divider) + " " + unitName;
    }

    public static String toHumanReadableByNumOfLeadingZeros(long size) {
        if (size < 0) {
            throw new IllegalArgumentException("Invalid file size: " + size);
        }
        if (size < 1024) {
            return size + " Bytes";
        }
        int unitIdx = (63 - Long.numberOfLeadingZeros(size)) / 10;
        return formatSize(size, 1L << (unitIdx * 10), " KMGTPE".charAt(unitIdx) + "iB");
    }

    public static void main(String[] args) {
        DATA_MAP_BINARY_PREFIXES.forEach(
                (in, expected) -> {
                    String value = toHumanReadableByNumOfLeadingZeros(in);
                    String message = String.format("%s%n    %s%n    %s%n", in, expected, value);
                    System.out.println(message);
                }
        );
    }

    private static void test() {
        long[] array = {
                BYTE, KiB, MiB, GiB, TiB, PiB, EiB
        };
        for (long item : array) {
            int num = Long.numberOfLeadingZeros(item);
            String message = String.format("%s : %s", item, num);
            System.out.println(message);
        }
    }
}
