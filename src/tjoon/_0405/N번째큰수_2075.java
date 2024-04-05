package tjoon._0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N번째큰수_2075 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st;
    PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        queue.add(Integer.parseInt(st.nextToken()));
      }
    }

    int[] answer = new int[N];
    for (int i = 0; i < N; i++) {
      answer[i] = queue.poll();
    }

    System.out.println(answer[N - 1]);

  }

}
