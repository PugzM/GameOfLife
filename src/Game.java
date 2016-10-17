import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.util.Hashtable;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Game extends JPanel
		implements MouseListener, MouseMotionListener, ActionListener, Runnable, ChangeListener {

	static final int WIDTH = 90;
	static final int HEIGHT = 90;

	static final int SPEED_MIN = 10;
	static final int SPEED_MAX = 600;
	static final int SPEED_INIT = 300;
	static int speedInt;
	static String stringTime = "300";

	JFrame frame = new JFrame("Game of Life");
	JFrame stillsFrame;
	// the panel is the a 'panel' within the JFrame. This is where we will draw.
	boolean[][] grid = new boolean[WIDTH][HEIGHT];
	MyPanel panel = new MyPanel(grid);
	JSlider speed = new JSlider(JSlider.HORIZONTAL, SPEED_MIN, SPEED_MAX, SPEED_INIT);
	JSlider gridSizeSlider = new JSlider(JSlider.HORIZONTAL, SPEED_MIN, SPEED_MAX, SPEED_INIT);
	JButton step = new JButton("Step");
	JButton start = new JButton("Start");
	JButton stop = new JButton("Stop");
	JButton clear = new JButton("Clear");
	public Dimension dim;
	
	public static Music musicObj = new Music();

	//final public ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));

	// Menu Variables
	JMenuBar menuBar;
	JMenu about, tips;
	JMenuItem aboutGOL, aboutPROG, still, osc, spaceship, guns;

	Container south = new Container();
	Container north = new Container();
	boolean running = false;

	public Game() {
		//URL iconURL = Game.class.getResource("/res/images/icon.png");
		//ImageIcon icon = new ImageIcon(iconURL);
		
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Game.class.getResource("/images/icon.png")));
		//frame.setIconImage(icon);
		frame.setSize(1000, 1000);
		frame.getContentPane().setLayout(new BorderLayout());
		// Add the mouse listener for the panel
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);

		Hashtable<Integer, JLabel> speedLabels = new Hashtable<Integer, JLabel>();
		speedLabels.put(new Integer(SPEED_MIN), new JLabel("Fast"));
		speedLabels.put(new Integer(SPEED_INIT), new JLabel("Set Speed"));
		speedLabels.put(new Integer(SPEED_MAX), new JLabel("Slow"));
		speed.setLabelTable(speedLabels);
		speed.setPaintLabels(true);

		// Menu stuff
		// ==========

		menuBar = new JMenuBar();
		tips = new JMenu("Tips");
		about = new JMenu("About");
		menuBar.add(tips);
		menuBar.add(about);

		// menu items

		still = new JMenuItem("Stills");
		osc = new JMenuItem("Oscillators");
		spaceship = new JMenuItem("Spaceships");
		guns = new JMenuItem("Guns");
		tips.add(still);
		still.addActionListener(this);
		tips.add(osc);
		osc.addActionListener(this);
		tips.add(spaceship);
		spaceship.addActionListener(this);
		tips.add(guns);
		guns.addActionListener(this);

		aboutGOL = new JMenuItem("About Game of Life");
		aboutPROG = new JMenuItem("About this Program");
		about.add(aboutGOL);
		aboutGOL.addActionListener(this);
		about.add(aboutPROG);
		aboutPROG.addActionListener(this);

		frame.setJMenuBar(menuBar);

		frame.getContentPane().add(panel, BorderLayout.CENTER);
		// Create the south container and add things to it.
		gridSizeSlider.addChangeListener(this);
		south.setLayout(new GridLayout(1, 5));
		south.add(start);
		start.addActionListener(this);
		south.add(step);
		step.addActionListener(this);
		south.add(stop);
		stop.addActionListener(this);
		south.add(clear);
		clear.addActionListener(this);
		south.add(speed);
		speed.addChangeListener(this);
		frame.getContentPane().add(south, BorderLayout.SOUTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(dim.width / 2 - frame.getWidth() / 2, dim.height / 2 - frame.getHeight() / 2);
		frame.setVisible(true);

		try {
			musicObj.play();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(frame,
				"Welcome to the Game of Life!\n\n"
						+ "The universe of the Game of Life is an infinite two-dimensional orthogonal grid of square cells.\n"
						+ "Each cell exists in one of two possible states, alive or dead. Every cell interacts with its eight\n"
						+ "neighbours, which are the cells that are horizontally, vertically, or diagonally adjacent. \n"
						+ "At each step in time, the following transitions occur:\n\n"
						+ "1. Any live cell with fewer than two live neighbours dies, as if caused by under-population.\n"
						+ "2. Any live cell with two or three live neighbours lives on to the next generation.\n"
						+ "3. Any live cell with more than three live neighbours dies, as if by over-population.\n"
						+ "4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.\n\n"
						+ "Draw some cells and press start to see your cells evolve. Tips available in the menu bar.\n\n"
						+ "\"Life, uh, finds a way.\" - Dr. Ian Malcolm");

	}

	// Main Method
	// ===========

	public static void main(String[] args) {
		new Game();
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource().equals(step) == true) {
			if (running == false) {
				step();
				frame.repaint();
			}
		}
		if (ev.getSource().equals(start)) {
			if (running == false) {
				running = true;
				Thread t = new Thread(this);
				// start eventually calls the 'run' method.
				t.start();
			}
		}
		if (ev.getSource().equals(stop)) {
			running = false;
		}
		if (ev.getSource().equals(clear)) {
			clear();
			running = false;
		}
		if (ev.getSource().equals(aboutGOL)) {
			JOptionPane.showMessageDialog(frame,
					"The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician\nJohn Horton Conway in 1970.\n\n"
							+ "The \"game\" is a zero-player game, meaning that its evolution is determined by its initial state, requiring no further input. One interacts\n"
							+ "with the Game of Life by creating an initial configuration and observing how it evolves or, for advanced players, by creating patterns with\n"
							+ "particular properties.\n\n"
							+ "From a theoretical point of view, Game of Life is interesting because it has the power of a universal Turing machine: that is, anything that\n"
							+ "can be computed algorithmically can be computed within Conway's Game of Life.\n\n"
							+ "Ever since its publication, Conway's Game of Life has attracted much interest, because of the surprising ways in which the patterns can evolve.\n"
							+ "Life provides an example of emergence and self-organization.\n\n"
							+ "The game can also serve as a didactic analogy, used to convey the somewhat counter-intuitive notion that \"design\" and \"organization\" can\n"
							+ "spontaneously emerge in the absence of a designer. For example, philosopher and cognitive scientist Daniel Dennett has used the analogue of\n"
							+ "Conway's Life \"universe\" extensively to illustrate the possible evolution of complex philosophical constructs, such as consciousness and\n"
							+ "free will, from the relatively simple set of deterministic physical laws governing our own universe.");
		}
		if (ev.getSource().equals(aboutPROG)) {
			JOptionPane.showMessageDialog(frame,
					"This program was coded in Java by James Pugliese.\nMusic written by James Pugliese.\n" + "Created on the 7th of March, 2016.");
		}
		if (ev.getSource().equals(still)) {
			Stills.stillsWindow();
		}
		if (ev.getSource().equals(osc)) {
			Osc.oscWindow();
		}
		if (ev.getSource().equals(spaceship)) {
			Space.spaceWindow();
		}
		if (ev.getSource().equals(guns)) {
			Gun.gunWindow();
		}

	}

	public void run() {
		while (running == true) {

			Long convert = Long.parseLong(stringTime);
			long time = convert.longValue();
			step();
			frame.repaint();
			try {
				Thread.sleep(time);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public void clear() {

		for (int x = 0; x < grid.length; x++) {
			for (int y = 0; y < grid[x].length; y++) {
				grid[x][y] = false;
				frame.repaint();
			}
		}

	}

	// This will take one step in the simulation.
	// For every cell, count it's neighbours.
	// If it is alive and has 2 or 3 neighbours, it stays alive; otherwise it
	// dies.
	// If it is dead and has 3 neighbours, it comes back to life; otherwise it
	// stays dead.
	public void step() {
		boolean[][] newGrid = new boolean[grid.length][grid.length];
		for (int x = 0; x < grid.length; x++) {
			for (int y = 0; y < grid.length; y++) {
				int neighbourCount = 0;
				// the y > 0 just checks that we don't go off the top of the
				// array.

				// up
				if (y > 0 && grid[x][y - 1] == true) {
					neighbourCount++;
				}
				// left
				if (x > 0 && grid[x - 1][y] == true) {
					neighbourCount++;
				}
				// down and right
				if (y < grid.length - 1 && x < grid.length - 1 && grid[x + 1][y + 1] == true) {
					neighbourCount++;
				}
				// Five more checks!

				// down
				if (y < grid.length - 1 && grid[x][y + 1] == true) {
					neighbourCount++;
				}
				// right
				if (x < grid.length - 1 && grid[x + 1][y] == true) {
					neighbourCount++;
				}
				// up and right
				if (y > 0 && x < grid.length - 1 && grid[x + 1][y - 1] == true) {
					neighbourCount++;
				}
				// down and left
				if (y < grid.length - 1 && x > 0 && grid[x - 1][y + 1] == true) {
					neighbourCount++;
				}
				// up and left
				if (y > 0 && x > 0 && grid[x - 1][y - 1] == true) {
					neighbourCount++;
				}

				if (grid[x][y] == true) {
					// if it has two or three neighbours.
					if (neighbourCount == 2 || neighbourCount == 3) {
						newGrid[x][y] = true;
					} else {
						newGrid[x][y] = false;
					}
				} else {// If it is dead, and it has 3 neighbours, back to life,
						// else dead.
					if (grid[x][y] == false) {
						// If you set this to 2 or 3 neighbours, you get an
						// explosion of life.
						if (neighbourCount == 3) {
							newGrid[x][y] = true;
						} else {
							newGrid[x][y] = false;
						}
					}

				}

			}
		}
		grid = newGrid;
		panel.setGrid(newGrid);
		frame.repaint();

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource().equals(speed) == true) {
			JSlider source = (JSlider) e.getSource();
			if (source.getValueIsAdjusting()) {
				int speedInt = (int) source.getValue();
				stringTime = Integer.toString(speedInt);
			}
		}

	}

	@Override
	public void mouseDragged(MouseEvent ev) {
		System.out.println(ev.getX() + "," + ev.getY());
		double col = Math.min(ev.getY() / ((double) panel.getHeight() / (double) HEIGHT), (double) HEIGHT - 1); // do
																												// math
																												// to
																												// figure
																												// this
																												// out!
		double row = Math.min(ev.getX() / ((double) panel.getWidth() / (double) WIDTH), (double) WIDTH - 1); // do
																												// math
																												// to
																												// figure
																												// this
																												// out!
		// The ! makes it equal to the opposite of what it was.
		if (grid[(int) row][(int) col] = false) {
			grid[(int) row][(int) col] = true;
		} else if (grid[(int) row][(int) col] = true) {
			grid[(int) row][(int) col] = true;
		}
		frame.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent ev) {
	}

	public void mouseClicked(MouseEvent ev) {
	}

	public void mouseEntered(MouseEvent ev) {
	}

	public void mouseExited(MouseEvent ev) {
	}

	public void mousePressed(MouseEvent ev) {
	}

	public void mouseReleased(MouseEvent ev) {
		System.out.println(ev.getX() + "," + ev.getY());

		double row = Math.min(ev.getX() / ((double) panel.getWidth() / (double) WIDTH), (double) WIDTH - 1);

		double col = Math.min(ev.getY() / ((double) panel.getHeight() / (double) HEIGHT), (double) HEIGHT - 1);

		grid[(int) row][(int) col] = !grid[(int) row][(int) col];
		frame.repaint();
	}

}
