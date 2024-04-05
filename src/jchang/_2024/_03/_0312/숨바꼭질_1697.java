package jchang._2024._03._0312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질_1697 {
  static int N;
  static int K;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    arr = new int[100_001];
    int result = bfs(N);
    System.out.print(result);

  }

  private static int bfs(int start) {
    Queue<Integer> q = new LinkedList<>();
    q.add(start);
    arr[start] = 1;

    while (!q.isEmpty()) {
      int cur = q.poll();

      if (cur == K) {
        return arr[cur] - 1;
      }

      if (cur - 1 >= 0 && cur - 1 < arr.length && arr[cur - 1] == 0) {
        arr[cur - 1] = arr[cur] + 1;
        q.add(cur - 1);
      }

      if (cur + 1 >= 0 && cur + 1 < arr.length && arr[cur + 1] == 0) {
        arr[cur + 1] = arr[cur] + 1;
        q.add(cur + 1);
      }

      if (cur * 2 < arr.length && arr[cur * 2] == 0) {
        arr[cur * 2] = arr[cur] + 1;
        q.add(cur * 2);
      }
    }
    return -1;
  }
}
