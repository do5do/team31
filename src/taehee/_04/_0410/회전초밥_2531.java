package taehee._04._0410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class 회전초밥_2531 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(tokenizer.nextToken()); // 접시 수
    int d = Integer.parseInt(tokenizer.nextToken()); // 초밥 가짓수
    int k = Integer.parseInt(tokenizer.nextToken()); // 연속해서 먹는 접시 수
    int c = Integer.parseInt(tokenizer.nextToken()); // 쿠폰 번호

    Dish start = null;
    Dish cur = null;
    for (int i = 0; i < N; i++) {
      int sushi = Integer.parseInt(br.readLine());

      if (start == null) {
        start = new Dish(sushi, true);
        cur = start;
      } else {
        Dish prev = cur;
        cur = new Dish(sushi, false);
        cur.prev = prev;
        prev.next = cur;
      }

      if (i == N - 1) {
        cur.next = start;
        start.prev = cur;
      }
    }

    Map<Integer, Integer> sushiMap = new HashMap<>(); // 초밥 가지 수
    Queue<Dish> queue = new LinkedList<>(); // 먹은 초밥 접시
    cur = start;
    int max = 0;
    do {
      if (queue.size() < k) {
        int value = sushiMap.getOrDefault(cur.sushi, 0) + 1;
        sushiMap.put(cur.sushi, value);
        queue.offer(cur);
        cur = cur.next;
      } else {
        Dish poll = queue.poll();
        int value = sushiMap.get(poll.sushi) - 1;
        if (value != 0) {
          sushiMap.put(poll.sushi, value);
        } else {
          sushiMap.remove(poll.sushi);
        }
      }

//      if ((cur.next.sushi == c  && !sushiMap.containsKey(c)) ||
//          (!queue.isEmpty() && queue.peek().prev.sushi == c && !sushiMap.containsKey(c))
//          || !sushiMap.containsKey(c)) {
//        max = Math.max(sushiMap.size() + 1, max);
//      } else {
        max = Math.max(sushiMap.size(), max);
//      }
    } while (cur != start.next);

    System.out.println(max);
  }

  static class Dish {

    int sushi;
    boolean start;
    Dish prev;
    Dish next;

    Dish(int sushi, boolean start) {
      this.sushi = sushi;
      this.start = start;
    }
  }
}
