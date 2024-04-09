package tjoon._202403._0312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질_1697 {

  static int[] line;
  static int n, k;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    line = new int[100_001];

    System.out.println(bfs(n));

  }

  private static int bfs(int start) {

    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    line[start] = 0;

    while (!queue.isEmpty()) {
      int cur = queue.poll();

      if (cur == k) {
        return line[k];
      }

      if (cur + 1 < line.length && line[cur + 1] == 0) {
        queue.offer(cur + 1);
        line[cur + 1] = line[cur] + 1;
      }

      if (cur - 1 >= 0 && line[cur - 1] == 0) {
        queue.offer(cur - 1);
        line[cur - 1] = line[cur] + 1;
      }

      if (cur * 2 < line.length && line[cur * 2] == 0) {
        queue.offer(cur * 2);
        line[cur * 2] = line[cur] + 1;
      }
    }

    return -1;
  }
}
