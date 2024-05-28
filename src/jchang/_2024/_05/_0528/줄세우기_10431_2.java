package jchang._2024._05._0528;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 줄세우기_10431_2 {
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int p = Integer.parseInt(br.readLine());

    for (int i = 0; i < p; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      solve(st);
    }

    System.out.println(sb);
  }

  private static void solve(StringTokenizer st) {
    int n = Integer.parseInt(st.nextToken());
    int result = 0;

    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < 20; i++) {
      list.add(Integer.parseInt(st.nextToken()));
    }

    for (int i = list.size() - 1; i >= 1; i--) {
      for (int j = i - 1; j >= 0; j--) {
        if (list.get(j) > list.get(i)) {
          result++;
        }
      }
    }

    sb.append(n).append(" ").append(result).append("\n");
  }
}
