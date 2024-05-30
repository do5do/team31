package jchang._2024._05._0530;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쿠키의신체측정_20125_2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    char[][] board = new char[n][n];
    for (int i = 0; i < n; i++) {
      board[i] = br.readLine().toCharArray();
    }

    int[] heart = new int[2];
    loop :
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == '*') {
          heart[0] = i + 1;
          heart[1] = j;
          break loop;
        }
      }
    }

    int leftArm = 0;
    int rightArm = 0;
    for (int i = 0; i < n; i++) {
      if (i < heart[1]) {
        if (board[heart[0]][i] == '*') {
          leftArm++;
        }
      } else if (i > heart[1]) {
        if (board[heart[0]][i] == '*') {
          rightArm++;
        }
      }
    }

    int leftLeg = 0;
    int rightLeg = 0;
    int waist = 0;
    for (int i = heart[0] + 1; i < n; i++) {
      for (int j = heart[1] - 1; j <= heart[1] + 1; j++) {
        if (j == heart[1] - 1 && board[i][j] == '*') {
          leftLeg++;
        } else if (j == heart[1] && board[i][j] == '*') {
          waist++;
        } else if (j == heart[1] + 1 && board[i][j] == '*') {
          rightLeg++;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(heart[0] + 1).append(" ").append(heart[1] + 1).append("\n")
        .append(leftArm).append(" ").append(rightArm).append(" ")
        .append(waist).append(" ").append(leftLeg).append(" ")
        .append(rightLeg);

    System.out.println(sb);
  }
}
