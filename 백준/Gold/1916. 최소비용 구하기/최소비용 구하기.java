import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int vertex;
        int weight;

        Node(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        } // Node

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        } // compareTo
    } // class - Node

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine()); // 도시 개수
        int E = Integer.parseInt(br.readLine()); // 버스 개수

        List<Node>[] graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        } // for

        for (int i = 1; i <= E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        } // for

        int[] distance = new int[V + 1];
        boolean[] visited = new boolean[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); // 시작 노드
        int end = Integer.parseInt(st.nextToken()); // 도착 노드
        distance[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int c_v = current.vertex;

            if (visited[c_v]) continue;
            visited[c_v] = true;

            for (Node next : graph[c_v]) {
                if (distance[next.vertex] > distance[c_v] + next.weight) {
                    distance[next.vertex] = distance[c_v] + next.weight;
                    pq.offer(new Node(next.vertex, distance[next.vertex]));
                } // if
            } // for
        } // while

        System.out.println(distance[end]);

        br.close();
    } // main
} // class
