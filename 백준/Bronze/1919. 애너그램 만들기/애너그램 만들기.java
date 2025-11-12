import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alp = new int[26];
        String str1 = br.readLine();
        String str2 = br.readLine();
        for (int i = 0; i < str1.length(); i++) {
            alp[str1.charAt(i) - 'a']++;
        } // for
        for (int i = 0; i < str2.length(); i++) {
            alp[str2.charAt(i) - 'a']--;
        } // for

        int ans = 0;
        for (int i = 0; i < alp.length; i++) {
            if (alp[i] > 0) {
                ans += alp[i];
            } else {
                ans -= alp[i];
            } // if ~ else
        } // for

        System.out.println(ans);
        br.close();
    } // main
} // class