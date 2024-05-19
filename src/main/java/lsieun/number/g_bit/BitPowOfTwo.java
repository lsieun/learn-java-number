package lsieun.number.g_bit;

public class BitPowOfTwo {
    public static int getMinPowOfTwo(int val) {
        int n = val - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
    }

    public static int findNextPositivePowerOfTwo(final int val) {
        assert val > Integer.MIN_VALUE && val < 0x40000000;
        return 1 << (32 - Integer.numberOfLeadingZeros(val - 1));
    }

    public static void main(String[] args) {
        int val = 7;

        int result1 = getMinPowOfTwo(val);
        // result1 = 8
        System.out.println("result1 = " + result1);

        int result2 = findNextPositivePowerOfTwo(val);
        // result2 = 8
        System.out.println("result2 = " + result2);
    }
}
