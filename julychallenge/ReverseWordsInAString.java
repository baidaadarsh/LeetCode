/*
Reverse Words in a String

Given an input string, reverse the string word by word.



Example 1:

Input: "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Follow up:

For C programmers, try to solve it in-place in O(1) extra space.

*/

package julychallenge;

import java.util.Stack;

public class ReverseWordsInAString {
	public static void main(String[] args) {
		System.out.println(reverseWords(" The sky is   blue "));
	}

	public static String reverseWords(String s) {
		int len, i, resLen;
		char a;
		String res = "";
		Stack<Character> stack = new Stack<Character>();

		s = " " + s;
		len = s.length();
		for (i = len - 1; i >= 0; i--) {
			a = s.charAt(i);
			if (a == ' ') {
				if (!stack.isEmpty()) {
					while (stack.size() > 0)
						res = res + stack.pop();
					res = res + " ";
				}
			} else {
				stack.push(a);
			}
		}
		if (res.length() == 0)
			return res;
		resLen = res.length() - 1;
		if (res.charAt(resLen) == ' ')
			res = res.substring(0, resLen);
		return res;
	}

}
