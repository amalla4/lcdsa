import java.util.HashMap;
import java.util.Map;
/*
 * 
Given an array of integers 'nums' and an integer 'target', return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]
*
*
 */

//Solution I: Brute Force with nested loops -  O(n^2)

class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; i < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
    return new int[]{};
    }
}

//Solution II: Using HashMap - O(n) - linear time complexity
//Only loops through the array once
//Detailed explanation here - https://www.youtube.com/watch?v=Yyyi12oaK94

//map is a collection of key-value (K-V) pairs
//lookup is fast (in constant time) in a hashmap

/*
 Example:
 nums = [3,2,4]     target = 6 

 HashMap:
 Key -> Value 
 (Key: target - nums[index] ) -> (value: index)
 
 3 -> 0 (bc 3 needs to be added to 3 to get target - 6)
 4 -> 1 (bc 4 needs to be added to 2 to get target - 6)

 next is index 2 in nums array, i.e nums[2] = 4
 we see 4 already exists as a key in the hashmap (4 -> 1)
 This tells us that nums[2] can be added to nums[1] to get target. 
 * 
 */

class TwoSumHashMap {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> complements = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            //hashmap get() to retrieve the value(index) associated with the key(nums[i])
            Integer complementIndex = complements.get(nums[i]);
            if (complementIndex != null) {
                return new int[] {complementIndex, i};
            }
            complements.put(target - nums[i], i);
        }
        return new int[]{};
    }
}