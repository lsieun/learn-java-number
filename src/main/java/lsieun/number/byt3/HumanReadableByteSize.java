package lsieun.number.byt3;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class HumanReadableByteSize {
    private static final long BYTE = 1L;
    private static final long KiB = BYTE << 10;
    private static final long MiB = KiB << 10;
    private static final long GiB = MiB << 10;
    private static final long TiB = GiB << 10;
    private static final long PiB = TiB << 10;
    private static final long EiB = PiB << 10;

    private static final long KB = BYTE * 1000;
    private static final long MB = KB * 1000;
    private static final long GB = MB * 1000;
    private static final long TB = GB * 1000;
    private static final long PB = TB * 1000;
    private static final long EB = PB * 1000;

    private static final DecimalFormat DEC_FORMAT = new DecimalFormat("#.##");

    private static String formatSize(long size, long divider, String unitName) {
        return DEC_FORMAT.format((double) size / divider) + " " + unitName;
    }

    public static String toHumanReadableBinaryPrefixes(long size) {
        if (size < 0)
            throw new IllegalArgumentException("Invalid file size: " + size);
        if (size >= EiB) return formatSize(size, EiB, "EiB");
        if (size >= PiB) return formatSize(size, PiB, "PiB");
        if (size >= TiB) return formatSize(size, TiB, "TiB");
        if (size >= GiB) return formatSize(size, GiB, "GiB");
        if (size >= MiB) return formatSize(size, MiB, "MiB");
        if (size >= KiB) return formatSize(size, KiB, "KiB");
        return formatSize(size, BYTE, "Bytes");
    }

    public static String toHumanReadableSIPrefixes(long size) {
        if (size < 0)
            throw new IllegalArgumentException("Invalid file size: " + size);
        if (size >= EB) return formatSize(size, EB, "EB");
        if (size >= PB) return formatSize(size, PB, "PB");
        if (size >= TB) return formatSize(size, TB, "TB");
        if (size >= GB) return formatSize(size, GB, "GB");
        if (size >= MB) return formatSize(size, MB, "MB");
        if (size >= KB) return formatSize(size, KB, "KB");
        return formatSize(size, BYTE, "Bytes");
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

    private static final Map<Long, String> DATA_MAP_SI_PREFIXES = new HashMap<>() {{
        put(0L, "0 Bytes");
        put(999L, "999 Bytes");
        put(1000L, "1 KB");
        put(12_345L, "12.35 KB");
        put(10_123_456L, "10.12 MB");
        put(10_123_456_798L, "10.12 GB");
        put(1_777_777_777_777_777_777L, "1.78 EB");
    }};

    private static void process(Map<Long, String> map, Function<Long, String> func) {
        System.out.println(map);
        map.forEach(
                (in, expected) -> {
                    String value = func.apply(in);
                    String message = String.format("%s%n    %s%n    %s%n", in, expected, value);
                    System.out.println(message);
                }
        );
    }

    public static void main(String[] args) {
        process(DATA_MAP_BINARY_PREFIXES, HumanReadableByteSize::toHumanReadableBinaryPrefixes);
        process(DATA_MAP_SI_PREFIXES, HumanReadableByteSize::toHumanReadableSIPrefixes);
    }
}
