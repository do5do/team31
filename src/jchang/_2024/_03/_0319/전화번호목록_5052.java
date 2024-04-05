package jchang._2024._03._0319;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 전화번호목록_5052 {

  static int t;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    t = Integer.parseInt(br.readLine());
    String[] result = new String[t];

    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      boolean flag = false;
      String[] strings = new String[n];
      Trie trie = new Trie();
      for (int j = 0; j < n; j++) {
        String str = br.readLine();
        trie.insert(str);
        strings[j] = str;
      }

      for (int j = 0; j < strings.length; j++) {
        String str = strings[j];
        if (trie.contains(str) && !flag) {
          flag = true;
          break;
        } else {
          trie.insert(str);
        }
      }

      if (flag) {
        result[i] = "NO";
      } else {
        result[i] = "YES";
      }
    }

    for (String res : result) {
      System.out.println(res);
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

    boolean contains(String str) {
      Node node = this.rootNode;

      for (int i = 0; i < str.length(); i++) {
        node = node.childNode.getOrDefault(str.charAt(i), null);
        if (node == null) {
          return false;
        }
      }

      if (node.endOfWord) {
        return !node.childNode.isEmpty();
      }
      // 911
      // 91122
      return false;
    }
  }

}
