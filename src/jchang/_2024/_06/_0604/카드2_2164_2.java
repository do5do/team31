package jchang._2024._06._0604;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 카드2_2164_2 {
  // 1번 카드 제일 위, N번 카드 제일 아래
  // 1. 제일 위 카드 버림
  // 2. 그 다음 카드를 제일 아래로 옮김
  // 마지막 한장 남은 카드는?  --> 뭔가 순환되는 느낌이므로 Queue 쓰면 될듯
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    // Q에 카드를 순서대로 넣어놓자
    Queue<Integer> q = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      q.offer(i);
    }

    // 1장 남을때까지 규칙 반복
    while (q.size() > 1) {
      q.poll();
      int top = q.poll();
      q.add(top);
    }

    System.out.println(q.poll());
  }
}
