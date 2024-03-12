package doh._0312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 숨바꼭질_1697 {
    static int k;
    static int[] dp;
    static int max = 100_000;
    static int[] temp = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()); // 동생의 위치
        dp = new int[max + 1]; // 초
        bfs(n);
    }

    public static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        dp[n] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == k) {
                System.out.println(dp[k] - 1);
                break;
            }

            temp[0] = cur - 1;
            temp[1] = cur + 1;
            temp[2] = cur * 2;

            for (int i = 0; i < 3; i++) {
                int next = temp[i];

                if (next >= 0 && next <= max && dp[next] == 0) {
                    dp[next] = dp[cur] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}
