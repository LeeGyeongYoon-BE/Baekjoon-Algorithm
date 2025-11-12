import java.io.*;
import java.util.*;

public class Main {

    // 선분 정보를 담는 클래스
    static class Line {
        long x1, y1, x2, y2;
        Line(long x1, long y1, long x2, long y2) {
            this.x1 = x1; this.y1 = y1;
            this.x2 = x2; this.y2 = y2;
        }
    }

    static int[] parent; // 유니온파인드 부모 배열
    static int[] size;   // 각 그룹의 크기 (루트일 때만 유효)
    static Line[] lines; // 선분 목록

    // 유니온파인드: find (루트 찾기, 경로 압축)
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    // 유니온파인드: union (두 집합 병합)
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return; // 이미 같은 그룹이면 패스
        // a 그룹에 b를 병합 (크기 누적)
        parent[b] = a;
        size[a] += size[b];
    }

    // CCW (Counter ClockWise) 계산
    // 세 점의 방향 (외적의 부호)
    static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long cross = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);
        if (cross > 0) return 1;   // 반시계 방향
        if (cross < 0) return -1;  // 시계 방향
        return 0;                  // 일직선
    }

    // p(px,py)가 선분 a~b 위에 있는지 확인
    static boolean onSegment(long ax, long ay, long bx, long by, long px, long py) {
        long minX = Math.min(ax, bx);
        long maxX = Math.max(ax, bx);
        long minY = Math.min(ay, by);
        long maxY = Math.max(ay, by);
        return (minX <= px && px <= maxX) && (minY <= py && py <= maxY);
    }

    // 두 선분이 교차하는지 판별
    static boolean isCross(Line A, Line B) {
        int c1 = ccw(A.x1, A.y1, A.x2, A.y2, B.x1, B.y1);
        int c2 = ccw(A.x1, A.y1, A.x2, A.y2, B.x2, B.y2);
        int c3 = ccw(B.x1, B.y1, B.x2, B.y2, A.x1, A.y1);
        int c4 = ccw(B.x1, B.y1, B.x2, B.y2, A.x2, A.y2);

        // 일반적인 교차 (서로 다른 방향)
        if (c1 * c2 < 0 && c3 * c4 < 0) return true;

        // 일직선인 경우 (끝점이 다른 선분 위에 있는지 확인)
        if (c1 == 0 && onSegment(A.x1, A.y1, A.x2, A.y2, B.x1, B.y1)) return true;
        if (c2 == 0 && onSegment(A.x1, A.y1, A.x2, A.y2, B.x2, B.y2)) return true;
        if (c3 == 0 && onSegment(B.x1, B.y1, B.x2, B.y2, A.x1, A.y1)) return true;
        if (c4 == 0 && onSegment(B.x1, B.y1, B.x2, B.y2, A.x2, A.y2)) return true;

        // 그 외에는 교차하지 않음
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 선분 개수

        lines = new Line[N + 1];     // 1-based index
        parent = new int[N + 1];     // 유니온파인드 초기화
        size = new int[N + 1];       // 각 그룹 크기 저장

        // 각 선분 입력
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x1 = Long.parseLong(st.nextToken());
            long y1 = Long.parseLong(st.nextToken());
            long x2 = Long.parseLong(st.nextToken());
            long y2 = Long.parseLong(st.nextToken());
            lines[i] = new Line(x1, y1, x2, y2);
            parent[i] = i;   // 자기 자신을 부모로 설정
            size[i] = 1;     // 초기 크기 1
        }

        // 모든 선분 쌍을 비교하며 교차 여부 검사
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (isCross(lines[i], lines[j])) {
                    union(i, j); // 교차하면 같은 그룹으로 묶음
                }
            }
        }

        // 루트인 노드 개수 = 그룹 개수
        int groupCount = 0;
        int maxSize = 0;

        for (int i = 1; i <= N; i++) {
            if (find(i) == i) {       // 루트 노드라면
                groupCount++;         // 그룹 개수 증가
                maxSize = Math.max(maxSize, size[i]); // 최대 그룹 크기 갱신
            }
        }

        // 출력: 그룹 개수, 가장 큰 그룹 크기
        System.out.println(groupCount);
        System.out.println(maxSize);

        br.close();
    }
}
