package tjoon._202404._0402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class KCPC_3758 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    int n, k, id, m;

    for (int t = 0; t < T; t++) {

      // start code
      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
      id = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());

      Tester[] testers = new Tester[n];
      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        int testerNum = Integer.parseInt(st.nextToken());
        int questNum = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());

        if (testers[testerNum - 1] == null) {
          testers[testerNum - 1] = new Tester(testerNum);
          testers[testerNum - 1].scoreMap.put(questNum, 0);
        }

        testers[testerNum - 1].scoreMap.put(questNum,
            Math.max(testers[testerNum - 1].scoreMap.getOrDefault(questNum, 0), score));
        testers[testerNum - 1].submitCnt++;
        testers[testerNum - 1].lastTime = i;
      }

      for (int i = 0; i < n; i++) {
        for (Entry<Integer, Integer> entry : testers[i].scoreMap.entrySet()) {
          testers[i].total += entry.getValue();
        }
      }

      Arrays.sort(testers);

      for (int i = 0; i < n; i++) {
        if (testers[i].id == id) {
          sb.append(i + 1).append("\n");
        }
      }
    }

    System.out.println(sb);

  }

  static class Tester implements Comparable<Tester> {

    int id;
    int lastTime = 0;
    Map<Integer, Integer> scoreMap;
    int total = 0;
    int submitCnt = 0;

    Tester(int id) {
      this.id = id;
      this.scoreMap = new HashMap<>();
    }

    @Override
    public int compareTo(Tester o) {
      int result = Integer.compare(o.total, this.total);
      if (result == 0) {
        result = Integer.compare(this.submitCnt, o.submitCnt);
        if (result == 0) {
          result = Integer.compare(this.lastTime, o.lastTime);
        }
      }

      return result;
    }
  }

}
