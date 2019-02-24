package Dec18;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class IsS {
    /*判断一个statck的出栈是否合理，判断入栈的元素与出栈的元素是否相同，如果相同就出栈，
    如果不相同就入栈，最后判断是栈是否为空
     */
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length!=popped.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        int i = 0,j =0;
        while(i<pushed.length&&j<popped.length){
            if(pushed[i]!=popped[j]){
                stack.push(pushed[i]);
                i++;
            }else{
                j++;
                i++;
                while(!stack.isEmpty()&&j<popped.length&&stack.peek()==popped[j]){
                    stack.pop();
                    j++;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int array[] = {4,3,5,1,2};
        System.out.println(validateStackSequences(arr,array));
    }
    public int[] deckRevealedIncreasing(int[] deck) {
        if(deck.length<=1)
            return deck;
        int res[] = new int[deck.length];
        Arrays.sort(deck);
        
        return res;
    }
    public boolean isIdealPermutation(int[] A) {
        int all = 0,local = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i+1; j < A.length; j++) {
                if(A[i]>A[j])
                    all++;
            }
        }
        for (int i = 0; i <A.length -1; i++) {
            if(A[i]>A[i+1])
                local++;
        }
        return all==local;
    }
    public int[] advantageCount(int[] A, int[] B) {
        int n = A.length;
        int tmpA[] = new int[n];
        int tmpB[] = new int[n];
        int res[] = new int[n];
        int tmp[] = new int[n];
        for (int i = 0; i < n; i++) {
            tmpA[i] = A[i];
            tmpB[i] = B[i];
        }
        Arrays.sort(tmpA);
        Arrays.sort(tmpB);
        for (int i = 0,j=0,K=0; i < tmpA.length; i++,j++)
        {
            if (tmpA[i] <= tmpB[j])
            {
                tmp[--n] = tmpA[i];
                j--;
            }
            else
            {
                tmp[K++] = tmpA[i];
            }
        }

        for (int i = 0; i < A.length; i++)
        {
            for (int j = 0; j < A.length; j++)
            {
                if (B[i] == tmpB[j])
                {
                    res[i] = tmp[j];
                    tmpB[j] = -1;
                    break;
                }
            }
        }
        return res;
    }
}
