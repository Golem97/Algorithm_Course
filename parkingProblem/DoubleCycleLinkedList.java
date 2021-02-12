package parkingProblem;

/**
 * This class represents a DoubleCycleLinkedList.
 * 
 * @author Shay Naor
 *
 */

public class DoubleCycleLinkedList {

	// ************ PRIVATE METHODS ************

	private Node head, tail;
	private int size;

	// ************ PUBLIC METHODS ************

	/** Constructor, constructs an empty list. */
	public DoubleCycleLinkedList() {
		this.head = this.tail = null;
		size = 0;
	}

	/**
	 * This function adds a new element to the end of the list.
	 * 
	 * @param data the new element that we want to add.
	 */
	public void add(char data) {
		if (this.head == null) {// if the linked list is empty.
			head = new Node(data, null, null);
			tail = head;
			head.setNext(tail);
			head.setPrev(tail);
		} else {// the linked list contains elements.
			Node node = new Node(data, tail, head);
			tail.setNext(node);
			tail = node;
			head.setPrev(node);
		}
		size++;
	}

	// *********GETTERS*********

	public Node getHead() {
		return this.head;
	}

	public Node getNext(Node n) {
		return n.getNext();
	}

	/**
	 * Prints the LinkedList as: [ Node [data=" + this.data + "] , ...... ,Node
	 * [data=" + this.data + "] .
	 */
	public String toString() {
		String str = "[";
		if (this.head != null) {
			str += this.head + ", ";
			Node node = head.getNext();
			while (node != head) {
				str = str + node + ", ";
				node = node.getNext();
			}
			str = str.substring(0, str.length() - 2);
		}
		return str + "]";
	}

}
