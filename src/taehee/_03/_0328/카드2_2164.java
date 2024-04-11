package taehee._03._0328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 카드2_2164 {

  static int N;
  static Queue<Integer> queue = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    for (int i = 1; i <= N; i++) {
      queue.add(i);
    }
    while (queue.size() > 1) {
      queue.poll();
      queue.add(queue.poll());
    }
    System.out.println(queue.poll());
  }
}
