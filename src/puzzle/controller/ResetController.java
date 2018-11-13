package puzzle.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import puzzle.boundary.PuzzleView;
import puzzle.boundary.SlidingPuzzleApp;
import puzzle.model.Model;

public class ResetController implements ActionListener{
	Model model;
	SlidingPuzzleApp app;
	
	public ResetController(Model m, SlidingPuzzleApp p){
		this.model = m;
		this.app = p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		PuzzleView view = app.getView();
		model.resetMoves();
		
		model.changePiece(0,0, 0, 100, 0, 0, 200, 100, 200);
		model.changePiece(1,100, 0, 300, 0, 100, 200, 300, 200);
		model.changePiece(2,300, 0, 400, 0, 300, 200, 400, 200);
	    model.changePiece(3,0, 200, 100, 200, 0, 400, 100, 400);
	    model.changePiece(4,300, 200, 400, 200, 300, 400, 400, 400);
	    model.changePiece(5,100, 400, 300, 400, 100, 500, 300, 500);
	    model.changePiece(6,100, 200, 200, 200, 100, 300, 200, 300);
	    model.changePiece(7,200, 200, 300, 200, 200, 300, 300, 300);
	    model.changePiece(8,100, 300, 200, 300, 100, 400, 200, 400);
	    model.changePiece(9,200, 300, 300, 300, 200, 400, 300, 400);
	    
	    (model.checkPiece(model.getSelectedPiece())).deselect();
		view.repaint();
	}

}
