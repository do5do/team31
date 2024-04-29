package jchang._2024._04._0426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 고층건물_1027 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] building = new int[n];
    for (int i = 0; i < n; i++) {
      building[i] = Integer.parseInt(st.nextToken());
    }

    int total = 0;
    for (int i = 0; i < n; i++) {

      int count = 0;
      double slope = 0;
      for (int j = i - 1; j >= 0 ; j--) {
        double temp = (double) (building[i] - building[j]) / (i - j);
        if (j == i - 1 || temp < slope) {
          slope = temp;
          count++;
        }
      }

      for (int j = i + 1; j < n; j++) {
        double temp = (double) (building[j] - building[i]) / (j - i);
        if (j == i + 1 || temp > slope) {
          slope = temp;
          count++;
        }
      }
      total = Math.max(total, count);
    }
    System.out.println(total);

  }
}
