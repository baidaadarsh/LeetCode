# 832. Flipping an Image - Easy
## Question:

Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].

Example 1:

Input: [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
Example 2:

Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Notes:

1 <= A.length = A[0].length <= 20
0 <= A[i][j] <= 1

## My Solution:(Simple Approach: Intuition)
```
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int low, high;
        for(int i=0; i < A.length; i++) {
            low = 0;
            high = A[i].length - 1;
            while(low < high) {
                flip(A[i], low, high);
                A[i][low] = invert(A[i][low]);
                A[i][high] = invert(A[i][high]);
                low++;
                high--;
            }
            if(low == high)
                A[i][low] = invert(A[i][low]);
        }
        
        return A;
    }
    
    public void flip(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
    
    public int invert(int num) {
        return (num == 1)? 0 : 1;
    }
    
}
```

## Leetcode Solution:(Inference/Deduction Approach)
```
class Solution {
    public int[][] flipAndInvertImage(int[][] arr) {
        for(int i = 0; i < arr.length; i++)
            for(int l = 0, r = arr[i].length-1; l <= r; l++, r--) 
                if(arr[i][l] == arr[i][r]) {
                    arr[i][l] = 1-arr[i][l];
                    arr[i][r] = arr[i][l];
                }
        return arr;
    }
}
```

## Approach:
1. Intuition: Time complexity: O(n), Space complexity: O(1)
2. Inference/Deduction: Time Complexity: O(n), Space Complexity: O(1)

## Learnings:
1. Try to deduce inference from simple operations and corelate with input and the final result.
