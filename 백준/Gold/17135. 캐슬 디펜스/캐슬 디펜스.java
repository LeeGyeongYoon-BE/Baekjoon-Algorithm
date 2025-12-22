import java.io.*;
import java.util.*;

public class Main {
    static class Enemy implements Comparable<Enemy> {
        Integer row, col; // 행 좌표, 열 좌표 - 턴마다 갱신됨
        Integer distance; // 궁수와의 거리 - 턴마다 갱신됨
        boolean deadYN; // 사망 여부
        public Enemy(int row, int col) {
            this.row = row;
            this.col = col;
        }
        @Override
        public int compareTo(Enemy enemy) {
            if( this.distance.equals( enemy.distance ) ) { // 공격 거리가 같다면,
                return this.col.compareTo( enemy.col ); // 컬럼 순으로 정렬
            } else { // 공격 거리가 다르면, 공격 거리 순으로 정렬
                return this.distance.compareTo( enemy.distance );
            }
        } // compareTo
    } // class
    static int N, M, D, count;
    static int [][] map;
    static List<Enemy> enemies = new ArrayList<Enemy>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            } // for - j
        } // for - i

        archerSelect( 0, new int[3] ); // game start

        System.out.println(count);

        br.close();
    } // main

    private static void archerSelect(int idx, int[] archers) { // 궁수 조합 recursion 함수
        if( idx == 3 ) { // 세 명의 궁수 선택 완료
//			System.out.println( Arrays.toString( archers ) );
            gameStart(archers);
            return;
        } // 재귀 탈출

        for (int i = idx; i < M; i++) {
            archers[idx] = i;
            archerSelect(idx + 1, archers);
        } // for
    } // archerSelect

    private static void gameStart(int[] archers) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if( map[i][j] == 1 ) enemies.add( new Enemy(i, j) );
            } // for - j
        } // for - i // 모든 적 정보 저장

        int dead = 0;
        boolean gameFlage = true;
        while( gameFlage ) { // 게임 턴 진행

            for (int i = 0; i < archers.length; i++) { // 모든 궁수가
                PriorityQueue<Enemy> targetEnemies = new PriorityQueue<>();
                int archer = archers[i];
                for (int j = 0; j < enemies.size(); j++) { // 모든 적에 대해
                    Enemy enemy = enemies.get(j);
                    enemy.distance = Math.abs(archer - enemy.col)
                            + Math.abs(N - enemy.row);
                    if( enemy.distance <= D ) { // 공격 가능 거리 검사
                        targetEnemies.offer(enemy); // 공격 가능 적으로 등록
                    }
                } // for - j // enemies.size

                if( !targetEnemies.isEmpty() ) {
                    targetEnemies.poll().deadYN = true; // 가장 앞의 하나만 사망 처리
                }
            } // for - i // archers.length // 모든 궁수가 공격 행위 1턴 완료

            for (int i = 0; i < enemies.size(); i++) {
                Enemy enemy = enemies.get(i);
                if( enemy.deadYN ) { // 사망인 경우
                    enemies.remove(i--); // 사망 처리 // 적군 수 감소
                    dead++; // 사망자 수 증가
                } else if ( enemy.row == N -1 ) { // 배열의 끝에 도달한 경우
                    enemies.remove(i--); // 탈출 처리 // 적군 수 감소
                } else { // 한 칸 전진
                    enemy.row++;
                } // if ~ else
            } // for // enemies.size

            if( enemies.size() == 0 ) gameFlage = false;
            // 적군이 모두 사라진 경우, 게임 종료 처리
        } // while - 게임 턴 종료

        count = Math.max(count, dead);
    } // gameStart
} // class
