package baekjoon.q11xxx;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class q11725 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> tree = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        boolean[] visited = new boolean[n+1];
        Map<Integer, Integer> parents = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        visited[1] = true;
        while(!queue.isEmpty()) {
            int currentNode = queue.poll();
            for( int neighbor : tree.get(currentNode)) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    parents.put(neighbor, currentNode);
                    queue.add(neighbor);
                }
            }
        }

        for (int i = 2 ; i <= n; i++) {
            System.out.println(parents.get(i));
        }

        br.close();
    }
}
