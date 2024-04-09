package tjoon._202403._0321;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ZOAC4_23971 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int H = Integer.parseInt(st.nextToken());
    int W = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int width = 1;
    int height = 1;
    for (int i = 0; i < W; i += (M + 1)) {
      if (i + M + 1 < W) {
        width++;
      }
    }

    for (int i = 0; i < H; i += (N + 1)) {
      if (i + N + 1 < H) {
        height++;
      }
    }

    System.out.println(width * height);

  }

}
