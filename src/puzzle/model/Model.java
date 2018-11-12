package puzzle.model;


public class Model {
	Piece[] positions;
	int selectedPiece, numMoves;
	
	public Model(){
		positions = new Piece[10];
		int selectedPiece = 0;
		numMoves = 0;
	}
	
	
	public void selectPiece(int i){
		positions[i].select();
		positions[selectedPiece].deselect();
		selectedPiece = i;
	}
	
	public int getMoves() {
		return numMoves;
	}
	public void plusMoves() {
		numMoves++;
	}
	public void resetMoves() {
		numMoves = 0;
	}
	
	//create new block to add to the model's array
	public void addPiece(int pos, int tLX, int tLY, int tRX, int tRY, int bLX, int bLY, int bRX, int bRY) {
		positions[pos] = new Piece( tLX,  tLY,  tRX,  tRY,  bLX,  bLY,  bRX,  bRY);
	}
	//add existing block to the model's array (set method v2)
	public void addPiece(int pos, Piece blockB){
		positions[pos] = blockB;
	}
	
	public Piece checkPiece(int i) {
		return positions[i];
	}

}
