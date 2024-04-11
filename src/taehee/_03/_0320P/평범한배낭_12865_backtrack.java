package taehee._03._0320P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 평범한배낭_12865_backtrack {

  static int N, K;
  static Item[] items;
  static boolean[] visited;
  static int maxValue = 0;
  static int bagWeight = 0;
  static int bagValue = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());

    N = Integer.parseInt(tokenizer.nextToken());
    K = Integer.parseInt(tokenizer.nextToken());
    items = new Item[N];
    visited = new boolean[N];

    for (int i = 0; i < N; i++) {
      tokenizer = new StringTokenizer(br.readLine());
      items[i] = new Item(Integer.parseInt(tokenizer.nextToken()),
          Integer.parseInt(tokenizer.nextToken()));
    }

    Arrays.sort(items);

    combination(0);

    System.out.println(maxValue);
  }

  static void combination(int cur) {
    if (bagWeight > K) {
      System.out.println("ret");
      return;
    }

    for (int i = cur; i < items.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        Item item = items[i];
        bagWeight += item.W;
        bagValue += item.V;
        combination(cur + 1);
        bagWeight -= item.W;
        bagValue -= item.V;
        maxValue = Math.max(maxValue, bagValue);
        visited[i] = false;
      }
    }

  }

  static class Item implements Comparable<Item> {

    int W;
    int V;

    Item(int w, int v) {
      this.W = w;
      this.V = v;
    }

    @Override
    public int compareTo(Item o) {
      int compare = Integer.compare(W, o.W);
      if (compare == 0) {
        return Integer.compare(V, o.W);
      }
      return compare;
    }
  }
}
