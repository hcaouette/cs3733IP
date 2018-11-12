package puzzle.model;

public class Block {
	private int[] tLeft, bLeft, tRight, bRight;
	
	Block(){
		tLeft = new int[2];
		tRight = new int[2];
		bLeft = new int[2];
		bRight = new int[2];
	}
	
	Block(int tLX, int tLY, int tRX, int tRY, int bLX, int bLY, int bRX, int bRY){
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
	}
	
	
	//top left
	int[] getTLeft() {
		return tLeft;
	}
	void setTLeft(int newX, int newY) {
		tLeft[0] = newX;
		tLeft[1] = newY;
	}
	//top right
	int[] getTRight() {
		return tRight;
	}
	void setTRight(int newX, int newY) {
		tRight[0] = newX;
		tRight[1] = newY;
	}
	//bottom left
	int[] getBLeft() {
		return bLeft;
	}
	void setBLeft(int newX, int newY) {
		bLeft[0] = newX;
		bLeft[1] = newY;
	}
	//bottom right
	int[] getBRight() {
		return bRight;
	}
	void setBRight(int newX, int newY) {
	bRight[0] = newX;
	bRight[1] = newY;
}

}