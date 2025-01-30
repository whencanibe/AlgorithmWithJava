package baekjoon.q5XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class j5639 {

    static class Node{
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }

    static ArrayList<Integer> preorderList = new ArrayList<>();
    static int index = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null && !line.isEmpty()){
            preorderList.add(Integer.parseInt(line));
        }
        Node root = makeBst(Integer.MIN_VALUE, Integer.MAX_VALUE);

        printPostorder(root);
    }

    static Node makeBst(int min, int max){
        if(index >= preorderList.size()){
            return null;
        }
        int key = preorderList.get(index);
        if(key < min || key > max){
            return null;
        }

        Node node = new Node(key);
        index++;
        node.left = makeBst(min, key - 1);
        node.right = makeBst(key + 1, max);

        return node;
    }

    static void printPostorder(Node root){
        if(root == null) return;

        printPostorder(root.left);
        printPostorder(root.right);
        System.out.println(root.key);
    }
}
