package lsieun.number.c_int;

// -Djava.lang.Integer.IntegerCache.high=256
public class IntegerCache {
    public static void main(String[] args) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i = -500; i < 1000; i++) {
            boolean flag = isSame(i);
            if (flag) {
                if (i < low) {
                    low = i;
                }
                if (i > high) {
                    high = i;
                }
            }
        }

        String msg = String.format("[%d, %d]", low, high);
        System.out.println(msg);
    }

    private static boolean isSame(int num) {
        Integer i1 = Integer.valueOf(num);
        Integer i2 = Integer.valueOf(num);
        return i1 == i2;
    }
}
