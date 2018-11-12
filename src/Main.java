import java.awt.Canvas;
import java.awt.EventQueue;
import java.awt.event.*;

import puzzle.boundary.*;
import puzzle.model.Model;
import puzzle.controller.*;

public class Main {

public static void main(String[] args) {
    Model gameMod = new Model();
    
    final SlidingPuzzleApp app = new SlidingPuzzleApp(gameMod);
    app.setVisible(true);
    
    //associate puzzle to model
    gameMod.setPuzzle(app);
    
    //initial configuration of board
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
    
    // Disposing the window will complete the application
	app.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			if (new QuitController().confirm(app)) {
				app.dispose();
			}
		}      
	});
}}
