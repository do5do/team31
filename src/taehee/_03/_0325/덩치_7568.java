package taehee._03._0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 덩치_7568 {

  static int N;
  static Body[] bodies;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    bodies = new Body[N];
    for (int i = 0; i < N; i++) {
      StringTokenizer tokenizer = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(tokenizer.nextToken());
      int y = Integer.parseInt(tokenizer.nextToken());
      bodies[i] = new Body(x, y);
    }

    // IllegalArgumentException 발생
//    Arrays.sort(bodies, Comparator.reverseOrder());
//
//    int rank = 1;
//    int same = 0;
//    for (int i = 0; i < N; i++) {
//      Body cur = bodies[i];
//      Body pre = (i > 0) ? bodies[i - 1] : null;
//
//      if (pre != null) {
//        if (pre.compareTo(cur) == 0) {
//          same++;
//        } else {
//          same = 0;
//        }
//      }
//
//      cur.rank = rank - same;
//      rank++;
//    }
//
//    Arrays.sort(bodies, Comparator.comparingInt((Body b) -> b.idx));
//
//    for(Body body : bodies) {
//      sb.append(body.rank).append(" ");
//    }
//    System.out.println(sb);

    for (int i = 0; i < N; i++) {
      Body cur = bodies[i];
      int rank = 1;

      for (int j = 0; j < N; j++) {
        if (i == j) {
          continue;
        }
        Body comp = bodies[j];

        if (cur.compareTo(comp) < 0) {
          rank++;
        }
      }
      sb.append(rank).append(" ");
    }

    System.out.println(sb);
  }

  static class Body implements Comparable<Body> {

    int weight;
    int height;

    Body(int w, int h) {
      this.weight = w;
      this.height = h;
    }

    @Override
    public int compareTo(Body o) {
      int weightComp = Integer.compare(weight, o.weight);
      int heightComp = Integer.compare(height, o.height);
      if (weightComp < 0 && heightComp < 0) {
        return -1;
      } else if (weightComp > 0 && heightComp > 0) {
        return 1;
      }
      return 0;
    }
  }
}

//5
//    15 15
//    14 12
//    13 14
//    10 15
//    10 20
//    1 2 2 2 2

//3
//    55 185
//    65 183
//    58 190

//6
//    20 50  1
//    19 49  2
//    18 48  3
//    50 20  1
//    49 19  2
//    48 18  3