package tjoon._0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 최소힙_1927 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int i = 0; i < N; i++) {
      int op = Integer.parseInt(br.readLine());

      if (op == 0) {
        if (queue.isEmpty()) {
          sb.append(0).append("\n");
        } else {
          sb.append(queue.poll()).append("\n");
        }
      } else {
        queue.add(op);
      }

    }

    System.out.println(sb);

  }

}
