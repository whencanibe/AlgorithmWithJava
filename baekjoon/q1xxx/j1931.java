package baekjoon.q1xxx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class j1931 {
    public static void main(String[] args) throws IOException {
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        List<int[]> schedule = new ArrayList<>(N);

        for (int i = 0 ; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            schedule.add(new int[]{start,end});
        }

        schedule.sort(((o1, o2) -> {
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        }));

        int count = 0;
        int endTime = 0;

        for(int i = 0 ; i < N ; i++){
            if(schedule.get(i)[0] >= endTime){
                count++;
                endTime = schedule.get(i)[1];
            }
        }

        System.out.println(count);
    }
}
