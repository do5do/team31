package jchang._2024._03._0328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 어두운굴다리_17266 {


  static int N;
  static int[] lampPosition;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());


    lampPosition = new int[M];
    for (int i = 0; i < M; i++) {
      lampPosition[i] = Integer.parseInt(st.nextToken());
    }

    int min = 1;
    int max = N;
    int result = 0;
    while (min <= max) {
      int mid = min + (max - min) / 2;
      // 불 들어오는 곳 표시
      if (checkAll(mid)) {
        result = mid;
        max = mid - 1;
      } else {
        min = mid + 1;
      }

    }

    System.out.println(result);
  }

  private static boolean checkAll(int height) {
    int prev = 0;
    for (int j : lampPosition) {
      if (j - height <= prev) {
        prev = j + height;
      } else {
        return false;
      }
    }
    return N - prev <= 0;
  }


}
