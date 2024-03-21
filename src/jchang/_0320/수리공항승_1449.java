package jchang._0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수리공항승_1449 {
  static int N;
  static int L;
  static int[] holes;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    holes = new int[N];
    for (int i = 0; i < N; i++) {
      holes[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(holes);
    int count = 0;
    int left = holes[0];
    for (int i = 1; i < N; i++) {
      int distance = holes[i] - left + 1;
      if (distance > L) {
        count++;
        left = holes[i];
      }
    }

    System.out.println(count + 1);
  }
}
