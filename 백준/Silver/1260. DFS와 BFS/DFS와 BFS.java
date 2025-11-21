import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        } // for

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        } // for

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        } // for

        dfs(V);
        sb.append("\n");

        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
        br.close();
    } // main

    private static void dfs(int v) {
        visited[v] = true;
        sb.append(v).append(" ");
        for (int i : graph[v]) {
            if (!visited[i]) {
                dfs(i);
            } // if
        } // for
    } // dfs

    private static void bfs(int v) {
        visited[v] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        while (!q.isEmpty()) {
            int u = q.poll();
            sb.append(u).append(" ");
            for (int i : graph[u]) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                } // if
            } // for
        } // while
    } // bfs
} // class
