package jchang._2024._03._0318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 로봇프로젝트_3649 {

  static int hole;
  static int n;
  static int[] lego;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    while (line != null) {
      hole = Integer.parseInt(line) * 10_000_000;
      n = Integer.parseInt(br.readLine());
      lego = new int[n];
      for (int i = 0; i < n; i++) {
        lego[i] = Integer.parseInt(br.readLine());
      }

      Arrays.sort(lego);

      int left = 0;
      int right = n - 1;
      boolean flag = false;
      while (left < right) {
        if (lego[left] + lego[right] == hole) {
          System.out.printf("yes %d %d%n", lego[left], lego[right]);
          flag = true;
          break;
        } else if (lego[left] + lego[right] < hole) {
          left++;
        } else if (lego[left] + lego[right] > hole) {
          right--;
        }
      }

      if (!flag) {
        System.out.println("danger");
      }

      line = br.readLine();
    }

  }
}
