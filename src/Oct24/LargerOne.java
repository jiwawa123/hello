package Oct24;

public class LargerOne {
    public static void main(String[] args) {
        int array[] = {7,1,5,3,6,4,10};
        System.out.println(new LargerOne().mostPro(array));
    }
    public int find(int array[]){
        if(array.length==0)
            return 0;
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i]==1){
                array[i] = array[i-1]+1;
                result =Math.max(result,array[i]);
            }else{
                array[i] = 0;
            }
        }
        return result;
    }
    public boolean detectCapitalUse(String word) {
        int count = 0;
        boolean flag = false;
        if(word.length()==0)
            return true;
        if(word.charAt(0)>='A'&&word.charAt(0)<='Z'){
            flag = !flag;
            count++;
        }
        for (int i = 1; i < word.length(); i++) {
            if(word.charAt(i)>='A'&&word.charAt(i)<='Z')
                count ++;
        }
        return count==word.length()||(count==1&&flag)||count==0;
    }
    public int mostPro(int array[]){
        int maxPro = 0, tmp = 0;
        for (int i = 1; i < array.length; i++) {
            tmp = array[i] - array[i-1];
            if (tmp > 0)
                maxPro += tmp;
        }
        return maxPro;
    }
}
