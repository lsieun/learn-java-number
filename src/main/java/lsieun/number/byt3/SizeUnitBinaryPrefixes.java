package lsieun.number.byt3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("AlibabaEnumConstantsMustHaveComment")
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
