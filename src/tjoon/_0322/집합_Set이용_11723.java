package tjoon._0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 집합_Set이용_11723 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int M = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    String op = "";
    int x = 0;

    Set<Integer> set = new HashSet<>();
    StringTokenizer st;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      op = st.nextToken();

      if (op.equals("all")) {
        for (int j = 0; j < 20; j++) {
          set.add(j + 1);
        }
      } else if (op.equals("empty")) {
        set.clear();
      } else {
        x = Integer.parseInt(st.nextToken());

        if (op.equals("add")) {
          set.add(x);
        } else if (op.equals("remove")) {
          set.remove(x);
        } else if (op.equals("check")) {
          if (set.contains(x)) {
            sb.append("1\n"); // System.out.println 으로 바로 출력하면 시간초과
          } else {
            sb.append("0\n");
          }
        } else if (op.equals("toggle")) {
          if (set.contains(x)) {
            set.remove(x);
          } else {
            set.add(x);
          }
        }
      }
    }

    System.out.println(sb);
  }

}
