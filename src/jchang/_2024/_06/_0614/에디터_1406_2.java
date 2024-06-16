package jchang._2024._06._0614;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 에디터_1406_2 {
  // 영어 소문자만, 최대 600,000글자
  // L : 커서를 왼쪽으로 한칸 이동
  // D : 커서를 오른쪽으로 한칸 이동
  // B : 커서 왼쪽에 있는 문자 삭제
  // P $ : $라는 글자를 커서 왼쪽에 추가함
  // 초기 커서는 문장의 맨 뒤
  // 문자열 관련 문제는 가끔 stack을 사용할 때가 있었다.
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    // 커서 왼쪽 문자 기록용 스택
    Stack<Character> left = new Stack<>();
    // 커서 오른쪽 문자 보관용 스택
    Stack<Character> right = new Stack<>();

    // 받은 문자열을 전부 left에 입력(초기 커서는 문장의 맨 뒤이기 때문)
    for (int i = 0; i < str.length(); i++) {
      left.push(str.charAt(i));
    }

    int m = Integer.parseInt(br.readLine());
    for (int i = 0; i < m; i++) {
      String command = br.readLine();

      if (command.startsWith("L")) {
        // 커서 왼쪽 이동은 left에서 꺼내서 right에 넣음
        if (!left.isEmpty()) {
          right.push(left.pop());
        }
      } else if (command.startsWith("D")) {
        // 커서 오른쪽 이동은 right에서 꺼내서 left에 넣음
        if (!right.isEmpty()) {
          left.push(right.pop());
        }
      } else if (command.startsWith("B")) {
        // 커서 왼쪽 삭제는 left에서 하나 꺼내기
        if (!left.isEmpty()) {
          left.pop();
        }

      } else if (command.startsWith("P")) {
        // 커서 왼쪽 추가는 left에 추가할 문자 추가
        String[] input = command.split(" ");
        left.push(input[1].charAt(0));
      }
    }

    // 순서대로 출력 위해 일단 right에 전부 넣었다가 출력함
    while (!left.isEmpty()) {
      right.push(left.pop());
    }

    StringBuilder sb = new StringBuilder();
    while (!right.isEmpty()) {
      sb.append(right.pop());
    }
    System.out.println(sb);

  }
}
