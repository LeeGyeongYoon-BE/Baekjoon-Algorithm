import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Serial {
    public Serial(String serial) {
        this.serial = serial;
        for (int i = 0; i < serial.length(); i++) {
            if ('0' <= serial.charAt(i) && serial.charAt(i) <= '9') {
                sum += serial.charAt(i) - '0';
            }
        }
    }
    String serial;
    int sum;
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Serial[] serials = new Serial[n];
        for (int i = 0; i < n; i++) {
            serials[i] = new Serial(br.readLine());
        }

        Arrays.sort(serials, (o1, o2) -> {
            if (o1.serial.length() != o2.serial.length()) {
                return o1.serial.length() - o2.serial.length();
            }
            if (o1.sum != o2.sum) {
                return o1.sum - o2.sum;
            }
            return o1.serial.compareTo(o2.serial);
        });

        for (Serial s : serials) {
            System.out.println(s.serial);
        }
    }
}
