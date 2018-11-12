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
	
	
	public PuzzleView(Model givenModel) {
		m = givenModel;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		/**g.setColor(Color.red);
		*g.fillRect(0, 0,  100, 200);
		*g.setColor(Color.blue);
		*g.fillRect(500, 500, 500, 500);
		*/
		Piece temPiece;
		int tLX,tLY,width,height;
		for(int i=0;i<10;i++){
			temPiece = m.checkPiece(i);
			tLX = temPiece.getTLeft()[0];
			tLY = temPiece.getTLeft()[1];
			width = (temPiece.getTRight()[0] - tLX);
			height = (temPiece.getBLeft()[1] - tLY);
			g.fillRect(tLX,tLY,width,height);
			
			Image piece2 = new Image();
		}
	}
	
	public void refreshScreen() {
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