package Oct15;

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

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0)
            return null;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        List<Interval> l = new ArrayList<>();
        if (intervals.size() == 1) {
            l.add(intervals.get(0));
            return l;
        }
        Interval temp = new Interval();
        temp.start = intervals.get(0).start;
        temp.end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            if (temp.end < intervals.get(i).start) {
                l.add(temp);
                temp = new Interval();
                temp.start = intervals.get(i).start;
                temp.end = intervals.get(i).end;
            } else {
                temp.end = Math.max(temp.end, intervals.get(i).end);
            }
        }
        l.add(temp);
        return l;
    }

    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }



    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            Map<Character, Integer> temp = new HashMap<>();
            for (int j = 0; j < B[i].length(); j++) {
                temp.put(B[i].charAt(j), temp.getOrDefault(B[i].charAt(i), 0) + 1);
            }
            for (Character c : temp.keySet()
                    ) {
                map.put(c, Math.max(map.getOrDefault(c, 0), temp.get(c)));
            }
        }
        for (int i = 0; i < A.length; i++) {
            Map<Character, Integer> temp = new HashMap<>();
            for (int j = 0; j < A[i].length(); j++) {
                temp.put(A[i].charAt(j), temp.getOrDefault(A[i].charAt(i), 0) + 1);
            }
            boolean flag = true;
            for (Character c : map.keySet()
                    ) {
                if (!temp.containsKey(c) || temp.get(c) < map.get(c)) {
                    flag = false;
                    break;
                }

            }
            if (flag)
                list.add(A[i]);
        }
        return list;
    }

    public String[] findWords(String[] words) {
        if (words.length < 1)
            return words;
        String[] str = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[i].length(); j++) {
                map.put(str[i].charAt(j), i);
            }
        }
        String re = "";
        for (int i = 0; i < words.length; i++) {
            String temp = words[i].toLowerCase();
            int s = map.get(temp.charAt(0));
            boolean flag = true;

            for (int j = 1; j < temp.length(); j++) {
                if (map.get(temp.charAt(j)) != s) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                re += words[i] + " ";

        }
        if (re.length() == 0) {
            return new String[0];
        }
        return re.split(" ");
    }

    public int[] shortestToChar(String S, char C) {
        int arr[] = new int[S.length()];
        Arrays.fill(arr, Integer.MAX_VALUE);
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C)
                arr[i] = 0;
            else {
                for (int j = i - 1; j >= 0; j--) {
                    if (S.charAt(j) == C) {
                        arr[i] = i - j;
                        break;
                    }
                }
                for (int j = i + 1; j < S.length(); j++) {
                    if (S.charAt(j) == C) {
                        arr[i] = Math.min(arr[i], j - i);
                        break;
                    }
                }

            }
        }
        return arr;
    }

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        int index = 1;
        while (index <= n) {
            if(index%15==0)
                list.add("FizzBuzz");
            else if(index%3==0)
                list.add("Fizz");
            else if(index%5==0)
                list.add("Buzz");
            else
                list.add(index+"");
        }
        return list;
    }
    public int compress(char[] chars) {
        if(chars.length<=1)
            return chars.length;
        String re = "";
        int j = 0;
        while(j<chars.length){
            char temp = chars[j];
            int index = 0;
            while(j<chars.length&&chars[j++]==temp){
                index++;
            }
            re+=temp+"";
            if(index!=0)
                re+=index+"";
        }
        for(int i = 0;i<re.length();i++)
            chars[i] = re.charAt(i);
        return re.length();
    }
    public boolean buddyStrings(String A, String B) {
        if(A.length()!=B.length())
            return false;
        if(A.length()<=1)
            return false;
        if(A.equals(B)){
            Map<Character,Integer> map = new HashMap<>();
            for (int i = 0; i < A.length(); i++) {
                if(map.containsKey(A.charAt(i)))
                    return true;
                else
                    map.put(A.charAt(i),1);
            }
        }
        int count = 0;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if(A.charAt(i)!=B.charAt(i)){
                list.add(A.charAt(i));
                list.add(B.charAt(i));
                count++;
            }
            if(count>2)
                return  false;

        }
        if(count!=2)
            return false;
        else
            return list.get(0)==list.get(3)&&list.get(1)==list.get(2);


    }
    public int repeatedStringMatch(String A, String B) {
        if(A==null)
            return 0;
        if(A.equals(B)||A.contains(B))
            return 1;
        for (int i = 0; i < B.length(); i++) {
            if(A.indexOf(B.charAt(i))==-1)
                return 0;
        }
        int count = 1;
        String temp =A;
        while(!A.contains(B)){
            A+=temp;
            count++;
        }
        return count;
    }
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0],y1 = rec1[1],x2 = rec1[2],y2 = rec1[3];
        int xx1 = rec2[0],yy1 = rec2[1],xx2 = rec2[2],yy2 = rec2[3];
        if(xx1>x1&&xx1<x2){
            if(yy1>y1&&yy1<yy2)
                return true;
        }
        if(x1>xx1&&x1<xx2){
            if(y1>yy1&&y1<yy2)
                return true;
        }
        return  false;
    }
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int a=Math.max(A,E),b=Math.max(B,F),c=Math.min(C,G),d=Math.min(D,H);
        if(c>a && d>b) return (C-A)*(D-B)+(G-E)*(H-F)-(c-a)*(d-b);
        else return (C-A)*(D-B)+(G-E)*(H-F);
    }
    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals.length<=1)
            return 0;
        Map<Interval,Integer> map = new HashMap<>();
        List<Interval> list = new ArrayList<>();
        for (Interval inter:intervals
                ) {
            if(!map.containsKey(inter)){
                map.put(inter,1);
                list.add(inter);
            }
        }
        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start!=o2.start){
                    return o1.start - o2.start;
                }else{
                    return o1.end - o2.end;
                }
            }
        });

        int arr[] = new int[list.size()];
        Arrays.fill(arr,1);
        int re = Integer.MIN_VALUE;
        for (int i = 1; i < list.size(); i++) {
            Interval temp = list.get(i);
            for (int j = i-1; j < list.size(); j++) {
               Interval tt = list.get(j);
               if(temp.start>tt.end){
                   arr[i] = Math.max(arr[i],1+arr[j]);
               }
            }
            re = Math.max(re,arr[i]);
        }
        return intervals.length - re;
    }
    public static void main(String[] args) {
        System.out.println(new Interval().computeArea(0,0,1,1,1,0,2,1));
    }
}
