package tjoon._202404._0422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 틱택토_7682 {

    static char[][] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // X가 O보다 1만큼만 많아야함
        // O가 빙고일때 X개수와 O개수가 같아야함

        StringBuilder sb = new StringBuilder();
        String str = null;
        while (!(str = br.readLine()).equals("end")) {
            boolean isFull = true;
            int XCnt = 0;
            int OCnt = 0;

            board = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = str.charAt(i * 3 + j);

                    if (board[i][j] == '.') {
                        isFull = false;
                    } else if (board[i][j] == 'X') {
                        XCnt++;
                    } else {
                        OCnt++;
                    }
                }
            }

            if (isFull) {
                if (OCnt + 1 != XCnt) {
                    sb.append("invalid\n");
                } else {
                    if (bingo('O')) {
                        sb.append("invalid\n");
                    } else {
                        sb.append("valid\n");
                    }
                }
            } else {
                if (bingo('X') && bingo('O')) {
                    sb.append("invalid\n");
                }
                // X 빙고일때 하나 많음
                else if (bingo('X') && XCnt == OCnt + 1) {
                    sb.append("valid\n");
                }
                // O 빙고일때 개수 같음
                else if (bingo('O') && XCnt == OCnt) {
                    sb.append("valid\n");
                } else {
                    sb.append("invalid\n");
                }

            }

        }

        System.out.println(sb);

    }

    private static boolean bingo(char ch) {

        for (int i = 0; i < 3; i++) {
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ch) {
                    count++;
                }
            }

            if (count == 3) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            int count = 0;
            for (int i = 0; i < 3; i++) {
                if (board[i][j] == ch) {
                    count++;
                }
            }

            if (count == 3) {
                return true;
            }
        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] == ch) {
            return true;
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[2][0] == ch) {
            return true;
        }

        return false;
    }
}
