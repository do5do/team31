package doh._06._0626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열게임2_20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t > 0) {
            t--;
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());

            if (k == 1) {
                sb.append(String.format("%d %d\n", 1, 1));
                continue;
            }

            // k개 이상인 것만 보기
            int[] alpha = new int[26];
            for (int i = 0; i < str.length(); i++) {
                alpha[str.charAt(i) - 'a']++;
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (alpha[c - 'a'] < k) {
                    continue;
                }

                // 끝 확인
                int right = i + 1;
                int cnt = 1;
                while (right < str.length()) {
                    if (str.charAt(right) == c) {
                        cnt++;
                    }

                    if (cnt == k) {
                        int length = right - i + 1;
                        min = Math.min(length, min);
                        max = Math.max(length, max);
                        break;
                    }

                    right++;
                }
            }

            if (min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) {
                sb.append(-1).append("\n");
            } else {
                sb.append(String.format("%d %d\n", min, max));
            }
        }

        System.out.println(sb);
    }
}
