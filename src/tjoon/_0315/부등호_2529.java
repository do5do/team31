package tjoon._0315;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 부등호_2529 {

  static int k;
  static char[] sign;
  static boolean[] visited;
  static int[] nums;
  static List<String> ans = new ArrayList<>();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    k = Integer.parseInt(br.readLine());

    sign = new char[k];
    visited = new boolean[10];
    nums = new int[k + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < k; i++) {
      sign[i] = st.nextToken().charAt(0);
    }

    dfs(0);

    System.out.println(ans.get(ans.size() - 1));
    System.out.println(ans.get(0));

  }

  private static void dfs(int curIdx) {

    if (curIdx == k + 1) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < nums.length; i++) {
        sb.append(nums[i]);
      }

      ans.add(sb.toString());
      return;
    }

    for (int i = 0; i < 10; i++) {
      if (curIdx == 0 || !visited[i] && check(i, curIdx, sign[curIdx - 1])) {
        visited[i] = true;
        nums[curIdx] = i;
        dfs(curIdx + 1);
        visited[i] = false;
      }
    }

  }

  private static boolean check(int num, int idx, char c) {

    if (c == '>') {
      return nums[idx - 1] > num;
    }
    if (c == '<') {
      return nums[idx - 1] < num;
    }

    return false;
  }

}
