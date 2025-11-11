import java.io.*;
import java.util.*;
public class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean arrive;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arrive = false;
        A = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
            visited[i] = false;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }
        // 노드마다 dfs 실행
        for (int i = 0; i < N; i++) {
            DFS(i, 1); // 노드, depth
            if (arrive) {
                break;
            }
        }
        if (arrive) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void DFS(int now, int depth) {
        if (depth == 5) {
            arrive = true;
            return;
        }
        visited[now] = true;
        for (int i : A[now]) {
            if (!visited[i]) {
                DFS(i, depth + 1);
            }
        }
        visited[now] = false;
    }
}