package puzzle.controller;
import puzzle.boundary.*;
import puzzle.model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class SelectController extends MouseAdapter{
	SlidingPuzzleApp app;
	Model model;
	//MoveType moves[] = { MoveType.UP, MoveType.DOWN, MoveType.LEFT, MoveType.RIGHT };
	
	public SelectController(Model m, SlidingPuzzleApp p){
		this.app = p;
		this.model = m;
	}
	
	public void mouseClicked(MouseEvent e) {
		SlidingPuzzleApp puzzle = model.getPuzzle();
		
		PuzzleView view = app.getPuzzleView();
		view.repaint();
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		PuzzleView view = app.getPuzzleView();
		
		int r = view.getRow(e.getY());
		int c = view.getColumn(e.getX());
		if (r < 0 || c < 0) { return; }  // nothing to do
		
		Puzzle puzzle = model.getPuzzle();
		if (puzzle.isSolved()) { return; }   // deny any movement once solved
		
		for (MoveType m : moves) {
			if (puzzle.tryMove(r, c, m)) {
				view.repaint();
				return;
			}
		}
		
	}
}

package puzzle.controller;
import puzzle.boundary.*;
import puzzle.model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class SelectController implements ActionListener{
		Model model;
		SlidingPuzzleApp app;
		
		public SelectController(Model m, SlidingPuzzleApp p){
			model = m;
			app = p;
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		public void selectPiece(){
			
			
			
			app.getView().refreshScreen();
		}
	}
