/*
Learning:-
1. Double LinkedList
*/
/*
//Definition for a Node.
class Node {
 public int val;
 public Node prev;
 public Node next;
 public Node child;
};
*/
package julychallenge;

public class FlattenAMultilevelDoublyLinkedList {
	public Node flatten(Node head) {
		Node curr = head;
		Node tempNext;
		while (curr != null) {
			if (curr.child == null) {
				curr = curr.next;
			} else {
				Node lastChildNode = curr.child;
				while (lastChildNode.next != null) {
					lastChildNode = lastChildNode.next;
				}
				lastChildNode.next = curr.next;
				curr.next = curr.child;
				curr.next.prev = curr;
				if (lastChildNode.next != null)
					lastChildNode.next.prev = lastChildNode;
				curr.child = null;
				curr = curr.next;
			}
		}
		return head;
	}
}