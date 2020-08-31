# 50EasyProblemsin7Days
This repository contains the set of 50 Easy Problems in 7 days.

# Problem List
1. [121. Best Time to Buy and Sell Stock] - Array
2. [26. Remove Duplicates from Sorted Array] - Array
3. [27. Remove Element] - Array
4. [283. Move Zeroes] - Array
5. [171. Excel Sheet Column Number] - Math
6. [168. Excel Sheet Column Title] - Math
7. [169. Majority Element] - Array
8. [412. Fizz Buzz]
9. [122. Best Time to Buy and Sell Stock II] - Array
10. [242. Valid Anagram] - Hash Table
11. [9. Palindrome Number] - Math
12. [160. Intersection of Two Linked Lists] - Linked List
13. [141. Linked List Cycle] - Linked List
14. [217. Contains Duplicate] - Array
15. [219. Contains Duplicate II] - Array
16. [13. Roman to Integer] - String
17. [21. Merge Two Sorted Lists] - linked List
18. [387. First Unique Character in a String] - String
19. [118. Pascal's Triangle] - Array	
20. [119. Pascal's Triangle II] - Array
21. [237. Delete Node in a Linked List] - Linked List
22. [206. Reverse Linked List] - Linked List
23. [234. Palindrome Linked List] - Linked List
24. [268. Missing Number] - Bit Manipulation
25. [104. Maximum Depth of Binary Tree] - Tree
26. [110. Balanced Binary Tree] - Tree
27. [111. Minimum Depth of Binary Tree] - Tree
28. [559. Maximum Depth of N-ary Tree] - Tree
29. [108. Convert Sorted Array to Binary Search Tree] - Tree
30. [344. Reverse String] - String
31. [345. Reverse Vowels of a String] - String
32. [541. Reverse String II] - String
33. [557. Reverse Words in a String III] - String
34. [925. Long Pressed Name] - String
35. [58. Length of Last Word] - String
36. [38. Count and Say] - String
37. [443. String Compression] - String
38. [20. Valid Parentheses] -String
39. [125. Valid Palindrome] - String
40. [28. Implement strStr()] - String
41. [680. Valid Palindrome II] - String
42. [350. Intersection of Two Arrays II] - Hash Table
43. [349. Intersection of Two Arrays] - Hash Table
44. [1002. Find Common Characters] - Hash Table
45. [202. Happy Number] - Hash Table
46. [191. Number of 1 Bits] - Bit Manipulation
47. [66. Plus One] - Array
48. [1. Two Sum] - Hash Table
49. [167. Two Sum II - Input array is sorted] - Two Pointers
50. [88. Merge Sorted Array] - Two Pointers


## Learnings:
# General Learnings:
1. Read the question carefully.
2. Think Simply.
3. Write neat code.
4. Break a big problem into small steps and it would surely get done!
5. Try Brute force first, you can think of optimization later on.
6. Using Library functions can help improve your code.
7. HashTables can be used in cases where we need to create multiple if else conditions, it would help improve the code.
8. If you need two output parameters to return in a recursion, use a global variable.
9. Do not recalculate same thing.

# DS Algo Learnings:
1. Boyer-Moore Voting Algorithm[Delighted to learn about it].
2. We can use two pointers to find a cycle.
3. You need not allocate new memory spaces for LinkedList Questions. The number of nodes are just enough. Try to use at max use 1 extra node reference.
4. Do not modify the initial linked list when returning final output.
5. We can apply abstract concepts like slow pointer and fast pointer in multiple ways.


# Java specific Learnings:
1. Its better to convert into a character array by using toCharArray, instead of using String and charAt everytime.
2. Integer array is always better than HashMap<String, Integer> [Time Complexity]
3. Collections.nCopies can be used in cases when we need a list with same object.
4. Usage of Array is better than Stack for time complexity concerns.
5. retainsAll java helps in set difference.
6. Conversion of Set<Integer> to int[] - result.stream().mapToInt(Integer::intValue).toArray();
6. char arrays are always better than hashmaps(Use them if the problem constraints allow you to).
