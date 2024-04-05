package jchang._2024._03._0328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class 카드2_2164 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Deque<Integer> deque = new LinkedList<>();

    for (int i = 1; i <= N ; i++) {
      deque.add(i);
    }

    while (deque.size() > 1) {
      deque.pollFirst();
      deque.addLast(deque.pollFirst());
    }

    System.out.println(deque.peek());

  }
}
