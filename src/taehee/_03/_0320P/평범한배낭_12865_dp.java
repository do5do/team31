package taehee._03._0320P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭_12865_dp {

  static int N, K;
  static Item[] items;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());

    N = Integer.parseInt(tokenizer.nextToken());
    K = Integer.parseInt(tokenizer.nextToken());
    items = new Item[N];
    dp = new int[101][100_001];

    for (int i = 0; i < N; i++) {
      tokenizer = new StringTokenizer(br.readLine());
      items[i] = new Item(Integer.parseInt(tokenizer.nextToken()),
          Integer.parseInt(tokenizer.nextToken()));
    }

    for (int i = 1; i < 101; i++) {

    }
  }

  static class Item {

    int W;
    int V;

    Item(int w, int v) {
      this.W = w;
      this.V = v;
    }
  }
}
