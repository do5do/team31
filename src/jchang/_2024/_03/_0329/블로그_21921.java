package jchang._2024._03._0329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 블로그_21921 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());

    int[] visit = new int[n];
    int max = 0;
    int count = 0;
    int sum = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      visit[i] = Integer.parseInt(st.nextToken());
      sum += visit[i];
      if (i >= x - 1) {
        if (i != x - 1) {
          sum -= visit[i - x];
        }

        if (sum > max) {
          max = sum;
          count = 1;
        } else if (sum == max) {
          count++;
        }
      }
    }

    if (max == 0) {
      System.out.println("SAD");
    } else {
      System.out.println(max);
      System.out.println(count);
    }
  }
}
