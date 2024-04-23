package jchang._2024._04._0423;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class $0만들기_7490 {
  static StringBuilder sb = new StringBuilder();
  static int maxIdx;
  static char[] operators= new char[]{'+','-',' '};
  static char[] result;
  static List<String> list;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      maxIdx = n - 1;
      result = new char[maxIdx];
      list = new ArrayList<>();
      dfs(0);
      Collections.sort(list);

      for (String s : list) {
        sb.append(s).append("\n");
      }
      sb.append("\n");
    }

    System.out.println(sb);

  }

  private static void dfs(int idx) {
    if (idx == maxIdx) {
      String str = makeString();
      if (calculator(str) == 0) {
        list.add(str);
      }
      return;
    }

    for (char operator : operators) {
      result[idx] = operator;
      dfs(idx + 1);
    }
  }

  private static int calculator(String str) {
    String string = str.replaceAll(" ", "");
    StringTokenizer tokenizer = new StringTokenizer(string, "-|+", true);
    int sum = Integer.parseInt(tokenizer.nextToken());
    while (tokenizer.hasMoreElements()) {
      String s = tokenizer.nextToken();
      if (s.equals("+")) {
        sum += Integer.parseInt(tokenizer.nextToken());
      } else if (s.equals("-")) {
        sum -= Integer.parseInt(tokenizer.nextToken());
      }
    }
    return sum;
  }

  private static String makeString() {
    StringBuilder localSb = new StringBuilder();
    for (int i = 0; i < result.length; i++) {
      localSb.append(i + 1);
      localSb.append(result[i]);
    }
    localSb.append(result.length + 1);
    return localSb.toString();
  }
}
