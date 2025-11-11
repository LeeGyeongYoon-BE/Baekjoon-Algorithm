import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] W;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            W[i] = Integer.parseInt(st.nextToken());
        } // for

        List<Integer> list = new ArrayList<>();
        for (int w : W) list.add(w);

        dfs(list, 0);
        System.out.println(max);
    } // main

    static void dfs(List<Integer> list, int energy) {
        if (list.size() == 2) {
            max = Math.max(max, energy);
            return;
        } // if

        // 첫 번째와 마지막 구슬은 제거할 수 없음
        for (int i = 1; i < list.size() - 1; i++) {
            int gain = list.get(i - 1) * list.get(i + 1);
            int removed = list.remove(i); // 구슬 제거
            dfs(list, energy + gain);
            list.add(i, removed); // 백트래킹: 원래 위치에 복원
        } // for
    } // dfs
} // class
