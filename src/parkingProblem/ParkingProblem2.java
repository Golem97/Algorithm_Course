package parkingProblem;

public class ParkingProblem2 {
	private DoubleCycleLinkedList _cars;
	private final int _nLetters = 23;// the number of letters.
	private final int _size = 13; // length of the list.

	/* Default constructor. */
	public ParkingProblem2() {
		_cars = new DoubleCycleLinkedList();
		for (int i = 0; i < _size; i++) {
			char c = (char) ('a' + (int) (Math.random() * _nLetters));
			_cars.add(c);
		}
	}

	public int calcNumOfCars() {
		_cars.getHead().setData('v');// mart the first car in 'v'.
		Node currNode = _cars.getHead().getNext();
		boolean flag = true;
		int count = 1; // The number of cars in the parking.
		while (flag) {
			if (currNode.getData() == 'v') {
				currNode.setData('w');
				int i = count;
				/* Go back as many steps we did. */
				while (i > 0) {
					currNode = currNode.getPrev();
					i--;
				}
				/* If the sign is w we come back to the head node and done. */
				if (currNode.getData() == 'w')
					flag = false;
				/* Otherwise, we'll take a step and start again. */
				else {
					count = 1;
					currNode = currNode.getNext();
				}
			} else { /* The sign is not 'v' */
				currNode = currNode.getNext();
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		ParkingProblem2 problem = new ParkingProblem2();
		System.out.println(problem.calcNumOfCars());
	}

}
