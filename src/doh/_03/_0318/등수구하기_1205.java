package doh._03._0318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 등수구하기_1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 현재 랭킹 리스트 개수
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken()); // 총 랭킹 리스트 개수

        if (n == 0) { // 랭킹이 아직 없는 경우
            System.out.println(1);
            System.exit(0);
        }

        int[][] ranking = new int[p][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ranking[i][0] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ranking, ((o1, o2) -> o2[1] - o1[1]));

        if (n == p && score <= ranking[n - 1][0]) { // 랭킹 진입 불가
            System.out.println(-1);
            System.exit(0);
        }

        ranking[0][1] = 1;
        if (ranking[0][0] <= score) { // 최고 점수일 때
            System.out.println(ranking[0][1]);
            System.exit(0);
        }

        if (ranking[n - 1][0] > score) { // 최하 점수
            ranking[n][0] = score;
        }

        for (int i = 1; i < p; i++) {
            if (ranking[i][0] < ranking[i - 1][0]) {
                ranking[i][1] = i + 1;
            } else {
                ranking[i][1] = ranking[i - 1][1];
            }

            // 랭킹 출력
            if (ranking[i][0] <= score) {
                System.out.println(ranking[i][1]);
                break;
            }
        }
    }
}
