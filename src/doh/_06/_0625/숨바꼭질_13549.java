package doh._06._0625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 숨바꼭질_13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(bfs(n, k));
    }

    public static int bfs(int n, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.offer(new int[] {n, 0});
        boolean[] visited = new boolean[100001];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (visited[cur[0]]) {
                continue;
            }
            visited[cur[0]] = true;

            if (cur[0] == k) {
                return cur[1];
            }

            int nx = cur[0] * 2;
            if (nx >= 0 && nx <= 100000) {
                pq.offer(new int[] {nx, cur[1]});
            }

            nx = cur[0] + 1;
            if (nx >= 0 && nx <= 100000) {
                pq.offer(new int[] {nx, cur[1] + 1});
            }

            nx = cur[0] - 1;
            if (nx >= 0 && nx <= 100000) {
                pq.offer(new int[] {nx, cur[1] + 1});
            }
        }

        return -1;
    }
}
