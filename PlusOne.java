/*
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit 
 * of the integer. The digits are ordered from most significant to least significant in left-to-right order. The
 *  large integer does not contain any leading 0's.
 * 
 * 
Example 2:
Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].

Example 3:
Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
 
Constraints:
1 <= digits.length <= 100
0 <= digits[i] <= 9
digits does not contain any leading 0's.

 * 
 */
//******* SOLUTION- O(N) ********
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        for(int i = digits.length-1; i >=0 ; i--){
            //if last digit less than 9, increment and return array
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            //if last digit in array is 9, set it to 0
            digits[i]=0;
        }
        //if all digits in array are 9, create new array with size n+1,set first element to 0 and return
        int finalArr[] = new int[digits.length+1];
        finalArr[0] = 1;
        return finalArr;
    }  
}
