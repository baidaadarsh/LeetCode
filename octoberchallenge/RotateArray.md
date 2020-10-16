# 189. Rotate Array - Medium
## Question:

Given an array, rotate the array to the right by k steps, where k is non-negative.

Follow up:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 

Constraints:

1 <= nums.length <= 2 * 104
-231 <= nums[i] <= 231 - 1
0 <= k <= 105

## Solution:(Reverse Approach)
```
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    public void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
```

## Solution:(Cyclic Replacements Approach)
```
class Solution {
    public void rotate(int[] nums, int k) {
        int count = 0, prev, current, next, temp;
        k %= nums.length;
       
        for(int start = 0; count < nums.length; start++) {
            prev = nums[start];
            current = start;
            do {
                next = (current + k) % nums.length;
                temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            }while(start != current);
        }
    }
}
```

## Approach:
1. Brute Force: traverse through the array k number of times. Time complexity: O(nk), Space complexity: O(1)
2. Optimzation using extra space: Copy the updated values into a new array. Time Complexity: O(n), Space Complexity: O(n)
3. Reverse Approach: Time Complexity: O(n), Space Complexity: O(1)
4. Cyclic Replacements Approach :Replacing elements (start + k) each time with k cycles. Time Complexity: O(n), Space Complexity: O(1)

## Learnings:
1. Simpler time complexity solutions can be thought of using % operator.
