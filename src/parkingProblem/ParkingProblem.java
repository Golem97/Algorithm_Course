package parkingProblem;

public class ParkingProblem {

	// ************ PRIVATE METHODS ************

	protected static DoubleCycleLinkedList parking = new DoubleCycleLinkedList();
	private static Node currentNode;
	private static boolean flag;
	private static char oldSign, newSign; // signs on the cars.
	private static int steps; // number of steps back.
	private static int count; // total number of cars.

	// ************ PUBLIC METHODS ************

	/**
	 * @return DoubleCycleLinkedList that represent our parking.
	 */
	public DoubleCycleLinkedList buildLinkedList() {
		DoubleCycleLinkedList DCLL = new DoubleCycleLinkedList();
		DCLL.add('V');
		DCLL.add('B');
		DCLL.add('M');
		DCLL.add('V');
		DCLL.add('S');
		DCLL.add('A');
		DCLL.add('X');
		DCLL.add('P');
		DCLL.add('V');
		DCLL.add('T');
		return DCLL;
	}

	/** Constructor, build parking place: Double Cycle Linked List. */
	public ParkingProblem() {
		parking = buildLinkedList();
		currentNode = parking.getHead().getNext();
		flag = true;
		count = 1;
		oldSign = 'V';
		newSign = 'W';
	}

	/**
	 * This function calculate the number of cars in the parking according to the
	 * Parking Problem algorithm (one robot-one pointer car calculation).
	 * 
	 * @return count, the number of cars in the parking.
	 */
	public static int calcCars() {
		while (flag) {
			if (currentNode.getData() != oldSign) { // no sign 'v'.
				currentNode = currentNode.getNext(); // go to the next node.
				count++;
			} else {// node with sign 'v'.
				currentNode.setData(newSign);
				steps = count;
				while (steps > 0) {// loop for steps back.
					currentNode = currentNode.getPrev(); // get the previous node.
					steps--;
				}
				if (currentNode.getData() == newSign) // back to new sign.
					flag = false;
				else {
					count = 1;
					currentNode = parking.getHead().getNext();
				}

			}
		}
		return count;
	}
}