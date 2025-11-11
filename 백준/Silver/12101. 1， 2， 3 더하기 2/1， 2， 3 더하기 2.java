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
        }

        br.close();
    }

    static void dfs(int sum, String expr) {
        if (sum > n) return;
        if (sum == n) {
            list.add(expr);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (expr.equals("")) {
                dfs(sum + i, expr + i);
            } else {
                dfs(sum + i, expr + "+" + i);
            }
        }
    }
}
