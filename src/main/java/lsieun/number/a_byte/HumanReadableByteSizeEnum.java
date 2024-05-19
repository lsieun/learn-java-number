package lsieun.number.a_byte;

import java.text.DecimalFormat;
import java.util.List;

import static lsieun.number.a_byte.HumanReadableData.DATA_MAP_BINARY_PREFIXES;

@SuppressWarnings("all")
public class HumanReadableByteSizeEnum {

    private static final DecimalFormat DEC_FORMAT = new DecimalFormat("#.##");

    private static String formatSize(long size, long divider, String unitName) {
        return DEC_FORMAT.format((double) size / divider) + " " + unitName;
    }

    public static String toHumanReadableWithEnum(long size) {
        List<SizeUnitBinaryPrefixes> units = SizeUnitBinaryPrefixes.unitsInDescending();
        if (size < 0) {
            throw new IllegalArgumentException("Invalid file size: " + size);
        }
        String result = null;
        for (SizeUnitBinaryPrefixes unit : units) {
            if (size >= unit.getUnitBase()) {
                result = formatSize(size, unit.getUnitBase(), unit.name());
                break;
            }
        }
        return result == null ? formatSize(size, SizeUnitBinaryPrefixes.Bytes.getUnitBase(), SizeUnitBinaryPrefixes.Bytes.name()) : result;
    }

    public static void main(String[] args) {
        DATA_MAP_BINARY_PREFIXES.forEach(
                (in, expected) -> {
                    String value = toHumanReadableWithEnum(in);
                    String message = String.format("%s%n    %s%n    %s%n", in, expected, value);
                    System.out.println(message);
                }
        );
    }
}
