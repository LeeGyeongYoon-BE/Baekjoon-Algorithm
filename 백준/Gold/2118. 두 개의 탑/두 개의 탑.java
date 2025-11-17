import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] distance = new int[N];
        int distanceSum = 0;
        for (int i = 0; i < N; i++) {
            distance[i] = Integer.parseInt(br.readLine());
            distanceSum += distance[i];
        }

        // 모든 기준 지점 i에서
        // 반시계방향거리 <= 시계방향거리가 되는 경계를 확인한다.
        int pairIndex = 0;
        int distClockWise = 0;
        int distCounterClockWise = distanceSum;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            while(distClockWise < distCounterClockWise){
                distClockWise += distance[pairIndex];
                distCounterClockWise -= distance[pairIndex];
                pairIndex = (pairIndex + 1) % N;
            }
            ans = Math.max(ans, distCounterClockWise);
            distClockWise -= distance[i];
            distCounterClockWise += distance[i];
        }
        System.out.println(ans);
    }
}
