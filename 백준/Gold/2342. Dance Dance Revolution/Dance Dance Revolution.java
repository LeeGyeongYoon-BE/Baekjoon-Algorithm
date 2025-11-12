import java.io.*;
import java.util.*;

public class Main {
    // 발판 이동 시 드는 비용을 계산하는 함수
    static int move(int from, int to) {
        // 같은 위치를 다시 누르면 1의 힘이 든다.
        if (from == to) return 1;
        // 처음 밟는 경우 (중앙에서 이동)에는 2의 힘이 든다.
        if (from == 0) return 2;
        // 반대편으로 이동할 경우 4의 힘이 든다. (예: 왼쪽->오른쪽)
        if (Math.abs(from - to) == 2) return 4;
        // 인접한 칸으로 이동할 경우 3의 힘이 든다. (예: 왼쪽->위쪽)
        return 3;
    } // move

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력된 발판 순서를 저장할 리스트
        List<Integer> list = new ArrayList<>();

        // 0이 나올 때까지 순서대로 저장 (0은 입력 종료를 의미)
        while (true) {
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            list.add(n);
        } // while

        int len = list.size();

        // dp[left][right] = 현재 왼발이 left, 오른발이 right일 때 최소 힘
        int[][] dp = new int[5][5];
        // 초기 상태는 매우 큰 값(최댓값)으로 설정
        for (int i = 0; i < 5; i++) {
            Arrays.fill(dp[i], 1000000000);
        } // for
        // 처음에는 양발이 모두 중앙(0)에 있는 상태
        dp[0][0] = 0;

        // 각 단계마다 발판을 밟으며 dp 갱신
        for (int num : list) {
            int[][] next = new int[5][5];
            for (int i = 0; i < 5; i++) {
                Arrays.fill(next[i], 1000000000);
            } // for

            // 가능한 모든 왼발, 오른발 상태에 대해 탐색
            for (int left = 0; left < 5; left++) {
                for (int right = 0; right < 5; right++) {
                    int cur = dp[left][right];
                    if (cur == 1000000000) continue;

                    // 왼발로 num을 밟는 경우
                    next[num][right] = Math.min(next[num][right], cur + move(left, num));

                    // 오른발로 num을 밟는 경우
                    next[left][num] = Math.min(next[left][num], cur + move(right, num));
                } // for - right
            } // for - left

            dp = next; // 이번 발판을 밟은 결과로 dp 갱신
        } // for - num

        int answer = Integer.MAX_VALUE;
        // 마지막에 남은 모든 경우 중 최소값을 찾음
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                answer = Math.min(answer, dp[i][j]);
            } // for - j
        } // for - i

        System.out.println(answer);
        br.close();
    } // main
} // class
