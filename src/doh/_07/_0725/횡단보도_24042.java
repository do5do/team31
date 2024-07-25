package doh._07._0725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 횡단보도_24042 {
    static int n, m;
    static List<List<Node>> graph;
    static long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, i));
            graph.get(b).add(new Node(a, i));
        }

        dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        bfs();
        System.out.println(dist[n]);
    }

    public static void bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.idx] < cur.time) {
                continue;
            }

            for (Node node : graph.get(cur.idx)) {
                long next = node.time - (cur.time % m);
                if (next < 0) {
                    next += m;
                }
                next += cur.time;

                if (dist[node.idx] > next + 1) {
                    dist[node.idx] = next + 1;
                    pq.offer(new Node (node.idx, dist[node.idx]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int idx;
        long time;

        public Node(int idx, long time) {
            this.idx = idx;
            this.time = time;
        }

        public int compareTo(Node o) {
            return Long.compare(o.time, time);
        }
    }
}
