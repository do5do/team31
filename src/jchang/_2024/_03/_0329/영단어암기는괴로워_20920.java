package jchang._2024._03._0329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class 영단어암기는괴로워_20920 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String word = br.readLine();
      if (word.length() < m) {
        continue;
      }
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    // 시간초과 2
    List<Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
    entryList.sort(new Comparator<Entry<String, Integer>>() {
      @Override
      public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
        if (o1.getValue() == o2.getValue()) {
          if (o1.getKey().length() == o2.getKey().length()) {
            return o1.getKey().compareTo(o2.getKey());
          }
          return o2.getKey().length() - o1.getKey().length();
        }
        return o2.getValue() - o1.getValue();
      }
    });

    StringBuilder sb = new StringBuilder();
    for (Entry<String, Integer> entry : entryList) {
      sb.append(entry.getKey()).append("\n");
    }
    System.out.println(sb);

    // 시간초과
//    Node[] array = new Node[map.size()];
//    int idx = 0;
//    for (String key : map.keySet()) {
//      Node node = new Node(key, map.get(key));
//      array[idx] = node;
//      idx++;
//    }
//
//    Arrays.sort(array);
//
//    StringBuilder sb = new StringBuilder();
//    for (Node node : array) {
//      sb.append(node.word).append("\n");
//    }
//    System.out.println(sb);

  }

//  static class Node implements Comparable<Node>{
//    String word;
//    int count;
//    public Node(String word, Integer count) {
//      this.word = word;
//      this.count = count;
//    }
//
//    @Override
//    public int compareTo(Node o) {
//      if (this.count == o.count) {
//        if (this.word.length() == o.word.length()){
//          return this.word.compareTo(o.word);
//        }
//        return o.word.length() - this.word.length();
//      }
//      return o.count - this.count;
//    }
//  }
}
