package tjoon._202403._0306;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class 카드게임_2621 {

  static List<Card> cardList = new ArrayList<>();
  static Map<String, Integer> colorMap = new HashMap<>();
  static Map<Integer, Integer> numMap = new HashMap<>();

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    for (int i = 0; i < 5; i++) {
      String color = scanner.next();
      int num = scanner.nextInt();

      cardList.add(new Card(color, num));
    }

    Collections.sort(cardList);

    for (Card card : cardList) {
      colorMap.put(card.color, colorMap.getOrDefault(card.color, 0) + 1);
      numMap.put(card.num, numMap.getOrDefault(card.num, 0) + 1);
    }

    int point = 0;

    // 1. 5개 색 같음, 5개 연속된 수 -> 제일 높은 수 +900
    if (isSameColor() && isExistsContinuous()) {
      point = cardList.get(cardList.size() - 1).num + 900;
    }
    // 2. 4개 숫자 같음 -> 같은수 +800
    else if (isSameNum(4)) {
      point = getNumFromMap(4) + 800;
    }
    // 3. 3개 숫자 같음, 나머지 2개 숫자 같음 -> 3장숫자 x10 + 나머지 2장숫자 +700
    else if (isSameNum(3) && isSameNum(2)) {
      point = getNumFromMap(3) * 10 + getNumFromMap(2) + 700;
    }
    // 4. 5개 색 같음 -> 제일 높은 수 +600
    else if (isSameColor()) {
      point = cardList.get(cardList.size() - 1).num + 600;
    }
    // 5. 5개 연속된 수 -> 제일 높은 수 +500
    else if (isExistsContinuous()) {
      point = cardList.get(cardList.size() - 1).num + 500;
    }
    // 6. 3개 숫자 같음 -> 3장숫자 +400
    else if (isSameNum(3)) {
      point = getNumFromMap(3) + 400;
    }
    // 7. 숫자 2개, 2개 같음 -> 큰 숫자 x10 + 작은 숫자 + 300
    else if (isSameTwice()) {
      point = getPointSameTwice();
    }
    // 8. 2개 숫자 같음 -> 같은 숫자 + 500
    else if (isSameNum(2)) {
      point = getNumFromMap(2) + 200;
    }
    // 9. 가장 큰 수 + 100
    else {
      point = cardList.get(cardList.size() - 1).num + 100;
    }

    System.out.println(point);

  }

  // is 연속된 수
  private static boolean isExistsContinuous() {
    for (int i = 0; i < 4; i++) {
      if (cardList.get(i).num + 1 != cardList.get(i + 1).num) {
        return false;
      }
    }

    return true;
  }

  // is 같은 수
  private static boolean isSameNum(int num) {
    return numMap.containsValue(num);
  }

  // is 같은 색 개수 5개
  private static boolean isSameColor() {
    return colorMap.containsValue(5);
  }

  // get 같은 수
  private static int getNumFromMap(int num) {

    for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
      if (entry.getValue() == num) {
        return entry.getKey();
      }
    }

    return 0;
  }

  // 같은수가 2번이 2개
  private static boolean isSameTwice() {

    int count = 0;

    for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
      if (entry.getValue() == 2) {
        count++;
      }
    }

    return count == 2;
  }
  private static int getPointSameTwice() {

    List<Integer> twoList = new ArrayList<>();

    for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
      if (entry.getValue() == 2) {
        twoList.add(entry.getKey());
      }
    }

    int max = Math.max(twoList.get(0), twoList.get(1));
    int min = Math.min(twoList.get(0), twoList.get(1));

    return max * 10 + min + 300;
  }

  static class Card implements Comparable<Card> {

    String color;
    int num;

    Card(String color, int num) {
      this.color = color;
      this.num = num;
    }

    @Override
    public int compareTo(Card o) {
      return Integer.compare(this.num, o.num);
    }
  }

}
