package gungame.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	static int seconds = 0;

	public static void main(String[] args) { // main method
		new Game().setVisible(true);

	}

	private Game() { // constructor for frame
		super("Lets Win this Hackathon!");
		setSize(1024, 768);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.CYAN);
		setLayout(null);
		
		//panels for top and bottom
		Panel panel = new Panel(); // panel
		panel.setBounds(0, 0, 1024, 70 );
		add(panel);

		Panel panel2 = new Panel(); // panel
		panel2.setBounds(0, 670, 1024, 70 );
		add(panel2);

		// panels for left and right (6 panels total)
		Panel panelLeft = new Panel();
		panelLeft.setBackground(Color.blue);
		panelLeft.setBounds(0, 70, 150, 200 ); //x,y, width, length
		add(panelLeft);
		
		Panel panelLeft2 = new Panel();
		panelLeft2.setBackground(Color.green);
		panelLeft2.setBounds(0, 270, 150, 200 );
		add(panelLeft2);
		
		Panel panelLeft3 = new Panel();
		panelLeft3.setBackground(Color.blue);
		panelLeft3.setBounds(0, 470, 150, 200 );
		add(panelLeft3);
		
		Panel panelRight = new Panel();
		panelRight.setBackground(Color.blue);
		panelRight.setBounds(874, 70, 150, 200 );
		add(panelRight);
		
		Panel panelRight2 = new Panel();
		panelRight2.setBackground(Color.green);
		panelRight2.setBounds(874, 270, 150, 200 );
		add(panelRight2);
		
		Panel panelRight3 = new Panel();
		panelRight3.setBackground(Color.blue);
		panelRight3.setBounds(874, 470, 150, 200 );
		add(panelRight3);
		
		//labels
		Label label = new Label();
		label.timer();
		panel.add(label);

		Label label2 = new Label();
		label2.setForeground(Color.white);
		label2.setFont(new Font("", Font.BOLD, 35));
		label2.setText("Health: ");
		panel2.add(label2);

	}

	/*******************************************************************
	 * PANELS
	 ********************************************************************/
	public class Panel extends JPanel { // create new class for the panels
		private static final long serialVersionUID = 1L;

		private Panel() { // constructor for panel
			setBackground(Color.black);
		}
	}

	/*******************************************************************
	 * LABELS
	 ********************************************************************/

	public class Label extends JLabel {
		public void timer() {
			Timer timer = new Timer(100, new ActionListener() { // timer for
						// score
						@Override
						public void actionPerformed(ActionEvent e) {
							seconds++;
							setText("Score:" + seconds);
						}
					});
			timer.start();
			setForeground(Color.white);
			setFont(new Font("", Font.BOLD, 35));
		}

	}

	/*******************************************************************
	 * GRAPHICS
	 ********************************************************************/
	public void paint(Graphics g) { // drawings
		super.paintComponents(g);

		g.drawRect(512, 310, 40, 40); // STICK FIGURE
		g.drawLine(532, 350, 532, 360); // neck (x1,y1 x2,y2) (starting ending)
		g.drawRect(482, 360, 100, 150); // body
		g.drawLine(582, 410, 632, 410); // right arm
		g.drawLine(632, 410, 632, 350);
		g.drawLine(482, 410, 422, 470); // left arm
		g.drawLine(507, 510, 477, 600); // left leg
		g.drawLine(477, 600, 457, 600);
		g.drawLine(557, 510, 587, 600); // right leg
		g.drawLine(587, 600, 607, 600);

		Graphics2D g2d = (Graphics2D) g; // HEALTH /*may need to create seprate
		// objects */
		g2d.setColor(Color.RED);
		g2d.fillOval(590, 710, 30, 30);
		g2d.fillOval(622, 710, 30, 30);
		g2d.fillOval(654, 710, 30, 30);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}