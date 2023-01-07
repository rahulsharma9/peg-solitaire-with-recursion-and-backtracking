import java.util.ArrayList;
import java.util.Collections;

public class pegPuzzle {
		
	ArrayList<ArrayList<Integer>> theBoard;
	ArrayList<Move> recordOfallMoves;
	ArrayList<ArrayList<ArrayList<Integer>>> uselessGrid;
	
	pegPuzzle(ArrayList<ArrayList<Integer>> theBoard){
		this.theBoard = theBoard;
	    recordOfallMoves = new ArrayList<>();
	    uselessGrid = new ArrayList<>();
	}
	
	
	public void printGrid(){
		
		for (int i = 0; i < theBoard.size(); i++) {
            for (int j = 0; j < theBoard.get(i).size(); j++) {
            	if(theBoard.get(i).get(j) == 8) {
            		System.out.print("    ");
            	}
            	else {
            		System.out.print("["+ theBoard.get(i).get(j) + "] ");
            	}
            }
            System.out.println();
        }
	}
	
	public void makeAMove(Move move) {
	    theBoard.get(move.initialPos/7).set(move.initialPos %7, 0);
	    theBoard.get(move.space/7).set(move.space %7, 0);
	    theBoard.get(move.finalPos/7).set(move.finalPos %7, 1);
	    recordOfallMoves.add(move);    
	}

	public void undoMove(Move move) {
	    theBoard.get(move.initialPos/7).set(move.initialPos %7, 1);
	    theBoard.get(move.space/7).set(move.space %7, 1);
	    theBoard.get(move.finalPos/7).set(move.finalPos %7, 0);
	    recordOfallMoves.remove(recordOfallMoves.size() - 1);  
	}
	
	public ArrayList<Move> numOfallPossibilities(){
		
		ArrayList<Move> allPossibilities = new ArrayList<>();
		
		for (int i = 0; i < theBoard.size(); i++) {
			for (int j = 0; j < theBoard.get(i).size(); j++) {	
				if(theBoard.get(i).get(j) == 0) {
					
					if(i-2 >= 0){
						if((theBoard.get(i-2).get(j) == 1) && (theBoard.get(i-1).get(j) == 1)) {
							allPossibilities.add(new Move((i-2)*7+j, (i-1)*7+j,i*7+j));
						}
					}
					
					if(j-2 >= 0){
						if((theBoard.get(i).get(j-2) == 1) && (theBoard.get(i).get(j-1) == 1)) {
							allPossibilities.add(new Move(i*7 + j-2, i*7 + j-1, i*7+j));
						}
					}
					
					if(i+2 <= 6){
						if((theBoard.get(i+2).get(j) == 1) && (theBoard.get(i+1).get(j) == 1)) {
							allPossibilities.add(new Move((i+2)*7+j, (i+1)*7+j,i*7+j));
						}
					}
					
					if(j+2 <= 6){
						if((theBoard.get(i).get(j+2) == 1) && (theBoard.get(i).get(j+1) == 1)) {
							allPossibilities.add(new Move(i*7 + j+2, i*7 + j+1, i*7+j));
						}
					}
					
				}
			}
		}
		
		return allPossibilities;
	}
	
	
	public int getCount(){
		
		int count = 0;
		for(int i = 0; i < theBoard.size(); i++){
			
			for (int j=0; j < theBoard.get(i).size(); j++){
				
				if(theBoard.get(i).get(j) == 1){
					count++;
				}
				
			}
			
		}
		return count;
	}
	
	ArrayList<ArrayList<Integer>> aCopy(ArrayList<ArrayList<Integer>> input){
			
			ArrayList<ArrayList<Integer>> newGrid = new ArrayList<>();
			
			for(ArrayList<Integer> line: input) {
				ArrayList<Integer> cpLine = new ArrayList<>();
				for(Integer i : line){
					cpLine.add(Integer.valueOf(i));
				}
				newGrid.add(cpLine);
			}
			return newGrid;
	}
	
	
	public boolean isSolved(){
		
		if(uselessGrid.contains(theBoard)){
			return false;
		}
		else if(getCount() == 1 && theBoard.get(3).get(3) == 1) {
			printGrid();
			return true;
		}
		else {
			ArrayList<Move> allMoves = numOfallPossibilities();
			Collections.sort(allMoves);
			
			for(Move move : allMoves) {
				
				makeAMove(move);
				if(isSolved()) {
					return true;
				}
				else {
					undoMove(move);
				}
			}
			printGrid();
			System.out.println();
		}
		
		if(!uselessGrid.contains(theBoard)){
			uselessGrid.add(aCopy(theBoard));
		}
		return false;
	}

}
