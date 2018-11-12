package puzzle.controller;

import javax.swing.JOptionPane;
import puzzle.boundary.SlidingPuzzleApp;

public class QuitController {
	public boolean confirm(SlidingPuzzleApp app) {
		return JOptionPane.showConfirmDialog (app, "Do you wish to exit Application?") == JOptionPane.OK_OPTION;	
	}
}