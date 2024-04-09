package tjoon._202403._0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 등수구하기_1205 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());

    if (N == 0) {
      System.out.println(1);
      System.exit(0);
    }

    int K = Integer.parseInt(st.nextToken());
    int P = Integer.parseInt(st.nextToken());

    int[] score = new int[P];
    Arrays.fill(score, -1);

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      score[i] = Integer.parseInt(st.nextToken());
    }

    int idx = 0;
    for (int i = 0; i < score.length; i++) {
      if (score[i] == -1) {
        score[i] = K;
        idx = i;
        break;
      }

      if (i == score.length - 1 && score[i] >= K) {
        System.out.println(-1);
        System.exit(0);
      }

      if (score[i] < K) {
        for (int j = score.length - 1; j >= i + 1; j--) {
          score[j] = score[j - 1];
        }
        score[i] = K;
        idx = i;
        break;
      }
    }

    int same = 0;
    for (int i = idx; i >= 0; i--) {
      if (score[i] == K) {
        same++;
      }
    }

    System.out.println(idx - same + 2);
  }

}
