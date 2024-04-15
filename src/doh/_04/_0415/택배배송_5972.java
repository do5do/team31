package doh._04._0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 택배배송_5972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] nodes = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            nodes[a].add(new Node(b, c));
            nodes[b].add(new Node(a, c));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        boolean[] visited = new boolean[n + 1];

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (!visited[cur.idx]) {
                visited[cur.idx] = true;

                for (Node node : nodes[cur.idx]) {
                    if (dist[node.idx] > dist[cur.idx] + node.weight) {
                        dist[node.idx] = dist[cur.idx] + node.weight;
                        pq.offer(new Node(node.idx, dist[node.idx]));
                    }
                }
            }
        }

        System.out.println(dist[n]);
    }

    static class Node implements Comparable<Node> {
        int idx;
        int weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(weight, o.weight);
        }
    }
}
