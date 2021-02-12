package tortoiseAndHare;

public class TortoiseAndHareAlgorithm {

	/**
	 * This method get linked list and verify the existence of the ciycle.
	 * 
	 * @param LL the linked list that we cheks
	 * @return true if the linked list is a linked list.
	 */
	public boolean hasLoop(CircleLinkedList LL) {
		Node slow;// the tortoise.
		Node fast;// the hare.
		slow = fast = LL.getHead();// place both pointers to the start of the list.
		while (true) {
			if (slow.getNext() == null || fast.getNext() == null)
				return false;
			slow = slow.getNext();// move forward one step.
			fast = fast.getNext().getNext();// move forward two steps.
			if (slow == null || fast == null)
				return false;
			if (slow == fast)
				return true;
		}
	}

	/**
	 * This fanction finds the meeting point of the tortiose and the hare in the
	 * circle and calculate how mutch steps its tekes.
	 * 
	 * @return the meeting point in the circle.
	 */
	public Node meetingPointInLoop(CircleLinkedList circleLL) {
		int steps = 0;
		Node fast = circleLL.getHead();
		Node slow = circleLL.getHead();
		fast = fast.getNext().getNext();
		slow = slow.getNext();
		steps++;
		while (fast != slow) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
			steps++;
			if (fast == slow)
				break;
		}
		System.out.println("number of steps to meeting point: " + steps);
		return fast;
	}

	/**
	 * This function find the start of the cycle in the linked list.
	 * 
	 * @param ll   linked list with cycle.
	 * @param meet the point in the cycle that them meet.
	 * @return the start point of the cyle.
	 */
	public Node startOfLoop(CircleLinkedList ll, Node meet) {
		Node slow = ll.getHead();
		Node fast = meet;
		while (slow != fast) {
			fast = fast.getNext();
			if (slow == fast.getNext())
				break;
			slow = slow.getNext();

		}
		return slow;
	}
	
	public int lengthOfLoop(CircleLinkedList ll, Node meet) {
		int lenght =0;
		Node slow = meet;
		Node fast = meet;
		fast = fast.getNext();
		lenght++;
		while(slow != fast) {
			fast = fast.getNext();
			lenght++;
		}
		return lenght;
	}

	public static void main(String[] args) {
		CircleLinkedList linearLL = new CircleLinkedList();
		for (int i = 0; i < 10; i++) // list size = 10
			linearLL.add(i);
		System.out.println("Linear Linked List size = " + linearLL.getSize());
		System.out.println(linearLL);

		CircleLinkedList circleLL = new CircleLinkedList();
		for (int i = 0; i < 10; i++) // list size = 10
			circleLL.add(i);
		circleLL.addLoop(4); // first loop node = 4
		System.out.println("\nLoop Linked List size = " + circleLL.getSize());
		System.out.println(circleLL);

		TortoiseAndHareAlgorithm fastAndSlow = new TortoiseAndHareAlgorithm();
		System.out.println();

		System.out.println(fastAndSlow.hasLoop(linearLL));
		System.out.println(fastAndSlow.hasLoop(circleLL));

		Node meetingNode = fastAndSlow.meetingPointInLoop(circleLL);
		System.out.println("Meeting point : " + meetingNode.getData());
		
		Node firstInLoop = fastAndSlow.startOfLoop(circleLL,meetingNode);
		System.out.println();
		System.out.println("Start of the loop : " + firstInLoop.getData());
		
		System.out.println("Length of the loop : " + fastAndSlow.lengthOfLoop(circleLL, meetingNode));
		
	}
}
