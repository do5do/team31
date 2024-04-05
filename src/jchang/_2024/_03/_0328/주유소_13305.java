package jchang._2024._03._0328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주유소_13305 {

  static long result = 0;
  static long[] distances;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    distances = new long[N-1];
    long[] cost = new long[N];
    for (int i = 0; i < N-1; i++) {
      distances[i] = Long.parseLong(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      cost[i] = Long.parseLong(st.nextToken());
    }

    for (int i = 0; i < N - 1; i++) {
      long cur = cost[i];
      boolean isVisit = false;
      for (int j = i + 1; j < N-1 ; j++) {
        if (cost[j] < cur) {
          move(cur, i, j);
          i = j - 1;
          isVisit = true;
          break;
        }
      }
      if (!isVisit) {
        move(cur, i, N - 1);
        break;
      }
    }

    System.out.println(result);
  }

  private static void move(long cost, int start, int end) {
    long distanceSum = 0;
    for (int i = start; i < end; i++) {
      distanceSum += distances[i];
    }
    result += cost * distanceSum;
  }
}
