package taehee._0314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 일곱난쟁이_2309 {

  static int[] 난쟁이 = new int[9];
  static boolean[] visited = new boolean[9];
  static List<Integer> real = new ArrayList<>();
  static int sum = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for (int i = 0; i < 9; i++) {
      난쟁이[i] = Integer.parseInt(br.readLine());
    }

    dfs(0);
  }

  static void dfs(int cur) {
    if (real.size() == 7 && sum == 100) {
      Collections.sort(real);
      real.forEach(System.out::println);
      System.exit(0);
    }

    if (cur == 7) {
      return;
    }

    for (int i = 0; i < 9; i++) {
      if (!visited[i]) {
        visited[i] = true;
        real.add(난쟁이[i]);
        sum += 난쟁이[i];
        dfs(cur + 1);
        visited[i] = false;
        real.remove(real.size() - 1);
        sum -= 난쟁이[i];
      }
    }
  }
}
