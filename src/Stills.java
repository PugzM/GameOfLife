import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Stills extends JFrame {

	private JPanel contentPane;

	public static Dimension dim;

	ImageIcon still1 = createImageIcon("/res/images/still1.png", "Block");
	ImageIcon still2 = createImageIcon("/res/images/still2.png", "Beehive");
	ImageIcon still3 = createImageIcon("/res/images/still3.png", "Loaf");
	ImageIcon still4 = createImageIcon("/res/images/still4.png", "Boat");

	/**
	 * Launch the application.
	 */
	public static void stillsWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dim = Toolkit.getDefaultToolkit().getScreenSize();
					Stills frame = new Stills();
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
	public Stills() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Stills.class.getResource("/javax/swing/plaf/metal/icons/ocean/info.png")));
		setTitle("Stills");

		setBounds(100, 100, 339, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Stills are life patterns that do not change.");
		lblNewLabel.setBounds(10, 11, 305, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Block");
		lblNewLabel_1.setBounds(10, 25, 121, 98);
		lblNewLabel_1.setIcon(new ImageIcon(Stills.class.getResource("/images/still1.png")));
		contentPane.add(lblNewLabel_1);

		JLabel lblBeehive = new JLabel("Beehive");
		lblBeehive.setBounds(170, 35, 162, 88);
		lblBeehive.setIcon(new ImageIcon(Stills.class.getResource("/images/still2.png")));
		contentPane.add(lblBeehive);

		JLabel lblNewLabel_3 = new JLabel("Loaf");
		lblNewLabel_3.setBounds(10, 140, 162, 98);
		lblNewLabel_3.setIcon(new ImageIcon(Stills.class.getResource("/images/still3.png")));
		contentPane.add(lblNewLabel_3);

		JLabel lblBoat = new JLabel("Boat");
		lblBoat.setBounds(170, 156, 138, 82);
		lblBoat.setIcon(new ImageIcon(Stills.class.getResource("/images/still4.png")));
		contentPane.add(lblBoat);
	}

}
