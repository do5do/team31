package jchang._2024._05._0527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합_11723_2 {

  static StringBuilder sb = new StringBuilder();
  static int bit = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int m = Integer.parseInt(br.readLine());

    for (int i = 0; i < m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      solve(st);
    }
    System.out.println(sb);
  }

  private static void solve(StringTokenizer st) {
    String command = st.nextToken();
    int n = 0;
    if (!command.equals("all") && !command.equals("empty")) {
      n = Integer.parseInt(st.nextToken());
    }

    switch (command) {
      case "add":
        bit |= 1 << n;
        break;
      case "remove":
        bit &= ~(1 << n);
        break;
      case "check":
        sb.append((bit & (1 << n)) == 0 ? 0 : 1).append("\n");
        break;
      case "toggle":
        bit ^= 1 << n;
        break;
      case "all":
        bit = (1 << 21) - 1;
        break;
      case "empty":
        bit = 0;
        break;
    }
  }
}
