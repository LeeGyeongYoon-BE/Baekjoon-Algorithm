import java.io.*;
import java.util.*;

class Main
{
    static int N, M;
    static int count = 0;
    static ArrayList<Integer>[] com;
    static boolean[] visited;

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        com = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            com[i] = new ArrayList<Integer>();
            visited[i] = false;
        } // for

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            com[s].add(e);
            com[e].add(s);
        } // for

        DFS(1);

        System.out.println(count);

        br.close();
    } // main

    private static void DFS(int i) {
        if (visited[i]) return;

        visited[i] = true;
        for (int k : com[i]) {
            if (!visited[k]) {
                count++;
                DFS(k);
            } // if
        } // if

    } // DFS
} // class