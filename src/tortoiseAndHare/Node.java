package tortoiseAndHare;

public class Node {

	// ************ PRIVATE METHODS ************

	private int data;
	private Node next;

	// ************ PUBLIC METHODS ************

	public Node(int data) {
		this.data = data;
		this.next = null;
	}

	public int getData() {
		return this.data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return this.next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public String toString() {
		return " (" + data + ")";
	}

}
