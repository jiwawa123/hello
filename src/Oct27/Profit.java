package Oct27;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Profit {
    class ProfitNode {
        public int diff;
        public int profit;

        public ProfitNode(int diff, int profit) {
            this.diff = diff;
            this.profit = profit;
        }
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<ProfitNode> list = new ArrayList<>();
        for (int i = 0; i < difficulty.length; i++) {
            list.add(new ProfitNode(difficulty[i], profit[i]));
        }
        Collections.sort(list, new Comparator<ProfitNode>() {
            @Override
            public int compare(ProfitNode o1, ProfitNode o2) {
                return o2.profit - o1.profit;
            }
        });
        int count = 0;
        for (int i = 0; i < worker.length; i++) {
            for (int j = list.size() - 1; j >= 0; j--) {
                if (worker[i] >= list.get(j).diff) {
                    count += list.get(j).profit;
                    break;
                }
            }
        }
        return count;
    }

    public int findShortestSubArray(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        Map<Integer, Integer> map = new HashMap();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            max = Math.max(max, map.get(nums[i]));
        }
        if (max == 1)
            return 1;
        List<Integer> list = new ArrayList();
        for (int k : map.keySet()
                ) {
            if (map.get(k) == max)
                list.add(k);
        }
        int re = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
            boolean f = false;
            int left = 0, right = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == temp) {
                    if (!f) {
                        f = true;
                        left = j;
                        right = j;
                    } else {
                        right = j;
                    }
                }
            }
            re = Math.min(re, right - left + 1);
        }

        return re;
    }

    public static void main(String[] args) {
        int g[] = {1,2,3,4,5};
        int c[] = {3,4,5,1,2};
        new Profit().canCompleteCircuit(g,c);

    }

    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int re = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                count++;
                re = Math.max(re, count);
            } else {
                count = 1;
            }
        }
        return re;
    }
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0)
            return 1;
        if(n==1)
            return 10;
        int arr[] = new int[n];
        arr[0] = 1;
        arr[1] = 10;
        int count = 10;
        for (int i = 2; i <= n; i++) {
            int temp = 1;
            int index = i;
            int t = 9;
            while(index>0){
                temp*=t--;
                index --;
            }
            int index1 = i;
            int tt = 9;
            int cou = 1;
            while(index1>1){
                cou*=tt--;
                index1--;
            }
            cou*=i;
            count+=cou+temp;
        }

        return count;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int arr[] = new int[nums.length-k];
        for (int i = 0; i < nums.length-k; i++) {
            int re = Integer.MIN_VALUE;
            for (int j = i; j < i+k; j++) {
                re = Math.max(re,nums[j]);
            }
            arr[i] = re;
        }
        return arr;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int g = gas[i] - cost[i];
            int tt = i+1;
            if(tt>=gas.length)
                tt = 0;
            while(tt!=i&&g>0){
                g = gas[tt] - cost[tt];
                tt++;
                if(tt>=gas.length)
                    tt = 0;
            }
            if(tt==i)
                return  i;
        }

        return -1;
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(null==rooms||rooms.size()==1)
            return true;
        boolean flag[] = new boolean[rooms.size()];
        Arrays.fill(flag,false);
        int count =1;
        flag[0] = true;
        List<Integer> list = rooms.get(0);
        Queue<Integer> queue = new LinkedList<>();
        for (int k:list
             ) {
            if(!flag[k]){
                flag[k] = true;
                count++;
                queue.add(k);
            }
        }
        while(!queue.isEmpty()){
            List<Integer> l = rooms.get(queue.remove());
            for (int k:list
                    ) {
                if(!flag[k]){
                    flag[k] = true;
                    count++;
                    queue.add(k);
                }
            }
        }
        return count == rooms.size();
    }

    public int binaryGap(int N) {

        String re = "";
        while(N>0){
            re+=N%2+"";
            N/=2;
        }
        int l = 0 , r = 0;
        int resu = 0;
        boolean flag = false;
        for (int i = 0; i < re.length(); i++) {
            if(re.charAt(i)=='1'){
                if(flag){
                    r = i;
                    resu = Math.max(resu,r - l);
                    l = r;
                }else{
                    r = l = i;
                    flag = true;
                }
            }

        }
        return resu;
    }
    public double largestTriangleArea(int[][] points) {
        double count = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                for (int k = j+1; k <points.length ; k++) {
                    double a = Math.sqrt((points[i][0]-points[j][0])*(points[i][0]-points[j][0])+(points[i][1]-points[j][1])*(points[i][1]-points[j][1]));
                    double b = Math.sqrt((points[i][0]-points[k][0])*(points[i][0]-points[k][0])+(points[i][1]-points[k][1])*(points[i][1]-points[k][1]));
                    double c = Math.sqrt((points[j][0]-points[k][0])*(points[j][0]-points[k][0])+(points[j][1]-points[k][1])*(points[j][1]-points[k][1]));
                    if(a+b>c&&a+c>b&&b+c>a){
                        count = Math.max(count,Area(a,b,c));
                    }
                }
            }
        }
        return count;
    }
    public double Area(double a,double b,double c){
        double p = (a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
    public boolean hasGroupsSizeX(int[] deck) {
        if(null==deck||deck.length==1)
            return false;
        Map<Integer,Integer> map = new HashMap<>();
        for (int k :deck
             ) {
            map.put(k,map.getOrDefault(k,0)+1);
        }
        int min = Integer.MAX_VALUE;
        for (int k:map.values()
             ) {
            min = Math.min(min,k);
        }
        if(min<2)
            return false;
        for (int k:map.values()
             ) {
            boolean flag = false;
            for (int i = 2; i <= min; i++) {
                if(min%i==0&&k%i==0){
                    flag = true;
                    break;
                }
            }
            if(!flag)
                return  false;

        }
        return true;
    }
    public String complexNumberMultiply(String a, String b) {
        String n1[] = a.split("\\+");
        String n2[] = b.split("\\+");
        int temp = Integer.valueOf(n1[0])*Integer.valueOf(n2[0]);
        n1[1] = n1[1].replaceAll("i","");
        n2[1] = n2[1].replaceAll("i","");
        int t1 = Integer.valueOf(n1[0])*Integer.valueOf(n2[1]);
        t1+=Integer.valueOf(n2[0])*Integer.valueOf(n1[1]);
        temp += -Integer.valueOf(n1[1])*Integer.valueOf(n2[1]);
        return temp+"+"+t1+"i";
    }
}
