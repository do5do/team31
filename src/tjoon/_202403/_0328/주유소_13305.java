package tjoon._202403._0328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주유소_13305 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine()); // 도시 개수
    int[] needOil = new int[N - 1];
    int[] cost = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < needOil.length; i++) {
      needOil[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < cost.length; i++) {
      cost[i] = Integer.parseInt(st.nextToken());
    }

    long sum = ((long) cost[0]) * needOil[0];
    int curCity = cost[0];
    for (int i = 1; i < N - 1; i++) {
      if (cost[i] < curCity) {
        curCity = cost[i];
      }
      sum += ((long) curCity) * needOil[i];
    }

    System.out.println(sum);

  }
}