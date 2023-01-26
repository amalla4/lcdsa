/*
 * 
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, 
 * representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. 
To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should 
be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * 
 */
/* 
 * Constraints:
nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109
 * 
 */
import java.util.Arrays;

public class MergeSortedArray {
    
    public static void main (String[] args){
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3; 
        int n = 3;
        mergeOptimal(nums1, m, nums2, n);
    }

    //SIMPLE solution
    /*
     * First copy elements from nums2 into nums1. Sort using built in Arrays.sort()
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //nums1.length = m+n
        for(int i=m,j=0;  i < nums1.length ; i++,j++){
            //copying nums2 into nums1
            nums1[i]=nums2[j];
        }
        Arrays.sort(nums1);
        
        System.out.println("Output: " );
        for(int i = 0; i < nums1.length; i++){
            System.out.print(nums1[i]);
        }
        System.out.println();
    }

     //OPTIMAL solution using in-place merge:
     /*
      * Use three pointers to keep track of position in nums1, nums2, mergedArray
      * Compare last elements of nums1 and nums2 --> place larger element at END of mergedArray
      * Decrement pointer and repeat
      * If one array is exhausted, the remaining elements in the other array are copied over to the merged array.
      * This is done in the while loops.
      * Time complexity of O(m+n) as we are iterating through both arrays once.
      * In-place merge, so the space complexity is O(1) as we are not using any extra space
      */
     public static void mergeOptimal(int[] nums1, int m, int[] nums2, int n) {
        //three pointers
        int i = m-1;
        int j = n-1;
        int k = m+n-1;  //merged array

        while(i>=0 && j >=0){
            if(nums1[i]>nums2[j]){
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        //required when i<0 but j>0
        //copy remaining elements of nums2 to the merged array
        while(j>=0){
            nums1[k--] = nums2[j--];
        }
        System.out.println("Output: " );
        for(int x = 0; x < nums1.length; x++){
            System.out.print(nums1[x]);
        }
        System.out.println();

    }

}
