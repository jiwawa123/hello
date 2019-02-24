package Oct8;
/*
2018-10-08 czh
 */
public class FindMiddle {
    public static void main(String[] args) {
        int a[]  = {1,2,3};
        int b[] = {2,3,4};
        System.out.println(findMiddle(a,0,2,b,0,2));
    }
    public static double findMiddle(int[] a,int s1,int e1,int[] b,int s2,int e2){
        int mid1 = (s1+e1)/2;
        int m1 = a[mid1];
        int mid2 = (s2+e2)/2;
        int m2 = b[mid2];
        System.out.println(m1+" "+m2);
        if(m1 == m2)
            return m1;
        if(m1!=m2&&s1==e1&&s2==e2){
            return (double)((m1+m2)*1.0/2);
        }
        if(m1<m2)
            return findMiddle(a,mid1,e1,b,s2,mid2);
        return findMiddle(a,s1,mid1,b,mid2,e2);
    }
}
