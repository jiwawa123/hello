package Dec5;

import java.util.*;

public class Combine {
    public static void main(String[] args) {

       new Combine().licenseKeyFormatting("r",1);
    }

    List<List<Integer>> list = new ArrayList();

    public List<List<Integer>> combinationSum3(int k, int n) {

        for (int i = 1; i <= 9; i++) {
            List<Integer> l = new ArrayList<>();
            l.add(i);
            if (i + (k - 1) > 9)
                break;
            else {
                addList(k - 1, l, n, i);
            }
        }
        return list;
    }

    public void addList(int k, List<Integer> l, int n, int start) {
        int temp = 0;
        List<Integer> ll = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            ll.add(l.get(i));
            temp += l.get(i);
        }
        if (temp > n)
            return;
        if (temp == n && k == 0)
            list.add(ll);
        for (int i = start + 1; i < 9; i++) {
            if (temp + i > n)
                return;
            List<Integer> lll = new ArrayList<>();
            for (int j = 0; j < ll.size(); j++) {
                lll.add(ll.get(j));
            }
            lll.add(i);
            addList(k - 1, lll, n, i);
        }
    }


    public int numFriendRequests(int[] ages) {

        int ans = 0;
        Arrays.sort(ages);
        for (int i = 0; i < ages.length; i++) {
            for (int j = i + 1; j < ages.length; j++) {
                if (firends(ages[i], ages[j]) == 1) {
                    ans++;
                } else {
                    break;
                }
                ans += firends(ages[i], ages[j]);
            }
        }
        for (int i = ages.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (firends(ages[i], ages[j]) == 1) {
                    ans++;
                } else {
                    break;
                }
            }
        }
        return ans;

    }

    public int firends(int a, int b) {

        if (b <= 0.5 * a + 7 || b > a || (a < 100 && b > 100)) {
            return 0;
        }
        return 1;
    }

    public int subarraySum(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (nums[i] == k) {
                ans++;
                continue;
            }
            if (nums[i] > k)
                break;
            for (int j = i + 1; j < nums.length; j++) {
                temp += nums[i];
                if (temp == k) {
                    ans++;
                }
                if (nums[i] > k)
                    break;
            }
        }
        return ans;
    }

    public int maximumSwap(int num) {
        int max = num;
        char a[] = ("" + num).toCharArray();
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                char te = a[i];
                a[i] = a[j];
                a[j] = te;
                max = Math.max(Integer.valueOf(String.valueOf(a)), max);
                te = a[i];
                a[i] = a[j];
                a[j] = te;
            }
        }
        return max;
    }

    public int maxProduct(int[] nums) {
        int min = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0)
                count++;
        }

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            min = Math.max(temp, min);
            for (int j = i + 1; j < nums.length; j++) {
                temp *= nums[j];
                min = Math.max(temp, min);
            }
        }
        return min;
    }

    public int minIncrementForUnique(int[] A) {
        Map<Integer, Integer> map = new HashMap();
        Arrays.sort(A);
        int count = 0;
        boolean flag[] = new boolean[A.length];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], 1);
                flag[i] = true;
            }
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }
        List<Integer> l = new ArrayList<>();
        for (int i = min + 1; i < max; i++) {
            if (!map.containsKey(i))
                l.add(i);
        }
        for (int i = 0; i < A.length; i++) {
            if (!flag[i]) {
                if (!l.isEmpty() && l.get(l.size() - 1) > A[i]) {
                    for (int j = 0; j < l.size(); j++) {
                        if (l.get(j) > A[i] && !map.containsKey(l.get(j))) {
                            map.put(l.get(j), 1);
                            count += l.get(j) - A[i];
                            l.remove(j);
                        }
                    }
                } else {
                    max += 1;
                    count += max - A[i];
                    max += 1;
                }
            }
        }
        return count;
    }

    public int smallestDistancePair(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                l.add(nums[i]);
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        Map<Integer, Integer> mm = new HashMap();
        int temp = 0;
        for (int i = 0; i < l.size(); i++) {
            temp += (map.get(l.get(i)) * (map.get(l.get(i)) - 1)) / 2;
        }
        if (temp >= k)
            return 0;
        int arr[] = new int[1000000];
        arr[0] = temp;
        for (int i = 0; i < l.size(); i++) {
            for (int j = i + 1; j < l.size(); j++) {
                int te = map.get(l.get(i)) * map.get(l.get(j));
                arr[Math.abs(l.get(i) - l.get(j))] += te;
            }
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += arr[i];
            if (count >= k)
                return i;
        }
        return 0;
    }

    public int rob(int[] nums) {
        if (null == nums || nums.length == 0 || nums.length == 2)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 3)
            return nums[1];
        int arr[] = new int[nums.length];
        int count = 0;
        arr[0] = nums[0];
        arr[1] = nums[1];
        for (int i = 2; i < nums.length - 1; i++) {
            arr[i] = Math.max(nums[i] + arr[i - 2], arr[i - 1]);
            count = Math.max(count, arr[i]);
        }
        arr[2] = nums[2];
        for (int i = 3; i <nums.length ; i++) {
            arr[i] = Math.max(nums[i] + arr[i - 2], arr[i - 1]);
            count = Math.max(count, arr[i]);
        }
        return count;
    }
    public int minSteps(int n) {
        if(n==1)
            return 0;
        if(n<=3)
            return n;
        if(isPrime(n))
            return n;
        int arr[] = new int[n+1];
        arr[1] = 0;
        arr[2] = 2;
        arr[3] = 3;
        for (int i = 4; i < n; i++) {
            if(isPrime(n)){
                arr[i] = n;
            }else{
                for (int j = i-1; j >=1; j--) {
                    if(i%j==0){
                        arr[i] = (i/j)*(arr[j]);
                    }
                }
            }
        }
        return arr[n+1];
    }
    public boolean isPrime(int n){
        if(n==2||n==3)
            return true;
        if(n%6!=1&&n%6!=5)
            return false;
        for (int i = 5; i <Math.sqrt(n)+1 ; i++) {
            if(n%i==0||n%(i+2)==0)
                return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        for (int i = 0; i < s2.length()-s1.length()+1; i++) {
            if(!s1.contains(s2.charAt(i)+""))
                continue;
            String str = s2.substring(i,i+s1.length());
            if(isAll(str,s1))
                return true;
        }
        return false;
    }
    public boolean isAll(String s1,String s2){
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        }
        for (int i = 0; i < s2.length(); i++) {
            if(!map.containsKey(s2.charAt(i))||map.get(s2.charAt(i))==0)
                return false;
            else
                map.put(s2.charAt(i),map.get(s2.charAt(i))-1);
        }
        return true;

    }
    public int findNumberOfLIS(int[] arr) {
        int res[] = new  int[arr.length];
        int cou[] = new  int[arr.length];
        Arrays.fill(res,1);
        Arrays.fill(cou,1);
        int max = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1; j >=0 ; j--) {
                if(arr[i]>arr[j])
                    res[i] = Math.max(res[j]+1,res[i]);
            }
            int count = 0;
            for (int j = 0; j <i ; j++) {
                if(res[j]==res[i]-1&&res[j]<res[i])
                    count+=res[j];
            }
            cou[i] = Math.max(cou[i],count);
            max = Math.max(max,res[i]);
        }
        if(max==1)
            return arr.length;
        int count = 0;
        for (int i = 0; i <arr.length ; i++) {
            if(res[i] ==max)
                count+=cou[i];
        }
        return count;
    }
    public String licenseKeyFormatting(String S, int K) {
        S = S.toUpperCase();
        S = S.replaceAll("-","");
        if(S.length()<=K)
            return S;
        StringBuffer temp = new StringBuffer();
        int i = 0;
        for ( i = S.length(); i >=0 ; i-=K) {

            if(i-K>0){
                temp = new StringBuffer(S.substring(i-K,i)).append(temp);
                temp= new StringBuffer("-").append(temp);
            }else{
                break;
            }
        }
        if(i!=0){
            if(temp.charAt(0)=='-')
                temp = new StringBuffer(S.substring(0,i)).append(temp);
            else
                temp = new StringBuffer(S.substring(0,i)).append(temp).append("-").append(temp);
        }
        return  temp.toString();
    }

}
