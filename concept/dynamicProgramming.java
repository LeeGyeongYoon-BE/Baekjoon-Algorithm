// 복잡한 문제를 작은 하위 문제로 나누고, 그 결과를 재활용하여 효율적으로 해결하는 알고리즘 기법
// 중복되는 부분 문제(overlapping subproblems)와 최적 부분 구조(optimal substructure)가 있을 때 사용
// 대표 문제: 피보나치 수열, 배낭 문제, 최소 편집 거리, 최장 공통 부분 수열(LCS)

// 1. 문제를 하위 문제로 분해
// 2. 각 하위 문제를 한 번만 계산하고, 결과를 저장 (메모이제이션)
// 3. 저장된 값을 재사용하여 전체 문제 해결

// DP 유형
// 1. 탑다운(Top-Down, 재귀 + 메모이제이션) : 재귀적으로 문제를 풀면서 계산한 값을 메모리에 저장
// 2. 바텀업(Bottom-Up, 반복문) : 작은 문제부터 차례로 계산하여 큰 문제를 해결

// 피보나치 수열
// Top-Down (재귀 + 메모이제이션)
static int[] dp;
static int fibonacci(int n) {
    if (dp[n] != 0) return dp[n];
    if (n == 1 || n == 2) return 1;
    return dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
} // fibonacci - top - down

public static void main(String[] args) {
    int n = 10;
    dp = new int[n + 1];
    System.out.println(fibonacci(n)); // 55
} // main
// Bottom-Up (반복문)
static int fibonacciBU(int n) {
    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 1;
    for (int i = 3; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    } // for
    return dp[n];
} // fibonacci - bottom - up
