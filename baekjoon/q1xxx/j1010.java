package baekjoon.q1xxx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class j1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            long result = combination(M,N);
            System.out.println(result);
        }
    }
    // 조합 계산 함수: M C N = M! / (N! * (M-N)!) 오버플로우 방지
    private static long combination(int M, int N) {
        if (N == 0 || N == M) return 1;

        long result = 1;
        for (int i = 0; i < N; i++) {
            result *= (M - i);
            result /= (i + 1);
        }
        return result;
    }
}
