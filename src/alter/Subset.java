package alter;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    List<List<Integer>> subsets = new ArrayList<>();
    List<Integer> choosen = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        generateSublists(nums, 0);
        return subsets;
    }
    // 效率比较低下
    public void generateSublists(int[] list, int start) {

        subsets.add(new ArrayList<>(choosen));

        for (int i = start; i < list.length; i++) {
            // Choose
            int element = list[i];
            choosen.add(element);
            // Explore
            generateSublists(list, i + 1);

            // Unchoose
            choosen.remove(choosen.size() - 1);

        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2};
        Subset ss = new Subset();
        ss.subsets(arr);
    }
}
