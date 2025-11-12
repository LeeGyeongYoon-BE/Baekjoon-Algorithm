import java.io.*;
import java.util.*;

public class Main {

    // 세 점의 방향성 계산 (외적의 부호)
    static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long cross = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);
        if (cross > 0) return 1;   // 반시계
        if (cross < 0) return -1;  // 시계
        return 0;                  // 일직선
    }

    // p (px,py)가 a~b 선분의 좌표 범위에 포함되는지 확인
    // (a와 b가 같은 x 또는 y 값을 가질 수도 있으므로 범위로 검사)
    static boolean onSegment(long ax, long ay, long bx, long by, long px, long py) {
        long minX = Math.min(ax, bx);
        long maxX = Math.max(ax, bx);
        long minY = Math.min(ay, by);
        long maxY = Math.max(ay, by);

        // px가 x 범위에 있고 py가 y 범위에 있어야 선분 위에 있음
        return (minX <= px && px <= maxX) && (minY <= py && py <= maxY);
    }

    // 두 선분이 교차하는지 판별
    static boolean isCross(long x1, long y1, long x2, long y2,
                           long x3, long y3, long x4, long y4) {

        int c1 = ccw(x1, y1, x2, y2, x3, y3);
        int c2 = ccw(x1, y1, x2, y2, x4, y4);
        int c3 = ccw(x3, y3, x4, y4, x1, y1);
        int c4 = ccw(x3, y3, x4, y4, x2, y2);

        // 일반적인 교차: 서로 다른 쪽에 있으면 교차
        if (c1 * c2 < 0 && c3 * c4 < 0) return true;

        // 한 점이 다른 선분 위에 있는 특수한 경우들 처리
        // (한쪽 ccw가 0이면, 해당 점이 다른 선분의 범위 안에 있는지 확인)
        if (c1 == 0 && onSegment(x1, y1, x2, y2, x3, y3)) return true; // 3이 1-2 위
        if (c2 == 0 && onSegment(x1, y1, x2, y2, x4, y4)) return true; // 4가 1-2 위
        if (c3 == 0 && onSegment(x3, y3, x4, y4, x1, y1)) return true; // 1이 3-4 위
        if (c4 == 0 && onSegment(x3, y3, x4, y4, x2, y2)) return true; // 2가 3-4 위

        // 그 외의 경우는 교차하지 않음
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 선분의 두 점 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x1 = Long.parseLong(st.nextToken());
        long y1 = Long.parseLong(st.nextToken());
        long x2 = Long.parseLong(st.nextToken());
        long y2 = Long.parseLong(st.nextToken());

        // 두 번째 선분의 두 점 입력
        st = new StringTokenizer(br.readLine());
        long x3 = Long.parseLong(st.nextToken());
        long y3 = Long.parseLong(st.nextToken());
        long x4 = Long.parseLong(st.nextToken());
        long y4 = Long.parseLong(st.nextToken());

        // 교차하면 1, 아니면 0 출력
        System.out.println(isCross(x1, y1, x2, y2, x3, y3, x4, y4) ? 1 : 0);
        br.close();
    }
}
