package jchang._0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스위치켜고끄기_1244 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    boolean[] switches = new boolean[N + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N ; i++) {
      int n = Integer.parseInt(st.nextToken());
      switches[i] = n == 1;
    }

    int numOfStudent = Integer.parseInt(br.readLine());
    Node[] students = new Node[numOfStudent];
    for (int i = 0; i < numOfStudent; i++) {
      st = new StringTokenizer(br.readLine());
      int gender = Integer.parseInt(st.nextToken());
      int number = Integer.parseInt(st.nextToken());
      students[i] = new Node(gender, number);
    }

    for (Node node : students) {
      if (node.gender == 1) {
        for (int i = node.number; i < switches.length; i += node.number) {
          switches[i] = !switches[i];
        }
      } else {
        int mid = node.number;
        int left = mid - 1;
        int right = mid + 1;
        while (left > 0 && right < switches.length) {
          if (switches[left] != switches[right]) {
            break;
          } else {
            left--;
            right++;
          }
        }

        for (int i = left + 1; i < right; i++) {
          switches[i] = !switches[i];
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < switches.length; i++) {
      if (switches[i]) {
        sb.append("1 ");
      } else {
        sb.append("0 ");
      }
      if (i % 20 == 0) {
        System.out.println(sb.toString().trim());
        sb = new StringBuilder();
      }
    }
    System.out.print(sb.toString().trim());
  }

  static class Node {
    int gender, number;
    public Node(int gender, int number) {
      this.gender = gender;
      this.number = number;
    }
  }
}
