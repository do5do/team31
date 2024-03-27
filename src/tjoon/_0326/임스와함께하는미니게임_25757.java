package tjoon._0326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class 임스와함께하는미니게임_25757 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    String game = st.nextToken();
    int full = 0;
    Set<String> already = new HashSet<>();
    List<String> curMember = new ArrayList<>();

    already.add(" ");

    switch (game) {
      case "Y":
        full = 1;
        break;
      case "F":
        full = 2;
        break;
      case "O":
        full = 3;
        break;
    }

    int count = 0;
    for (int i = 0; i < N; i++) {
      String user = br.readLine();
      if (!already.contains(user)) {
        already.add(user);
        curMember.add(user);

        if (curMember.size() == full) {
          count++;
          curMember.clear();
        }

      }
    }

    System.out.println(count);
  }

}
