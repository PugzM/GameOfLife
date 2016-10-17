import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Space extends JFrame {

	/**
	 * 
	 */

	private JPanel contentPane;

	public static Dimension dim;

	ImageIcon space1 = createImageIcon("/res/images/space1.gif", "Glider");
	ImageIcon space2 = createImageIcon("/res/images/space2.gif", "Lightweight Spaceship (LWSS)");

	/**
	 * Launch the application.
	 */
	public static void spaceWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dim = Toolkit.getDefaultToolkit().getScreenSize();
					Space frame = new Space();
					frame.setLocation(dim.width / 2 - frame.getWidth() / 2, dim.height / 2 - frame.getHeight() / 2);
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	/**
	 * Create the frame.
	 */
	public Space() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Space.class.getResource("/javax/swing/plaf/metal/icons/ocean/info.png")));
		setTitle("Spaceships");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInACellular = new JLabel("In a cellular automaton, a finite pattern is called a spaceship if it");
		lblInACellular.setBounds(30, 12, 414, 14);
		contentPane.add(lblInACellular);

		JLabel lblCertainNumberOf = new JLabel("orientation but in a different position. The smallest such number");
		lblCertainNumberOf.setBounds(30, 44, 414, 14);
		contentPane.add(lblCertainNumberOf);

		JLabel lblTheSmallestSuch = new JLabel("of generations is called the period of the spaceship.");
		lblTheSmallestSuch.setBounds(30, 60, 402, 14);
		contentPane.add(lblTheSmallestSuch);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Space.class.getResource("/images/space1.gif")));
		lblNewLabel.setBounds(30, 116, 172, 126);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Space.class.getResource("/images/space2.gif")));
		lblNewLabel_2.setBounds(228, 116, 183, 126);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("Glider");
		lblNewLabel_1.setBounds(30, 110, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("Lightweight spaceship (LWSS)");
		lblNewLabel_3.setBounds(228, 110, 196, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblReappearsAfterA = new JLabel("reappears after a certain number of generations in the same");
		lblReappearsAfterA.setBounds(30, 28, 414, 14);
		contentPane.add(lblReappearsAfterA);
	}

}
