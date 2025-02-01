package baekjoon.q1xxx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class j1167 {

    static List<List<int[]>> tree;
    static boolean[] visited;
    static int farthest = 0;
    static int maxDist = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        tree = new ArrayList<>(V+1);

        for (int i = 0; i <= V; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());

            while (true) {
                int child = Integer.parseInt(st.nextToken());
                if(child == -1) break;

                int weight = Integer.parseInt(st.nextToken());
                tree.get(node).add(new int[]{child, weight});
                tree.get(child).add(new int[]{node, weight});
            }
        }
        visited = new boolean[V+1];
        dfs(0,1);

        maxDist = 0;
        visited = new boolean[V+1];
        dfs(0, farthest);

        System.out.println(maxDist);
    }


    static void dfs(int distance, int root) {
        visited[root] = true;
        if (distance > maxDist) {
            maxDist = distance;
            farthest = root;
        }

        for (int[] neighbor : tree.get(root)) {
            int node = neighbor[0];
            int weight = neighbor[1];

            if (!visited[node]) dfs(distance + weight, node);
        }
    }
}
