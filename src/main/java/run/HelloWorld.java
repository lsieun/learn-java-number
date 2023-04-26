package run;

import java.util.UUID;

public class HelloWorld {
    public static void main(String[] args) {
        double d1 = 0;
        for (int i = 1; i <= 8; i++) {
            d1 += 0.1;
        }

        double d2 = 0.1 * 8;

        System.out.println(d1);
        System.out.println(d2);

        // universally unique identifier (UUID)
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
    }
}
