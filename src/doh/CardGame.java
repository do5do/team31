package doh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

/**
 * 2621 카드게임
 */
public class CardGame {
    static List<Card> cards = new ArrayList<>();
    static Map<String, Integer> colorMap = new HashMap<>();
    static Map<Integer, Integer> numMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cards.add(new Card(st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        // 숫자 기준으로 정렬
        Collections.sort(cards);

        // 개수 세기
        for (Card card : cards) {
            colorMap.put(card.color, colorMap.getOrDefault(card.color, 0) + 1);
            numMap.put(card.num, numMap.getOrDefault(card.num, 0) + 1);
        }

        int score = 0;
        int maxNum = cards.get(4).num;
        int[] sameTwo = new int[2];

        // 1. 모두 같은색 && 연속된 수
        if (colorMap.containsValue(5) && isSequence()) {
            score = maxNum + 900;
        }
        // 2. 4장의 수가 같을 때
        else if (numMap.containsValue(4)) {
            score = getKeyByValue(4) + 800;
        }
        // 3. 3장의 수가 같고, 나머지 2장의 수가 같을 때
        else if (numMap.containsValue(3) && numMap.containsValue(2)) {
            score = getKeyByValue(3) * 10 + getKeyByValue(2) + 700;
        }
        // 4. 5장이 모두 같은 색
        else if (colorMap.containsValue(5)) {
            score = maxNum + 600;
        }
        // 5. 5장의 수가 연속적일 때
        else if (isSequence()) {
            score = maxNum + 500;
        }
        // 6. 3장의 수가 같을 때
        else if (numMap.containsValue(3)) {
            score = getKeyByValue(3) + 400;
        }
        // 7. 2장의 수가 같고, 또 다른 2장의 수가 같을 때
        else if (isSameTwo(sameTwo)) {
            score = sameTwo[0] * 10 + sameTwo[1] + 300;
        }
        // 8. 2장의 수가 같을 때
        else if (numMap.containsValue(2)) {
            score = getKeyByValue(2) + 200;
        }
        // 9. 나머지
        else {
            score = maxNum + 100;
        }

        System.out.println(score);
    }

    private static boolean isSameTwo(int[] sameTwo) {
        int num1 = 0;
        int num2 = 0;
        for (Entry<Integer, Integer> entry : numMap.entrySet()) {
            if (entry.getValue() == 2) {
                if (num1 == 0) {
                    num1 = entry.getKey();
                } else {
                    num2 = entry.getKey();
                }
            }
        }

        if (num1 <= num2) {
            sameTwo[0] = num2;
            sameTwo[1] = num1;
        } else {
            sameTwo[0] = num1;
            sameTwo[1] = num2;
        }
        return num1 != 0 && num2 != 0;
    }

    private static int getKeyByValue(int value) {
        int num = 0;
        for (Entry<Integer, Integer> entry : numMap.entrySet()) {
            if (entry.getValue() == value) {
                num = entry.getKey();
                break;
            }
        }
        return num;
    }

    private static boolean isSequence() {
        for (int i = 0; i < 4; i++) {
            if (cards.get(i).num + 1 != cards.get(i + 1).num) {
                return false;
            }
        }
        return true;
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
            return Integer.compare(num, o.num);
        }
    }
}
