import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 도시 개수
        int M = Integer.parseInt(br.readLine()); // 버스 개수

        final int INF = 10000001; // 충분히 큰 값 (버스 최대 비용 * 도시 개수 이상)

        int[][] dist = new int[N + 1][N + 1];

        // 초기화
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        } // for

        // 간선 입력
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = Math.min(dist[a][b], c); // 여러 간선 있을 경우 최소 비용 선택
        } // for

        // 플로이드-워셜
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    } // if
                } // for - j
            } // for - i
        } // for - k

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] == INF) sb.append("0 ");
                else sb.append(dist[i][j]).append(" ");
            } // for - j
            sb.append("\n");
        } // for - i

        System.out.print(sb);
        br.close();
    } // main
} // class
