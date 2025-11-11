// 연속된 구간(윈도우)을 이동하면서 최적화된 계산을 하는 기법
// 배열, 문자열 등에서 연속된 구간 합, 최대/최소, 특정 조건 만족 개수 등을 효율적으로 계산
// 구간 크기 고정 또는 가변으로 설정 가능

// idea
// 1. 윈도우 초기화
// 배열/문자열에서 처음 K개의 원소를 선택하여 계산
// 2. 윈도우 이동
// 한 칸씩 이동하면서 빠진 값 제거, 새로 들어온 값 추가
// 전체 구간을 반복 계산하지 않고 O(N) 시간에 처리 가능

// 고정 크기 윈도우의 합 구하기
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 10; // 배열 길이
        int K = 3;  // 윈도우 크기
        int[] arr = {1, 2, 3, 4, 2, 5, 1, 2, 6, 1};

        int windowSum = 0;
        for (int i = 0; i < K; i++) {
            windowSum += arr[i]; // 초기 윈도우 합
        } // for
        System.out.println(windowSum);

        for (int i = K; i < N; i++) {
            windowSum += arr[i] - arr[i - K]; // 슬라이딩 윈도우 이동
            System.out.println(windowSum);
        } // for

        br.close();
    } // main
} // class
