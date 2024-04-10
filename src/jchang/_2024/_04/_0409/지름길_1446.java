package jchang._2024._04._0409;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 지름길_1446 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());

    int[] road = new int[10001];
    Arrays.fill(road, Integer.MAX_VALUE);
    ArrayList<Node>[] shortCut = new ArrayList[d + 1];
    for (int i = 0; i < shortCut.length; i++) {
      shortCut[i] = new ArrayList<>();
    }

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int distance = Integer.parseInt(st.nextToken());

      if (end - start > distance && end <= d) {
        shortCut[end].add(new Node(start, end, distance));
      }

    }

    road[0] = 0;
    for (int i = 1; i < shortCut.length; i++) {
      if (!shortCut[i].isEmpty()) {
        for (Node node : shortCut[i]) {
          road[i] = Math.min(road[i], road[i - 1] + 1);
          road[i] = Math.min(road[node.start] + node.distance, road[i]);
        }
        continue;
      }
      road[i] = road[i - 1] + 1;
    }
    System.out.println(road[d]);
  }

  static class Node{
    int start, end, distance;
    public Node(int start, int end, int distance) {
      this.start = start;
      this.end = end;
      this.distance = distance;
    }
  }
}
