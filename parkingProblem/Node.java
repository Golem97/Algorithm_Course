package parkingProblem;

/**
 * This class represents a node in doubleCycleLinkedList.
 * 
 * @author Shay Naor
 */
public class Node {

	// ************ PRIVATE METHODS ************
	private char data;
	private Node next, prev;

	// ************ PUBLIC METHODS ************
	public Node(char data, Node prev, Node next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}

	// *********GETTERS && SETTERS*********

	public char getData() {
		return this.data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public Node getNext() {
		return this.next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrev() {
		return this.prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}
	/** Prints the node as "Node [data=" + this.data + "]". */
	public String toString() {
		return "Node [data=" + this.data + "]";
	}
}
