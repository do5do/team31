package taehee._0306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 카드게임_2621 {

  public static void main(String[] args) throws IOException {
    List<Card> cardList = new ArrayList<>(5);

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for (int i = 0; i < 5; i++) {
      StringTokenizer tokenizer = new StringTokenizer(br.readLine());
      cardList.add(
          new Card(tokenizer.nextToken(),
              Integer.parseInt(tokenizer.nextToken()))
      );
    }

    // 정렬
    cardList.sort(Comparator.comparingInt(c -> c.number));

    int point = 0;
    Map<String, Integer> colorMap = new HashMap<>();
    Map<Integer, Integer> numMap = new HashMap<>();

    for (Card card : cardList) {
      colorMap.put(card.color, colorMap.getOrDefault(card.color, 0) + 1);
      numMap.put(card.number, numMap.getOrDefault(card.number, 0) + 1);
    }

    if (isRule1(cardList)) {
      int maxNum = cardList.stream().max(Comparator.comparingInt(c -> c.number))
          .get().number;
      point = 900 + maxNum;
    } else if (isRule2(numMap)) {
      int numCount4 = getNumberByCount(numMap, 4);
      point = 800 + numCount4;
    } else if (isRule3(numMap)) {
      int numCount3 = getNumberByCount(numMap, 3);
      int numCount2 = getNumberByCount(numMap, 2);
      point = numCount3 * 10 + numCount2 + 700;
    } else if (isRule4(colorMap)) {
      int max = cardList.stream().max(Comparator.comparingInt(c -> c.number))
          .get().number;
      point = 600 + max;
    } else if (isRule5(cardList)) {
      int max = cardList.stream().max(Comparator.comparingInt(c -> c.number))
          .get().number;
      point = 500 + max;
    } else if (isRule6(numMap)) {
      int numCount3 = getNumberByCount(numMap, 3);
      point = 400 + numCount3;
    } else if (isRule7(numMap)) {
      int[] nums = getNumbersByCount(numMap, 2);
      int max = Math.max(nums[0], nums[1]);
      int min = Math.min(nums[0], nums[1]);
      point = max * 10 + min + 300;
    } else if (isRule8(numMap)) {
      int numCount2 = getNumberByCount(numMap, 2);
      point = 200 + numCount2;
    } else {
      int max = cardList.stream().max(Comparator.comparingInt(c -> c.number))
          .get().number;
      point = 100 + max;
    }

    System.out.println(point);
  }


  static int getNumberByCount(Map<Integer, Integer> numMap, int count) {
    return numMap.entrySet().stream().filter(e -> e.getValue() == count)
        .map(Map.Entry::getKey).findFirst().get();
  }

  static int[] getNumbersByCount(Map<Integer, Integer> numMap, int count) {
    return numMap.entrySet().stream().filter(e -> e.getValue() == count)
        .map(Map.Entry::getKey).collect(Collectors.toList()).stream().mapToInt(i -> i)
        .toArray();
  }

  static boolean isAllSameColor(List<Card> cardList) {
    return cardList.stream().allMatch(card -> card.color.equals(cardList.get(0).color));
  }

  static boolean isAllSequential(List<Card> cardList) {
    int diff = 0;

    for (int i = 1; i < cardList.size(); i++) {
      diff = cardList.get(i).number - cardList.get(i - 1).number;

      if (diff != 1) {
        return false;
      }
    }

    return true;
  }

  static boolean isRule1(List<Card> cardList) {
    return isAllSameColor(cardList) && isAllSequential(cardList);
  }

  static boolean isRule2(Map<Integer, Integer> numMap) {
    return numMap.containsValue(4);
  }

  static boolean isRule3(Map<Integer, Integer> numMap) {
    return numMap.containsValue(3) && numMap.containsValue(2);
  }

  static boolean isRule4(Map<String, Integer> colorMap) {
    return colorMap.containsValue(5);
  }

  static boolean isRule5(List<Card> cardList) {
    return isAllSequential(cardList);
  }

  static boolean isRule6(Map<Integer, Integer> numMap) {
    return numMap.containsValue(3);
  }

  static boolean isRule7(Map<Integer, Integer> numMap) {
    return numMap.values().stream().filter(v -> v == 2).count() == 2;
  }

  static boolean isRule8(Map<Integer, Integer> numMap) {
    return numMap.values().stream().filter(v -> v == 2).count() == 1;
  }

  static class Card {

    int number;
    String color;

    public Card(String color, int number) {
      this.number = number;
      this.color = color;
    }

    @Override
    public String toString() {
      return "Card [color=" + color + ", number=" + number + "]";
    }
  }
}
