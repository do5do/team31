package jchang._2024._07._0702;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 틱택토_7682_2 {
  // 게임판 3 x 3
  // 첫번째 사람이 X, 두번째 사람이 O 번갈아 놓는다
  // 가로, 세로, 대각선 방향으로 3칸을 이으면 게임 종료
  // 게임판이 가득 차도 게임 종료
  // '.'은 빈칸
  static char[][] board;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;
    StringBuilder sb = new StringBuilder();
    board = new char[3][3];
    while (!(input = br.readLine()).equals("end")) {
      int xCount = 0;
      int oCount = 0;
      for (int i = 0; i < input.length(); i++) {
        char ch = input.charAt(i);
        board[i / 3][i % 3] = ch;
        if (ch == 'X') {
          xCount++;
        } else if (ch == 'O') {
          oCount++;
        }
      }

      int total = xCount + oCount;

      if (total == 9) {
        if (isBingo('O')) {
          sb.append("invalid").append("\n");
          continue;
        }

        if (xCount - oCount != 1) {
          sb.append("invalid").append("\n");
          continue;
        }

      } else {
        if (isBingo('O') && isBingo('X')) {
          sb.append("invalid").append("\n");
          continue;
        }

        if (!isBingo('O') && !isBingo('X')) {
          sb.append("invalid").append("\n");
          continue;
        }

        if (total % 2 == 1) {
          if (xCount - oCount != 1) {
            sb.append("invalid").append("\n");
            continue;
          }

          if (!isBingo('X')) {
            sb.append("invalid").append("\n");
            continue;
          }
        } else {
          if (xCount != oCount) {
            sb.append("invalid").append("\n");
            continue;
          }

          if (!isBingo('O')) {
            sb.append("invalid").append("\n");
            continue;
          }
        }
      }

      sb.append("valid").append("\n");
    }

    System.out.println(sb);
  }

  private static boolean isBingo(char target) {
    for (int i = 0; i < 3; i++) {
      if (board[i][0] == target && board[i][1] == target && board[i][2] == target) {
        return true;
      }

      if (board[0][i] == target && board[1][i] == target && board[2][i] == target) {
        return true;
      }
    }

    if (board[0][0] == target && board[1][1] == target && board[2][2] == target) {
      return true;
    }

    if (board[0][2] == target && board[1][1] == target && board[2][0] == target) {
      return true;
    }

    return false;
  }
}
