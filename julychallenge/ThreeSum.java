/*
3Sum

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
   Hide Hint #1  
So, we essentially need to find three numbers x, y, and z such that they add up to the given value. If we fix one of the numbers say x, we are left with the two-sum problem at hand!
   Hide Hint #2  
For the two-sum problem, if we fix one of the numbers, say
x
, we have to scan the entire array to find the next number
y
which is
value - x
where value is the input parameter. Can we change our array somehow so that this search becomes faster?
   Hide Hint #3  
The second train of thought for two-sum is, without changing the array, can we use additional space somehow? Like maybe a hash map to speed up the search?

Approach:
1. Using Two sum approach, 1st sort the array and then use two pointer concept.

*/

package julychallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
	
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		System.out.println(threeSum(nums));
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
        int i, j, k, len, sum;
        Set<List<Integer>> result =  new HashSet<List<Integer>>();
        
        len = nums.length;
        if(len < 3)
            return new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        for(i = 0; i < len - 2; i++) {
            j = i + 1;
            k = len - 1;
            while(j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                }
                else if(sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }            
        }
        
        return new ArrayList<List<Integer>>(result);
    }

}
