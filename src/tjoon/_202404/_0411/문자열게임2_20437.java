package tjoon._202404._0411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열게임2_20437 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        String w = "";
        int k = 0;


        for (int t = 0; t < T; t++) {

            // start code
            w = br.readLine();
            k = Integer.parseInt(br.readLine());

            if (k == 1) { // k가 1일때
                sb.append("1 1").append("\n");
                continue;
            }

            int[] alpha = new int[26];//알파벳 별 개수를 저장한다.
            for (int i = 0; i < w.length(); i++) {
                alpha[w.charAt(i) - 'a']++;
            }

            int min = Integer.MAX_VALUE;
            int max = -1;
            for (int i = 0; i < w.length(); i++) {
                if (alpha[w.charAt(i) - 'a'] >= k) {

                    int count = 1;
                    for (int j = i + 1; j < w.length(); j++) {
                        if (w.charAt(i) == w.charAt(j)) {
                            count++; // 같은게 나오면 +1
                        }

                        if (count == k) { // k 개만큼 나오면
                            min = Math.min(min, j - i + 1);
                            max = Math.max(max, j - i + 1);
                            break; // 나가서 다음문자부터 비교
                        }
                    }
                }
            }

            if (min == Integer.MAX_VALUE || max == -1) { // 하나라도 변함이 없었다면
                sb.append(-1).append("\n");
            } else {
                sb.append(min).append(" ").append(max).append("\n");
            }

        }

        System.out.println(sb);

    }
}
