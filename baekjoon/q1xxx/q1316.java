package baekjoon.q1xxx;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class q1316 {

    public static boolean isGroup(String str) {
        ArrayList<Character> list = new ArrayList<Character>();
        boolean isConnected = false;
        boolean flag = false;

        list.add(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if( str.charAt(i-1) == str.charAt(i) ) {
                isConnected = true;
            } else {
                isConnected = false;
                if(!isConnected && list.contains(str.charAt(i))) {
                    flag = true;
                    break;
                }
                list.add(str.charAt(i));
            }
        }

        if(flag){
            return false;
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if(isGroup(s)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
