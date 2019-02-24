package Oct24;


import Oct8.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public static void main(String[] args) {
       int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
       new ListNode(1).minFallingPathSum(arr);
    }
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] re = new ListNode[k];
        List<Integer> list = new ArrayList<>();
        while(root!=null)
        {
            list.add(root.val);
            root = root.next;
        }

        int index = 0;
        for (int i = 0; i < k; i++) {
            int len = (list.size()-index)/k;
            if((list.size()-index)%k!=0)
                len++;
            if(index>=list.size()){
                re[i] = null;
            }else{
                int temp = 0;
                ListNode ro = new ListNode(list.get(index));
                ListNode t = ro;
                while(temp<k&&index<list.size()){
                    t.next = new ListNode(list.get(index));
                    t = t.next;
                    index++;
                    temp++;
                }
                re[i] = ro;
            }
        }
        return re;
    }
    public int minFallingPathSum(int[][] A) {
        if(null==A||A.length==0)
            return 0;
        int m = A.length+1;
        int n = A[0].length+1;
        int arr[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            A[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            A[0][i] = 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int t = arr[i-1][j];
                if(j!=1){
                    t = Math.min(t,arr[i-1][j-1]);
                }
                if(j<n-1){
                     t = Math.min(t,arr[i-1][j+1]);
                }
                arr[i][j] = A[i-1][j-1]+t;
            }
        }
        int re = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            re = Math.min(re,arr[m-1][i]);
        }
        return re;
    }
    public ListNode partition(ListNode head, int x) {
        List<Integer> list  = new ArrayList<>();
        if(head==null)
            return null;
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        boolean flag[] = new boolean[list.size()];
        ListNode t = new ListNode(0);
        ListNode temp = t;
        int index = list.indexOf(x);
        //开始添加小于x的节点
        for(int i = 0;i<list.size();i++){
            if(list.get(i)<x){
                ListNode tt = new ListNode(list.get(i));
                temp.next = tt;
                temp = tt;
                flag[i] = true;
            }
        }
        for(int i = 0;i<list.size();i++){
            if(list.get(i)>x&&i<index){
                ListNode tt = new ListNode(list.get(i));
                temp.next = tt;
                temp = tt;
                flag[i] = true;
            }
        }
        for (int i = 0;i<flag.length;i++){
            if(!flag[i]){
                ListNode tt = new ListNode(list.get(i));
                temp.next = tt;
                temp = tt;
                flag[i] = true;
            }
        }
        return t.next;
    }

}
