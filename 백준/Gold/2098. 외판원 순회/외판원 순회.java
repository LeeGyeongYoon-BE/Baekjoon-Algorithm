import java.io.*;
import java.util.*;

public class Main {
    static int N;                  // 도시의 개수
    static int[][] W;              // 도시 간 비용을 저장하는 배열
    static int[][] dp;             // dp[현재 도시][방문 상태 비트마스크]
    static final int INF = 1_000_000_000; // 매우 큰 값(경로가 없을 경우)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        W = new int[N][N];
        dp = new int[N][1 << N];   // 도시 N개 → 가능한 방문 조합은 2^N가지

        // 비용 행렬 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            } // for - j
        } // for - i

        // dp 배열을 -1로 초기화 (아직 계산되지 않은 상태)
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        } // for

        // 0번 도시에서 출발한다고 가정
        System.out.println(dfs(0, 1)); // 1은 0번 도시를 방문한 상태 (비트마스크 0001)
        br.close();
    } // main

    // 현재 도시(cur)와 방문 상태(visited)를 기반으로 최소 비용을 구하는 재귀 함수
    static int dfs(int cur, int visited) {
        // 모든 도시를 방문한 경우
        if (visited == (1 << N) - 1) { // 비트마스크가 111...1 (모든 도시 방문)
            // 출발지로 돌아가는 길이 있으면 그 비용 반환, 없으면 매우 큰 값 반환
            if (W[cur][0] == 0) return INF;
            return W[cur][0];
        } // if

        // 이미 계산된 적 있는 상태라면 바로 반환 (메모이제이션)
        if (dp[cur][visited] != -1) return dp[cur][visited];

        dp[cur][visited] = INF; // 초기값을 매우 큰 값으로 설정

        // 모든 도시를 탐색하면서 아직 방문하지 않은 도시로 이동 시도
        for (int next = 0; next < N; next++) {
            // 갈 수 없는 도시이거나 이미 방문한 도시는 스킵
            if (W[cur][next] == 0 || (visited & (1 << next)) != 0) continue;

            // 다음 도시로 이동 시의 총 비용 계산
            int nextCost = W[cur][next] + dfs(next, visited | (1 << next));
            dp[cur][visited] = Math.min(dp[cur][visited], nextCost);
        } // for

        return dp[cur][visited];
    } // dfs
} // class
