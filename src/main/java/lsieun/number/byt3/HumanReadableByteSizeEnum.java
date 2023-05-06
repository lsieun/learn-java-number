package lsieun.number.byt3;

import java.text.DecimalFormat;
import java.util.*;

public class HumanReadableByteSizeEnum {
    enum SizeUnitBinaryPrefixes {
        Bytes(1L),
        KiB(Bytes.unitBase << 10),
        MiB(KiB.unitBase << 10),
        GiB(MiB.unitBase << 10),
        TiB(GiB.unitBase << 10),
        PiB(TiB.unitBase << 10),
        EiB(PiB.unitBase << 10);

        private final Long unitBase;

        SizeUnitBinaryPrefixes(Long unitBase) {
            this.unitBase = unitBase;
        }

        public Long getUnitBase() {
            return unitBase;
        }

        public static List<SizeUnitBinaryPrefixes> unitsInDescending() {
            List<SizeUnitBinaryPrefixes> list = Arrays.asList(values());
            Collections.reverse(list);
            return list;
        }

    }

    enum SizeUnitSIPrefixes {
        Bytes(1L),
        KB(Bytes.unitBase * 1000),
        MB(KB.unitBase * 1000),
        GB(MB.unitBase * 1000),
        TB(GB.unitBase * 1000),
        PB(TB.unitBase * 1000),
        EB(PB.unitBase * 1000);

        private final Long unitBase;

        SizeUnitSIPrefixes(Long unitBase) {
            this.unitBase = unitBase;
        }

        public Long getUnitBase() {
            return unitBase;
        }

        public static List<SizeUnitSIPrefixes> unitsInDescending() {
            List<SizeUnitSIPrefixes> list = Arrays.asList(values());
            Collections.reverse(list);
            return list;
        }
    }

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
                    String value = toHumanReadableWithEnum(in);
                    String message = String.format("%s%n    %s%n    %s%n", in, expected, value);
                    System.out.println(message);
                }
        );
    }
}
