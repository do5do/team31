package tjoon._0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class IF문좀대신써줘_19637 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 칭호 개수
    int M = Integer.parseInt(st.nextToken()); // 캐릭 개수
    StringBuilder sb = new StringBuilder();

    List<Power> powerList = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      powerList.add(new Power(st.nextToken(), Integer.parseInt(st.nextToken())));
    }

    for (int i = 0; i < M; i++) {
      int value = Integer.parseInt(br.readLine());

      int left = 0;
      int right = powerList.size() - 1;

      int mid = 0;
      while (left < right) {
        mid = (left + right) / 2;

        if (value <= powerList.get(mid).amount) {
          right = mid;
        } else if (value > powerList.get(mid).amount) {
          left = mid + 1;
        }
      }

      sb.append(powerList.get(left).name).append("\n");
    }

    System.out.println(sb);


  }

  static class Power {

    String name;
    int amount;

    Power(String name, int amount) {
      this.name = name;
      this.amount = amount;
    }
  }

}
