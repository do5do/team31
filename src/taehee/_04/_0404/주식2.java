package taehee._04._0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 주식2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      int N = Integer.parseInt(br.readLine());
      int[] days = new int[N];
      String[] lines = br.readLine().split(" ");
      for (int j = 0; j < lines.length; j++) {
        days[j] = Integer.parseInt(lines[j]);
      }

      long profit = 0;
      int max = days[N - 1];
      for (int j = N - 1; j >= 0; j--) {
        if (days[j] <= max) {
          profit += (max - days[j]);
        } else {
          max = days[j];
        }
      }
      sb.append(profit).append("\n");
    }

    System.out.println(sb);
  }
}
