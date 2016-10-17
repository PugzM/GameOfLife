import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.net.URL;

@SuppressWarnings("serial")
public class Gun extends JFrame {

	private JPanel contentPane;

	public static Dimension dim;

	//ImageIcon gun1 = createImageIcon("/res/images/gun1.png", "Glider");
	//ImageIcon gun2 = createImageIcon("/res/images/gun2.gif", "Lightweight Spaceship (LWSS)");

	
	/**
	 * Launch the application.
	 */
	public static void gunWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dim = Toolkit.getDefaultToolkit().getScreenSize();
					Gun frame = new Gun();
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
	
	public Gun() {
		
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Gun.class.getResource("/javax/swing/plaf/metal/icons/ocean/info.png")));
		setTitle("Guns");
		setBounds(100, 100, 645, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInACellular = new JLabel("In a cellular automaton, a gun is a pattern with a main");
		lblInACellular.setBounds(10, 16, 414, 14);
		contentPane.add(lblInACellular);

		JLabel lblRepeatsPeriodicallyLike = new JLabel(
				"part that repeats periodically, like an oscillator, and that");
		lblRepeatsPeriodicallyLike.setBounds(10, 32, 414, 14);
		contentPane.add(lblRepeatsPeriodicallyLike);

		JLabel lblEmitsSpaceshipsThere = new JLabel("also periodically emits spaceships. There are then two");
		lblEmitsSpaceshipsThere.setBounds(10, 48, 414, 14);
		contentPane.add(lblEmitsSpaceshipsThere);

		JLabel lblConsideredThePeriod = new JLabel("periods that may be considered: the period of the");
		lblConsideredThePeriod.setBounds(10, 64, 414, 14);
		contentPane.add(lblConsideredThePeriod);

		JLabel lblOfTheGun = new JLabel("spaceship output, and the period of the gun itself, which");
		lblOfTheGun.setBounds(10, 80, 414, 14);
		contentPane.add(lblOfTheGun);

		JLabel lblOutputs = new JLabel("is necessarily a multiple of the spaceship output's");
		lblOutputs.setBounds(10, 96, 414, 14);
		contentPane.add(lblOutputs);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Gun.class.getResource("/images/gun1.png")));
		lblNewLabel.setBounds(10, 198, 610, 178);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Gun.class.getResource("/images/gun2.gif")));
		lblNewLabel_1.setBounds(370, 11, 300, 180);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("period.");
		lblNewLabel_2.setBounds(10, 112, 46, 14);
		contentPane.add(lblNewLabel_2);
	}
}
