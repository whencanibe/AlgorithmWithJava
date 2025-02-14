package baekjoon.q1xxx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class j1697 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        if (start >= end) {
            System.out.println(start - end);
            return;
        }

        int max = 2 * end;
        int[] dist = new int[max + 1];
        Arrays.fill(dist,-1);

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()){
            int cur = q.poll();

            if(cur == end){
                System.out.println(dist[cur]);
                return;
            }

            int[] nextPos = {cur - 1, cur + 1, cur * 2};
            for(int next : nextPos){
                if (next >= 0 && next <= max && dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }

    }
}
