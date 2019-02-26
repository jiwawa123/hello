package _2_15;/*
    user ji
    data 2019/2/26
    time 4:53 PM
*/

import java.util.HashMap;
import java.util.Map;

public class Jutice {
    public static void main(String[] args) {

    }

    public int findJudge(int N, int[][] trust) {
        int re[] = new int[N + 1];
        int arr[] = new int[N + 1];
        for (int i = 0; i < trust.length; i++) {
            re[trust[i][0]] = 1;
            arr[trust[i][1]] += 1;
            if (arr[trust[i][1]] == N - 1 && re[trust[i][1]] == 0)
                return trust[i][1];
        }
        return -1;
    }

    //象的遍历问题
    public int numRookCaptures(char[][] board) {
        boolean flag = false;
        int r = 0, c = 0;
        //开始寻找象
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]=='R'){
                    flag = true;
                    r = i;
                    c = j;
                    break;
                }
            }
        }
        int re = 0;
        int tr = r;
        //开始沿着四个方向查找不同的卒
        while(tr>=0&&board[tr][c]!='B'){
            if(board[tr][c]=='p')
                re++;
            tr--;
        }
        tr = r;
        while(tr<board.length&&board[tr][c]!='B'){
            if(board[tr][c]=='p')
                re++;
            tr++;
        }
        int tc = c;
        while(tc>=0&&board[r][tc]!='B'){
            if(board[r][tc]=='p')
                re++;
            tc--;
        }
        tc = c;
        while(tc<board[0].length&&board[r][tc]!='B'){
            if(board[r][tc]=='p')
                re++;
            tc++;
        }
        return re;
    }
}
