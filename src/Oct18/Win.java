package Oct18;

public class Win {
    public static void main(String[] args) {

    }

    public boolean PredictTheWinner(int[] nums) {
        if (nums.length % 2 == 0)
            return true;
        else {
            int a = 0;
            boolean flag = true;
            if (nums[0] > nums[nums.length - 1]) {
                a = nums[0];
            } else {
                a = nums[nums.length - 1];
                flag = !flag;
            }
            if(flag){
                int m = 0,n = 1;
                for (int i = 1; i <nums.length ; i+=2) {
                    m+=nums[i];
                }
                for (int i = 2; i <nums.length ; i+=2) {
                    n+=nums[i];
                }
                return a>=Math.abs(m-n);
            }else{
                int m = 0,n = 1;
                for (int i = 0; i <nums.length-1 ; i+=2) {
                    m+=nums[i];
                }
                for (int i = 1; i <nums.length-1; i+=2) {
                    n+=nums[i];
                }
                return a>=Math.abs(m-n);
            }
        }
    }
}
