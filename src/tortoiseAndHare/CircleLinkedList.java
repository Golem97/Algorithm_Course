package tortoiseAndHare;

public class CircleLinkedList {
	private Node head, tail;
	private int size;

	public CircleLinkedList() {
		head = tail = null;
		size = 0;
	}

	public void add(int data) {
		if (head == null) {// if the list is empty.
			head = new Node(data);
			tail = head;
		} else {// the list is not empty - add net node.
			Node temp = tail;
			tail = new Node(data);
			temp.setNext(tail);
		}
		size++;
	}

	public void addLoop(int index) {
		Node current = head;
		while (current.getData() != index) {
			if (current.getNext() == null)
				return;
			current = current.getNext();
		}
		tail.setNext(current);
	}

	public int getSize() {
		return this.size;
	}

	public Node getHead() {
		return this.head;
	}

	public Node getTail() {
		return this.tail;
	}

	public String toString() {
		Node current = head;
		String result = "";
		int count = 0;
		while (current != null) {
			result += "[" + current.getData() + "]";
			current = current.getNext();
			count++;
			if (count % 10 == 0 || count % 16 == 0)
				result = result + " ";
			if (count == 20) // maybe linked list has a loop
				break;
		}
		return result;
	}
}
