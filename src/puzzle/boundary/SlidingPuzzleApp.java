package puzzle.boundary;

import puzzle.model.*;
import puzzle.controller.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.Color;


@SuppressWarnings("serial")
public class SlidingPuzzleApp extends JFrame {
	PuzzleView view;
	Model model;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public SlidingPuzzleApp(Model m) {
		setResizable(false);//static size
		this.model = m;
		setTitle("SlidingPuzzleApp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		view = new PuzzleView(m);		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setSize(new Dimension(400, 500));
//		System.out.println("height is "+panel.getHeight()+", width is "+panel.getWidth());
//		System.out.println("height is "+view.getHeight()+", width is "+view.getWidth());
		panel.add(view);
		
			
		JButton btnReset = new JButton("Reset");
		JButton button = new JButton("^");
		JButton button_1 = new JButton("<");
		JButton button_2 = new JButton(">");
		JButton btnV = new JButton("V");
		JLabel lblMoves = new JLabel("Moves:");
		JLabel label = new JLabel("0");
		this.add(label);
		btnReset.addActionListener(new ResetController(m,this));
		view.add(btnReset);
		button.addActionListener(new MoveController(m,this,0));
		view.add(button);
		button_1.addActionListener(new MoveController(m,this,3));
		view.add(button_1);
		button_2.addActionListener(new MoveController(m,this,1));
		view.add(button_2);
		btnV.addActionListener(new MoveController(m,this,2));
		view.add(btnV);
		
//		view.addMouseMotionListener(new MouseAdapter() {
//			@Override
//			public void mouseMoved(MouseEvent e) {
//				new SelectController(m,SlidingPuzzleApp.this).react(e.getPoint());
//			}
//		});
		
		view.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				new SelectController(m,SlidingPuzzleApp.this).select(e.getPoint());
			}
		});
			
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(38)
										.addComponent(button)
										.addGap(36))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(button_1)
										.addGap(33)
										.addComponent(button_2)))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 39, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnReset)
										.addComponent(btnV))
									.addGap(15))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(lblMoves)
							.addGap(18)
							.addComponent(label)))
					.addContainerGap(79, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMoves)
								.addComponent(label))
							.addGap(189)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(button)
								.addPreferredGap(ComponentPlacement.UNRELATED))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(button_2)
								.addComponent(button_1))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnV)
							.addPreferredGap(ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
							.addComponent(btnReset)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	

	
	public PuzzleView getView() {
		return view;
	}
}
