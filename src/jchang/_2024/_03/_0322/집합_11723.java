package jchang._2024._03._0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 집합_11723 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int M = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    boolean[] set = new boolean[21];
    for (int i = 0; i < M; i++) {
      String str = br.readLine();
      String[] split = str.split(" ");
      int n;
      if (split[0].equals("add")) {
        n = Integer.parseInt(split[1]);
        set[n] = true;
      } else if (split[0].equals("remove")) {
        n = Integer.parseInt(split[1]);
        set[n] = false;
      } else if (split[0].equals("check")) {
        n = Integer.parseInt(split[1]);
        if (set[n]) {
          sb.append("1").append("\n");
        } else {
          sb.append("0").append("\n");
        }
      } else if (split[0].equals("toggle")) {
        n = Integer.parseInt(split[1]);
        set[n] = !set[n];
      } else if (split[0].equals("all")) {
        for (int j = 1; j <= 20; j++) {
          set[j] = true;
        }
      } else if (split[0].equals("empty")) {
        set = new boolean[21];
      }
    }

    System.out.println(sb);

//    Set<Integer> set = new HashSet<>();
//
//    for (int i = 0; i < M; i++) {
//      String str = br.readLine();
//      String[] split = str.split(" ");
//      int n;
//      if (str.startsWith("add")) {
//        n = Integer.parseInt(split[1]);
//        set.add(n);
//      } else if (str.startsWith("remove")) {
//        n = Integer.parseInt(split[1]);
//        set.remove(n);
//      } else if (str.startsWith("check")) {
//        n = Integer.parseInt(split[1]);
//        if (set.contains(n)) {
//          sb.append("1").append("\n");
//        } else {
//          sb.append("0").append("\n");
//        }
//      } else if (str.startsWith("toggle")) {
//        n = Integer.parseInt(split[1]);
//        if (!set.add(n)) {
//          set.remove(n);
//        }
//      } else if (str.startsWith("all")) {
//        for (int j = 1; j <= 20; j++) {
//          set.add(j);
//        }
//      } else if (str.startsWith("empty")) {
//        set.clear();
//      }
//    }
  }
}
