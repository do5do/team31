package tjoon._202403._0318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 신입사원_1946 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {

      int N = Integer.parseInt(br.readLine());
      List<Applicant> applicants = new ArrayList<>();

      StringTokenizer st;
      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        applicants.add(new Applicant(a, b));
      }

      Collections.sort(applicants);

      int count = 1;
      int cur = applicants.get(0).interview;
      for (int i = 1; i < N; i++) {
        if (applicants.get(i).interview < cur) {
          cur = applicants.get(i).interview;
          count++;
        }
      }

      System.out.println(count);

    }
  }

  static class Applicant implements Comparable<Applicant> {

    int paper;
    int interview;

    Applicant(int paper, int interview) {
      this.paper = paper;
      this.interview = interview;
    }

    @Override
    public int compareTo(Applicant o) {
      return Integer.compare(this.paper, o.paper);
    }
  }

}
