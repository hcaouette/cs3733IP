package puzzle.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import puzzle.boundary.SlidingPuzzleApp;
import puzzle.model.Model;
import puzzle.model.Piece;

public class MoveController implements ActionListener{
	Model model;
	SlidingPuzzleApp app;
	int dir;
	
	public MoveController(Model m, SlidingPuzzleApp p, int dir){
		model = m;
		app = p;
		this.dir=dir;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//dir determined at time of function call
	//0 up, 1 right, 2 down, 3 left
	public void movePiece(Piece p, int dir){
		//check for bounding edges
		if((p.getTLeft()[0] == 0 || p.getBLeft()[0]==0) && dir==3){
			System.out.println("error, left already on 0");
			return;
		}else if((p.getTLeft()[1] == 0 || p.getTRight()[1]==0) && dir==0){
			System.out.println("error, top edge already on 0");
			return;
		}else if((p.getTRight()[0] == 400 || p.getBRight()[0]==400) && dir==1){
			System.out.println("error, right edge already on 400");
			return;
		}else if((p.getBLeft()[1] == 500 || p.getBRight()[1]==500) && dir==2){
			System.out.println("error, bottom edge already on 500");
			return;
		}
		
		//check for bordering pieces
		boolean collisionFree=true;
		for(int i=0;i<10;i++){
		Piece pNew = model.checkPiece(i);
			switch(dir) {
			case 0:
				if(((p.getTLeft()[1] > pNew.getBLeft()[1])||(p.getTRight()[1] > pNew.getBRight()[1]))||
					((p.getTLeft()[0] >= pNew.getBRight()[0])||(p.getTRight()[0] <= pNew.getBLeft()[0]))
					){
					break;
				}else {
					collisionFree=false;
					break;
				}
			case 1:
				if(((p.getTLeft()[1] > pNew.getBLeft()[1])||(p.getTRight()[1] > pNew.getBRight()[1]))||
					((p.getTLeft()[0] >= pNew.getBRight()[0])||(p.getTRight()[0] <= pNew.getBLeft()[0]))
					){
					break;
				}else {
					collisionFree=false;
					break;
				}
			case 2:
				if(((p.getTRight()[1] < pNew.getBLeft()[1])||(p.getTRight()[1] > pNew.getBRight()[1]))||
					((p.getTLeft()[0] >= pNew.getBRight()[0])||(p.getTRight()[0] <= pNew.getBLeft()[0]))
					){
					break;
				}else {
					collisionFree=false;
					break;
				}
			case 3:
				if(((p.getTLeft()[1] > pNew.getBLeft()[1])||(p.getTRight()[1] > pNew.getBRight()[1]))||
					((p.getTLeft()[0] >= pNew.getBRight()[0])||(p.getTRight()[0] <= pNew.getBLeft()[0]))
					){
					break;
				}else {
					collisionFree=false;
					break;
				}
			}
		}
		
		model.plusMoves();
		app.getView().refreshScreen();
	}
	
	//compares two Pieces, given an edge to compare
	//returns true if they can do not align with each other
	//returns false if there would be a collision
	private boolean comparePieces(Piece p, Piece p2, int edge, int edge2) {
		
		if((p.getTLeft()[0]<p2.getBRight()[0]) && (p.getTLeft()[1]<p2.getBRight()[1])){
			//top left/bottom right intersect
			//
			return false;
		}else if((p.getTLeft()[0]>p2.getBRight()[0]) && (p.getTLeft()[1]<p2.getBRight()[1])){
			//bottom left/top right intersect
			//p is more x, less y
			return false;
		}else if((p.getTLeft()[0]<p2.getBRight()[0]) && (p.getTLeft()[1] < p2.getBRight()[1])){
			//bottom right/top left intersect
		}else if((p.getTLeft()[0]<p2.getBRight()[0]) && (p.getTLeft()[1] < p2.getBRight()[1])){
			//top right/bottom left intersect
		}
		
		return true;
	}

}
