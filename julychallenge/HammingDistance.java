/*

Hamming Distance

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.
Approach:
1. XOR + java built-in library function Integer.bitCount uses SWAR algo.
2. XOR + Brian Kernighan'S Algo count the x & x-1 while x>0. 
*/
package julychallenge;

public class HammingDistance {
	public static void main(String[] args) {
		System.out.println(hammingDistance(1, 4));
	}
	
	//Approach 1:XOR + java built-in library function Integer.bitCount uses SWAR algo.
	/*public static int hammingDistance(int x, int y) {
		return Integer.bitCount(x^y);
    }*/

	//Approach 2: 2. XOR + Brian Kernighan'S Algo count the x & x-1 while x>0.
	public static int hammingDistance(int x, int y) {
		return getBitCount(x ^ y);
	}

	public static int getBitCount(int num) {
		int count = 0;
		while (num > 0) {
			num = num & num - 1;
			count++;
		}
		return count;
	}
}
