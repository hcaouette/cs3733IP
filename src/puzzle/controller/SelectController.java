package puzzle.controller;

import puzzle.boundary.*;
import puzzle.model.*;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;


public class SelectController extends MouseAdapter{
	SlidingPuzzleApp app;
	Model model;
	
	public SelectController(Model m, SlidingPuzzleApp p){
		this.app = p;
		this.model = m;
	}
	
	public void react(Point pt) {
		PuzzleView view = app.getView();
		//view.repaint();
	}
	
	public void select(Point pt){
		PuzzleView view = app.getView();
		for(int i=0;i<10;i++) {
			Piece piece = model.checkPiece(i);
			if((piece.getTLeft()[0]<pt.getX()) && (piece.getTRight()[0]>pt.getX()) &&
					(piece.getTLeft()[1]<pt.getY()) && (piece.getBLeft()[1]>pt.getY())) {
				model.selectPiece(i);
				System.out.println("selected block number "+i);
			}
		}
		view.repaint();
	}

}