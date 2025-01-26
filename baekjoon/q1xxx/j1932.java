package baekjoon.q1xxx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class j1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //int[][] dp = new int [N+1][N+1] 2차원 배열로 선언하면 메모리가 낭비됨.
        int[][] dp = new int[N + 1][];
        for(int i = 1; i <= N; i++) {
            dp[i] = new int[i+1];
        }

        dp[1][1] = Integer.parseInt(br.readLine());

        for(int i = 2; i <= N; i++) {
            // split을 반복적으로 사용할 경우 메모리가 낭비됨. StringTokenizer를 사용하여 해결.
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= i; j++) {
                int currentInput = Integer.parseInt(st.nextToken());
                if ( j == 1){
                    dp[i][j] = dp[i-1][1] + currentInput;
                } else if( j == i){
                    dp[i][j] = dp[i-1][j - 1] + currentInput;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1] + currentInput, dp[i-1][j]+ currentInput);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++) {
            max = Math.max(max, dp[N][i]);
        }

        System.out.println(max);
    }

}
