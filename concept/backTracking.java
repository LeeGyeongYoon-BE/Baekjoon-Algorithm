// 모든 가능한 경우를 탐색하면서 조건에 맞지 않으면 되돌아가는(백트랙) 방법
// 주로 재귀(Recursive)를 사용
// 탐색 과정에서 불필요한 경로를 가지치기(Pruning)하여 효율성 향상
// 조합, 순열, 부분집합, N-Queens, 미로 탐색 등에서 활용

// 1. 현재 상태에서 가능한 선택을 모두 시도
// 2. 선택 후 조건 검증
// 조건 만족: 다음 단계로 재귀
// 조건 불만족: 이전 상태로 되돌아가 다른 선택 시도
// 3. 모든 선택을 다 시도하면 종료

// 1 ~ N 숫자로 길이 M 순열 만들기
static int N = 3, M = 2;
static int[] arr = new int[M];
static boolean[] used = new boolean[N + 1];

static void backtrack(int depth) {
    if (depth == M) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
        return;
    } // if
    
    for (int i = 1; i <= N; i++) {
        if (!used[i]) {
            used[i] = true;
            arr[depth] = i;
            backtrack(depth + 1);
            used[i] = false; // 되돌리기
        } // if
    } // for
} // backtrack

public static void main(String[] args) {
    backtrack(0);
} // main
