// 입력값이 2보다 작으면 → 0과 1은 소수가 아니므로 false 반환.

// 2부터 √n까지만 검사하는 이유

//어떤 수 n이 a × b로 표현된다면, 적어도 하나는 √n 이하입니다.
// 예를 들어, 36 = 6 × 6, 8 × 9처럼 곱해도 한쪽은 6보다 작음.

// 따라서 √n까지만 확인해도 모든 약수를 검사한 것과 같습니다.

// n을 i로 나누었을 때 나머지가 0이면 → 약수가 존재 → false 반환.

// 모든 i에 대해 나누어떨어지지 않으면 → 소수(true).

static boolean isPrime(int n) {
    if (n < 2) return false;
    for (int i = 2; i * i <= n; i++) {
        if (n % i == 0) return false;
    }
    return true;
}
