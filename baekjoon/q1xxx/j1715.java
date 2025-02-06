package baekjoon.q1xxx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class j1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0 ; i < N ; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        if (pq.size() == 1) {
            System.out.println(0);
            return;
        }

        int result = 0;
        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();

            pq.add(first+second);
            result += first + second;
        }

        System.out.println(result);
    }
}
