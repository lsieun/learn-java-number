package lsieun.number.byt3;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class HumanReadableByteSizeLong {
    private static final long BYTE = 1L;
    private static final long KiB = BYTE << 10;
    private static final long MiB = KiB << 10;
    private static final long GiB = MiB << 10;
    private static final long TiB = GiB << 10;
    private static final long PiB = TiB << 10;
    private static final long EiB = PiB << 10;

    private static final DecimalFormat DEC_FORMAT = new DecimalFormat("#.##");

    private static String formatSize(long size, long divider, String unitName) {
        return DEC_FORMAT.format((double) size / divider) + " " + unitName;
    }

    public static String toHumanReadableByNumOfLeadingZeros(long size) {
        if (size < 0) {
            throw new IllegalArgumentException("Invalid file size: " + size);
        }
        if (size < 1024) return size + " Bytes";
        int unitIdx = (63 - Long.numberOfLeadingZeros(size)) / 10;
        return formatSize(size, 1L << (unitIdx * 10), " KMGTPE".charAt(unitIdx) + "iB");
    }

    private static final Map<Long, String> DATA_MAP_BINARY_PREFIXES = new HashMap<>() {{
        put(0L, "0 Bytes");
        put(1023L, "1023 Bytes");
        put(1024L, "1 KiB");
        put(12_345L, "12.06 KiB");
        put(10_123_456L, "9.65 MiB");
        put(10_123_456_798L, "9.43 GiB");
        put(1_777_777_777_777_777_777L, "1.54 EiB");
    }};

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
