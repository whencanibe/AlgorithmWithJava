package baekjoon.q11xxx;

import java.io.*;
import java.util.*;

public class j14502 {
    static List<int[]> zeros = new ArrayList<>();
    static List<int[]> viruses = new ArrayList<>();
    static int[][] lab;
    static int maxSafeArea = 0;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 0) zeros.add(new int[]{i, j});
                if (lab[i][j] == 2) viruses.add(new int[]{i, j});
            }
        }

        selectWalls(0, 0);
        System.out.println(maxSafeArea);
    }

    static void selectWalls(int count, int start) {
        if (count == 3) {
            maxSafeArea = Math.max(maxSafeArea, spreadVirus());
            return;
        }

        for (int i = start; i < zeros.size(); i++) {
            int[] pos = zeros.get(i);
            lab[pos[0]][pos[1]] = 1;
            selectWalls(count + 1, i + 1);
            lab[pos[0]][pos[1]] = 0;
        }
    }

    static int spreadVirus() {
        Queue<int[]> q = new LinkedList<>();
        int[][] tempLab = new int[N][M];

        for (int i = 0; i < N; i++) tempLab[i] = lab[i].clone();
        for (int[] v : viruses) q.add(new int[]{v[0], v[1]});

        while (!q.isEmpty()) {
            int[] virus = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = virus[1] + dx[i];
                int ny = virus[0] + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && tempLab[ny][nx] == 0) {
                    tempLab[ny][nx] = 2;
                    q.add(new int[]{ny, nx});
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempLab[i][j] == 0) count++;
            }
        }
        return count;
    }
}

