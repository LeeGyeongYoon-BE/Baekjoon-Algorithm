import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            } // for - j
        } // for - i

        int year = 0;

        while (true) {
            int count = countIcebergs(); // 빙산 덩어리 개수

            if (count >= 2) {
                System.out.println(year);
                return;
            } // if

            if (count == 0) {
                System.out.println(0);
                return;
            } // if

            meltIce();
            year++;
        } // while
    } // main

    // 빙산 덩어리 수 계산
    static int countIcebergs() {
        visited = new boolean[N][M];
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    bfs(i, j);
                    count++;
                } // if
            } // for - j
        } // for - i
        return count;
    } // countIcebergs

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] <= 0) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            } // for
        } // while
    } // bfs

    // 빙산 녹이기
    static void meltIce() {
        int[][] melt = new int[N][M];

        // 1) 각 칸의 녹는 양 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    int sea = 0;

                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                        if (map[nx][ny] == 0) sea++;
                    } // for - d

                    melt[i][j] = sea;
                } // if
            } // for - j
        } // for - i

        // 2) 동시에 녹이기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = Math.max(0, map[i][j] - melt[i][j]);
            } // for - j
        } // for - i
    } // meltIce
} // class
