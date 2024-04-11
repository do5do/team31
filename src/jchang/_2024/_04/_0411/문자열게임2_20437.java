package jchang._2024._04._0411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 문자열게임2_20437 {
  // 문제 해석
  // 4. 어떤 문자를 정확히 K개를 포함하고, 문자열의 첫 번째와 마지막 글자가 해당 문자로 같은 가장 긴 연속 문자열의 길이를 구한다.
  // 위의 말은 중간에 문자가 K개를 넘어도 상관없단 뜻 (ex. k = 2인 경우 abbbbbbbbba는 통과)
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      solve(br);
    }
  }

  private static void solve(BufferedReader br) throws IOException {
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());
    Node[] alphabet = new Node[26];
    for (int i = 0; i < alphabet.length; i++) {
      alphabet[i] = new Node();
    }

    for (int i = 0; i < str.length(); i++) {
      int idx = str.charAt(i) - 'a';
      alphabet[idx].idxList.add(i);
    }

    int min = Integer.MAX_VALUE;
    int max = -1;
    for (Node node: alphabet) {
      int distance = 0;
      if (node.idxList.size() >= k) {
        for (int i = k - 1; i < node.idxList.size(); i++) {
          distance = node.idxList.get(i) - node.idxList.get(i - (k - 1));
          min = Math.min(distance, min);
          max = Math.max(distance, max);
        }
      }
    }

    if (min == Integer.MAX_VALUE || max == -1) {
      System.out.println(-1);
    } else {
      System.out.println((min + 1) + " " + (max + 1));
    }
  }

  static class Node{
    List<Integer> idxList = new ArrayList<>();
  }
}
