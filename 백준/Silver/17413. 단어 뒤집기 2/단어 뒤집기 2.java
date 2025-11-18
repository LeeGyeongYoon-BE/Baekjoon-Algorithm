import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length;) {
            if (s[i] == '<') {
                while (s[i] != '>') sb.append(s[i++]);
                sb.append(s[i++]);
            }
            else {
                int nextIndex = i;
                while (nextIndex < s.length && s[nextIndex] != ' ' && s[nextIndex] != '<')
                    nextIndex++;
                for (int j = nextIndex - 1; j >= i; j--)
                    sb.append(s[j]);
                if (nextIndex < s.length && s[nextIndex] == ' ') {
                    sb.append(" ");
                    nextIndex++;
                }
                i = nextIndex;
            }
        }
        System.out.println(sb);
    } // main
} // class
