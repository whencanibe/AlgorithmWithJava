package baekjoon.q1xxx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class j1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numOfGem = Integer.parseInt(st.nextToken());
        int numOfBag = Integer.parseInt(st.nextToken());

        List<int[]> gems = new ArrayList<>(numOfGem);
        List<Integer> weightsForBags = new ArrayList<>(numOfBag);
        for(int i = 0 ; i < numOfGem ; i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            gems.add(new int[]{weight, price});
        }

        for(int i = 0 ; i < numOfBag ; i++){
            int bagWeight= Integer.parseInt(br.readLine());
            weightsForBags.add(bagWeight);
        }

        weightsForBags.sort(Comparator.naturalOrder());
        gems.sort((o1, o2) -> o1[0] - o2[0]);

        PriorityQueue<Integer> prices = new PriorityQueue<>(Comparator.reverseOrder());

        int gemIndex = 0;
        long result = 0;

        for(Integer weight : weightsForBags){
            while(gemIndex < numOfGem && weight >= gems.get(gemIndex)[0]){
                prices.add(gems.get(gemIndex)[1]);
                gemIndex++;
            }

            if(!prices.isEmpty()) result += prices.poll();
        }
        System.out.println(result);
    }
}
