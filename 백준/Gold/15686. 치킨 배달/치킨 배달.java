import java.io.*;
import java.util.*;

public class Main {
    static int N, M; // 도시 크기, 치킨집 개수
    static List<int[]> house = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();
    static int[] choice;
    static int min = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        choice = new int[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) house.add( new int[] {i, j} );
                else if(tmp == 2) chicken.add( new int[] {i, j} );
            } // for - j
        } // for - i

        combination(0, 0);

        System.out.println( min );

        br.close();
    } // main

    private static void combination(int idx, int start) {
        if(idx >= M) {

            int sum = 0;
            for (int i = 0; i < house.size(); i++) {

                int distance = 987654321;
                for (int j = 0; j < choice.length; j++) {
                    distance = Math.min(distance
                            , Math.abs( house.get(i)[0] - chicken.get(choice[j])[0] )
                                    + Math.abs( house.get(i)[1] - chicken.get(choice[j])[1] ) );
                } // for - j
                sum += distance;
            } // for - i
            min = Math.min(min, sum);

            return;
        } // 재귀 탈출

        for (int i = start; i < chicken.size(); i++) {
            choice[idx] = i; // chicken의 번지를 저장
            combination(idx + 1, i + 1);
        } // for
    } // combination
    
} // class
