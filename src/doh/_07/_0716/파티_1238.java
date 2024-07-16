package doh._07._0716;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 파티_1238 {
    static int n;
    static int[] dist;
    static int[] dist2;
    static List<int[]>[] graph;
    static List<int[]>[] graph2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        graph2 = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
            graph2[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph[start].add(new int[] {end, time});
            graph2[end].add(new int[] {start, time});
        }

        // x -> 마을로가는 최단거리
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dfs(x, dist, graph);

        // 마을 -> x로가는 최단거리
        dist2 = new int[n + 1];
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dfs(x, dist2, graph2);

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(dist[i] + dist2[i], max);
        }
        System.out.println(max);
    }

    public static void dfs(int start, int[] dist, List<int[]>[] graph) {
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.offer(new int[] {start, 0});
        boolean[] visited = new boolean[n + 1];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (visited[cur[0]]) {
                continue;
            }
            visited[cur[0]] = true;

            for (int[] node : graph[cur[0]]) {
                if (dist[node[0]] > cur[1] + node[1]) {
                    dist[node[0]] = cur[1] + node[1];
                    pq.offer(new int[] {node[0], dist[node[0]]});
                }
            }
        }
    }
}
