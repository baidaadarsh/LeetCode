# 674. Longest Continuous Increasing Subsequence - Easy
## Question:

Given an unsorted array of integers nums, return the length of the longest continuous increasing subsequence (i.e. subarray). The subsequence must be strictly increasing.

A continuous increasing subsequence is defined by two indices l and r (l < r) such that it is [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] and for each l <= i < r, nums[i] < nums[i + 1].

 

Example 1:

Input: nums = [1,3,5,4,7]
Output: 3
Explanation: The longest continuous increasing subsequence is [1,3,5] with length 3.
Even though [1,3,5,7] is an increasing subsequence, it is not continuous as elements 5 and 7 are separated by element
4.
Example 2:

Input: nums = [2,2,2,2,2]
Output: 1
Explanation: The longest continuous increasing subsequence is [2] with length 1. Note that it must be strictly
increasing.
 

Constraints:

0 <= nums.length <= 104
-109 <= nums[i] <= 109

## My Solution:(Simple Approach: Intuition)
```
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0)
            return 0;
        int i, count = 1, maxCount = 0;
        for(i = 0; i < nums.length - 1; i++) {
            if(nums[i] < nums[i + 1])
                count++;
            else {
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
        }
        return Math.max(maxCount, count);
    }
}
```

## Leetcode Solution:(Sliding Window Approach)
```
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int ans = 0, anchor = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i-1] >= nums[i]) anchor = i;
            ans = Math.max(ans, i - anchor + 1);
        }
        return ans;
    }
}
```

## Approach:
1. Intuition: Time complexity: O(n), Space complexity: O(1)
2. Sliding Window: Time Complexity: O(n), Space Complexity: O(1)

## Learnings:
1. Sliding window concept.(Anchor Concept)
