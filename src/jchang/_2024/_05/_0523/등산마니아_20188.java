package jchang._2024._05._0523;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 등산마니아_20188 {
  static int n;
  static List<Integer>[] tree;
  static int[] subTree;
  static boolean[] visited;
  static long result = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    tree = new List[n + 1];
    subTree = new int[n + 1];
    Arrays.fill(subTree, 1);
    for (int i = 0; i <= n; i++) {
      tree[i] = new ArrayList<>();
    }

    for (int i = 1; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      tree[a].add(b);
      tree[b].add(a);
    }

    visited = new boolean[n + 1];
    visited[1] = true;
    dfs(1);

    for (int i = 2; i <= n; i++) {
      int restNode = n - subTree[i];
      result += combination(n) - combination(restNode);
    }

    System.out.println(result);
  }

  private static long combination(int n) {
    return (long) n * (n - 1) / 2;
  }

  private static int dfs(int start) {
    for (int next : tree[start]) {
      if (!visited[next]) {
        visited[next] = true;
        subTree[start] += dfs(next);
      }
    }

    return subTree[start];
  }
}
// 참고 : https://velog.io/@lio8625/%EB%B0%B1%EC%A4%80-20188-JAVA-%EB%93%B1%EC%82%B0-%EB%A7%88%EB%8B%88%EC%95%84
