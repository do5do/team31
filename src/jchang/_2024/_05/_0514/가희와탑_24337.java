package jchang._2024._05._0514;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 가희와탑_24337 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    Deque<Integer> dq = new LinkedList<>();
    for (int i = 1; i <= a - 1; i++) {
      dq.offerLast(i);
    }
    dq.offerLast(Math.max(a, b));
    // 10 1 3
    // 3 1 1 1 1 2 1

    for (int i = b - 1; i >= 1; i--) {
      dq.offerLast(i);
    }

    if (dq.size() > n) {
      System.out.println(-1);
      return;
    }

    if (dq.getFirst() != 1) {
      int temp = dq.pollFirst();
      while (dq.size() < n - 1) {
        dq.addFirst(1);
      }
      dq.addFirst(temp);
    } else {
      while (dq.size() < n) {
        dq.addFirst(1);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (Integer num : dq) {
      sb.append(num).append(" ");
    }
    System.out.println(sb);
  }
}
