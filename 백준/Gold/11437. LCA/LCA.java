import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] tree;
    static int[] depth, parent;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        depth = new int[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        } // for

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        } // for

        BFS(1);

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int LCA = excuteLCA(a, b);
            System.out.println(LCA);
        } // for

        br.close();
    } // main

    private static int excuteLCA(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        } // if
        // depth 맞추기
        while (depth[a] != depth[b]) {
            a = parent[a];
        } // while
        // 같은 조상나올 때까지 두 노드 함께 한킨씩 올라가기
        while (a != b) {
            a = parent[a];
            b = parent[b];
        } // while
        return a;
    } // excuteLCA

    private static void BFS(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        int level = 1;
        int now_size = 1; // 현재 depth 크기
        int count = 0; // 현재 depth에서 몇 개 노드 처리했는지

        while (!q.isEmpty()) {
            int now_node = q.poll();
            for (int next : tree[now_node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    parent[next] = now_node; // 부모 노드 지정
                    depth[next] = level; // 노드 깊이 넣어주는 부분
                } // if
            } // for
            count++;
            if (count == now_size) {
                count = 0;
                now_size = q.size();
                level++;
            } // if
        } // while
    } // BFS
} // class
