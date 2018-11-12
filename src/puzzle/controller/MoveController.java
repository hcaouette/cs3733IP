package puzzle.controller;

import puzzle.boundary.SlidingPuzzleApp;
import puzzle.model.Model;

public class MoveController {
	Model model;
	SlidingPuzzleApp app;
	
	MoveController(Model m, SlidingPuzzleApp p){
		model = m;
		app = p;
	}
	
	public void movePiece(){
		
		
		
		
		model.plusMoves();
		app.getView().refreshScreen();
	}
}
