package jchang._2024._06._0625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숨바꼭질3_13549_2 {
  // 수빈이 위치 N, 동생 위치 K
  // 수빈이 걸으면 1초 후 X-1 또는 X+1, 순간이동을 하면 0초 후 2X
  // 수빈이가 동생을 찾을 수 있는 가장 빠른 시간
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    if (n == k) {
      System.out.println(0);
      return;
    }

    // 해당 위치(인덱스)에 올 수 있는 최소시간을 나타내는 dp배열을 만듬
    int[] dp = new int[100001];
    // n보다 작은 위치는 무조건 n에서 하나씩 줄여오는게 최소시간임(n/2로 이동할 수 있는 방법이 없기 때문)
    for (int i = n - 1; i >= 0; i--) {
      dp[i] = dp[i + 1] + 1;
      if (i == k) {
        System.out.println(dp[i]);
        return;
      }
    }

    // n보다 큰 위치는 위치가 짝수인 경우 왼쪽에서 한칸 오는 것과 순간이동으로 오는 것을 비교하여 작은 값을 선택하면 됨
    // (dp[i + 1] / 2 + 1을 비교하지 않아도 되는 이유 : i + 1은 홀수가 되기 때문에 순간이동을 할 수가 없음)
    // n보다 큰 위치가 홀수인 경우 왼쪽에서 한칸 오는 것과 i + 1의 위치에서 순간이동 해서 오는 경우 중 작은 값을 선택하면 됨
    for (int i = n + 1; i <= k; i++) {
      if (i % 2 == 0) {
        dp[i] = Math.min(dp[i - 1] + 1, dp[i / 2]);
      } else {
        dp[i] = Math.min(dp[i - 1] + 1, dp[(i + 1) / 2] + 1);
      }
    }

    System.out.println(dp[k]);
  }
}
