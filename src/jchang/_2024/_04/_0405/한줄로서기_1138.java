package jchang._2024._04._0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 한줄로서기_1138 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] array = new int[n];
    for (int i = 0; i < n; i++) {
      int moreHigh = Integer.parseInt(st.nextToken());
      int height = i + 1;
      int count = 0;
      for (int j = 0; j < array.length; j++) {
        if (count == moreHigh && array[j] == 0) {
          array[j] = height;
          break;
        }

        if (array[j] == 0) {
          count++;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int num : array) {
      sb.append(num).append(" ");
    }

    System.out.println(sb);
  }
}
// 4
// 2 1 1 0
// 1 2 3 4

// 4 2 1 3