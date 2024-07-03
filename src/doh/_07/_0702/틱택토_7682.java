package doh._07._0702;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 틱택토_7682 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line.equals("end")) {
                break;
            }

            int idx = 0;
            char[][] board = new char[3][3];
            int xCnt = 0;
            int oCnt = 0;
            int blank = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = line.charAt(idx++);
                    if (board[i][j] == 'X') {
                        xCnt++;
                    } else if (board[i][j] == 'O') {
                        oCnt++;
                    } else {
                        blank++;
                    }
                }
            }

            if (blank == 0) { // 가득 찬 경우
                if (xCnt - oCnt != 1) { // x가 1개 더 많아야 한다.
                    sb.append("invalid\n");
                } else {
                    if (bingo(board, 'O')) {
                        sb.append("invalid\n");
                    } else {
                        sb.append("valid\n");
                    }
                }
            } else { // 빈 공간이 있는 경우
                if (bingo(board, 'O') && bingo(board, 'X')) {
                    sb.append("invalid\n");
                }else if (xCnt == oCnt && bingo(board, 'O')) {
                    sb.append("valid\n");
                } else if (xCnt - oCnt == 1 && bingo(board, 'X')) {
                    sb.append("valid\n");
                } else {
                    sb.append("invalid\n");
                }
            }
        }

        System.out.println(sb);
    }

    public static boolean bingo(char[][] board, char target) {
        // 가로
        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == target) {
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
                if (board[j][i] == target) {
                    cnt++;
                }
            }

            if (cnt == 3) {
                return true;
            }
        }

        // 대각선
        if (target == board[0][0] && target == board[1][1] && target == board[2][2]) {
            return true;
        }

        if (target == board[0][2] && target == board[1][1] && target == board[2][0]) {
            return true;
        }

        return false;
    }
}
