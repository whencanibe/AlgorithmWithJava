package programmers.kakao2024Winter;

import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int n = friends.length;

        Map<String, Integer> fim = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            int index = i;
            String name = friends[i];
            fim.put(name, index);
        }

        int[][] giftRecord = new int[n][n];
        for(int i = 0 ; i < gifts.length; i++){
            String[] fromTo = gifts[i].split(" ");
            int from = fim.get(fromTo[0]);
            int to = fim.get(fromTo[1]);
            giftRecord[from][to]++;
        }

        int[] given = new int[n];
        int[] received = new int[n];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                given[i] += giftRecord[i][j];
                received[j] += giftRecord[i][j];
            }
        }

        int[] giftIndex = new int[n];
        for(int i = 0 ; i < n ; i++){
            giftIndex[i] = given[i] - received[i];
        }

        int[] nextMonth = new int[n];

        for(int i = 0 ; i < n - 1 ; i++){
            for (int j = i + 1 ; j < n ;j++){
                int itoj = giftRecord[i][j];
                int jtoi = giftRecord[j][i];
                if(itoj > jtoi){
                    nextMonth[i]++;
                } else if(itoj < jtoi){
                    nextMonth[j]++;
                } else {
                    if(giftIndex[i] > giftIndex[j]){
                        nextMonth[i]++;
                    } else if(giftIndex[i] < giftIndex[j]){
                        nextMonth[j]++;
                    }
                }
            }
        }
        int max = -1;

        for(int gift : nextMonth){
            max = Math.max(max, gift);
        }

        answer = max;
        return answer;
    }
}