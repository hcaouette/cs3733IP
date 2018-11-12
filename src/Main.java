import java.awt.Canvas;
import java.awt.EventQueue;

import puzzle.boundary.*;
import puzzle.model.Model;
import puzzle.controller.*;

public class Main {

public static void main(String[] args) {
    Model gameMod = new Model();
    //initial configuration
    gameMod.addPiece(0,0, 0, 100, 0, 0, 200, 100, 200);
    gameMod.addPiece(1,100, 0, 300, 0, 100, 200, 300, 200);
    gameMod.addPiece(2,300, 0, 400, 0, 300, 200, 400, 200);
    gameMod.addPiece(3,0, 200, 100, 200, 0, 400, 100, 400);
    gameMod.addPiece(4,300, 200, 400, 200, 300, 400, 400, 400);
    gameMod.addPiece(5,100, 400, 300, 400, 100, 500, 300, 500);
    gameMod.addPiece(6,100, 200, 200, 200, 100, 300, 200, 300);
    gameMod.addPiece(7,200, 200, 300, 200, 200, 300, 300, 300);
    gameMod.addPiece(8,100, 300, 200, 300, 100, 400, 200, 400);
    gameMod.addPiece(9,200, 300, 300, 300, 200, 400, 300, 400);
    
    for(int i=0; i<10; i++) {
    	gameMod.checkPiece(i).printDim();
    }
    
    //create and open the SlidingPuzzleApp window
    EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				SlidingPuzzleApp frame = new SlidingPuzzleApp();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
    
    //establish a new puzzle view, to populate the app window
    PuzzleView view = new PuzzleView();
    
    
    //view.paintComponent(frame.contentPane);
}
}
