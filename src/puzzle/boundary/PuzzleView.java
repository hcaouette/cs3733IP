package puzzle.boundary;

import java.awt.*;
import java.util.*;
import javax.swing.JPanel;

import puzzle.model.*;

/** 
 * Knows how to visually present the puzzle. 
 */
public class PuzzleView extends JPanel {
	Model m;
	SlidingPuzzleApp puzzle;
	
	public PuzzleView(Model givenModel){
		m=givenModel;
		this.puzzle = m.getPuzzle();
	}

	@Override
	public void paintComponent(Graphics g){
		this.setSize(new Dimension(400, 500));
		this.setAlignmentX(LEFT_ALIGNMENT);
		this.setAlignmentY(TOP_ALIGNMENT);
		//System.out.println("height is "+getHeight()+", width is "+getWidth());
		super.paintComponent(g);
		Piece temPiece;
		int tLX,tLY,width,height;
		g.setColor(Color.GREEN);
		for(int i=0;i<10;i++){
			temPiece = m.checkPiece(i);
			tLX = temPiece.getTLeft()[0];
			tLY = temPiece.getTLeft()[1];
			width = (temPiece.getTRight()[0] - tLX);
			height = (temPiece.getBLeft()[1] - tLY);
			System.out.println("painting an "+width+" by "+height+" rect from "+tLX+","+tLY);
			//g.drawRect(tLX,tLY,width,height);
			
			g.fillRect(tLX,tLY,width,height);
		}
		
	}
	
	
	public void refreshScreen(){
		Piece temPiece;
		int tLX,tLY,width,height;
		for(int i=0;i<10;i++){
			temPiece = m.checkPiece(i);
			tLX = temPiece.getTLeft()[0];
			tLY = temPiece.getTLeft()[1];
			width = (temPiece.getTRight()[0] - tLX);
			height = (temPiece.getBLeft()[1] - tLY);
			//g.fillRect(tLX,tLY,width,height);
		}
	}
	
	
}