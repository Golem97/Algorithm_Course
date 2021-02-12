package aeroplane_problem;


public class Main {

	public static void main(String[] args) {
		AeroplaneProblem plane = new AeroplaneProblem();
		plane.printPriceMat();
		plane.printMatrixNode();
		System.out.println(plane.getOneBestTrack());
		plane.getAllBestPathsRec();
		
	}

}
