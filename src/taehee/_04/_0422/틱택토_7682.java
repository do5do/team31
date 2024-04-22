package taehee._04._0422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 틱택토_7682 {

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;

    while (!"end".equals(line = br.readLine())) {
      char[][] board = new char[3][3];
      int emptyCount = 0;
      int xCount = 0;
      int oCount = 0;

      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          board[i][j] = line.charAt(i * 3 + j);
          switch (board[i][j]) {
            case 'X':
              xCount++;
              break;
            case 'O':
              oCount++;
              break;
            case '.':
              emptyCount++;
              break;
          }
        }
      }

      if (emptyCount == 0) {
        char win = isWin(board);

        if (win == 'X') {
          if (xCount == oCount + 1) {
            sb.append("valid").append("\n");
          } else {
            sb.append("invalid").append("\n");
          }
        } else if (win == 'O') {
          if (xCount == oCount) {
            sb.append("valid").append("\n");
          } else {
            sb.append("invalid").append("\n");
          }
        } else if (win == '-') {
          sb.append("invalid").append("\n");
        } else {
          if (xCount == oCount + 1) {
            sb.append("valid").append("\n");
          } else {
            sb.append("invalid").append("\n");
          }
        }
      } else {
        if (xCount < 3 && oCount < 3) {
          sb.append("invalid").append("\n");
        } else {
          char win = isWin(board);

          if (win == 'X') {
            if (xCount == oCount + 1) {
              sb.append("valid").append("\n");
            } else {
              sb.append("invalid").append("\n");
            }
          } else if (win == 'O') {
            if (xCount - emptyCount == oCount - emptyCount && xCount > emptyCount) {
              sb.append("valid").append("\n");
            } else {
              sb.append("invalid").append("\n");
            }
          } else {
            sb.append("invalid").append("\n");
          }
        }
      }
    }

    System.out.println(sb);
  }

  static char isWin(char[][] board) {
    Set<Character> bingo = new HashSet<>();

    if (board[0][0] != '.' && board[0][0] == board[0][1] && board[0][1] == board[0][2]) {
      bingo.add(board[0][0]);
    }

    if (board[1][0] != '.' && board[1][0] == board[1][1] && board[1][1] == board[1][2]) {
      bingo.add(board[1][0]);
    }

    if (board[2][0] != '.' && board[2][0] == board[2][1] && board[2][1] == board[2][2]) {
      bingo.add(board[2][0]);
    }

    if (board[0][0] != '.' && board[0][0] == board[1][0] && board[1][0] == board[2][0]) {
      bingo.add(board[0][0]);
    }

    if (board[0][1] != '.' && board[0][1] == board[1][1] && board[1][1] == board[2][1]) {
      bingo.add(board[0][1]);
    }

    if (board[0][2] != '.' && board[0][2] == board[1][2] && board[1][2] == board[2][2]) {
      bingo.add(board[0][2]);
    }

    if (board[0][0] != '.' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
      bingo.add(board[0][0]);
    }

    if (board[0][2] != '.' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
      bingo.add(board[0][2]);
    }

    return (bingo.isEmpty()) ? '.' : bingo.size() == 1 ? bingo.iterator().next() : '-';
  }
}
