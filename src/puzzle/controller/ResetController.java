package puzzle.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import puzzle.boundary.SlidingPuzzleApp;
import puzzle.model.Model;

public class ResetController implements ActionListener{
	Model model;
	SlidingPuzzleApp app;
	
	public ResetController(Model m, SlidingPuzzleApp p){
		model = m;
		app = p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void resetPuzzle(){
		model.resetMoves();
		
		
		
		app.getView().refreshScreen();
	}
}
