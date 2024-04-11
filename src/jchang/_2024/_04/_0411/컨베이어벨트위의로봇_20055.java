package jchang._2024._04._0411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 컨베이어벨트위의로봇_20055 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k  = Integer.parseInt(st.nextToken());

    int[] belt = new int[2 * n];
    boolean[] robot = new boolean[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 2 * n; i++) {
      belt[i] = Integer.parseInt(st.nextToken());
    }

    int zeroCount = 0;
    int stage = 0;
    while (zeroCount < k) {
      stage++;
      // 벨트 한 칸 회전
      int temp = belt[belt.length - 1];
      for (int i = belt.length - 1; i > 0; i--) {
        belt[i] = belt[i - 1];
      }
      belt[0] = temp;

      boolean tempRobot = robot[robot.length - 1];
      for (int i = robot.length - 1; i > 0; i--) {
        robot[i] = robot[i - 1];
      }
      robot[0] = tempRobot;
      robot[n - 1] = false;

      // 로봇 이동
      for (int i = robot.length - 1; i > 0; i--) {
        if (!robot[i] && robot[i - 1] && belt[i] > 0) {
          robot[i] = true;
          belt[i]--;
          robot[i - 1] = false;
        }
      }
      robot[n - 1] = false;

      // 로봇 올리기
      if (belt[0] > 0) {
        robot[0] = true;
        belt[0]--;
      }

      // 내구도 검사
      zeroCount = 0;
      for (int num : belt) {
        if (num <= 0) {
          zeroCount++;
        }
        if (zeroCount > k) {
          break;
        }
      }

    }

    System.out.println(stage);

  }



  // 성공했지만 성능이 너무 안 좋음
//  public static void main(String[] args) throws IOException {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine());
//
//    int n = Integer.parseInt(st.nextToken());
//    int k  = Integer.parseInt(st.nextToken());
//
//    LinkedList<Node> belt = new LinkedList<>();
//    st = new StringTokenizer(br.readLine());
//    for (int i = 0; i < 2 * n; i++) {
//      int a = Integer.parseInt(st.nextToken());
//      belt.add(new Node(a));
//    }
//
//    int zeroCount = 0;
//    List<Robot> robots = new ArrayList<>();
//    List<Robot> trash = new ArrayList<>();
//    int stage = 0;
//    while (zeroCount < k) {
//      stage++;
//      // 벨트 한칸 회전
//      belt.addFirst(belt.pollLast());
//      for (Robot robot: robots) {
//        robot.idx = robot.idx + 1;
//        if (robot.idx == n - 1) {
//          belt.get(n - 1).robotExist = false;
//          trash.add(robot);
//        }
//      }
//      robots.removeAll(trash);
//      trash.clear();
//
//      // 로봇 이동
//      for (Robot robot : robots) {
//        int toIdx = robot.idx + 1;
//        if (!belt.get(toIdx).robotExist && belt.get(toIdx).durability > 0) {
//          belt.get(toIdx).robotExist = true;
//          belt.get(toIdx).durability--;
//          belt.get(robot.idx).robotExist = false;
//          robot.idx = toIdx;
//          if (toIdx == n - 1) {
//            belt.get(toIdx).robotExist = false;
//            trash.add(robot);
//          }
//        }
//      }
//      robots.removeAll(trash);
//      trash.clear();
//
//      // 로봇 올리기
//      if (belt.get(0).durability > 0) {
//        belt.get(0).durability--;
//        belt.get(0).robotExist = true;
//        robots.add(new Robot(0));
//      }
//
//      // 내구도 0 체크
//      zeroCount = 0;
//      for (Node node : belt) {
//        if (node.durability <= 0) {
//          zeroCount++;
//        }
//      }
//    }
//
//    System.out.println(stage);
//  }
//
//  static class Node{
//    int durability;
//    boolean robotExist;
//    public Node(int durability) {
//      this.durability = durability;
//      this.robotExist = false;
//    }
//  }
//
//  static class Robot{
//    int idx;
//    public Robot(int idx) {
//      this.idx = idx;
//    }
//  }
}
