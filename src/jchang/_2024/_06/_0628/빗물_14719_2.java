package jchang._2024._06._0628;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빗물_14719_2 {
  // 고이는 빗물의 총량
  // 오목한 곳을 찾아야 한다.
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int h = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());

    int[] heights = new int[w];
    st = new StringTokenizer(br.readLine());
    int maxIdx = 0;
    int max = 0;

    // 데이터를 입력 받을 때 최대값과 이에 해당하는 인덱스를 기록한다.
    for (int i = 0; i < w; i++) {
      heights[i] = Integer.parseInt(st.nextToken());
      if (heights[i] > max) {
        max = heights[i];
        maxIdx = i;
      }
    }

    if (w == 1) {
      System.out.println(0);
      return;
    }

    // 왼쪽에서 부터 maxIdx까지 순회하며 고여있는 빗물을 계산한다.
    // 왼쪽 기준점을 pre로 한다.
    int pre = heights[0];
    int sum = 0;
    for (int i = 1; i < maxIdx; i++) {
      if (heights[i] < pre) {
        sum += pre - heights[i];
      } else {
        pre = heights[i];
      }
    }

    // 오른쪽에서 maxIdx까지 순회하며 고여있는 빗물을 계산한다.
    // 오른쪽 기준점을 pre로 한다.
    pre = heights[w - 1];
    for (int i = w - 2; i > maxIdx ; i--) {
      if (heights[i] < pre) {
        sum += pre - heights[i];
      } else {
        pre = heights[i];
      }
    }

    System.out.println(sum);
  }
}
