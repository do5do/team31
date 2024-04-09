package tjoon._202404._0408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 겹치는건싫어_20922 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] nums = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < nums.length; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    int p1 = 0;
    int p2 = 0;
    int max = 0;

    Map<Integer, Integer> map = new HashMap<>();
    while (p2 < n) {

      if (map.getOrDefault(nums[p2], 0) + 1 <= k) {
        map.put(nums[p2], map.getOrDefault(nums[p2], 0) + 1);
        p2++;
      } else {
        map.put(nums[p1], map.get(nums[p1]) - 1);
        p1++;
      }

      max = Math.max(max, p2 - p1);

    }

    System.out.println(max);
  }

}
