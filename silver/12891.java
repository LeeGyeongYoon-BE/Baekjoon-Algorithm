import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int[] myArr;
    static int[] checkArr;
    static int checkSecret;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int Result = 0;
        checkArr = new int[4];
        myArr = new int[4];
        checkSecret = 0;

        char[] A = br.readLine().toCharArray();

        st =  new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) {
                checkSecret++;
            } // if
        } // for

        for (int i = 0; i < P; i++) { // 부분 문자열 처음 받을 때 세팅
            Add(A[i]);
        } // for

        if (checkSecret == 4) {
            Result++;
        } // if

        // 슬라이딩 윈도우
        for (int i = P; i < S; i++){
            int j = i - P;
            Add(A[i]);
            Remove(A[j]);
            if (checkSecret == 4) Result++;
        } // for

        System.out.println(Result);
        br.close();

    } // main

    private static void Remove(char c) {
        switch (c) {
            case 'A' :
                if (myArr[0] == checkArr[0]) {
                    checkSecret--;
                } // if
                myArr[0]--;
                break;
            case 'C' :
                if (myArr[1] == checkArr[1]) {
                    checkSecret--;
                } // if
                myArr[1]--;
                break;
            case 'G' :
                if (myArr[2] == checkArr[2]) {
                    checkSecret--;
                } // if
                myArr[2]--;
                break;
            case 'T' :
                if (myArr[3] == checkArr[3]) {
                    checkSecret--;
                } // if
                myArr[3]--;
                break;
        } // switch
    } // Remove

    private static void Add(char c) {
        switch (c) {
            case 'A' :
                myArr[0]++;
                if (myArr[0] == checkArr[0]) {
                    checkSecret++;
                } // if
                break;
            case 'C' :
                myArr[1]++;
                if (myArr[1] == checkArr[1]) {
                    checkSecret++;
                } // if
                break;
            case 'G' :
                myArr[2]++;
                if (myArr[2] == checkArr[2]) {
                    checkSecret++;
                } // if
                break;
            case 'T' :
                myArr[3]++;
                if (myArr[3] == checkArr[3]) {
                    checkSecret++;
                } // if
                break;
        } // switch
    } // Add
} // class
