package baekjoon.q1xxx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class j1967 {
    static List<List<int[]>> tree;
    static boolean[] visited;
    static int maxDist = 0;
    static int farthest = 0;

    static void dfs(int root, int distance){
        visited[root] = true;

        if(distance > maxDist){
            maxDist = distance;
            farthest = root;
        }

        for(int[] neighbor : tree.get(root)){
            int node = neighbor[0];
            int weight = neighbor[1];
            if(!visited[node]){
                dfs(node, distance+weight);
            }
        }
    }


    public static void main(String[] args) throws IOException {

        //N 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        // 간선 입력 처리 (양방향 저장)
        for (int i = 0; i < N - 1; i++) {
            String[] s = br.readLine().split(" ");
            int parent = Integer.parseInt(s[0]);
            int child = Integer.parseInt(s[1]);
            int weight = Integer.parseInt(s[2]);
            tree.get(parent).add(new int[]{child, weight});
            tree.get(child).add(new int[]{parent, weight}); // 양방향
        }
        visited = new boolean[N + 1];
        dfs(1,0);


        maxDist = 0;
        visited = new boolean[N + 1];
        dfs(farthest,0);

        System.out.println(maxDist);
    }

}
