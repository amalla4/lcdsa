/*
 * 
 * 
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. 
he relative order of the elements should be kept the same.
Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array 
nums. More formally, if there are k elements after 
removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Example 1:
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

 */

 /*
  ***************SOLUTION:*****************
  - variable'first' initialized to 0 - for index 0 (first element) ==> nums[first]
    'first' keeps track of unique elements in nums array

  - loop through array nums starting from index 1 (second element) ==> nums[i]
    'i' is used to iterate through nums and compare current element with previous element  

  - if(nums[i]!=nums[first]){
    }
    checks if current element unique from previous element
    nums[1]!=nums[0]  (false) 
    nums[2]!=nums[1]  (true)    --->first++; = 0++; = 1; 
    nums[3]!=nums[2]  (true)    --->first++; = 1++; = 2;

    - Bc its unique, assign current element at 'i' to new unique element at 'first'
    nums[first] = nums[i];  

    - at this point, first = 2.
        After iteration completed, function returns 'first + 1' as the total num of unique elements
        (one added bc variable 'first' initialized to '0')

    Input: nums = [1,1,2,3]
    Output: 3, nums = [1,2,3,_]

    works bc sorted array
  - 
  */

class RemoveDuplicatesFromSortedArray{
    public int removeDuplicates(int[] nums){
        //track unique elements
        int first = 0;

        for(int i = 1; i < nums.length ; i++){
            if(nums[i]!=nums[first]){
                //if unique increment tracker
                first++;
                //asign unique element at 'i' to nums[first]
                nums[first] = nums[i];
            }
        }
        return first+1;
    }
}