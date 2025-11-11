// 정렬된 배열 또는 구간에서 목표 값을 효율적으로 찾는 탐색 알고리즘
// 매 단계에서 탐색 범위를 절반으로 줄여가며 목표값 존재 여부 확인
// 시간 복잡도가 O(log N)으로 매우 효율적

// idea
// 1. 정렬된 자료 필요
// 배열, 리스트, 문자열 등 탐색 대상이 반드시 정렬되어 있어야 함
// 2. 중간 값 선택
// 시작점(left), 끝점(right)을 기준으로 중간(mid) 위치 계산
// 3. 조건 비교
// 목표값과 mid 위치 값 비교
// 작으면 오른쪽 절반, 크면 왼쪽 절반 탐색
// 4. 반복
// 목표값을 찾거나 범위가 사라질 때까지 반복

// 값 찾
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int target = 7;
        int left = 0, right = arr.length - 1;
        boolean found = false;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                found = true;
                break;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            } // if ~ else
        } // while

        System.out.println(found ? "찾음" : "없음");
    } // main
} // class
