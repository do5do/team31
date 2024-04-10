package doh._04._0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 창고다각형_2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] land = new int[1001]; // 1 ~ 1000
        int maxY = 0;
        int maxIdx = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            land[x] = y;

            if (maxY < y) {
                maxY = y;
                maxIdx = x;
            }
        }

        int height = land[1];
        int answer = 0;

        for (int i = 1; i < maxIdx; i++) {
            height = Math.max(height, land[i]);
            answer += height;
        }

        height = land[1000];
        for (int i = 1000; i > maxIdx; i--) {
            height = Math.max(height, land[i]);
            answer += height;
        }

        answer += maxY;
        System.out.println(answer);
    }
}
