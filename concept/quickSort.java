// 분할 정복 전략
// 기준(pivot) 선택 -> pivot보다 작은 값 왼쪽, 큰 값 오른쪽 -> 재귀 정렬

// 1. pivot 선택
// 2. pivot보다 작은 값 왼쪽, 큰 값 오른쪽 배치
// 3. 좌우 배열 재귀 정렬

public static void quickSort(int[] arr, int left, int right) {
    if (left >= right) return;
    int pivot = arr[left];
    int l = left + 1, r = right;
    while (l <= r) {
        while (l <= r && arr[l] <= pivot) l++;
        while (l <= r && arr[r] >= pivot) r--;
        if (l < r) {
            int temp = arr[l]; arr[l] = arr[r]; arr[r] = temp;
        } // if
    } // while
    arr[left] = arr[r];
    arr[r] = pivot;
    quickSort(arr, left, r - 1);
    quickSort(arr, r + 1, right);
} // quickSort
