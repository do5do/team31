package tjoon._202404._0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주식_11501 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());

    int N;
    int[] days;

    for (int t = 0; t < T; t++) {

      // 코드 시작
      N = Integer.parseInt(br.readLine());
      days = new int[N];

      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        days[i] = Integer.parseInt(st.nextToken());
      }

      long sum = 0;
      int max = days[N - 1];
      for (int i = N - 2; i >= 0; i--) {
        if (days[i] <= max) {
          sum += max - days[i];
        } else {
          max = days[i];
        }
      }

      sb.append(sum).append("\n");
    }

    System.out.println(sb);

  }

}
