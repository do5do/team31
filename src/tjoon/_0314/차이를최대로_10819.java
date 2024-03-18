package tjoon._0314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 차이를최대로_10819 {

  static int n;
  static int[] nums;
  static int[] result;
  static boolean[] visited;
  static int max = Integer.MIN_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    nums = new int[n];
    result = new int[n];
    visited = new boolean[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    dfs(0);
    System.out.println(max);
  }

  private static void dfs(int idx) {
    if (idx == n) {
      int sum = 0;
      for (int i = 0; i < n - 1; i++) {
        sum += Math.abs(result[i] - result[i + 1]);
      }

      max = Math.max(max, sum);
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (!visited[i]) {
        result[idx] = nums[i];
        visited[i] = true;
        dfs(idx + 1);
        visited[i] = false;
      }
    }
  }

}
