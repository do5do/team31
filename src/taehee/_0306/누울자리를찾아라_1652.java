package taehee._0306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 누울자리를찾아라_1652 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    char[][] room = new char[N][N];

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < N; j++) {
        room[i][j] = line.charAt(j);
      }
    }

    int rowCnt = 0;
    int colCnt = 0;

    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < N; i++) {
      stack.clear();
      for (int j = 0; j < N; j++) {
        char pos = room[i][j];
        if (pos != '.') {
          if (stack.size() >= 2) {
            rowCnt++;
          }
          stack.clear();
        }
        else {
          stack.push(pos);
        }
      }
      if (stack.size() >= 2) {
        rowCnt++;
      }

      stack.clear();
      for (int j = 0; j < N; j++) {
        char pos = room[j][i];
        if (pos != '.') {
          if (stack.size() >= 2) {
            colCnt++;
          }
          stack.clear();
        }
        else {
          stack.push(pos);
        }
      }
      if (stack.size() >= 2) {
        colCnt++;
      }
    }

    System.out.printf("%d %d\n", rowCnt, colCnt);
  }
}
