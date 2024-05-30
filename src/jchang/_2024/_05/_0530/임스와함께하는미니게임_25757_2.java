package jchang._2024._05._0530;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class 임스와함께하는미니게임_25757_2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    Map<String, Integer> map = new HashMap<>();
    map.put("Y", 1);
    map.put("F", 2);
    map.put("O", 3);

    int n = Integer.parseInt(st.nextToken());
    String gameType = st.nextToken();

    Set<String> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      set.add(br.readLine());
    }

    System.out.println(set.size() / map.get(gameType));
  }
}
