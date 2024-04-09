package doh._03._0326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쿠키의신체측정_20125 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] matrix = new char[n][n];
        int[] heart = new int[2]; // 심장 위치
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = line.charAt(j);

                if (heart[0] == 0 && matrix[i][j] == '*') {
                    heart[0] = i + 1;
                    heart[1] = j;
                }
            }
        }

        sb.append(heart[0] + 1).append(" ").append(heart[1] + 1).append("\n");

        // 왼팔
        int nx = heart[0];
        int ny = heart[1] - 1;
        int cnt = 0;

        while (ny >= 0 && ny < n) {
            if (matrix[nx][ny] == '*') {
                cnt++;
            }
            ny--;
        }
        sb.append(cnt).append(" ");

        // 오른팔
        ny = heart[1] + 1;
        cnt = 0;

        while (ny >= 0 && ny < n) {
            if (matrix[nx][ny] == '*') {
                cnt++;
            }
            ny++;
        }
        sb.append(cnt).append(" ");

        // 허리
        nx = heart[0] + 1;
        ny = heart[1];
        cnt = 0;
        int disk = 0;

        while (nx >= 0 && nx < n) {
            if (matrix[nx][ny] == '*') {
                cnt++;
            }
            nx++;
        }
        sb.append(cnt).append(" ");
        disk = cnt;

        // 왼다리
        nx = heart[0] + disk + 1;
        ny = heart[1] - 1;
        cnt = 0;

        while (nx >= 0 && nx < n && ny >= 0 && ny < n) {
            if (matrix[nx][ny] == '*') {
                cnt++;
            }
            nx++;
        }
        sb.append(cnt).append(" ");

        // 오른다리
        nx = heart[0] + disk + 1;
        ny = heart[1] + 1;
        cnt = 0;

        while (nx >= 0 && nx < n && ny >= 0 && ny < n) {
            if (matrix[nx][ny] == '*') {
                cnt++;
            }
            nx++;
        }
        sb.append(cnt).append(" ");

        System.out.println(sb);
    }
}
