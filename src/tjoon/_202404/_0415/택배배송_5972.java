package tjoon._202404._0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 택배배송_5972 {

    static int n, m;
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 노드개수
        m = Integer.parseInt(st.nextToken()); // 간선개수

        list = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, cost));
            list[b].add(new Node(a, cost));
        }

        visited = new boolean[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijkstra();

        System.out.println(dist[n]);
    }

    private static void dijkstra() {

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(1, 0));
        dist[1] = 0;

        while (!queue.isEmpty()) {

            Node cur = queue.poll();

            if (!visited[cur.num]) {
                for (Node node : list[cur.num]) {
                    if (dist[node.num] > dist[cur.num] + node.cost) {
                        dist[node.num] = dist[cur.num] + node.cost;
                        queue.offer(new Node(node.num, dist[node.num]));
                    }
                }
            }

        }


    }

    static class Node implements Comparable<Node> {
        int num;
        int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

}
