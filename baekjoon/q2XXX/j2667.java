package baekjoon.q2XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class j2667 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static char[][] map;

    static int bfs(boolean[][] visited, int x, int y, int N){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[y][x] = true;
        int count = 1;
        while(!q.isEmpty()){
            int[] coord = q.poll();
            int cx = coord[0];
            int cy = coord[1];
            for(int i = 0 ; i < 4 ; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[ny][nx] || map[ny][nx] != '1') continue;

                visited[ny][nx] = true;
                count++;
                q.add(new int[]{nx,ny});
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        boolean[][] visited = new boolean[N][N];

        for(int i = 0 ; i < N ; i++){
            map[i] = br.readLine().toCharArray();
        }
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(map[i][j] == '1' && !visited[i][j]){
                    int result = bfs(visited,j,i,N);
                    pq.add(result);
                    count++;
                }
            }
        }

        System.out.println(count);
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }

    }
}
