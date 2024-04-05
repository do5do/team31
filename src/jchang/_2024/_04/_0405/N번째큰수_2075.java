package jchang._2024._04._0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N번째큰수_2075 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        int num = Integer.parseInt(st.nextToken());
        pq.add(num);
      }
    }

    int result = 0;
    for (int i = 0; i < n; i++) {
      result = pq.poll();
    }

    System.out.println(result);

  }
}
