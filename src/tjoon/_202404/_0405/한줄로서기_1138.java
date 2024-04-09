package tjoon._202404._0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 한줄로서기_1138 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] answer = new int[N];
    for (int i = 1; i < N + 1; i++) {
      int cur = Integer.parseInt(st.nextToken());

      for (int j = 0; j < N; j++) {
        if (cur == 0 && answer[j] == 0) {
          answer[j] = i;
          break;
        }

        if (answer[j] == 0) {
          cur--;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      sb.append(answer[i]).append(" ");
    }

    System.out.println(sb);

  }

}
