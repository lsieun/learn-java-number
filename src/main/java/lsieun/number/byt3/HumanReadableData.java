package lsieun.number.byt3;

import java.util.HashMap;
import java.util.Map;

public class HumanReadableData {
    public static final Map<Long, String> DATA_MAP_BINARY_PREFIXES = new HashMap<>();

    public static final Map<Long, String> DATA_MAP_SI_PREFIXES = new HashMap<>();

    static {
        DATA_MAP_BINARY_PREFIXES.put(0L, "0 Bytes");
        DATA_MAP_BINARY_PREFIXES.put(1023L, "1023 Bytes");
        DATA_MAP_BINARY_PREFIXES.put(1024L, "1 KiB");
        DATA_MAP_BINARY_PREFIXES.put(12_345L, "12.06 KiB");
        DATA_MAP_BINARY_PREFIXES.put(10_123_456L, "9.65 MiB");
        DATA_MAP_BINARY_PREFIXES.put(10_123_456_798L, "9.43 GiB");
        DATA_MAP_BINARY_PREFIXES.put(1_777_777_777_777_777_777L, "1.54 EiB");

        DATA_MAP_SI_PREFIXES.put(0L, "0 Bytes");
        DATA_MAP_SI_PREFIXES.put(999L, "999 Bytes");
        DATA_MAP_SI_PREFIXES.put(1000L, "1 KB");
        DATA_MAP_SI_PREFIXES.put(12_345L, "12.35 KB");
        DATA_MAP_SI_PREFIXES.put(10_123_456L, "10.12 MB");
        DATA_MAP_SI_PREFIXES.put(10_123_456_798L, "10.12 GB");
        DATA_MAP_SI_PREFIXES.put(1_777_777_777_777_777_777L, "1.78 EB");
    }
}
