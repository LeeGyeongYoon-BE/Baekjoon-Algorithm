import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static ArrayList<Integer>[] graph;
    static int[] order;     // 방문 순서 저장
    static int cnt = 1;     // 방문 순서 카운트

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        order = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        } // for

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        } // for

        // 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        } // for

        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(order[i]).append("\n");
        } // for
        System.out.print(sb);
    } // main

    private static void dfs(int cur) {
        order[cur] = cnt++;  // 현재 정점 방문 순서 기록

        for (int next : graph[cur]) {
            if (order[next] == 0) {  // 아직 방문 안 했다면
                dfs(next);
            } // if
        } // for
    } // dfs
} // class
