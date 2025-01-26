package baekjoon.q1xxx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class j1967 {

    public static int goLeft(List<List<int[]>> tree, int n) {
        if(tree.get(n).isEmpty()) return 0;

        int result = tree.get(n).get(0)[1];
        return result + goLeft(tree, tree.get(n).get(0)[0]);
    }

    public static int goRight(List<List<int[]>> tree, int n) {
        if(tree.get(n).isEmpty() || tree.get(n).size() < 2) return 0;

        int result = tree.get(n).get(1)[1];
        return result + goRight(tree, tree.get(n).get(1)[0]);
    }

    public static void main(String[] args) throws IOException {
        //N 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<List<int[]>> tree = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        //부모 자식 간선가중치 n-1개 줄 입력받기. 알아서 부모 작은순, 부모 같으면 자식 작은순 입력됨
        for (int i = 1; i <= N-1; i++) {
            String[] s = br.readLine().split(" ");
            tree.get(Integer.parseInt(s[0])).add(new int[]{Integer.parseInt(s[1]), Integer.parseInt(s[2])});
        }
        // 노드 별로 왼쪽으로만 쭉 가고 오른쪽으로만 쭉가서 그 값을 더하고 반환함. 그 반환 값을 max 함수 이용해서 최댓값을 저장시킴
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            int res = goRight(tree, i) + goLeft(tree, i);
            max = Math.max(max, res);
        }
//        System.out.println(tree.get(6).get(1)[0] + " " + tree.get(6).get(1)[1]);
        System.out.println(max);
    }
}
