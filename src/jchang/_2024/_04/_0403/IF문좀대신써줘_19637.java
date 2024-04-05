package jchang._2024._04._0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IF문좀대신써줘_19637 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    String[] titles = new String[n];
    int[] limits = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      titles[i] = st.nextToken();
      limits[i] = Integer.parseInt(st.nextToken());
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      int candidate = 0;
      int stat = Integer.parseInt(br.readLine());
      int left = 0;
      int right = limits.length - 1;

      while (left <= right) {
        int mid = left + (right - left) / 2;
        if (stat <= limits[mid]) {
          candidate = mid;
          right = mid - 1;
        } else if (stat > limits[mid]) {
          left = mid + 1;
        }
      }

      sb.append(titles[candidate]).append("\n");
    }

    System.out.println(sb);

  }

    //2차 시도 실패
//    List<Node>[] digits = new List[11];
//    for (int i = 0; i < digits.length; i++) {
//      digits[i] = new ArrayList();
//    }
//
//    for (int i = 0; i < n; i++) {
//      st = new StringTokenizer(br.readLine());
//      String title = st.nextToken();
//      String limit = st.nextToken();
//      digits[limit.length()].add(new Node(title, limit));
//    }
//
//    StringBuilder sb = new StringBuilder();
//    for (int i = 0; i < m; i++) {
//      String stat = br.readLine();
//
//      loop:
//      for (int j = stat.length(); j <= digits.length; j++) {
//        if (digits[j].isEmpty()) {
//          continue;
//        }
//
//        for (Node node : digits[j]) {
//          int statNum = Integer.parseInt(stat);
//          int limitNum = Integer.parseInt(node.limit);
//          if (statNum <= limitNum) {
//            sb.append(node.title).append("\n");
//            break loop;
//          }
//        }
//      }
//    }
//    System.out.println(sb);
//  }
//
//  static class Node {
//    String title;
//    String limit;
//    public Node(String title, String limit) {
//      this.title = title;
//      this.limit = limit;
//    }
//  }

  // 1차 시도
//    String[] titles = new String[n];
//    int[] limits = new int[n];
//    for (int i = 0; i < n; i++) {
//      st = new StringTokenizer(br.readLine());
//      titles[i] = st.nextToken();
//      limits[i] = Integer.parseInt(st.nextToken());
//    }
//
//    StringBuilder sb = new StringBuilder();
//    for (int i = 0; i < m; i++) {
//      int stat = Integer.parseInt(br.readLine());
//      for (int j = 0; j < limits.length; j++) {
//        if (stat <= limits[j]) {
//          sb.append(titles[j]).append("\n");
//          break;
//        }
//      }
//    }
//
//    System.out.println(sb);
//  }
}
