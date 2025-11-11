import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 도시 개수

        int[][] dist = new int[N + 1][N + 1];

        // 간선 입력
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++){
                dist[i][j] = Integer.parseInt(st.nextToken());
            } // for - j
        } // for - i

        // 플로이드-워셜
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][k] == 1 && dist[k][j] == 1) {
                        dist[i][j] = 1;
                    } // if
                } // for - j
            } // for - i
        } // for - k

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sb.append(dist[i][j]).append(" ");
            } // for - j
            sb.append("\n");
        } // for - i

        System.out.print(sb);
        br.close();
    } // main
} // class
