/*
Ugly Number II

Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:  

1 is typically treated as an ugly number.
n does not exceed 1690.
   Hide Hint #1  
The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
   Hide Hint #2  
An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
   Hide Hint #3  
The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
   Hide Hint #4  
Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).

Approach:
1. Brute Force (TLE)
2. Using TreeSet

*/
package julychallenge;

import java.util.TreeSet;

public class UglyNumber2 {
	public static void main(String[] args) {
		System.out.println(nthUglyNumber(1407));
	}
	//Approach 1: TLE
	/*public static int nthUglyNumber(int n) {
        if(n==1)
        	return 1;
        int count = 1, tempNum = 1;
         do{
        	tempNum++;
        	while(!isUglyNumber(tempNum)) {
        		tempNum++;
        	}
        	count++;
        }while(count<n);
        return tempNum;
    }
	public static boolean isUglyNumber(int num) {
		while(num>1 && num%2 == 0)
			num = num / 2;
		while(num>1 && num%3 == 0)
			num = num / 3;
		while(num>1 && num%5 == 0)
			num = num / 5;
		if(num == 1)
			return true;
		return false;
	}*/
	
	//Approach 2: Using TreeSet
	public static int nthUglyNumber(int n) {
		if(n==1)
        	return 1;
		TreeSet<Long> treeSet = new TreeSet<Long>();
		treeSet.add(1l);
		long count = 1, tempNum;
		long tempNumComp;
		while(count < n) {
			tempNum = treeSet.pollFirst();
			tempNumComp = tempNum*2;
			if(tempNumComp == tempNum*2)
				treeSet.add(tempNum*2);
			tempNumComp = tempNum*3;
			if(tempNumComp == tempNum*3)
				treeSet.add(tempNum*3);
			tempNumComp = tempNum*5;
			if(tempNumComp == tempNum*5)
				treeSet.add(tempNum*5);
			count++;
		}
		return treeSet.pollFirst().intValue();
	}
}
