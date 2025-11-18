import java.io.*;
import java.util.*;

class Main
{
    static boolean isMatch(char open, char close){
        if (open == '(' && close == ')'){
            return true;
        }
        if (open == '[' && close == ']'){
            return true;
        }
        return false;
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            char[] input = br.readLine().toCharArray();
            if (input.length == 1 && input[0] == '.'){
                break;
            }
            char[] opened = new char[input.length];
            int topIndex = -1;
            boolean isValid = true;
            for (char ch : input){
                if (ch == '(' || ch == '['){
                    opened[++topIndex] = ch;
                } else if (ch == ')' || ch == ']') {
                    if (topIndex < 0 || !isMatch(opened[topIndex--], ch)){
                        isValid = false;
                        break;
                    }
                }
            }
            if (topIndex >= 0){
                isValid = false;
            }
            System.out.println(isValid? "yes" : "no");

        }

    }
}