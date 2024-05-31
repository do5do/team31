package jchang._2024._05._0531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스위치켜고끄기_1244_2 {
  static boolean[] switches;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    switches = new boolean[n + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      int temp = Integer.parseInt(st.nextToken());
      switches[i] = temp == 1;
    }

    int students = Integer.parseInt(br.readLine());
    for (int i = 0; i < students; i++) {
      st = new StringTokenizer(br.readLine());
      int gender = Integer.parseInt(st.nextToken());
      int num = Integer.parseInt(st.nextToken());
      if (gender == 1) {
        man(num);
      } else {
        woman(num);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < switches.length; i++) {
      if (switches[i]) {
        sb.append(1).append(" ");
      } else {
        sb.append(0).append(" ");
      }
      if (i % 20 == 0) {
        sb.append("\n");
      }
    }

    System.out.println(sb);
  }

  private static void man(int num) {
    for (int i = num; i < switches.length; i += num) {
      switches[i] = !switches[i];
    }
  }

  private static void woman(int num) {
    int left = num;
    int right = num;
    // 0 1 1 1 0 1 0 1

    while (switches[left] == switches[right]) {

      left--;
      right++;

      if (left <= 0 || right >= switches.length) {
        break;
      }
    }

    for (int i = left + 1; i <= right - 1; i++) {
      switches[i] = !switches[i];
    }
  }
}
