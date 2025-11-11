import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int from, to, cost;
        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        } // Edge
    } // class - Edge

    static int N, M, start, end;
    static List<Edge> edges = new ArrayList<>();
    static long[] dist;
    static long[] money;
    static boolean[] reachable;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시 개수
        start = Integer.parseInt(st.nextToken()); // 시작 도시
        end = Integer.parseInt(st.nextToken());   // 도착 도시
        M = Integer.parseInt(st.nextToken());     // 교통수단 개수

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, w));
        } // for

        money = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            money[i] = Long.parseLong(st.nextToken()); // 각 도시에서 벌 수 있는 돈
        } // for

        dist = new long[N];
        Arrays.fill(dist, Long.MIN_VALUE);
        dist[start] = money[start];

        // 벨만-포드: N-1번 반복
        for (int i = 0; i < N - 1; i++) {
            for (Edge e : edges) {
                if (dist[e.from] == Long.MIN_VALUE) continue;
                if (dist[e.to] < dist[e.from] - e.cost + money[e.to]) {
                    dist[e.to] = dist[e.from] - e.cost + money[e.to];
                } // if
            } // for - edge
        } // for - i

        // 사이클 체크
        boolean[] cycle = new boolean[N];
        for (int i = 0; i < N; i++) {
            for (Edge e : edges) {
                if (dist[e.from] == Long.MIN_VALUE) continue;
                if (dist[e.to] < dist[e.from] - e.cost + money[e.to]) {
                    dist[e.to] = Long.MAX_VALUE; // 무한대 처리
                    cycle[e.to] = true;
                } // if
                if (cycle[e.from]) cycle[e.to] = true;
            } // for - edge
        } // for - i

        if (dist[end] == Long.MIN_VALUE) {
            System.out.println("gg"); // 도달 불가
        } else if (cycle[end]) {
            System.out.println("Gee"); // 무한대 수익
        } else {
            System.out.println(dist[end]);
        } // if ~ else
    } // main
} // class
