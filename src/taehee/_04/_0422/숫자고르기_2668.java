package taehee._04._0422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.SortedSet;
import java.util.TreeSet;

public class 숫자고르기_2668 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Map<Integer, List<Integer>> map = new HashMap<>();

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());

      if (!map.containsKey(num)) {
        map.put(num, new ArrayList<>());
      }

      map.get(num).add(i + 1);
    }

    SortedSet<Integer> set = new TreeSet<>();

    for (int key : map.keySet()) {
      Queue<Integer> queue = new LinkedList<>();
      queue.offer(key);
      boolean[] visited = new boolean[N + 1];
      while (!queue.isEmpty()) {
        int num = queue.poll();
        if (!visited[num]) {
          visited[num] = true;
          if (map.containsKey(num)) {
            map.get(num).forEach(queue::offer);
          }
        } else if (num == key) {
          set.add(key);
          break;
        }
      }
    }

    System.out.println(set.size());
    set.forEach(System.out::println);
  }
}

// 1 2 3 4 5 6 7
// 3 1 1 5 5 4 6

// 1    3  4  5    6
// 2 3  1  6  4 5  7

//7
//    3
//    1
//    1
//    5
//    5
//    4
//    6