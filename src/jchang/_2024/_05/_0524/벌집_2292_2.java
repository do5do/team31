package jchang._2024._05._0524;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 벌집_2292_2 {
  // 1, 6, 12, 18,
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int total = 1;
    int stage = 0;
    while (true) {
      total += 6 * stage;

      if (n <= total) {
        System.out.println(stage + 1);
        return;
      }

      stage++;
    }
  }
}
