package puzzle.controller;

import puzzle.boundary.SlidingPuzzleApp;
import puzzle.model.Model;

public class ResetController {
	Model model;
	SlidingPuzzleApp puzzle;
	
	ResetController(Model m, SlidingPuzzleApp p){
		model = m;
		puzzle = p;
	}
	
	public void resetPuzzle(){
		
	}
}
