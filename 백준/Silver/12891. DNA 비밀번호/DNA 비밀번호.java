import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
    static int baseToIndex(char alp){
        if (alp == 'A') {
            return 0;
        } else if (alp == 'C') {
            return 1;
        } else if (alp == 'G') {
            return 2;
        } else if (alp == 'T') {
            return 3;
        }
        return -1;
    }

    static boolean isValid(int[] count, int[] minimumCount){
        for (int i = 0; i < count.length; i++) {
            if (count[i] < minimumCount[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        char[] sequence = br.readLine().toCharArray();
        int[] minimumCount = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            minimumCount[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[4];
        for (int i = 0; i < p-1 ; i++) {
            count[baseToIndex(sequence[i])]++;
        }
        int ans = 0;
        // 모든 경우의 수 탐색
        for (int i = p - 1; i < s; i++){
            // 이번 윈도우의 끝 값 추가
            count[baseToIndex(sequence[i])]++;
            if (isValid(count, minimumCount)){
                ans++;
            }
            // 이번 윈도우의 첫 값 제거
            count[baseToIndex(sequence[i - p + 1])]--;
        }
        System.out.println(ans);
    }
}
