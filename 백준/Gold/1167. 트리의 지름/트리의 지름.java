import java.io.*;
import java.util.*;
public class Main {
    static class edge {
        int E;
        int V;

        edge(int E, int V) {
            this.E = E;
            this.V = V;
        }
    }

    static List<edge>[] A;
    static boolean[] visited;
    static int[] dist;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        A = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            while (true) {
                int S = Integer.parseInt(st.nextToken());
                if (S == -1) {
                    break;
                }
                int E = Integer.parseInt(st.nextToken());
                A[V].add(new edge(S, E));
            }
        }

        // 1차 BFS : 아무 노드 (1번)에서 가장 먼 노드 구하기
        int startNode = bfs(1);

        // 2차 BFS : 위에서 찾은 노드에서 다시 가장 먼 거리 계산
        bfs(startNode);

        Arrays.sort(dist);
        System.out.println(dist[N]);
    }

    private static int bfs(int start) {
        visited = new boolean[N+1];
        dist = new int[N+1];
        Arrays.fill(visited, false);
        Arrays.fill(dist, 0);
        Queue<Integer> myqueue = new LinkedList<>();

        visited[start] = true;
        myqueue.offer(start);

        while (!myqueue.isEmpty()) {
            int current = myqueue.poll();

            for (edge next : A[current]) {
                if (!visited[next.E]) {
                    visited[next.E] = true;
                    dist[next.E] = dist[current] + next.V;
                    myqueue.offer(next.E);
                }
            }
        }
        int maxIdx = 1;
        for (int i = 2; i <= N; i++) {
            if (dist[i] > dist[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}