/*

Maximum Width of Binary Tree

Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

Example 1:

Input: 

           1
         /   \
        3     2
       / \     \  
      5   3     9 

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:

Input: 

          1
         /  
        3    
       / \       
      5   3     

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
Example 3:

Input: 

          1
         / \
        3   2 
       /        
      5      

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
Example 4:

Input: 

          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).


Note: Answer will in the range of 32-bit signed integer.

*/

	

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
package julychallenge;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class WidthOfBinaryTree {

	public int widthOfBinaryTree(TreeNode root) {
		int width = 0, widthMax = 0, leftMostNonNull, rightMostNonNull, i;
		TreeNode temp;
		Iterator<TreeNode> it;
		Deque<TreeNode> currentQueue = new LinkedList<TreeNode>();
		Deque<TreeNode> childQueue = new LinkedList<TreeNode>();
		
		if(root != null && root.left == null && root.right == null)
			return 1;
		
		currentQueue.add(root);
		while (!currentQueue.isEmpty()) {
			temp = currentQueue.poll();
			width++;
			if(temp == null) {
				childQueue.add(null);
				childQueue.add(null);
			} else {
				childQueue.add(temp.left);
				childQueue.add(temp.right);
			}			
			if (currentQueue.isEmpty()) {
				while(!childQueue.isEmpty() && childQueue.peekFirst() == null)
					childQueue.pollFirst();
				while(!childQueue.isEmpty() && childQueue.peekLast() == null)
					childQueue.pollLast();
				it = childQueue.iterator();
				leftMostNonNull = 0;
				rightMostNonNull = 0;
				i = 0;
				while (it.hasNext()) {
					i++;
					if (it.next() != null) {
						leftMostNonNull = i;
						break;
					}
				}
				if(leftMostNonNull == 0)
					break;
				i = childQueue.size();
				it = childQueue.descendingIterator();
				while (it.hasNext()) {
					if (it.next() != null) {
						rightMostNonNull = i;
						break;
					}
					i--;
				}
				width = rightMostNonNull - leftMostNonNull + 1;
				if (widthMax < width) {
					widthMax = width;
				}
				currentQueue.addAll(childQueue);
				childQueue.clear();
			}
		}
		return widthMax;
	}

}
