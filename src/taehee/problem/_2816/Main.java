package taehee.problem._2816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

  final static String KBS1 = "KBS1";
  final static String KBS2 = "KBS2";

  static List<Integer> commands = new ArrayList<>();
  static List<String> channels = new ArrayList<>();
  static int pos = 0;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      channels.add(br.readLine());
    }

    while (true) {
      String firstChannel = channels.get(0);
      String secondChannel = channels.get(1);

      if (firstChannel.equals(KBS1) && secondChannel.equals(KBS2)) {
        break;
      }

      // KBS1이 0 인덱스에 오는 것을 제일 먼저 수행해야함
      if (!firstChannel.equals(KBS1)) {
        int kbs1Pos = channels.indexOf(KBS1);
        if (pos < kbs1Pos) {
          swapDown();
        } else if (pos > kbs1Pos) {
          moveToUp(false);
        } else {
          swapUp();
        }
      } else {
        int kbs2Pos = channels.indexOf(KBS2);
        if (pos < kbs2Pos) {
          swapDown();
        } else if (pos > kbs2Pos) {
          moveToUp(false);
        } else {
          swapUp();
        }
      }

      // KBS1에 설정이 완료되면 다음 POS로 이동함
      if (channels.get(0).equals(KBS1) && pos == 0) {
        moveToDown(false);
      }
    }

    commands.forEach(System.out::print);
    System.out.println();
  }

  static int moveToDown(boolean swap) {
    if (pos < channels.size() - 1) {
      pos++;
      if (!swap) {
        commands.add(1);
      }
    }

    return pos;
  }

  static int moveToUp(boolean swap) {
    if (pos > 0) {
      pos--;
      if (!swap) {
        commands.add(2);
      }
    }

    return pos;
  }

  static int swapDown() {
    int before = pos;
    int after = moveToDown(true);

    if (before != after) {
      swap(before, after);
      commands.add(3);
    }

    return after;
  }

  static int swapUp() {
    int before = pos;
    int after = moveToUp(true);

    if (before != after) {
      swap(before, after);
      commands.add(4);
    }

    return after;
  }

  static void swap(int a, int b) {
    String tmp = channels.get(a);
    channels.set(a, channels.get(b));
    channels.set(b, tmp);
  }
}
