package jchang._2024._03._0329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 예산_2512 {

  static int total;
  static int[] request;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    request = new int[n];
    int max = 0;
    for (int i = 0; i < n; i++) {
      request[i] = Integer.parseInt(st.nextToken());
      max = Math.max(max, request[i]);
    }

    total = Integer.parseInt(br.readLine());
    int result = 0;
    int min = 0;
    while (min <= max) {
      int mid = min + (max - min) / 2;

      if (check(mid)) {
        result = mid;
        min = mid + 1;
      } else {
        max = mid -1;
      }
    }

    System.out.println(result);
  }

  private static boolean check(int limit) {
    int sum = 0;
    for (int j : request) {
      sum += Math.min(j, limit);

      if (sum > total) {
        return false;
      }
    }
    return true;
  }
}
