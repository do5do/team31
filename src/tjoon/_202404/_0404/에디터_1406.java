package tjoon._202404._0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class 에디터_1406 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    Stack<String> left = new Stack<>();
    Deque<String> right = new LinkedList<>();

    for (int i = 0; i < str.length(); i++) {
      left.push(String.valueOf(str.charAt(i)));
    }

    int opCnt = Integer.parseInt(br.readLine());

    for (int i = 0; i < opCnt; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      while (st.hasMoreTokens()) {
        String op = st.nextToken();
        if (op.equals("L")) {
          if (!left.isEmpty()) {
            right.offerFirst(left.pop());
          }
        } else if (op.equals("D")) {
          if (!right.isEmpty()) {
            left.push(right.pop());
          }
        } else if (op.equals("B")) {
          if (!left.isEmpty()) {
            left.pop();
          }
        } else if (op.equals("P")) {
          String ch = st.nextToken();
          left.push(ch);
        }
      }

    }

    System.out.println(String.join("", left) + String.join("", right));

  }

}
