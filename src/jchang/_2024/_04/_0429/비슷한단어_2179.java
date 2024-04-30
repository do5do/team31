package jchang._2024._04._0429;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 비슷한단어_2179 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String[] board = new String[n];
    String[] result = new String[2];
    int same = -1;
    for (int i = 0; i < n; i++) {
      board[i] = br.readLine();
    }

    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        int count = 0;
        for (int k = 0; k < Math.min(board[i].length(), board[j].length()); k++) {
          if (board[i].charAt(k) != board[j].charAt(k)) {
            break;
          }
          count++;
        }
        if (count > same) {
          same = count;
          result[0] = board[i];
          result[1] = board[j];
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (String s : result) {
      sb.append(s).append("\n");
    }
    System.out.println(sb);
  }
}
