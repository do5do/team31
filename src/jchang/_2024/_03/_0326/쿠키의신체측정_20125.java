package jchang._2024._03._0326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쿠키의신체측정_20125 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] board = new int[N][N];
    int[] heart = new int[2];

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < str.length(); j++) {
        char c = str.charAt(j);
        if (c == '*') {
          board[i][j] = 1;
          // 심장 위치 찾기
          if (j > 0 && i > 0 && str.charAt(j - 1) == '*') {
            if (board[i - 1][j] == 1) {
              heart[0] = i;
              heart[1] = j;
            }
          }
        }
      }
    }

    // 팔길이
    int leftArm = 0;
    int rightArm = 0;
    for (int j = 0; j < N; j++) {
      int n = board[heart[0]][j];
      if (j < heart[1]) {
        leftArm += n;
      } else if (j > heart[1]) {
        rightArm += n;
      }
    }

    // 다리길이 및 허리
    int leftLeg = 0;
    int rightLeg = 0;
    int back = 0;
    for (int i = heart[0] + 1; i < N; i++) {
      int n = board[i][heart[1]];
      if (n == 0) {
        leftLeg += board[i][heart[1] - 1];
        rightLeg += board[i][heart[1] + 1];
      } else {
        back += board[i][heart[1]];
      }
    }

    System.out.printf("%d %d\n", heart[0] + 1, heart[1] + 1);

    int[] result = new int[]{leftArm, rightArm, back, leftLeg, rightLeg};
    for (int n : result) {
      System.out.print(n + " ");
    }
  }


}
