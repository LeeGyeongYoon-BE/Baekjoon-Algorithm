import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        } // Edge

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w; // 가중치 오름차순
        } // compareTo
    } // class - Edge

    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    } // find

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;
        parent[b] = a;
        return true;
    } // union

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(u, v, w));
        } // for

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        } // for

        int result = 0;
        int count = 0;

        while (!pq.isEmpty() && count < V - 1) {
            Edge edge = pq.poll();

            if (union(edge.u, edge.v)) {
                result += edge.w;
                count++;
            } // if
        } // while

        System.out.println(result);
    } // main
} // class
