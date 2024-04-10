package tjoon._202404._0410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질3_13549 {

    static int N, K;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[100_002];

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(N, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.pos == K) {
                return cur.time;
            }

            if (cur.pos * 2 < visited.length && !visited[cur.pos * 2]) {
                queue.offer(new Node(cur.pos * 2, cur.time));
                visited[cur.pos * 2] = true;
            }

            if (cur.pos - 1 >= 0 && !visited[cur.pos - 1]) {
                queue.offer(new Node(cur.pos - 1, cur.time + 1));
                visited[cur.pos - 1] = true;
            }

            if (cur.pos + 1 < visited.length && !visited[cur.pos + 1]) {
                queue.offer(new Node(cur.pos + 1, cur.time + 1));
                visited[cur.pos + 1] = true;
            }

        }

        return -1;
    }

    static class Node {
        int pos;
        int time;

        public Node(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }
}
