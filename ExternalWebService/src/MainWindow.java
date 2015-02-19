import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class MainWindow {
	
	public static JTextField street;
	public static JTextField nr;
	public static JTextField city;
	public static JTextField plz;
	
	public static void main(String[] args){
		JFrame frame = new JFrame("Externel WebService");
		frame.setSize(300,150);

		GridLayout gridLayout = new GridLayout(5, 2);
		frame.setLayout(gridLayout);
		frame.add(new JLabel("Street"));
		street = new JTextField();
		frame.add(street);
		frame.add(new JLabel("Nr"));
		nr = new JTextField();
		frame.add(nr);
		frame.add(new JLabel("City"));
		city = new JTextField();
		frame.add(city);
		frame.add(new JLabel("PLZ"));
		plz = new JTextField();
		frame.add(plz);
		JButton button = new JButton("Send");
		frame.add(button);
		button.addActionListener(new ButtonListener());
		frame.setVisible(true);

	}
}
