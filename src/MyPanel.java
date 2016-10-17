import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyPanel extends JPanel {

	/**
	 * 
	 */
	boolean[][] grid;

	public MyPanel(boolean[][] newGrid) {
		// So the MyPanel object we created in Game class, is passing it's
		// boolean grid to this constructor.
		// So this makes each grid contain the same information, despite being
		// different variables.
		grid = newGrid;

	}

	public void setGrid(boolean[][] newGrid) {
		grid = newGrid;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		// JPanels know their dimensions so we can use 'this'.
		// So here we are using our array length, which was set by our final int
		// values in the Game class.
		// This allows us to number of rows and columns easily by simply
		// changing those values.
		double boxWidth = (double) (this.getWidth()) / grid.length;
		double boxHeight = (double) (this.getHeight()) / grid.length;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (grid[i][j] == true) {
					g.setColor(Color.GREEN);
					g.fillRect((int) (i * boxWidth), (int) (j * boxHeight), (int) (boxWidth), (int) (boxHeight));
				}
			}

		}
		for (int x = 0; x < grid.length + 1; x++) {
			g.setColor(Color.DARK_GRAY);
			g.drawLine((int) (x * boxWidth), 0, (int) (x * boxWidth), this.getHeight());
		}
		for (int y = 0; y < grid.length + 1; y++) {
			g.setColor(Color.DARK_GRAY);
			g.drawLine(0, (int) (y * boxHeight), this.getWidth(), (int) (y * boxHeight));
		}
		for (int x = 0; x < grid.length + 1; x += 10) {
			g.setColor(Color.GRAY);
			g.drawLine((int) (x * boxWidth), 0, (int) (x * boxWidth), this.getHeight());
		}
		for (int y = 0; y < grid.length + 1; y += 10) {
			g.setColor(Color.GRAY);
			g.drawLine(0, (int) (y * boxHeight), this.getWidth(), (int) (y * boxHeight));
		}

	}

}
