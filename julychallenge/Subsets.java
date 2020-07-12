/*

Subsets

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

Approach:
1. Using Binary Numbers & Masking
		
*/
package leetcode.julychallenge;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
        int len, possibleSets, j, k;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        len = nums.length;
        possibleSets = (int) Math.pow(2, len);
        for(j = 0; j < possibleSets; j++) {
            List<Integer> tempList = new ArrayList<Integer>();
            for(k = 0; k < len; k++) {
                if((j & (1 << k)) > 0) {
                    tempList.add(nums[k]);
                }
            }
            result.add(tempList);
        }
        return result;
    }
}
