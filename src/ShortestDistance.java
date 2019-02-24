public class ShortestDistance {
    public static void main(String[] args) {
        ShortestDistance shortestDistance = new ShortestDistance();

        shortestDistance.shortestToChar("loveCode",'e');
    }
    public int[] shortestToChar(String S, char C) {
        /*int[] result = new int[S.length()];
        for (int i = 0; i <S.length() ; i++) {
            result[i] = S.length()+1;
            if(S.charAt(i)==C)
            {
                result[i] = 0;
                if(i<S.length()-1)
                    result[i+1] = 1;
                if(i>0)
                    result[i-1] = Math.min(result[i-1],1);
            }
        }
        return result;*/
        int N = S.length();
        int[] ans = new int[N];
        int prev = Integer.MIN_VALUE / 2;

        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == C) prev = i;
            
            ans[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;
        for (int i = N-1; i >= 0; --i) {
            if (S.charAt(i) == C) prev = i;

            ans[i] = Math.min(ans[i], prev - i);
        }

        return ans;
    }
}
