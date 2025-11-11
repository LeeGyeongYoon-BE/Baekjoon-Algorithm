// 재귀방식
// 1. 재귀 함수는 현재 원소를 포함할지 말지 2가지 선택을 함.
// 2. index == arr.length일 때 현재까지 선택된 원소들의 리스트를 출력.
// 3. 포함 후 재귀 호출 후에는 되돌리기(remove) 로 다른 경우 탐색 가능.
// 4. 모든 경우의 수를 탐색하므로 시간복잡도: O(n * 2^n)

public static void generateSubsets(int[] arr, int index, List<Integer> current) {
    if (index == arr.length) {
        System.out.println(current);
        return;
    } // if

    // 1️⃣ 현재 원소를 포함하지 않는 경우
    generateSubsets(arr, index + 1, current);

    // 2️⃣ 현재 원소를 포함하는 경우
    current.add(arr[index]);
    generateSubsets(arr, index + 1, current);

    // 3️⃣ 되돌리기 (백트래킹)
    current.remove(current.size() - 1);
} // generateSubsets


// 비트마스크 방식
// 1. 각 부분집합은 0 ~ 2^n-1 사이의 이진수로 표현 가능. 예: n=3, mask=5 → 101 → arr[0]과 arr[2] 포함
// 2. 내부 루프에서 비트가 1인지 확인하고 포함 여부 결정.
// 3. 반복문만 사용하므로 재귀보다 구현 간단, n ≤ 20에서 효율적.
// 4. 시간복잡도: O(n * 2^n)

// mask는 0 ~ 2^n - 1까지
for (int mask = 0; mask < (1 << n); mask++) {
    List<Integer> subset = new ArrayList<>();

    for (int i = 0; i < n; i++) {
        // mask의 i번째 비트가 1이면 arr[i] 포함
        if ((mask & (1 << i)) != 0) {
            subset.add(arr[i]);
        } // if
    } // for - i
} // for - mask
