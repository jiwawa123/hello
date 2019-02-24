package _2_15;

import java.util.*;

public class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval> list = new ArrayList<>();
        int i = 0, j = 0;
        int start = 0, end = 0;
        boolean flag = true;
        while (i < A.length && j < B.length) {
            if (A[i].end < B[j].start) {
                i++;
                continue;
            }
            if (B[j].end < A[i].start) {
                j++;
                continue;
            }
            if (A[i].start >= B[j].start) {
                start = A[i].start;
            } else {
                start = B[j].start;
            }
            if (A[i].end <= B[j].end) {
                end = A[i].end;
                i++;
            } else {
                end = B[j].end;
                j++;
            }
            list.add(new Interval(start, end));
        }

        Interval[] intervals = new Interval[list.size()];
        for (int k = 0; k < list.size(); k++) {
            intervals[k] = list.get(k);
        }
        return intervals;
    }

    public int numSubarraysWithSum(int[] A, int S) {
        int re = 0;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            count += A[i];
            if (count == S)
                re++;
            for (int j = i + 1; j < A.length; j++) {
                count += A[j];
                if (count == S)
                    re++;
            }
        }
        return re;
    }

    public String optimalDivision(int[] nums) {
        StringBuffer re = new StringBuffer("");
        if (nums != null) {
            re.append(nums[0]);
            if (nums.length == 2) {
                re.append("/");
                re.append(nums[1]);
                return re.toString();
            }
            if (nums.length > 2) {
                re.append("/");
                re.append("(");
                for (int i = 1; i < nums.length; i++) {
                    re.append(nums[i]);
                }
                re.append(")");
            }
        }

        return re.toString();
    }

    public int leastBricks(List<List<Integer>> wall) {
        int re = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < wall.size(); i++) {
            int count = 0;
            List<Integer> temp = wall.get(i);
            for (int j = 0; j < temp.size(); j++) {
                count += temp.get(j);
                re = Math.max(re, map.getOrDefault(count, 0) + 1);
                map.put(count, map.getOrDefault(count, 0) + 1);
            }
        }
        return re;
    }

    public int reversePairs(int[] nums) {
        int re = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if ((long) nums[i] > (long) 2 * nums[j])
                    re++;
            }
        }
        return re;
    }

    public int findMinDifference(List<String> timePoints) {
        if (timePoints == null)
            return 0;
        int re = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size(); i++) {
            for (int j = i + 1; j < timePoints.size(); j++) {
                re = Math.min(re, computer(timePoints.get(i), timePoints.get(j)));
            }
        }
        return re;
    }

    public int computer(String a, String b) {
        if (a.equals(b))
            return 0;
        int re = Integer.MAX_VALUE;
        String aa[] = a.split(":");
        String bb[] = b.split(":");
        int at = Integer.valueOf(aa[0]) * 60 + Integer.valueOf(aa[1]);
        int bt = Integer.valueOf(bb[0]) * 60 + Integer.valueOf(bb[1]);
        re = Math.min(Math.abs(at - bt), re);
        int t1 = Math.max(at, bt);
        int t2 = Math.min(at, bt);
        re = Math.min(re, t2 + (24 * 60 - t1));
        return re;
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while(index<asteroids.length){
            if(stack.isEmpty()||asteroids[index]>0||stack.peek()<0){
                stack.push(asteroids[index++]);
            }else{
                if (stack.peek() < -asteroids[index])
                    stack.pop();
                else if (stack.peek() > -asteroids[index])
                    index++;
                else
                {
                    stack.pop();
                    index++;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        int re[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            re[i] = list.get(list.size() - i - 1);
        }
        return re;
    }

    public static void main(String[] args) {
        int arr[] = {-2,-2,1,-2};
        new Interval().asteroidCollision(arr);
    }
}
