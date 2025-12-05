import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N; // 재료의 갯수
    static int minValue = Integer.MAX_VALUE;
    static int[][] taste;


    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N =  Integer.parseInt(st.nextToken());
        taste = new int[2][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            taste[0][i] = Integer.parseInt(st.nextToken());
            taste[1][i] = Integer.parseInt(st.nextToken());
        } // for

        subset(0, 1, 0);

        System.out.println( minValue );

        br.close();
    } // main

    private static void subset(int idx, int sour, int bitter) {

        if ( idx >= N ){
            if ( bitter == 0 ){
                return;
            }
            if ( (minValue > Math.abs(sour - bitter)) && (bitter != 0)){
                minValue = Math.abs(sour - bitter);
            }
            return;
        } // 재귀 탈출

        subset(idx + 1, sour * taste[0][idx], bitter + taste[1][idx]);

        subset( idx + 1, sour, bitter);
    } // subset

} // class