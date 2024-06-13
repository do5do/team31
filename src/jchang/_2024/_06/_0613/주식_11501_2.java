package jchang._2024._06._0613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 주식_11501_2 {
  // 매일 하는 아래 행동 중 하나를 함
  // 1. 주식 하나 산다
  // 2. 원하는 만큼 가지고 있는 주식을 판다
  // 3. 아무것도 안 한다
  // 최대 이익 계산(답은 부호있는 64bit 정수형으로 표현)
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      solve(br);
    }

    System.out.println(sb);
  }

  public static class Node{
    int price, idx;
    public Node(int price, int idx) {
      this.price = price;
      this.idx = idx;
    }
  }

  private static void solve(BufferedReader br) throws IOException {
    int n = Integer.parseInt(br.readLine());

    int[] prices = new int[n];
    Node[] nodes = new Node[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      prices[i] = Integer.parseInt(st.nextToken());
      nodes[i] = new Node(prices[i], i);
    }

    Arrays.sort(nodes, new Comparator<Node>() {
      @Override
      public int compare(Node o1, Node o2) {
        return Integer.compare(o2.price, o1.price);
      }
    });

    int maxIdx = 0;
    long result = 0;
    for (int i = 0; i < n; i++) {
      if (prices[i] < nodes[maxIdx].price) {
        result += nodes[maxIdx].price - prices[i];
      } else if (prices[i] == nodes[maxIdx].price) {
        for (int j = maxIdx + 1; j < nodes.length; j++) {
          if (nodes[j].idx > i) {
            maxIdx = j;
            break;
          }
        }
      }
    }

    sb.append(result).append("\n");
  }
}
