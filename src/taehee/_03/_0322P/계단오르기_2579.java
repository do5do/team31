package taehee._03._0322P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기_2579 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] stair = new int[N + 1];
    for (int i = 1; i < stair.length; i++) {
      stair[i] = Integer.parseInt(br.readLine());
    }
    int score = stair[1];
    int step = 1;
    while (++step < stair.length) {
      int st1 = stair[step++];

      if (step < stair.length) {
        int st2 = stair[step];

        if (st1 >= st2) {
          score += st1;
          step--;
        } else {
          score += st2;
        }
      } else {
        score += st1;
      }
    }

    System.out.println(score);
  }
}
