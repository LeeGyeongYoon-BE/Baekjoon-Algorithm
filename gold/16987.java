import java.io.*;
import java.util.*;

public class Main {
    static class Egg {
        int durability;
        int weight;

        Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        } // constructor
    } // Egg

    static int N;
    static Egg[] eggs;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(d, w);
        } // for

        dfs(0);
        System.out.println(max);
    } // main

    static void dfs(int target) {
        if (target == N) {
            int broken = 0;
            for (Egg egg : eggs) {
                if (egg.durability <= 0) broken++;
            } // for
            max = Math.max(max, broken);
            return;
        } // if

        if (eggs[target].durability <= 0) { // 깨진 계란이면 넘어감
            dfs(target + 1);
            return;
        } // if

        boolean hit = false;
        for (int i = 0; i < N; i++) {
            if (i == target || eggs[i].durability <= 0) continue;

            // 서로 부딪힘
            eggs[target].durability -= eggs[i].weight;
            eggs[i].durability -= eggs[target].weight;

            dfs(target + 1);

            // 백트래킹: 원래 상태로 복원
            eggs[target].durability += eggs[i].weight;
            eggs[i].durability += eggs[target].weight;

            hit = true;
        } // for

        // 다른 계란을 치지 못하는 경우
        if (!hit) dfs(target + 1);
    } // dfs
} // class
