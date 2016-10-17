
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;

import javax.swing.ImageIcon;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class Osc extends JFrame {

	/**
	 * 
	 */

	private JPanel contentPane;

	public static Dimension dim;

	ImageIcon osc1 = createImageIcon("/res/images/osc1.gif", "Blinker (period 2)");
	ImageIcon osc2 = createImageIcon("/res/images/osc2.gif", "Toad (period 2)");
	ImageIcon osc3 = createImageIcon("/res/images/osc3.gif", "Beacon (period 2)");
	ImageIcon osc4 = createImageIcon("/res/images/osc4.gif", "Pulsar (period 3)");
	ImageIcon osc5 = createImageIcon("/res/images/osc5.gif", "Pentadecathlon (period 15)");

	/**
	 * Launch the application.
	 */
	public static void oscWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dim = Toolkit.getDefaultToolkit().getScreenSize();
					Osc frame = new Osc();
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
	public Osc() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Osc.class.getResource("/javax/swing/plaf/metal/icons/ocean/info.png")));
		setResizable(false);
		setTitle("Oscillators");
		setBounds(100, 100, 500, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 494, 453);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel(
				"Oscillators are patterns that repeat the same pattern in the same");
		lblNewLabel.setBounds(17, 11, 467, 22);
		panel.add(lblNewLabel);

		JLabel lblPeriodOfSteps = new JLabel("location over a period of steps.");
		lblPeriodOfSteps.setBounds(17, 33, 447, 14);
		panel.add(lblPeriodOfSteps);

		JLabel lblNewLabel_1 = new JLabel("Blinker (period 2)");
		lblNewLabel_1.setIcon(new ImageIcon(Osc.class.getResource("/images/osc1.gif")));
		lblNewLabel_1.setBounds(10, 33, 282, 129);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Toad (period 2)");
		lblNewLabel_2.setIcon(new ImageIcon(Osc.class.getResource("/images/osc2.gif")));
		lblNewLabel_2.setBounds(271, 33, 213, 129);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Beacon (period 2)");
		lblNewLabel_3.setIcon(new ImageIcon(Osc.class.getResource("/images/osc3.gif")));
		lblNewLabel_3.setBounds(271, 240, 213, 119);
		panel.add(lblNewLabel_3);

		JLabel lblPulsarperiod = new JLabel("Pulsar (period 3)");
		lblPulsarperiod.setIcon(new ImageIcon(Osc.class.getResource("/images/osc4.gif")));
		lblPulsarperiod.setBounds(10, 297, 298, 156);
		panel.add(lblPulsarperiod);

		JLabel lblNewLabel_4 = new JLabel("Pentadecathlon (period 15)");
		lblNewLabel_4.setIcon(new ImageIcon(Osc.class.getResource("/images/osc5.gif")));
		lblNewLabel_4.setBounds(10, 140, 282, 167);
		panel.add(lblNewLabel_4);
	}
}
