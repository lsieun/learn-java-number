package lsieun.utils;

public class BitUtils {
    public static String toString(int num) {
        return toString(num, Integer.SIZE);
    }

    public static String toString(int num, int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = size - 1; i >= 0; i--) {
            sb.append((num >> i) & 0x01);
        }
        return sb.toString();
    }

    public static String toString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            for (int i = 7; i >= 0; i--) {
                int val = (b >> i) & 0x01;
                sb.append(val == 0 ? "0" : "1");
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    public static String toString(byte b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            int val = (b >> i) & 0x01;
            sb.append(val == 0 ? "0" : "1");
        }
        return sb.toString();
    }
}
