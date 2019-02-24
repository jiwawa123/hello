package Oct24;

import java.util.*;

public class LongChain {
    public int findLongestChain(int[][] pairs) {
        if(null==pairs||pairs.length==0)
            return 0;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < pairs.length; i++) {
            list.add(pairs[i]);
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o1[0] - o2[0];
                }else{
                    return o1[1] - o2[1];
                }
            }
        });
        int re = 1;
        int arr[] = new int[list.size()];
        Arrays.fill(arr,1);
        for (int i = 1; i < list.size(); i++) {
            int temp[] = list.get(i);
            for (int j = i-1; j >=0 ; j--) {
                int t[] = list.get(j);
                if(temp[0]>t[1]){
                    arr[i] = Math.max(arr[i],1+arr[j]);
                }
            }
            re = Math.max(arr[i],re);
        }
        return  re;
    }


    List<String> list = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {

        addDot(s,"",3);
        return  list;
    }
    private void addDot(String s,String result, int k){

        //传入字符串必须合法
        if(s.length() <= k){
            return;
        }
        if(s.length() > 3*(k+1)){
            return;
        }
        if(k == 0){//最后一段，判断小于256
            if((s.charAt(0) == '0' && s.length() > 1 ) || Integer.parseInt(s) >= 256)
                return;
            list.add(result + "." + s);
            return;
        }
        //遍历前面3位，如果小于256，则参与递归
        for(int i = 1; i <= s.length(); i++){
            String temp = s.substring(0,i);//当前段小于256，表示合法，可以继续
            if(Integer.parseInt(temp) < 256){
                String str = s.substring(i);
                //分情况，如果result为空，则前面不加"."
                if(result.length() > 0){
                    temp = result + "." + temp;
                }
                addDot(str,temp, k-1);
                //如果第一个数字为0，则不再继续循环
                if(s.charAt(0) == '0'){
                    break;
                }
            }else{
                break;
            }
        }
    }
    public int longestPalindromeSubseq(String s) {
        if(null==s||s.length()==0||s.equals(""))
            return 0;
        int arr[] = new int[s.length()];
        String str[] = new String[s.length()];
        Arrays.fill(arr,1);
        str[0] = s.charAt(0)+"";
        int re =1;
        for (int i = 1; i < s.length(); i++) {
            str[i] = s.charAt(i)+"";
            for (int j = i-1; j >=0 ; j--) {

                if(isPalind(str[j]+s.charAt(i))){
                    if(arr[j]+1>arr[i]){
                        str[i] = str[j]+s.charAt(i);
                        arr[i] = arr[j]+1;
                    }
                }
            }
            re = Math.max(re,arr[i]);
        }
        return re;
    }
    public boolean isPalind(String s){
        int i = 0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int arr[] = {1,0,0,0,1,0,1};
        System.out.println(new LongChain().maxDistToClosest(arr));
    }
    public int wiggleMaxLength(int[] nums) {
        if(nums.length<=2)
            return 0;
        int arr[] = new int[nums.length-1];
        for (int i = 1; i < nums.length; i++) {
            arr[i-1] = nums[i] - nums[i-1];
        }
        int tmp[] = new int[arr.length];
        Arrays.fill(tmp,1);
        int re = 0;
        for (int i = 1; i <arr.length ; i++) {
            if(arr[i]==0)
                continue;
            for (int j= i-1;j>=0;j--){
                if(arr[j]*arr[i]<0){
                    tmp[i] = Math.max(tmp[j]+1,tmp[i]);
                    break;
                }

            }
            re = Math.max(re,tmp[i]);
        }
        return re+1;
    }
    public boolean rotateString(String A, String B) {
        if(A.length()!=B.length())
            return false;
        if(A.equals(B))
            return true;
        int i = 0;
        while(i<A.length()){
            A = A.substring(1,A.length())+A.substring(0,1);
            if(A.equals(B))
                return  true;
            i++;
        }
        return false;
    }
    public String reverseVowels(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('a',1);
        map.put('e',1);
        map.put('i',1);
        map.put('o',1);
        map.put('u',1);
        map.put('A',1);
        map.put('E',1);
        map.put('I',1);
        map.put('O',1);
        map.put('U',1);
        char tp[] = s.toCharArray();
        int i = 0,j=s.length()-1;
        while(i<j){
            if(!map.containsKey(tp[i])){
                i++;
            }else{
                if(!map.containsKey(tp[j])){
                    j--;
                }
                if(i<j){
                    char tmp = tp[i];
                    tp[i] = tp[j];
                    tp[j] = tmp;
                }
            }
        }
        return String.valueOf(tp);
    }
    public int maxDistToClosest(int[] seats) {
        int re = 0;
        for (int i = 0; i <seats.length ; i++) {
            int left = 0 ;
            int right = 0;
            int temp = 0;
            boolean l = false;
            boolean r = false;
            if(seats[i]!=0)
                continue;

            for (int j = i-1; j >=0 ; j--) {
                l = true;
                if(seats[j]==0){
                    left = Math.max(left,i-j);
                }else{
                    left = Math.max(left,i-j);
                    break;
                }
            }
            for (int j = i+1; j <seats.length ; j++) {
                r = true;
                if(seats[j]==0){
                    right = Math.max(right,j-i);
                }else{
                    right = Math.max(right,j-i);
                    break;
                }
            }
            if(l&&r)
                temp = Math.min(left,right);
            else if(l)
                temp = left;
            else
                temp = right;
            re = Math.max(temp,re);
        }
        return re;
    }

    public int[] constructRectangle(int area) {
        int arr[] = new int[2];
        int q =(int)Math.sqrt(area);
        int p = (int)Math.sqrt(area);
        while(p*q!=area){
            if(p*q<area){
                q++;
            }else
                p--;
        }
        arr[0] = q;
        arr[1] = p;
        return arr;
    }
}
