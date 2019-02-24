package Oct15;

import java.util.*;

public class SubSum {
    public static void main(String[] args) {
        int arr[] = {3,0,6,1,5};
        System.out.println(new SubSum().hIndex(arr));
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++)
            sum+=nums[i];
        boolean[] v=new boolean[n];
        if(sum%k!=0)
            return false;
        return dfs(nums,k,sum/k,0,0,v);
    }
    public static boolean dfs(int[] nums,int k,int target,int sum,int s,boolean[] v){
        if(k==1)
            return true;
        if(target<0)
            return false;
        if(target==sum)
            return dfs(nums,k-1,target,0,0,v);
        for(int i=s;i<nums.length;i++){
            if(v[i])
                continue;
            v[i]=true;
            if(dfs(nums,k,target,sum+nums[i],i+1,v))
                return true;
            v[i]=false;
        }
        return false;
    }
    public int hIndex(int[] citations) {
        if(citations==null||citations.length==0)
            return 0;
        if(citations.length==1)
            return 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < citations.length; i++) {
            int count = 0;
            for (int j = 0; j < citations.length; j++) {
                if(citations[j]>=i+1)
                    count++;
            }
            if(count<=i+1)
                max = Math.max(max,i+1);
        }
        return max;
    }
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int arr[] = new int[2];
                arr[0] = nums1[i];
                arr[1] = nums2[j];
                list.add(arr);
            }
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] - o1[2]) - (o2[0] - o2[2]);
            }
        });
        List<int[]> re = new ArrayList<>();
        int index = 0;
        while(index<k&&index<list.size()){
            re.add(list.get(index));
        }
        return re;
    }
    public double largestSumOfAverages(int[] A, int K) {
        Arrays.sort(A);
        boolean flag[] = new boolean[A.length];
        double re = 0.0;
        int i = 1;
        while(K>1){
            re+=A[A.length-i];
            flag[A.length-i] = true;
            K--;
            i++;
        }
        int count = 0;
        int left = 0;
        for (int j = 0; j < flag.length; j++) {
            if(!flag[j]){
                count+=A[j];
                left++;
            }
        }
        return re+1.0*count/left;
    }

    public String replaceWords(List<String> dict, String sentence) {
        Map<Character,List<String>> map = new HashMap<>();
        for (int i = 0; i < dict.size(); i++) {
            if(map.containsKey(dict.get(i).charAt(0))){
                List<String> l = map.get(dict.get(i).charAt(0));
                l.add(dict.get(i));
                map.put(dict.get(i).charAt(0),l);
            }else{
                List<String> l = new ArrayList<>();
                l.add(dict.get(i));
                map.put(dict.get(i).charAt(0),l);
            }
        }
        String str[] = sentence.split(" ");
        StringBuffer re = new StringBuffer();
        for (String temp:str
             ) {
            if(!map.containsKey(temp.charAt(0))){
                re.append(temp+" ");
            }else{
                List<String> l = map.get(temp.charAt(0));
                int min = Integer.MAX_VALUE;
                for(String t :l){
                    if(temp.length()>=t.length()&&temp.substring(0,t.length()).equals(t)&&min>t.length()){

                            temp =t;
                            min = t.length();


                    }
                }
                re.append(temp+" ");
            }
        }
        return re.toString().trim();
    }

}
