package tjoon._202405._0517;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 성냥개비_3687 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            long[] minDp = new long[101];

            Arrays.fill(minDp, Long.MAX_VALUE);
            minDp[2] = 1;
            minDp[3] = 7;
            minDp[4] = 4;
            minDp[5] = 2;
            minDp[6] = 6;
            minDp[7] = 8;
            minDp[8] = 10;

            String[] add = {"1", "7", "4", "2", "0", "8"};

            for (int i = 9; i <= 100; i++) {
                for (int k = 2; k <= 7; k++) {
                    String line = minDp[i - k] + add[k - 2];
                    minDp[i] = Math.min(Long.parseLong(line), minDp[i]);
                }
            }

            StringBuilder max = new StringBuilder();
            long a = n / 2;
            long b = n % 2;
            if (b == 1) {
                max.append("7");
            } else {
                max.append("1");
            }

            for (int j = 1; j < a; j++) {
                max.append("1");
            }

            System.out.println(minDp[n] + " " + max);

        }

    }
}
