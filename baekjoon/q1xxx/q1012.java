package baekjoon.q1xxx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class q1012 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int[][] field;

    static void dfs(boolean[][] visited, int[] coord, int N, int M){
        Stack<int[]> stack = new Stack<>();
        stack.add(coord);

        while(!stack.isEmpty()){
            int[] cur = stack.pop();

            for(int i = 0 ; i < 4 ; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx < 0 || nx >= M || ny < 0 || ny >= N || field[ny][nx] != 1 || visited[ny][nx]) continue;

                visited[ny][nx] = true;
                stack.add(new int[]{nx,ny});
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T ; i++){
            String[] nmk = br.readLine().split(" ");
            int N = Integer.parseInt(nmk[0]);
            int M = Integer.parseInt(nmk[1]);
            int K = Integer.parseInt(nmk[2]);

            field = new int[N][M];
            List<int[]> cabbage = new ArrayList<>();

            for(int j = 0 ; j < K ; j++){
                String[] xy = br.readLine().split(" ");
                int y = Integer.parseInt(xy[0]);
                int x = Integer.parseInt(xy[1]);

                field[y][x] = 1;
                cabbage.add(new int[]{x,y});
            }

            boolean[][] visited = new boolean[N][M];
            int count = 0;
            for(int[] coord : cabbage){
                if(!visited[coord[1]][coord[0]]){
                    visited[coord[1]][coord[0]] = true;
                    dfs(visited,coord,N,M);
                    count++;
                }
            }

            System.out.println(count);
        }




    }
}
