public static long nPr(int n, int r) {
    long result = 1;
    for (int i = 0; i < r; i++) {
        result *= (n - i);
    } // for
    return result;
} // nPr
