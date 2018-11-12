package puzzle.controller;

import puzzle.boundary.SlidingPuzzleApp;
import puzzle.model.Model;

public class ResetController {
	Model model;
	SlidingPuzzleApp app;
	
	ResetController(Model m, SlidingPuzzleApp p){
		model = m;
		app = p;
	}
	
	public void resetPuzzle(){
		model.resetMoves();
		
		
		
		app.getView().refreshScreen();
	}
}
