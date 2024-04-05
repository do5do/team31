package tjoon._0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 창고다각형_2304 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] line = new int[1001];

    int max = 0;
    int maxIdx = 0;
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int idx = Integer.parseInt(st.nextToken());
      int height = Integer.parseInt(st.nextToken());

      line[idx] = height;

      if (height > max) {
        max = height;
        maxIdx = idx;
      }
    }

    int sum = 0;
    int curHeight = line[1];
    for (int i = 1; i < maxIdx; i++) {
      curHeight = Math.max(line[i], curHeight);
      sum += curHeight;
    }

    curHeight = line[1000];
    for (int i = 1000; i >= maxIdx; i--) {
      curHeight = Math.max(line[i], curHeight);
      sum += curHeight;
    }

    System.out.println(sum);


  }


}
