package tjoon._0319;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 회의실배정_1931 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    List<Meeting> meetings = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      meetings.add(new Meeting(a, b));
    }

    Collections.sort(meetings);

    int count = 0;
    int curTime = 0;
    for (int i = 0; i < n; i++) {
      if (meetings.get(i).start >= curTime) {
        count++;
        curTime = meetings.get(i).end;
      }
    }

    System.out.println(count);
  }

  static class Meeting implements Comparable<Meeting> {

    int start;
    int end;

    Meeting(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
      int c = Integer.compare(this.end, o.end);
      if (c == 0) {
        c = Integer.compare(this.start, o.start);
      }

      return c;
    }
  }

}
