package puzzle.boundary;

import java.awt.Graphics;
import javax.swing.JPanel;

/** 
 * Knows how to visually present the puzzle. 
 */
public class PuzzleView extends JPanel {

	public PuzzleView() {

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.fillRect(0, 0,  400, 500);
		g.setColor(java.awt.Color.red);
		g.fillRect(0, 0, 100, 200);
	}
	
}