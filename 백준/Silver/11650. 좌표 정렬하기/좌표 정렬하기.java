import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(matrix, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]); // x 같으면 y 비교
            }
            return Integer.compare(a[0], b[0]); // x 기준 정렬
        });

        for (int[] matrix1 : matrix) {
            System.out.println(matrix1[0] + " " + matrix1[1]);
        }
    }
}
