package lsieun.number.byt3;

import org.apache.commons.io.FileUtils;

import static lsieun.number.byt3.HumanReadableData.DATA_MAP_BINARY_PREFIXES;

public class HumanReadableByteSizeApache {
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
