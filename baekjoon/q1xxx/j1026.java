package baekjoon.q1xxx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class j1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] A = br.readLine().split(" ");
        String[] B = br.readLine().split(" ");

        Integer[] a = new Integer[N];
        Integer[] b = new Integer[N];
        for(int i = 0 ; i < A.length ; i++){
            a[i] = Integer.parseInt(A[i]);
            b[i] = Integer.parseInt(B[i]);
        }

        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());

        int result = 0;
        for(int i = 0 ; i < a.length; i++){
            result += a[i] * b[i];
        }

        System.out.println(result);
    }
}
