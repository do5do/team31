package jchang._2024._03._0319;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 듣보잡_1764 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    Trie trie = new Trie();
    for (int i = 0; i < N; i++) {
      trie.insert(br.readLine());
    }

    List<String> notHearAndSee = new ArrayList<>();
    for (int i = 0; i < M; i++) {
      String notSee = br.readLine();
      if (trie.search(notSee)) {
        notHearAndSee.add(notSee);
      }
    }

    Collections.sort(notHearAndSee);
    System.out.println(notHearAndSee.size());
    for (String s: notHearAndSee) {
      System.out.println(s);
    }
  }

  static class Node {
    Map<Character, Node> childNode = new HashMap<>();
    boolean endOfWord;
  }

  static class Trie{

    Node rootNode = new Node();

    void insert(String str) {
      Node node = this.rootNode;

      for (int i = 0; i < str.length(); i++) {
        node = node.childNode.computeIfAbsent(str.charAt(i), key -> new Node());
      }
      node.endOfWord = true;
    }

    boolean search(String str) {
      Node node = this.rootNode;

      for (int i = 0; i < str.length(); i++) {
        node = node.childNode.getOrDefault(str.charAt(i), null);
        if (node == null) {
          return false;
        }
      }
      return node.endOfWord;

    }
  }
}
