# 933. Number of Recent Calls

## Question:

You have a RecentCounter class which counts the number of recent requests within a certain time frame.

Implement the RecentCounter class:

RecentCounter() Initializes the counter with zero recent requests.
int ping(int t) Adds a new request at time t, where t represents some time in milliseconds, and returns the number of requests that has happened in the past 3000 milliseconds (including the new request). Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.

 

Example 1:

Input
["RecentCounter", "ping", "ping", "ping", "ping"]
[[], [1], [100], [3001], [3002]]
Output
[null, 1, 2, 3, 3]

Explanation
RecentCounter recentCounter = new RecentCounter();
recentCounter.ping(1);     // requests = [1], range is [-2999,1], return 1
recentCounter.ping(100);   // requests = [1, 100], range is [-2900,100], return 2
recentCounter.ping(3001);  // requests = [1, 100, 3001], range is [1,3001], return 3
recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
 

Constraints:

1 <= t <= 109
Each test case will call ping with strictly increasing values of t.
At most 104 calls will be made to ping.

## My Solution:
`
import java.util.*;

class RecentCounter {
 
    TreeMap<Integer, Integer> map;
    
    public RecentCounter() {
        map = new TreeMap<Integer, Integer>();
    }
    
    public int ping(int t) {
        map.put(t, map.size());
        return map.size() - map.ceilingEntry(t - 3000).getValue();
    }
}
`

## Leetcode Solution:
`
class RecentCounter {
    LinkedList<Integer> slideWindow;

    public RecentCounter() {
        this.slideWindow = new LinkedList<Integer>();
    }
    
    public int ping(int t) {
        this.slideWindow.addLast(t);
        
        while(this.slideWindow.getFirst() < t - 3000)
            this.slideWindow.removeFirst();
        
        return this.slideWindow.size();
    }
}
`

## Approach:
1. TreeMap(Not so efficient as we are storing redundant pings as well).
2. Sliding window approach using LinkedList java. O(1)
3. Another approach can be considered of binary search, but that one needs to compromise on storage while using arrays.

## Learnings:
1. For sliding windows, using LinkedList is a great option, arrays won't suffice because we cannot free up memory.
2. For binary search, using Arrays is a great option as the items can readily be accessed using indices.
