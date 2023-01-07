import java.util.ArrayList;
import java.util.Arrays;

public class game1{

	public static void main(String[] args) {
		
		ArrayList<ArrayList<Integer>> board1 = new ArrayList<>();
		
		ArrayList<Integer> l1 = new ArrayList<>();
		l1.addAll(Arrays.asList(8, 8, 1, 1, 1, 8, 8));
		
		ArrayList<Integer> l2 = new ArrayList<>();
		l2.addAll(Arrays.asList(8, 8, 1, 1, 1, 8, 8));
		
		ArrayList<Integer> l3 = new ArrayList<>();
		l3.addAll(Arrays.asList(1, 1, 1, 1, 1, 1, 1));
		
		ArrayList<Integer> l4 = new ArrayList<>();
		l4.addAll(Arrays.asList(1, 1, 1, 0, 1, 1, 1));

		
		ArrayList<Integer> l5 = new ArrayList<>();
		l5.addAll(Arrays.asList(1, 1, 1, 1, 1, 1, 1));
		
		ArrayList<Integer> l6 = new ArrayList<>();
		l6.addAll(Arrays.asList(8, 8, 1, 1, 1, 8, 8));
		
		ArrayList<Integer> l7 = new ArrayList<>();
		l7.addAll(Arrays.asList(8, 8, 1, 1, 1, 8, 8));
		
		board1.add(new ArrayList<Integer>(l1));
		board1.add(new ArrayList<Integer>(l2));
		board1.add(new ArrayList<Integer>(l3));
		board1.add(new ArrayList<Integer>(l4));
		board1.add(new ArrayList<Integer>(l5));
		board1.add(new ArrayList<Integer>(l6));
		board1.add(new ArrayList<Integer>(l7));

		
		pegPuzzle solution1 = new pegPuzzle(board1);
		solution1.isSolved();


	}

}
