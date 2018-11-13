package puzzle.model;

public class Piece {
	private int[] tLeft, bLeft, tRight, bRight;
	boolean selected;
	
	Piece(){
		tLeft = new int[2];
		tRight = new int[2];
		bLeft = new int[2];
		bRight = new int[2];
		selected = false;
	}
	
	Piece(int tLX, int tLY, int tRX, int tRY, int bLX, int bLY, int bRX, int bRY){
		tLeft = new int[2];
		tRight = new int[2];
		bLeft = new int[2];
		bRight = new int[2];
		
		tLeft[0]=tLX;
		tLeft[1]=tLY;
		tRight[0]=tRX;
		tRight[1]=tRY;
		bLeft[0]=bLX;
		bLeft[1]=bLY;
		bRight[0]=bLX;
		bRight[1]=bRY;
		
		selected = false;
	}
	public boolean isSelected() {return selected;}
	
	public boolean isKeyPiece(){
		if((tRight[0] - tLeft[0])==200 && (bLeft[1]-tLeft[1])==200){
			return true;
		}else {
			return false;
		}
	}
	protected void select(){
		selected = true;
	}
	protected void deselect(){
		selected = false;
	}
	
	public void printDim() {
		System.out.println("piece is "+(tRight[0] - tLeft[0])+" by "+(bLeft[1]-tLeft[1]));
	}
	
	
	//returns top left "ordered pair"
	public int[] getTLeft() {
		return tLeft;
	}
	public void setTLeft(int newX, int newY) {
		tLeft[0] = newX;
		tLeft[1] = newY;
	}
	//returns top right "ordered pair"
	public int[] getTRight() {
		return tRight;
	}
	public void setTRight(int newX, int newY) {
		tRight[0] = newX;
		tRight[1] = newY;
	}
	//returns bottom left "ordered pair"
	public int[] getBLeft() {
		return bLeft;
	}
	public void setBLeft(int newX, int newY) {
		bLeft[0] = newX;
		bLeft[1] = newY;
	}
	//returns bottom right "ordered pair"
	public int[] getBRight() {
		return bRight;
	}
	public void setBRight(int newX, int newY) {
	bRight[0] = newX;
	bRight[1] = newY;
}

}