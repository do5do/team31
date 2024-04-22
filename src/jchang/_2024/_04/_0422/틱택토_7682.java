package jchang._2024._04._0422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 틱택토_7682 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str;
    StringBuilder sb = new StringBuilder();
    while (!(str = br.readLine()).equals("end")) {
      if (checkValid(str)) {
        sb.append("valid\n");
      } else {
        sb.append("invalid\n");
      }
    }
    System.out.println(sb);
  }

  public static boolean checkValid(String str) {
    char[][] board = new char[3][3];
    boolean isFull = true;
    int xCount = 0;
    int oCount = 0;
    for (int i = 0; i < str.length(); i++) {
      board[i / 3][i % 3] = str.charAt(i);
      if (str.charAt(i) == '.') {
        isFull = false;
      } else if (str.charAt(i) == 'X') {
        xCount++;
      } else if (str.charAt(i) == 'O') {
        oCount++;
      }
    }

    // 연속 3개 탐색
    Bingo oBingo = new Bingo();
    Bingo xBingo = new Bingo();
    // 대각선 \
    if (board[0][0] == board[1][1] && board[1][1] == board[2][2]
        && board[0][0] == board[2][2]) {
      if (board[0][0] == 'X') {
        xBingo.cross[0] = true;
      } else if (board[0][0] == 'O') {
        oBingo.cross[0] = true;
      }
    }

    // 대각선 /
    if (board[2][0] == board[1][1] && board[1][1] == board[0][2]
        && board[2][0] == board[0][2]) {
      if (board[2][0] == 'X') {
        xBingo.cross[1] = true;
      } else if (board[2][0] == 'O') {
        oBingo.cross[1] = true;
      }
    }

    for (int i = 0; i < board.length; i++) {
      // 가로줄
      if (board[i][0] == board[i][1] && board[i][1] == board[i][2]
          && board[i][0] == board[i][2]) {
        if (board[i][0] == 'X') {
          xBingo.horizontal[i] = true;
        } else if (board[i][0] == 'O') {
          oBingo.horizontal[i] = true;
        }
      }

      // 세로줄
      if (board[0][i] == board[1][i] && board[1][i] == board[2][i]
          && board[0][i] == board[2][i]) {
        if (board[0][i] == 'X') {
          xBingo.vertical[i] = true;
        } else if (board[0][i] == 'O') {
          oBingo.vertical[i] = true;
        }
      }
    }

    if (isFull) {
      if (xCount - 1 != oCount || oBingo.count() > 0 || xBingo.checkDouble()) {
        return false;
      }
    } else {
      if (xBingo.count() == 0 && oBingo.count() == 0) {
        return false;
      }
      if (xBingo.count() > 0) {
        if (oBingo.count() > 0 || xCount - 1 != oCount || xBingo.checkDouble()) {
          return false;
        }
      }

      if (oBingo.count() > 0) {
        if (xBingo.count() > 0 || xCount != oCount || oBingo.checkDouble()) {
          return false;
        }
      }
    }
    return true;
  }

  static class Bingo {

    boolean[] horizontal = new boolean[3];
    boolean[] vertical = new boolean[3];
    boolean[] cross = new boolean[2];

    public int count() {
      int count = 0;
      for (boolean b : this.horizontal) {
        if (b) {
          count++;
        }
      }

      for (boolean b : this.vertical) {
        if (b) {
          count++;
        }
      }

      for (boolean b : this.cross) {
        if (b) {
          count++;
        }
      }
      return count;
    }

    public boolean checkDouble() {
      int count = 0;
      for (boolean b : this.horizontal) {
        if (b) {
          count++;
        }
        if (count >= 2) {
          return true;
        }
      }

      count = 0;
      for (boolean b : this.vertical) {
        if (b) {
          count++;
        }
        if (count >= 2) {
          return true;
        }
      }
      return false;
    }
    //  X X X
    //  O O .
    //  X X X


  }
}
