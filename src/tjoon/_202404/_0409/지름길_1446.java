package tjoon._202404._0409;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 지름길_1446 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int D = Integer.parseInt(st.nextToken());

    List<Node> path = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int distance = Integer.parseInt(st.nextToken());

      if (end <= D) {
        if (end - start > distance) {
          path.add(new Node(start, end, distance));
        }
      }
    }

    Collections.sort(path);

    int[] dist = new int[10001];
    Arrays.fill(dist, 10001);

    int idx = 0;
    int move = 0;

    dist[0] = 0;

    while (move < D) {
      if (idx < path.size()) {
        Node cur = path.get(idx);
        if (move == cur.start) {
          dist[cur.end] = Math.min(dist[move] + cur.distance, dist[cur.end]);
          idx++;
        } else {
          dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
          move++;
        }
      } else {
        dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
        move++;
      }
    }

    System.out.println(dist[D]);

  }

  static class Node implements Comparable<Node> {

    int start;
    int end;
    int distance;

    public Node(int start, int end, int distance) {
      this.start = start;
      this.end = end;
      this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
      if (this.start == o.start) {
        return Integer.compare(this.end, o.end);
      }

      return Integer.compare(this.start, o.start);
    }
  }

}
