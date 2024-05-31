package jchang._2024._05._0531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 등수구하기_1205_2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int targetScore = Integer.parseInt(st.nextToken());
    int p = Integer.parseInt(st.nextToken());
    if (n == 0) {
      System.out.println(1);
      return;
    }

    st = new StringTokenizer(br.readLine());
    int[] scores = new int[n];
    for (int i = 0; i < n; i++) {
      scores[i] = Integer.parseInt(st.nextToken());
    }

    int rank = -1;
    if (n == p && targetScore == scores[n - 1]) {
      System.out.println(rank);
      return;
    } else {
      for (int i = 0; i < n; i++) {
        if (targetScore >= scores[i]) {
          rank = i + 1;
          break;
        }
      }

      if (rank == -1 && n < p) {
        rank = n + 1;
      }
    }

    System.out.println(rank);
  }
}
