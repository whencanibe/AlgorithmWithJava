package baekjoon.q1xxx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class j1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        String[] minusSplit = expression.split("-");

        int total = 0;
        String[] ps = minusSplit[0].split("\\+");
        for (String p : ps) {
            total += Integer.parseInt(p);
        }

        for(int i = 1 ; i < minusSplit.length ; i++){
            String tmp = minusSplit[i];
            String[] plusSplit = tmp.split("\\+");
            int sum = 0;
            for (String s : plusSplit) {
                sum += Integer.parseInt(s);
            }
            total -= sum;
        }

        System.out.println(total);
    }
}
