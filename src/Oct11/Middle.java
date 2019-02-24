package Oct11;

public class Middle {
    public static void main(String[] args) {
        int[] arr = {1,2};
        int[] arr1 = {3,4};
        Middle middle = new Middle();
        System.out.println(middle.findMedianSortedArrays(arr1,arr));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int array[] = new int[nums1.length+nums2.length];
        int i = 0,j =0;
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]>nums2[j]){
                array[i+j] = nums2[j];
                j++;
            }else{
                array[i+j] = nums1[i];
                i++;
            }
        }
        while(i<nums1.length){
            array[i+j] = nums1[i];
            i++;
        }
        while(j<nums2.length){
            array[i+j] = nums2[j];
            j++;
        }
        if((nums1.length+nums2.length)%2==0){

            return 1.0*(array[(nums1.length+nums2.length)/2-1]+array[(nums1.length+nums2.length)/2])/2;
        }else{
            return array[(nums1.length+nums2.length)/2]*1.0;
        }

    }
}
