package lsieun.number.byt3;

import org.apache.commons.io.FileUtils;

import java.util.HashMap;
import java.util.Map;

public class HumanReadableByteSizeApache {
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
                    String value = FileUtils.byteCountToDisplaySize(in);
                    String message = String.format("%s%n    %s%n    %s%n", in, expected, value);
                    System.out.println(message);
                }
        );
    }
}
