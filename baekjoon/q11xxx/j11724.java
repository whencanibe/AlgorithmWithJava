package baekjoon.q11xxx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class j11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for(int i = 0 ; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        for (int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] visited = new boolean[N + 1];
        int count = 0;
        for (int i = 1 ; i <= N ; i++){
            if(!visited[i]){
                bfs(visited,graph,i);
                count++;
            }
        }

        System.out.println(count);
    }

    static void bfs(boolean[] visited, ArrayList<Integer>[] graph, int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(Integer next : graph[cur]){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

    }
}
