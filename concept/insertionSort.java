// 배열의 각 원소를 적절한 위치에 삽입하며 정렬
// 카드 정렬 방식과 유사

// 1. 현재 원소를 key로 저장
// 2. 왼쪽 정렬된 배열과 비교
// 3. key보다 큰 값들을 한 킨씩 이동
// 4. key 삽입
public static void insertionSort(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        } // while
        arr[j + 1] = key;
    } // for
} // insertionSort
