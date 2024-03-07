package taehee._0307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 올림픽_8979 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(tokenizer.nextToken());
    int K = Integer.parseInt(tokenizer.nextToken());

    List<Board> boards = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      tokenizer = new StringTokenizer(br.readLine());
      int country = Integer.parseInt(tokenizer.nextToken());
      int gold = Integer.parseInt(tokenizer.nextToken());
      int silver = Integer.parseInt(tokenizer.nextToken());
      int bronze = Integer.parseInt(tokenizer.nextToken());
      boards.add(new Board(country, gold, silver, bronze));
    }

    Collections.sort(boards);

    boards.get(0).rank = 1;
    Board kboard = boards.get(0);

    for (int i = 1; i < boards.size(); i++) {
      Board board = boards.get(i);
      Board prevBoard = boards.get(i - 1);

      if (board.compareTo(prevBoard) != 0) {
        // 이 부분이 문제
        // 이해한 내용은 중간에 비는 순위 없이 가는 줄 알았는데
        // 공동 순위 수 만큼 중간 순위가 비기 때문에 i+1로 순위를 매김
        board.rank = i + 1;
      } else {
        board.rank = prevBoard.rank;
      }

      if (board.country == K) {
        kboard = board;
        break;
      }
    }

    System.out.println(kboard.rank);
  }

  static class Board implements Comparable<Board> {

    private final int country;
    private final int gold;
    private final int silver;
    private final int bronze;
    private int rank;

    public Board(int country, int gold, int silver, int bronze) {
      this.country = country;
      this.gold = gold;
      this.silver = silver;
      this.bronze = bronze;
    }

    @Override
    public String toString() {
      return String.format("country=%d, gold=%d, silver=%d, bronze=%d", country, gold,
          silver, bronze);
    }

    @Override
    public int compareTo(Board o) {
      // 내림 차순 정렬
      if (this.gold == o.gold) {
        if (this.silver == o.silver) {
          return o.bronze - this.bronze;
        } else {
          return o.silver - this.silver;
        }
      } else {
        return o.gold - this.gold;
      }
    }
  }
}
