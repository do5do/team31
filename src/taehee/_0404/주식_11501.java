package taehee._0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 주식_11501 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      int N = Integer.parseInt(br.readLine());
      long[] days = new long[N];
      List<Integer> peakIndexes = new LinkedList<>();
      String[] lines = br.readLine().split(" ");
      int maxIndex = 0;
      for (int j = 0; j < lines.length; j++) {
        days[j] = Long.parseLong(lines[j]);

        // 피크 인덱스만 모으기..
        // 워스트 케이스의 경우 n^으로 시간초과 예상..
        if (peakIndexes.isEmpty()) {
          peakIndexes.add(j);
        } else {
          if (days[j] >= days[maxIndex]) {
            while (true) {
              if (peakIndexes.remove(peakIndexes.size() - 1) == maxIndex) {
                peakIndexes.add(maxIndex = j);
                break;
              }
            }
          } else {
            int last = peakIndexes.get(peakIndexes.size() - 1);

            if (days[last] > days[j]) {
              peakIndexes.add(j);
            } else if (days[last] < days[j]) {
              peakIndexes.remove(peakIndexes.size() - 1);
              peakIndexes.add(j);
            }
          }
        }
      }

      long profit = 0;
      Queue<Integer> queue = (Queue<Integer>) peakIndexes;
      for (int j = 0; j < days.length; j++) {
        if (queue.isEmpty()) {
          break;
        }
        if (j < queue.peek()) {
          profit += (days[queue.peek()] - days[j]);
        } else {
          queue.poll();
        }
      }
      sb.append(profit).append("\n");
    }
    System.out.println(sb);
  }
}

//      long profit = 0;
//      List<Integer> account = new LinkedList<>();
//      for (int j = 0; j < N; j++) {
//        int today = days[j];
//
//        for (int k = j + 1; k < N; k++) {
//          days[k]
//        }
//
//        int tomorrow = (j < N - 1) ? days[j + 1] : 0;
//
//        // 다음날이 증가인지 확인하기..
//        // 증가거나, 같으면 산다..
//        if (tomorrow >= today) {
//          account.add(today);
//        } else {
//          // 가지고 있으면 판다.
//          if (!account.isEmpty()) {
//            profit += account.stream()
//                .mapToLong(Long::valueOf)
//                .reduce(0, (a, b) -> a + today - b);
//            account.clear();
//          }
//        }
//      }
//      sb.append(profit).append("\n");
//    }

//1
//    8
//    1 1 5 1 4 1 3 4

// 4 + 4 + 3 + 3 + 1
// 8 + 6 + 1