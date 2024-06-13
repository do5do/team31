package jchang._2024._06._0612;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 최소힙_1927_2 {
  // 1. 배열에 자연수 x를 삽입
  // 2. 배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거(x = 0)
  // 배열이 비어있는 경우 가장 작은 값 출력 시 0으로 출력
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      int input = Integer.parseInt(br.readLine());
      if (input == 0) {
        if (pq.isEmpty()) {
          sb.append(0).append("\n");
        } else {
          sb.append(pq.poll()).append("\n");
        }
      } else {
        pq.add(input);
      }
    }

    System.out.println(sb);
  }
}
