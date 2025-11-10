// 백준 12101번 - 1, 2, 3 더하기 2
// https://www.acmicpc.net/problem/12101
// 알고리즘 분류: 백트래킹(DFS)
// 풀이 아이디어:
// - DFS로 1,2,3의 조합을 만들어서 합이 N이 되는 경우 탐색
// - k번째 수열만 출력하도록 카운트 관리


import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dfs(0, "");  // 초기 합 0, 빈 문자열

        if (list.size() < k) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(k - 1)); // k번째(1-indexed)
        } // if ~ else

        br.close();
    } // main

    static void dfs(int sum, String expr) {
        if (sum > n) return;
        if (sum == n) {
            list.add(expr);
            return;
        } // if

        for (int i = 1; i <= 3; i++) {
            if (expr.equals("")) {
                dfs(sum + i, expr + i);
            } else {
                dfs(sum + i, expr + "+" + i);
            } // if ~ else
        } // for
    } // dfs
} // class
