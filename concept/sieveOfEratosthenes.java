// 1. 2부터 시작해서, 아직 지워지지 않은 수를 소수로 판정
// 2. 그 수의 배수들을 모두 제거
// 3. 다음 남은 수를 찾아 반복
// 4. N까지 반복하면, 남아있는 수들은 모두 소수

static void sieve(int n) {
        isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true); // 처음엔 전부 소수로 가정
        isPrime[0] = isPrime[1] = false; // 0, 1은 소수가 아님

        // 2부터 √n까지 검사
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                // i의 배수를 모두 제거
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                } // for - j
            } // if
        } // for - i
} // sieve
