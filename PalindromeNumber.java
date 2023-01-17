/*
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 * Input= 121 (true), -121 (false bc it reads 121- backwards), 10 (false bc 01)
 * 
 */

class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        //negative numbers cannot be palindrome
        if (x < 0){
            return false;
        }
        /*
         * To reverse int x:
         * 1. isolate last digit: int lastDigit = x % 10;
         * 2. append last digit to variable that stores reversed number: int reverse = reverse*10 + lastDigit;
         * 3. remove last digit from the number: x = x / 10;
         * 4. interate while x > 0 
         * 
        */
        int originalNum = x;
        int reversedNum = 0;
        int lastDigit = 0;
        
        while(x>0){
        lastDigit = x % 10;
        reversedNum = (reversedNum * 10) + lastDigit;
        x = x / 10;
        }

        if(reversedNum == originalNum){
            return true; 
        }
       else return false;
    }
}