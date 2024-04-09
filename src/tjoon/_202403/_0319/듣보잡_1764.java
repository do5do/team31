package tjoon._202403._0319;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class 듣보잡_1764 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int hear = Integer.parseInt(st.nextToken());
    int see = Integer.parseInt(st.nextToken());
    Map<String, Integer> map = new HashMap<>();

    for (int i = 0; i < hear; i++) {
      String s = br.readLine();
      map.put(s, 1);
    }

    for (int i = 0; i < see; i++) {
      String s = br.readLine();
      map.put(s, map.getOrDefault(s, 0) + 1);
    }

    int count = 0;
    List<String> list = new ArrayList<>();
    for (Entry<String, Integer> entry : map.entrySet()) {
      if (entry.getValue() > 1) {
        count++;
        list.add(entry.getKey());
      }
    }

    Collections.sort(list);
    System.out.println(count);
    for (String s : list) {
      System.out.println(s);
    }

  }

}
