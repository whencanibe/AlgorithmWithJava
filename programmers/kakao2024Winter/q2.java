package programmers.kakao2024Winter;

import java.util.*;

class Solution2 {
    public int[] solution(int[][] edges) {
        int[] answer;
        int vertexNum = -1;

        for(int[] edge : edges){
            vertexNum = Math.max(vertexNum, edge[0]);
            vertexNum = Math.max(vertexNum, edge[1]);
        }

        int[] inward = new int[vertexNum + 1];
        int[] outward = new int[vertexNum + 1];
        boolean[] used = new boolean[vertexNum + 1];

        for(int[]edge : edges){
            int in = edge[1];
            int out = edge[0];
            inward[in]++;
            outward[out]++;
            used[in] = true;
            used[out] = true;
        }

        int newVertex = -1;
        for(int i = 1 ; i <= vertexNum ; i++){
            if(used[i] && inward[i] == 0 && outward[i] >= 2){
                newVertex = i;
                break;
            }
        }

        ArrayList<Integer>[] undirected = new ArrayList[vertexNum + 1];
        ArrayList<Integer>[] directed = new ArrayList[vertexNum + 1];

        for(int i = 1 ; i<= vertexNum ;i++){
            if(used[i] && i != newVertex){
                undirected[i] = new ArrayList<>();
                directed[i] = new ArrayList<>();
            }
        }

        for (int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(u == newVertex || v == newVertex){
                continue;
            }

            if(undirected[u] != null && undirected[v] != null){
                undirected[u].add(v);
                undirected[v].add(u);
            }

            if (directed[u] != null){
                directed[u].add(v);
            }
        }

        int[] compId = new int[vertexNum + 1];
        int compCount = 0;
        int[] compVertexCount = new int[vertexNum + 1];

        for(int i = 1; i <= vertexNum ; i++){
            if(used[i] && i != newVertex && compId[i] == 0){
                compCount++;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                compId[i] = compCount;
                int count = 0;
                while(!queue.isEmpty()){
                    int cur = queue.poll();
                    count++;
                    for(int next : undirected[cur]){
                        if(compId[next] == 0){
                            compId[next] = compCount;
                            queue.add(next);
                        }
                    }
                }
                compVertexCount[compCount] = count;
            }
        }

        int[] compEdgeCount = new int[compCount + 1];
        for(int i = 1 ; i <= vertexNum ; i++){
            if(used[i] && i != newVertex && directed != null){
                for (int next : directed[i]){
                    if(compId[next] == compId[i] && compId[next] != 0){
                        compEdgeCount[compId[i]]++;
                    }
                }
            }
        }

        int donut = 0, stick = 0, eight = 0;
        for(int comp = 1 ; comp <= compCount; comp++){
            int vCount = compVertexCount[comp];
            int eCount = compEdgeCount[comp];

            if(eCount == vCount){
                donut++;
            } else if(eCount == vCount - 1){
                stick++;
            } else if(eCount == vCount + 1){
                eight++;
            }
        }

        answer = new int[]{newVertex, donut, stick, eight};

        return answer;
    }
}