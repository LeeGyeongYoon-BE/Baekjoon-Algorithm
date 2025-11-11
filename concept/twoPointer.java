// 두 개의 포인터를 이용해 배열이나 문자열을 동시에 탐색하는 기법
// 연속된 구간, 조건 만족, 정렬된 배열 처리 등에 활용
// 슬라이딩 윈도우와 유사하지만, 포인터가 가변적이며 특정 조건에 따라 이동

// idea
// 1. 포인터 초기화
// 일반적으로 시작점(왼쪽)과 끝점(오른쪽) 두 개의 포인터 설정
// 2. 조건에 따라 포인터 이동
// 조건 만족 시 결과 처리 후 한쪽 포인터 이동
// 조건 불만족 시 다른 포인터 이동
// 3. 전체 배열/문자열을 한 번만 탐색
// 반복 계산 없이 효율적 탐색 가능

// 합이 특정 값인 연속 부분 배열 찾기
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] arr = {1, 2, 3, 2, 5, 1, 1, 3};
        int N = arr.length;
        int S = 5; // 목표 합

        int left = 0, right = 0, sum = 0;
        while (right < N) {
            sum += arr[right];

            while (sum > S && left <= right) {
                sum -= arr[left];
                left++;
            } // while

            if (sum == S) {
                System.out.println("구간: " + left + " ~ " + right);
            } // if
            right++;
        } // while
    } // main
} // class
