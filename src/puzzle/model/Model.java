package puzzle.model;

import puzzle.boundary.*;


public class Model {
	Piece[] positions;
	int selectedPiece, numMoves;
	SlidingPuzzleApp app;
	
	public Model(){
		positions = new Piece[10];
		int selectedPiece = 0;
		numMoves = 0;
		app=null;
	}
	
	public Model(SlidingPuzzleApp puzzle){
		positions = new Piece[10];
		int selectedPiece = 0;
		numMoves = 0;
		app=puzzle;
	}
	
	public void setPuzzle(SlidingPuzzleApp puzzle) {
		app = puzzle;
	}
	
	public SlidingPuzzleApp getPuzzle() {
		return app;
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
