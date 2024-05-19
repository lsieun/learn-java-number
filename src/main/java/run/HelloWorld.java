package run;

import lsieun.utils.BitUtils;

public class HelloWorld {

    static final int resizeStamp(int n) {
        return Integer.numberOfLeadingZeros(n) | (1 << 15);
    }

    public static void main(String[] args) {
        // 00000000000000000000000000100000
//        System.out.println(BitUtils.toString(32, 32));
//        System.out.println(0b11010);
//
//        for (int i = 32; i < 33; i++) {
//            int k = resizeStamp(i);
//            String msg = String.format("%03d - %d", i, k);
//            System.out.println(msg);
//            System.out.println(BitUtils.toString(k, 32));
//
//            int m = k << 16;
//            System.out.println(m);
//            System.out.println(BitUtils.toString(m, 32));
//            System.out.println(BitUtils.toString(m + 2, 32));
//        }


    }


}
