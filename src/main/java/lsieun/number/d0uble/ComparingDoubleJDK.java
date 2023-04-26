package lsieun.number.d0uble;

public class ComparingDoubleJDK {
    public static void main(String[] args) {
        double d1 = 0;
        for (int i = 1; i <= 8; i++) {
            d1 += 0.1;
        }

        double d2 = 0.1 * 8;

        System.out.println(d1);
        System.out.println(d2);

        double epsilon = 0.000001d;
        boolean flag = Math.abs(d1 - d2) < epsilon;
        System.out.println("equals: " + flag);
    }
}
