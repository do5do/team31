package doh._07._0715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 비슷한단어_2179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];

        for (int i = 0; i < n; i++){
            words[i] = br.readLine();
        }

        String[] answer = new String[2];
        int maxPrefixCnt = 0;

        for (int i = 0; i < n; i++) {
            String cur = words[i];

            for (int j = i + 1; j < n; j++) {
                String next = words[j];
                int len = Math.min(cur.length(), next.length());
                int prefixCnt = 0;

                for (int k = 0; k < len; k++) { // 문자 하나씩 확인
                    if (cur.charAt(k) == next.charAt(k)) {
                        prefixCnt++;
                    } else {
                        break;
                    }
                }

                if (maxPrefixCnt < prefixCnt) {
                    maxPrefixCnt = prefixCnt;
                    answer[0] = cur;
                    answer[1] = next;
                }
            }
        }

        System.out.println(answer[0] + "\n" + answer[1]);
    }
}
