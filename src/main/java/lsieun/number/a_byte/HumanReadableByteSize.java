package lsieun.number.a_byte;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.function.Function;

import static lsieun.number.a_byte.HumanReadableData.DATA_MAP_BINARY_PREFIXES;
import static lsieun.number.a_byte.HumanReadableData.DATA_MAP_SI_PREFIXES;
import static lsieun.number.a_byte.HumanReadableConst.*;

public class HumanReadableByteSize {
    private static final DecimalFormat DEC_FORMAT = new DecimalFormat("#.##");

    private static String formatSize(long size, long divider, String unitName) {
        return DEC_FORMAT.format((double) size / divider) + " " + unitName;
    }

    public static String toHumanReadableBinaryPrefixes(long size) {
        if (size < 0) {
            throw new IllegalArgumentException("Invalid file size: " + size);
        }
        if (size >= EiB) {
            return formatSize(size, EiB, "EiB");
        }
        if (size >= PiB) {
            return formatSize(size, PiB, "PiB");
        }
        if (size >= TiB) {
            return formatSize(size, TiB, "TiB");
        }
        if (size >= GiB) {
            return formatSize(size, GiB, "GiB");
        }
        if (size >= MiB) {
            return formatSize(size, MiB, "MiB");
        }
        if (size >= KiB) {
            return formatSize(size, KiB, "KiB");
        }
        return formatSize(size, BYTE, "Bytes");
    }

    public static String toHumanReadableSIPrefixes(long size) {
        if (size < 0) {
            throw new IllegalArgumentException("Invalid file size: " + size);
        }
        if (size >= EB) {
            return formatSize(size, EB, "EB");
        }
        if (size >= PB) {
            return formatSize(size, PB, "PB");
        }
        if (size >= TB) {
            return formatSize(size, TB, "TB");
        }
        if (size >= GB) {
            return formatSize(size, GB, "GB");
        }
        if (size >= MB) {
            return formatSize(size, MB, "MB");
        }
        if (size >= KB) {
            return formatSize(size, KB, "KB");
        }
        return formatSize(size, BYTE, "Bytes");
    }


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
