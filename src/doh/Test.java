package doh;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Test {
    static Random random = new Random();
    static long totalAmount = 1000;
    static int n = 10;

    public static void main(String[] args) {
//        calcRate();
//        boundary();
//        dp();
    }

    public static void dp() {
        long[] dp = new long[n];
        long amount = totalAmount;
        long sumAmount = 0;

        if (amount < 500 || totalAmount < n) {
            dp[0] = amount;
        } else {
            for (int i = 0; i < n - 1; i++) {
                long num = random.nextLong(100, amount);

                amount = Math.min(num, Math.abs(amount - num));
                amount = amount > 100 ? amount / 100 * 100 : amount;

                dp[i] = amount;
                sumAmount += dp[i];

                if (amount <= 100) {
                    break;
                }
            }

            dp[n - 1] = totalAmount - sumAmount;
        }


        for (long d : dp) {
            System.out.println(d);
        }
        System.out.println("sum : " + Arrays.stream(dp).sum());
    }

    public static void calcRate() {
        int range = 61;
        int sumRate = 0;
        long sumAmount = 0;

        for (int i = 0; i < n - 1; i++) {
            int rate = random.nextInt(range); // 1 ~ 60
            sumRate += rate;
            range -= rate;

            long amount = (long) (totalAmount * (rate / 100.0));
            sumAmount += amount;
            System.out.println(rate + "%, " + amount);
        }

        int lastRate = 100 - sumRate;
        long lastAmount = (long) (totalAmount * ((100.0 - sumRate) / 100.0));
        sumRate += lastRate;
        sumAmount += lastAmount;

        System.out.println(lastRate + "%, " + lastAmount);
        System.out.println("sumRate: " + sumRate);
        System.out.println("sumAmount: " + sumAmount);
    }

    public static void boundary() {
        List<Integer> boundaries = Stream
                .generate(() -> random.nextInt(1,61)) // 1 ~ 60
                .limit(n - 1)
                .sorted()
                .toList();

        long sumAmount = 0;
        int sumPercent = 0;
        int prevBoundary = 0;

        for (int boundary : boundaries) {
            int percent = boundary - prevBoundary;
            prevBoundary = percent;
            long amount = (long) (totalAmount * (percent / 100.0));

            sumPercent += percent;
            sumAmount += amount;

            System.out.println(percent + "%, " + amount);
        }


        int lastPercent = 100 - prevBoundary;
        long lastAmount = (long) (totalAmount * (lastPercent / 100.0));
        sumAmount += lastAmount;
        sumPercent += lastPercent;

        System.out.println(lastPercent + "%, " + lastAmount);
        System.out.println("sum amount: " + sumAmount);
        System.out.println("sum percent: " + sumPercent);
    }
}
