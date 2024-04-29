package jchang._2024._04._0426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 여행가자_1976 {
  static int n;
  static int m;
  static int[] parent;
  static int[] plan;
  static Set<Integer> set = new HashSet<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());
    parent = new int[n + 1];
    for (int i = 1; i <= n ; i++) {
      parent[i] = i;
    }


    plan = new int[m];
    StringTokenizer st;
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= n; j++) {
        int temp = Integer.parseInt(st.nextToken());
        if (temp == 1) {
          union(i, j);
        }
      }
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      plan[i] = Integer.parseInt(st.nextToken());
    }

    int start = plan[0];
    for (int i = 1; i < m; i++) {
      if (parent[start] != parent[plan[i]]) {
        System.out.println("NO");
        return;
      }
    }
    System.out.println("YES");
  }

  private static int find(int x) {
    if (x == parent[x]) {
      return x;
    }
    return parent[x] = find(parent[x]);
  }

  private static void union(int x, int y) {
    x = find(x);
    y = find(y);
    if (x > y) {
      parent[x] = y;
    } else {
      parent[y] = x;
    }

  }
}
