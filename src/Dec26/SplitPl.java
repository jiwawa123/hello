package Dec26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitPl {

    public static void main(String[] args) {
        List<List<String>> lists = new SplitPl().dealSplit("aaba");
        for (List<String> list : lists
                ) {
            for (String tmp : list
                    ) {
                System.out.print(tmp + " ");
            }
            System.out.println();
        }
    }

    public boolean isPl(String s) {
        if (null == s)
            return true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }

    public void helper(List<List<String>> res, List<String> tmp, int start, String str) {
        if (start == str.length()) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i < str.length(); i++) {
            String stmp = str.substring(start, i+1);
            if (isPl(stmp)) {
                tmp.add(stmp);
                helper(res, tmp, i + 1, str);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public List<List<String>> dealSplit(String str) {
        List<List<String>> lists = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        helper(lists, tmp, 0, str);
        return lists;
    }

}
