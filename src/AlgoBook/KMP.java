package AlgoBook;

import java.lang.reflect.Array;
import java.util.Arrays;

//自己写一个字符串匹配算法
public class KMP {
    public static void main(String[] args) {
        String str1 = "ababc";
        int arr[] = new KMP().buildNext(str1);
        System.out.println(Arrays.toString(arr));
    }

    //创建next数组
    public int[] buildNext(String str) {
        int next[] = new int[str.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < str.length(); i++) {
            while (j > 0 && str.charAt(j) != str.charAt(i)) {
                j = next[j - 1];
            }
            if (str.charAt(i) == str.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;

    }

    public int kmp(String str, String dest) {//str文本串  dest 模式串
        int next[] = buildNext(dest);
        for (int i = 0, j = 0; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            if (str.charAt(i) == dest.charAt(j)) {
                j++;
            }
            if (j == dest.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }
    //其实就是寻找最长重复子序列
    public int[] buildMyNext(String str) {
        int next[] = new int[str.length()];
        next[0] = 0;
        for (int i = 1,j=0; i < str.length(); i++) {
            while(j>0&&str.charAt(i)!=str.charAt(j)){
                j = next[j-1];
            }
            if(str.charAt(i)==str.charAt(j))
                j++;
            next[i] = j;
        }
        return next;
    }
}
