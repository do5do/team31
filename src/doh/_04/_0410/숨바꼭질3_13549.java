package doh._04._0410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 숨바꼭질3_13549 {
    static int n;
    static int k;
    static int[] dist = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        bfs();

        System.out.println(dist[k]);
    }

    static void bfs() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[] {n, 0});
        int[] step = new int[3];
        int[] time = new int[3];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[0] == k) {
                return;
            }

            step[0] = cur[0] - 1;
            step[1] = cur[0] + 1;
            step[2] = cur[0] * 2;

            time[0] = dist[cur[0]] + 1;
            time[1] = dist[cur[0]] + 1;
            time[2] = dist[cur[0]];

            for (int i = 0; i < 3; i++) {
                int nx = step[i];

                if (nx >= 0 && nx < dist.length && time[i] < dist[nx]) {
                    dist[nx] = time[i];
                    pq.offer(new int[] {nx, time[i]});
                }
            }
        }
    }
}

// 0 100
// expect 3

// queue로 하면 연산 순서에 따라 틀림. *2, -1, 1 순서로 해야 정답 처리
// pq로 하면 상관 없음