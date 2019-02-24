package Oct15;
public class NoAdd {
    public static void main(String[] args) {
        NoAdd noAdd = new NoAdd();
        System.out.println(noAdd.noAdd1(2,3));
        System.out.println(noAdd.myNoAdd(3,5));
    }
    public int noAdd1(int a,int b){
        if (0 == b)
            return a;
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return noAdd1(sum, carry);
    }
    public int myNoAdd(int a,int b){
        if(b==0)
            return a;
        return myNoAdd(a^b,(a&b)<<1);
    }
    public int no_add(int a,int b){
        if(b==0)
            return  a;
        return no_add(a^b,(a&b)<<1);
    }
}
