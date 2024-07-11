package jchang._2024._07._0711;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 고층건물_1027_2 {
  // 가장 많은 고층 빌딩이 보이는 고층 빌딩을 찾으려고 한다.
  // 빌딩 N개, 고층 빌딩 A에서 다른 고층 빌딩 B를 보려면,
  // 두 지붕을 잇는 선분이 A와 B를 제외한 다른 고층빌딩을 지나거나 접하지 않아야 한다.
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] buildings = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      buildings[i] = Integer.parseInt(st.nextToken());
    }

    int result = 0;
    for (int i = 0; i < n; i++) {
      int count = 0;

      double pre = (double) Integer.MAX_VALUE;
      for (int j = i - 1; j >= 0; j--) {
        double slope = (double) (buildings[i] - buildings[j]) / (i - j);
        if (slope < pre) {
          count++;
          pre = slope;
        }
      }

      pre = (double) Integer.MIN_VALUE;;
      for (int j = i + 1; j < n; j++) {
        double slope = (double) (buildings[i] - buildings[j]) / (i - j);
        if (slope > pre) {
          count++;
          pre = slope;
        }
      }

      result = Math.max(result, count);
    }

    System.out.println(result);
  }
}
