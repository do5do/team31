package doh._06._0628;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빗물_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] blocks = new int[w];
        st = new StringTokenizer(br.readLine());

        int maxIdx = 0;
        int max = 0;

        for (int i = 0; i < w; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
            if (max < blocks[i]) {
                max = blocks[i];
                maxIdx = i;
            }
        }

        int answer = 0;
        int cnt = 0;
        int cur = blocks[0];

        for (int i = 1; i < maxIdx; i++) {
            int next = blocks[i];
            if (cur > next) {
                cnt += cur - next;
            } else {
                cur = next;
            }
        }
        answer += cnt;

        cnt = 0;
        cur = blocks[blocks.length - 1];

        for (int i = blocks.length - 2; i > maxIdx; i--) {
            int next = blocks[i];
            if (cur > next) {
                cnt += cur - next;
            } else {
                cur = next;
            }
        }
        answer += cnt;

        System.out.println(answer);
    }
}
