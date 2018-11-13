package puzzle.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import puzzle.boundary.PuzzleView;
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
		int selNum =model.getSelectedPiece();
		Piece piece = model.checkPiece(selNum);
		PuzzleView view = app.getView();
		System.out.println(dir+" button pressed!");
		switch(dir) {
		case 0:
			//System.out.println("initiate movecheck up. ("+dir+")");
			if(moveCheck(piece,dir,selNum)){
			piece.setTLeft(piece.getTLeft()[0], (piece.getTLeft()[1]-100));
			piece.setTRight(piece.getTRight()[0], (piece.getTRight()[1]-100));
			piece.setBLeft(piece.getBLeft()[0], (piece.getBLeft()[1]-100));
			piece.setBRight(piece.getBRight()[0], (piece.getBRight()[1]-100));
			model.plusMoves();}
			break;
			
		case 1:
			//System.out.println("initiate movecheck right. ("+dir+")");
			if(moveCheck(piece,dir,selNum)){
			piece.setTLeft((piece.getTLeft()[0]+100), (piece.getTLeft()[1]));
			piece.setTRight((piece.getTRight()[0]+100), (piece.getTRight()[1]));
			piece.setBLeft((piece.getBLeft()[0]+100), (piece.getBLeft()[1]));
			piece.setBRight((piece.getBRight()[0]+100), (piece.getBRight()[1]));
			model.plusMoves();}
			break;
		case 2:
			//System.out.println("initiate movecheck down. ("+dir+")");
			if(moveCheck(piece,dir,selNum)){
			piece.setTLeft(piece.getTLeft()[0], (piece.getTLeft()[1]+100));
			piece.setTRight(piece.getTRight()[0], (piece.getTRight()[1]+100));
			piece.setBLeft(piece.getBLeft()[0], (piece.getBLeft()[1]+100));
			piece.setBRight(piece.getBRight()[0], (piece.getBRight()[1]+100));
			model.plusMoves();}
			break;
		case 3:
			//System.out.println("initiate movecheck left. ("+dir+")");
			if(moveCheck(piece,dir,selNum)){
			piece.setTLeft((piece.getTLeft()[0]-100), (piece.getTLeft()[1]));
			piece.setTRight((piece.getTRight()[0]-100), (piece.getTRight()[1]));
			piece.setBLeft((piece.getBLeft()[0]-100), (piece.getBLeft()[1]));
			piece.setBRight((piece.getBRight()[0]-100), (piece.getBRight()[1]));
			model.plusMoves();}
			break;
		}
		view.repaint();
	}
	
	//dir determined at time of function call
	//0 up, 1 right, 2 down, 3 left
	public boolean moveCheck(Piece p, int dir,int selNum){
		//System.out.println("dir: "+dir);
		//check for victory
		if((p.getBLeft()[1] == 500 || p.getBRight()[1]==500) && p.isKeyPiece()
				&&(p.getBLeft()[0]==100) &&(p.getBRight()[0]==300) && dir==2){
			System.out.println("YOU WIN!");
			return JOptionPane.showConfirmDialog (app, "You Win!") == JOptionPane.OK_OPTION;	
		}
		
		
		//check for bounding edges
		if((p.getTLeft()[0] == 0 || p.getBLeft()[0]==0) && dir==3){
			System.out.println("error, left already on 0");
			return false;
		}else if((p.getTLeft()[1] == 0 || p.getTRight()[1]==0) && dir==0){
			System.out.println("error, top edge already on 0");
			return false;
		}else if((p.getTRight()[0] == 400 || p.getBRight()[0]==400) && dir==1){
			System.out.println("error, right edge already on 400");
			return false;
		}else if((p.getBLeft()[1] == 500 || p.getBRight()[1]==500) && dir==2){
			System.out.println("error, bottom edge already on 500");
			return false;
		}
		
		//check for bordering pieces
		boolean collisionFree=true;
		for(int i=0;i<10;i++){
			if(i != selNum) {
			Piece p2 = model.checkPiece(i);
			switch(dir) {
			case 0:
				if(((p.getTLeft()[1]==p2.getBLeft()[1]) && (p.getTRight()[1]==p2.getBRight()[1]))&&
						((p.getTLeft()[0]==p2.getBLeft()[0]) && (p.getTRight()[0]==p2.getBRight()[0]))){
					System.out.println("Piece "+selNum+" shares a border with "+i+" at y="+p.getTLeft()[1]);
					System.out.println(p.getTLeft()[1]+","+p2.getBLeft()[1]+","+p.getTRight()[1]+","+p2.getBRight()[1]);
					//active piece contacting on top
					System.out.println("collisionFree up failed.");
					collisionFree= false;
				}break;
			case 1:
				if(((p.getTRight()[0]==p2.getTLeft()[0]) && (p.getBRight()[0]==p2.getBLeft()[0]))&&
						((p.getTRight()[1]==p2.getTLeft()[1]) && (p.getBRight()[1]==p2.getBLeft()[1]))){
					System.out.println("Piece "+selNum+" shares a border with "+i+" at x="+p.getTRight()[0]);
					//active piece contacting on right
					System.out.println("collisionFree right failed.");
					collisionFree= false;
				}break;
			case 2:
				if(((p.getBLeft()[1]==p2.getTLeft()[1]) && (p.getBRight()[1]==p2.getTRight()[1]))&&
						((p.getBLeft()[0]==p2.getTLeft()[0]) && (p.getBRight()[0]==p2.getTRight()[0]))){
					System.out.println("Piece "+selNum+" shares a border with "+i+" at y="+p.getBLeft()[1]);
					System.out.println(p.getBLeft()[1]+","+p2.getTLeft()[1]+","+p.getBRight()[1]+","+p2.getTRight()[1]);
					System.out.println(p.getBLeft()[0]+","+p2.getTLeft()[0]+","+p.getBRight()[0]+","+p2.getTRight()[0]);
					//active piece contacting on bottom
					System.out.println("collisionFree down failed.");
					collisionFree= false;
				}break;
			case 3:
				if(((p.getTLeft()[0]==p2.getTRight()[0]) && (p.getBLeft()[0]==p2.getBRight()[0]))&&
						((p.getTLeft()[1]==p2.getTRight()[1]) && (p.getBLeft()[1]==p2.getBRight()[1]))){
					System.out.println("Piece "+selNum+" shares a border with "+i+" at x="+p.getTLeft()[0]);
					//active piece contacting on left
					System.out.println("collisionFree left failed.");
					collisionFree= false;
				}break;
			}}
		}
		
		return collisionFree;
	}
	
	
}
