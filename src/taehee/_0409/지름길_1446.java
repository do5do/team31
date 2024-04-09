package taehee._0409;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 지름길_1446 {

  static int N, D;

  static List<Node> branch = new ArrayList<>();

  static int drived = 0;

  static int minDrived = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());

    N = Integer.parseInt(tokenizer.nextToken());
    D = Integer.parseInt(tokenizer.nextToken());

    for (int i = 0; i < N; i++) {
      tokenizer = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(tokenizer.nextToken());
      int end = Integer.parseInt(tokenizer.nextToken());
      int distance = Integer.parseInt(tokenizer.nextToken());
      branch.add(new Node(start, end, distance));
    }
    Collections.sort(branch);

    dfs(0, 0);
    System.out.println(minDrived);
  }

  static void dfs(int pos, int idx) {
    if (pos == D || drived > minDrived) {
      minDrived = Math.min(drived, minDrived);
      return;
    }

    for (int i = idx; i < branch.size(); i++) {
      Node node = branch.get(i);
      if (node.start < pos || node.end > D) {
        continue;
      }

      int moved = node.start - pos + node.distance;
      int tmp = drived;
      drived += moved;
      dfs(node.end, i + 1);
      drived = tmp;
    }

    // 마지막 지름길 까지 탐색하고 그래도 거리가 남으면 그냥 이동..
    if (pos < D) {
      drived += (D - pos);
      minDrived = Math.min(drived, minDrived);
    }
  }

  static class Node implements Comparable<Node> {

    int start;
    int end;
    int distance;

    public Node(int start, int end, int distance) {
      this.start = start;
      this.end = end;
      this.distance = distance;
    }

    private final static Comparator<Node> nodeComparator = Comparator.comparingInt(
            (Node n) -> n.start)
        .thenComparingInt(n -> n.end)
        .thenComparingInt(n -> n.distance);

    @Override
    public int compareTo(Node o) {
      return nodeComparator.compare(this, o);
    }
  }
}

//  0   10   9(9)

// 0
// 20   60  45(10 + 45)
// 50   70  15(40 + 15)o
// 80  190 100
// 140 160  14 (70 + 14)
// 160 180  14 ( 14)
// 420 901   5(x)
// 450 900   0(o) 70

// 반례
// 2 20
// 0 10 5
// 2 7 3
// ans: 15
// me: 18

// 예제1) 5가지의 지름길이 있고, 가야하는 거리가 150까지 가야함..
//    5 150

//    0 50 10
//    0 50 20(x)
//    50 100 10(o)

// 이동한 거리는 20이고, 현재 위치는 100

// 20 + 50 = 70

//    100 151 10(x)

//    10만큼은 가야하니까 30이동했고..
//    110 140 90