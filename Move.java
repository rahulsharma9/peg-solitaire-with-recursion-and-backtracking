
class Move implements Comparable<Move>{
		
		int initialPos;
		int space;
		int finalPos;
		
		Move(int initialPos, int space, int finalPos){
		this.initialPos = initialPos;
		this.space = space;
		this.finalPos = finalPos;
		}
		
		@Override
		
		public String toString() {
			return("(" + this.initialPos + ", " + this.space + ", " + this.finalPos + ")");
		}

		@Override
		public int compareTo(Move m) {
			return Integer.valueOf(this.initialPos).compareTo(Integer.valueOf(m.initialPos));
		}
		
	}
