package doh._04._0422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 틱택토_7682 {
    static char[][] matrix = new char[3][3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();

        while (!(line = br.readLine()).equals("end")) {
            int xCnt = 0;
            int oCnt = 0;
            int blank = 0;

            for (int i = 0; i < 9; i++) {
                matrix[i / 3][i % 3] = line.charAt(i);
                if (line.charAt(i) == 'X') {
                    xCnt++;
                } else if (line.charAt(i) == 'O') {
                    oCnt++;
                } else {
                    blank++;
                }
            }

            // x가 선공이라서 x가 o보다 많아야 한다.
            if (oCnt > xCnt) {
                sb.append("invalid").append("\n");
                continue;
            }

            boolean xBingo = bingo('X');
            boolean oBingo = bingo('O');

            // 빈칸이 없는 경우
            if (blank == 0) {
                if (xCnt - 1 == oCnt) {
                    if (oBingo) { // o는 빙고일 수 없다.
                        sb.append("invalid").append("\n");
                    } else {
                        sb.append("valid").append("\n");
                    }
                } else {
                    sb.append("invalid").append("\n");
                }
            } else {
                if (xBingo && oBingo) {
                    sb.append("invalid").append("\n");
                } else if (oBingo && xCnt == oCnt) { // o가 빙고면 개수가 같아야한다.
                    sb.append("valid").append("\n");
                } else if (xBingo && xCnt - 1 == oCnt) { // x가 빙고면 개수가 하나 많아야 한다.
                    sb.append("valid").append("\n");
                } else {
                    sb.append("invalid").append("\n");
                }
            }
        }

        System.out.println(sb);
    }

    static boolean bingo(char target) {
        // 가로 확인
        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == target) {
                    cnt++;
                }
            }

            if (cnt == 3) {
                return true;
            }
        }

        // 세로
        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            for (int j = 0; j < 3; j++) {
                if (matrix[j][i] == target) {
                    cnt++;
                }
            }

            if (cnt == 3) {
                return true;
            }
        }

        // 대각선 \
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (matrix[i][i % 3] == target) {
                cnt++;
            }

            if (cnt == 3) {
                return true;
            }
        }

        // 대각선 /
        cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (matrix[i][3 - i - 1] == target) {
                cnt++;
            }

            if (cnt == 3) {
                return true;
            }
        }
        return false;
    }
}
