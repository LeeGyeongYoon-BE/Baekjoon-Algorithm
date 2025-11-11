import java.io.*;
import java.util.*;
public class Main {
    static long count = 0;
    static int[] A, tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        tmp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        } // for

        mergeSort(0, N - 1);
        System.out.println(count);
    } // main

    static void mergeSort(int start, int end) {
        if (start >= end) return;

        int mid = (start + end) / 2;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        merge(start, mid, end);
    } // mergeSort

    static void merge(int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = start;

        while (i <= mid && j <= end) {
            if (A[i] <= A[j]) {
                tmp[k++] = A[i++];
            } else {
                tmp[k++] = A[j++];
                count += (mid - i + 1);
            } // if ~ else
        } // while

        while (i <= mid) {
            tmp[k++] = A[i++];
        } // while
        while (j <= end) {
            tmp[k++] = A[j++];
        } // while

        for (int t = start; t <= end; t++) {
            A[t] = tmp[t];
        } // for
    } // mergeSort
} // class