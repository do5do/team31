package doh._03._0328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 어두운굴다리_17266_2 {
    static int[] place;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 굴다리 길이
        int m = Integer.parseInt(br.readLine()); // 가로등 개수

        StringTokenizer st = new StringTokenizer(br.readLine());
        place = new int[m]; // 가로등 위치

        for (int i = 0; i < m; i++) {
            place[i] = Integer.parseInt(st.nextToken());
        }

        int result = place[0]; // 0 ~ 첫 가로등까지 거리
        int gap;

        for (int i = 1; i < m; i++) {
            gap = (place[i] - place[i - 1]) / 2 + ((place[i] - place[i - 1]) % 2 == 0 ? 0 : 1);
            result = Math.max(result, gap);
        }

        result = Math.max(result, n - place[m - 1]); // 마지막 가로등 ~ n까지 거리

        System.out.println(result);
    }
}
