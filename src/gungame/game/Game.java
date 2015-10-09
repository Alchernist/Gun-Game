package gungame.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	static int seconds = 0;

	public Game() { // constructor for frame
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
		
		ArrayList<Panel> myPanels = new ArrayList<Panel>();
		myPanels.add(panelLeft);
		myPanels.add(panelLeft2);
		myPanels.add(panelLeft3);
		myPanels.add(panelRight);
		myPanels.add(panelRight2);
		myPanels.add(panelRight3);
		
		
		//labels
		Label label = new Label();
		label.timer();
		panel.add(label);

		Label label2 = new Label();
		label2.setForeground(Color.white);
		label2.setFont(new Font("", Font.BOLD, 35));
		label2.setText("Health: ");
		panel2.add(label2);
		
//		
//		//images
//		ImageIcon background = new ImageIcon("C:\\Users\\William\\Desktop\\pic1.png");
//		ImageIcon background1 = new ImageIcon("C:\\Users\\William\\Desktop\\pic2.png");
//		ImageIcon background2 = new ImageIcon("C:\\Users\\William\\Desktop\\pic3.png");
//		ImageIcon background3 = new ImageIcon("C:\\Users\\William\\Desktop\\pic4.png");
//		ImageIcon background4 = new ImageIcon("C:\\Users\\William\\Desktop\\pic5.png");
//		ImageIcon background5 = new ImageIcon("C:\\Users\\William\\Desktop\\pic6.png");
//		
//		Image img = background.getImage();
//		Image img1 = background1.getImage();
//		Image img2 = background2.getImage();
//		Image img3 = background3.getImage();
//		Image img4 = background4.getImage();
//		Image img5 = background5.getImage();
//		
//		BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
//		BufferedImage bi1 = new BufferedImage(img1.getWidth(null), img1.getHeight(null), BufferedImage.TYPE_INT_ARGB);
//		BufferedImage bi2 = new BufferedImage(img2.getWidth(null), img2.getHeight(null), BufferedImage.TYPE_INT_ARGB);
//		BufferedImage bi3 = new BufferedImage(img3.getWidth(null), img3.getHeight(null), BufferedImage.TYPE_INT_ARGB);
//		BufferedImage bi4 = new BufferedImage(img4.getWidth(null), img4.getHeight(null), BufferedImage.TYPE_INT_ARGB);
//		BufferedImage bi5 = new BufferedImage(img5.getWidth(null), img5.getHeight(null), BufferedImage.TYPE_INT_ARGB);
//		
//		Graphics picG = bi.createGraphics();
//		Graphics picG1 = bi1.createGraphics();
//		Graphics picG2 = bi2.createGraphics();
//		Graphics picG3 = bi3.createGraphics();
//		Graphics picG4 = bi4.createGraphics();
//		Graphics picG5 = bi5.createGraphics();
//		
//		picG.drawImage(img, 0, 145, 150, 200, null);// works
//		picG1.drawImage(img1, 0, 620, 150, 200, null);//works
//		picG2.drawImage(img2, 0, 0, 150, 200, null); // works
//		picG3.drawImage(img3, 0, 240, 150, 200, null); // works
//		picG4.drawImage(img4, 0, 150, 150, 200, null);//works
//		picG5.drawImage(img5, 0, 375, 150, 180, null);//works
//		
//		ImageIcon newBackground = new ImageIcon(bi);
//		ImageIcon newBackground1 = new ImageIcon(bi1);
//		ImageIcon newBackground2 = new ImageIcon(bi2);
//		ImageIcon newBackground3 = new ImageIcon(bi3);
//		ImageIcon newBackground4 = new ImageIcon(bi4);
//		ImageIcon newBackground5 = new ImageIcon(bi5);
//	
//		//stored images in an ArrayList
//		ArrayList<ImageIcon> myPics = new ArrayList<ImageIcon>();
//		myPics.add(newBackground);
//		myPics.add(newBackground1);
//		myPics.add(newBackground2);
//		myPics.add(newBackground3);
//		myPics.add(newBackground4);
//		myPics.add(newBackground5);
//		
//		//chooses random image to be displayed in panel
//		Random rand = new Random();
//		int index = rand.nextInt(myPics.size());
//		Label labelB = new Label();
//		labelB.setBounds(0, 0, 150, 250);
//		labelB.setIcon(myPics.get(index));
//		panelLeft.add(labelB);
//				
//		
//		for(int i = 0; i< 5; i++){ 	// sets all panels to no layout
//			myPanels.get(i).setLayout(null);
//		}
		
		setVisible(true);
			

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

		Graphics2D g2d = (Graphics2D) g; // HEALTH 
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