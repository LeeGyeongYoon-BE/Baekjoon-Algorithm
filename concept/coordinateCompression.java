// 큰 범위의 좌표 값을 작은 범위로 변환하여 효율적으로 처리하는 기법
// 주로 정렬, 구간 합, 세그먼트 트리, BIT 등에서 사용
// 순서를 유지하면서 값의 범위를 줄이는 것이 핵심

// 1. 원래 배열의 값을 모두 복사
// 2. 복사 배열을 정렬
// 3. 각 값에 인덱스 번호 부여
// 4. 원래 배열의 값을 인덱스로 치환

// 예시:
// 원본 배열: [100, 300, 200, 100]
// 복사 & 정렬: [100, 100, 200, 300]
// 고유 값 정렬 후 인덱스 매핑: {100 -> 0, 200 -> 1, 300 -> 2}
// 좌표 압축 적용: [0, 2, 1, 0]

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = {100, 300, 200, 100};
        int n = arr.length;
        
        // 중복 제거 & 정렬
        int[] sorted = Arrays.stream(arr).distinct().sorted().toArray();
        
        // 좌표 압축 적용
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sorted.length; i++) {
            map.put(sorted[i], i);
        } // for
        
        // 결과 출력
        for (int i = 0; i < n; i++) {
            System.out.print(map.get(arr[i]) + " ");
        } // for
        // 출력: 0 2 1 0
    } // main
} // class
