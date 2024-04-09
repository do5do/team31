package tjoon._202403._0315;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 멀티탭스케줄링_1700 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int removeCount = 0;

    int[] plug = new int[K];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < K; i++) {
      plug[i] = Integer.parseInt(st.nextToken());
    }

    boolean[] usingTap = new boolean[101];
    int count = 0; // 채워진 콘센트 개수

    for (int i = 0; i < K; i++) {
      int temp = plug[i];

      if (!usingTap[temp]) {
        if (count < N) {
          usingTap[temp] = true;
          count++;

        } else {

          List<Integer> list = new ArrayList<>();

          for (int j = i + 1; j < K; j++) { // 현재기준으로 끝까지 다시 사용되는 스케쥴일때
            if (usingTap[plug[j]] && !list.contains(plug[j])) {
              list.add(plug[j]);
            }
          }

          if (list.size() < N) { // 나중에도 사용되는 콘센트가 구멍의 개수보다 작을 경우
            for (int j = 0; j < usingTap.length; j++) {
              if (usingTap[j] && !list.contains(j)) {
                usingTap[j] = false;
                break;
              }
            }
          } else { // 모든 콘센트가 나중에도 사용될 경우
            int last = list.get(list.size() - 1); // 가장 마지막에 사용될 콘센트 제거 (그리디)
            usingTap[last] = false;
          }

          usingTap[temp] = true;
          removeCount++;
        }
      }
    }

    System.out.println(removeCount);

  }

}
