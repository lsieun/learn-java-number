package lsieun.number.a_byte;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("AlibabaEnumConstantsMustHaveComment")
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
