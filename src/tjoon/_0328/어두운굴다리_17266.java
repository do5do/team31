package tjoon._0328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 어두운굴다리_17266 {

  static int[] location;
  static int N, M;

  public static void main(String[] args) throws NumberFormatException, IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    location = new int[M];
    for (int i = 0; i < M; i++) {
      location[i] = Integer.parseInt(st.nextToken());
    }

    int start = 1;
    int end = N;
    int result = 0;
    while (start <= end) {
      int mid = (start + end) / 2;

      if (check(mid)) {
        result = mid;
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    System.out.println(result);
  }

  static boolean check(int height) {
    int prev = 0;
    for (int i = 0; i < M; i++) {
      if (location[i] - height <= prev) {
        prev = location[i] + height;
      } else {
        return false;
      }
    }

    return N - prev <= 0;
  }

}
