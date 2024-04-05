package jchang._2024._04._0402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class KCPC_3758 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken()); // 팀의 개수
      int k = Integer.parseInt(st.nextToken()); // 문제 개수
      int t = Integer.parseInt(st.nextToken()); // 팀 ID
      int m = Integer.parseInt(st.nextToken()); // 로그 엔트리 개수

      Map<Integer, Node> map = new HashMap<>();
      for (int j = 0; j < m; j++) {
        st = new StringTokenizer(br.readLine());
        int id = Integer.parseInt(st.nextToken());
        int problem = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());

        Node node = map.getOrDefault(id, new Node());
        node.team = id;
        node.submit++;
        node.score.put(problem, Math.max(node.score.getOrDefault(problem, 0), score));
        node.lastSubmit = j;

        map.put(id, node);
      }

      List<Node> list = new ArrayList<>(map.values());
      Collections.sort(list);

      int rank = 0;
      for (Node node : list) {
        rank++;
        if (node.team == t) {
          sb.append(rank).append("\n");
        }
      }
    }

    System.out.println(sb);
  }

  static class Node implements Comparable<Node>{
    int team, submit, lastSubmit;
    Map<Integer, Integer> score = new HashMap<>();
    public Node() {
    }

    @Override
    public int compareTo(Node o) {
      int total1 = this.score.values().stream().reduce(0, Integer::sum);
      int total2 = o.score.values().stream().reduce(0, Integer::sum);
      if (total1 == total2) {
        if (this.submit == o.submit) {
          return this.lastSubmit - o.lastSubmit;
        }
        return this.submit - o.submit;
      }
      return total2 - total1;
    }
  }
}
