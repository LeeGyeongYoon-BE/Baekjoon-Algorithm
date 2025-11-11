import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] indegree = new int[N + 1];          // 진입차수
        int[] time = new int[N + 1];              // 건물 시간
        int[] result = new int[N + 1];            // 최종 건설 시간
        List<Integer>[] adj = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int pre = Integer.parseInt(st.nextToken());
                if (pre == -1) break;
                adj[pre].add(i);
                indegree[i]++;
            } // while
        } // for

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                result[i] = time[i];
            } // if
        } // for

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : adj[now]) {
                indegree[next]--;
                result[next] = Math.max(result[next], result[now] + time[next]);
                if (indegree[next] == 0) {
                    q.offer(next);
                } // if
            } // for
        } // while

        for (int i = 1; i <= N; i++) {
            System.out.println(result[i]);
        } // for

        br.close();
    } // main
} // class
