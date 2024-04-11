package taehee._04._0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class 최소힙_1927 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    Queue<Integer> queue = new PriorityQueue<>();
    for (int i = 0; i < N; i++) {
      int x = Integer.parseInt(br.readLine());
      if (x == 0) {
        sb.append(queue.isEmpty() ? 0 : queue.poll()).append("\n");
      } else {
        queue.add(x);
      }
    }
    System.out.println(sb);
  }
}
