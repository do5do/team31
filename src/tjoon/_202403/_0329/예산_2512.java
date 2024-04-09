package tjoon._202403._0329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 예산_2512 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] budgets = new int[N];
    long sum = 0;
    int maxValue = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      budgets[i] = Integer.parseInt(st.nextToken());
      sum += budgets[i];
      maxValue = Math.max(maxValue, budgets[i]);
    }

    int goal = Integer.parseInt(br.readLine());

    if (sum <= goal) {
      System.out.println(maxValue);
      System.exit(0);
    }

    int left = 1;
    int right = maxValue;
    int result = 0;
    while (left < right) {
      int mid = left + (right - left) / 2;

      sum = 0;

      for (int i = 0; i < N; i++) {
        if (budgets[i] <= mid) {
          sum += budgets[i];
        } else {
          sum += mid;
        }
      }

      if (sum <= goal) {
        result = Math.max(result, mid);
        left = mid + 1;
      } else {
        right = mid;
      }

    }

    System.out.println(result);


  }

}
