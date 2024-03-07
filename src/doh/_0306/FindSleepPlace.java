package doh._0306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1652 누울 자리를 찾아라
 */
public class FindSleepPlace {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int width = 0;
        int height = 0;

        // 가로
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 'X') {
                    cnt++;
                } else { // X이면 개수 확인
                    if (cnt >= 2) {
                        width++;
                    }
                    cnt = 0;
                }
            }
            if (cnt >= 2) { // X 이후 개수 체크
                width++;
            }
        }

        // 세로
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (board[j][i] != 'X') {
                    cnt++;
                } else {
                    if (cnt >= 2) {
                        height++;
                    }
                    cnt = 0;
                }
            }
            if (cnt >= 2) {
                height++;
            }
        }

        System.out.println(width + " " + height);
    }
}
