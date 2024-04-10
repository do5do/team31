package jchang._2024._04._0410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class 회전초밥_2531 {
  static Map<Integer, Integer> map;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      int dish = Integer.parseInt(br.readLine());
      q.add(dish);
    }

    int count = 0;

    List<Integer> eat = new ArrayList<>();
    map = new HashMap<>();
    int max = 0;
    while (count <= n + k) {
      count++;
      int cur = q.poll();
      eat.add(cur);
      map.put(cur, map.getOrDefault(cur, 0) + 1);

      if (count >= k) {
        eat.add(c);
        map.put(c, map.getOrDefault(cur, 0) + 1);
        max = Math.max(map.size(), max);
        eat.remove(k);
        deleteMapElement(c);
        int temp = eat.get(0);
        eat.remove(0);
        deleteMapElement(temp);
      }

      q.add(cur);
    }

    System.out.println(max);
  }

  private static void deleteMapElement(int c) {
    if (map.get(c) == 1) {
      map.remove(c);
    } else {
      map.put(c, map.get(c) - 1);
    }
  }
}
