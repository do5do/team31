package tjoon._202404._0429;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 파티_1238 {
    static int n, m, x;
    static List<ArrayList<Node>> goList;
    static List<ArrayList<Node>> backList;
    static int[] dist1;
    static int[] dist2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        goList = new ArrayList<>();
        backList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            goList.add(new ArrayList<>());
            backList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            goList.get(start).add(new Node(end, cost));
            backList.get(end).add(new Node(start, cost));
        }


        dist1 = new int[n + 1];
        dist2 = new int[n + 1];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        dijkstra(goList, dist1, x);
        dijkstra(backList, dist2, x);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dist1[i + 1] + dist2[i + 1]);
        }

        System.out.println(max);

    }

    private static void dijkstra(List<ArrayList<Node>> list, int[] arr, int start) {

        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        arr[start] = 0;

        while (!pq.isEmpty()) {

            Node cur = pq.poll();

            if (!visited[cur.end]) {
                visited[cur.end] = true;

                for (Node node : list.get(cur.end)) {
                    if (arr[node.end] > arr[cur.end] + node.cost) {
                        arr[node.end] = arr[cur.end] + node.cost;
                        pq.offer(new Node(node.end, arr[node.end]));
                    }
                }

            }

        }
    }

    static class Node implements Comparable<Node> {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
