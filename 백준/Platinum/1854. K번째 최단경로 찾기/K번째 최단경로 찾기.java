import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        } // Node

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight; // 최소 힙 (다익스트라용)
        } // compareTo
    } // class - Node

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 도시 개수
        int M = Integer.parseInt(st.nextToken()); // 도로 개수
        int K = Integer.parseInt(st.nextToken()); // K번째 최단경로

        List<Node>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        } // for

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        } // for

        // 각 노드별로 K개까지 최단 경로 비용 저장하는 우선순위 큐 (최대 힙)
        PriorityQueue<Integer>[] dist = new PriorityQueue[N + 1];
        for (int i = 1; i <= N; i++) {
            dist[i] = new PriorityQueue<>(K, Collections.reverseOrder());
        } // for

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0)); // 시작점 = 1번 도시
        dist[1].offer(0);

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int to = cur.vertex;
            int cost = cur.weight;

            for (Node next : graph[to]) {
                int newCost = cost + next.weight;

                if (dist[next.vertex].size() < K) {
                    dist[next.vertex].offer(newCost);
                    pq.offer(new Node(next.vertex, newCost));
                } else if (dist[next.vertex].peek() > newCost) {
                    dist[next.vertex].poll();
                    dist[next.vertex].offer(newCost);
                    pq.offer(new Node(next.vertex, newCost));
                } // if ~ else if
            } // for
        } // while

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (dist[i].size() == K) sb.append(dist[i].peek()).append("\n");
            else sb.append(-1).append("\n");
        } // for
        System.out.print(sb);
    } // main
} // class
