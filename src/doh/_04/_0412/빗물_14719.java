package doh._04._0412;

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

        int[] block = new int[w];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        int maxIdx = 0;

        for (int i = 0; i < w; i++) {
            block[i] = Integer.parseInt(st.nextToken());
            if (max < block[i]) {
                max = block[i];
                maxIdx = i;
            }
        }

        int select = block[0];
        int answer = 0;

        for (int i = 1; i < maxIdx; i++) {
            if (select < block[i]) {
                select = block[i];
            } else {
                answer += select - block[i];
            }
        }

        select = block[w - 1];
        for (int i = w - 2; i > maxIdx; i--) {
            if (select < block[i]) {
                select = block[i];
            } else {
                answer += select - block[i];
            }
        }

        System.out.println(answer);
    }
}
