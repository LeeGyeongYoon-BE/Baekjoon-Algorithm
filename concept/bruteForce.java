// 가능한 모든 경우의 수를 탐색하여 문제를 해결하는 알고리즘
// 완전 탐색

// 1 ~ N까지 합 구하기
public class BruteForceSum {
    public static void main(String[] args) {
        int N = 5;
        int sum = 0;
        for (int i = 1; i <= N; i++) { // 모든 경우 탐색
            sum += i;
        } // for
        System.out.println(sum); // 15
    } // main
} // class

// 두 수의 합이 10인 쌍 찾기
public class TwoSumBruteForce {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == 10) {
                    System.out.println(arr[i] + " + " + arr[j] + " = 10");
                } // if
            } // for - j
        } // for - i
    } // main
} // class

// 문자열 내 특정 패턴 찾기
public class BruteForceString {
    public static void main(String[] args) {
        String text = "abcabc";
        String pattern = "abc";
        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            if (text.substring(i, i + pattern.length()).equals(pattern)) {
                System.out.println("Pattern found at index " + i);
            } // if
        } // for
    } // main
} // class
