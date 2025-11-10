import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static char[] sign;
    static boolean[] visited = new boolean[10];
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        sign = new char[k];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            sign[i] = st.nextToken().charAt(0);
        }

        dfs(0, "");

        // 결과를 정렬해서 가장 작은 수와 큰 수 출력
        Collections.sort(result);
        System.out.println(result.get(result.size() - 1)); // 최대
        System.out.println(result.get(0)); // 최소

        br.close();
    }

    static void dfs(int depth, String num) {
        if (depth == k + 1) { // 숫자 k+1개 완성 시
            result.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (visited[i]) continue;

            if (depth == 0 || check(num.charAt(depth - 1) - '0', i, sign[depth - 1])) {
                visited[i] = true;
                dfs(depth + 1, num + i);
                visited[i] = false;
            }
        }
    }

    static boolean check(int a, int b, char op) {
        if (op == '<') return a < b;
        else return a > b;
    }
}
