import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
    static int[] currentAlphabetFrequency = new int[26];
    static int currentUniqueAlphabetCount = 0;

    static void increaseFrequency(char alphabet){
        if (currentAlphabetFrequency[alphabet - 'a']++ == 0){
            currentUniqueAlphabetCount++;
        }
    }

    static void decreaseFrequency(char alphabet){
        if (--currentAlphabetFrequency[alphabet - 'a'] == 0){
            currentUniqueAlphabetCount--;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        char[] nyang = br.readLine().toCharArray();
        int nextIndex = 0, maxLength = 0;
        for (int i = 0; i < nyang.length; i++) {
            while (nextIndex < nyang.length){
                increaseFrequency(nyang[nextIndex++]);
                if (currentUniqueAlphabetCount > n){
                    decreaseFrequency(nyang[--nextIndex]);
                    break;
                }
            }
            maxLength = Math.max(maxLength, nextIndex - i);
            decreaseFrequency(nyang[i]);
        }
        sb.append(maxLength);
        System.out.println(sb);
    }
}
