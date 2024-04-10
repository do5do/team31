package taehee._03._0315;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 멀티탭스케줄링_1700 {

  static int N, K;

  static Set<Integer> used = new HashSet<>();

  static int[] devices;

  static int[] arr;

  static int count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());

    N = Integer.parseInt(tokenizer.nextToken());
    K = Integer.parseInt(tokenizer.nextToken());
    arr = new int[K];
    devices = new int[K + 1];

    tokenizer = new StringTokenizer(br.readLine());
    for (int i = 0; i < K; i++) {
      int num = Integer.parseInt(tokenizer.nextToken());
      arr[i] = num;
      devices[num]++;
    }

    for (int i = 0; i < arr.length; i++) {
      int num = arr[i];
      if (used.size() == N) {
        if (!used.contains(arr[i])) {
          int candidate = getCandidate(i);
          used.remove(candidate);
          devices[candidate]--;
          count++;
        }

      } else {
        used.add(num);
        devices[num]--;
      }
    }

    System.out.println(count);
  }

  static int getCandidate(int pos) {

    // 더 이상 사용 안하는 가전
    for (Integer using : used) {
      if (devices[using] == 0) {
        return using;
      }
    }

    // 가장 늦게 나오는 것
    for (int i = arr.length - 1; i >= pos + 1; i--) {
      for (Integer using : used) {
        if (arr[i] == using) {
          return using;
        }
      }
    }

    return used.stream().findFirst().get();
  }

}
