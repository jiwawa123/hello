package Oct22;

import java.util.Stack;

public class LRL {
    public static void main(String[] args) {
        int array[] = {1};
        System.out.println(new LRL().findByStack(array));
        //System.out.println((int)Math.sqrt(35099627));
    }

    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        //存放每一个height[i]的矩形面积
        int[] area = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            int curarea = height[i];
            area[i] = height[i];
            //向右边加
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] < curarea)
                    break;
                else
                    area[i] += curarea;
            }
            //向左边加
            for (int k = i - 1; k >= 0; k--) {
                if (height[k] < curarea)
                    break;
                else
                    area[i] += curarea;
            }
        }
        //找出area[i]中最大的值
        int max = 0;
        for (int i = 0; i < area.length; i++) {
            System.out.print(area[i] + " ");
            if (area[i] > max)
                max = area[i];
        }
        return max;
    }

    public int MyLargeRectangleArea(int[] array) {
        int result = 0;
        int arr[] = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arr[i] = array[i];
            int current = array[i];
            //向左遍历
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] < current) {
                    break;
                } else {
                    arr[i] += current;
                }
            }
            //向右遍历
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < current)
                    break;
                arr[i] += current;
            }
            result = Math.max(result, arr[i]);
        }
        return result;
    }
    public int mySqrt(int x) {
        return (int)Math.sqrt(x);
    }

    public int findByStack(int array[]){
        int result = 0;
        if(array.length==0){
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            while(!stack.isEmpty()&&array[stack.peek()]>=array[i]){
                int index = stack.pop();
                int k = stack.empty()?-1:stack.peek();
                result = Math.max(result,array[index]*(i-k-1));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()&&array[stack.peek()]>=0){
            int index = stack.pop();
            int k = stack.empty()?-1:stack.peek();
            result = Math.max(result,array[index]*(array.length-k-1));
        }
        return result;
    }
}
