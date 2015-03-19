import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class MainWindow {
	
	public static JTextField street;
	public static JTextField nr;
	public static JTextField city;
	public static JTextField plz;
	public static JTextField description;
	
	public static void main(String[] args){
		JFrame frame = new JFrame("External WebService");
		frame.setSize(600,200);

		GridBagLayout gridLayout = new GridBagLayout();
		frame.setLayout(gridLayout);
		frame.add(new JLabel("Street"), new GridBagConstraints(0,0,1,1,1.0,1.0,GridBagConstraints.WEST,GridBagConstraints.NONE,new Insets(0,10,0,0),10,0));
		street = new JTextField();
		frame.add(street, new GridBagConstraints(1,0,2,1,2.0,1.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));
		frame.add(new JLabel("Street Nr"), new GridBagConstraints(0,1,1,1,1.0,1.0,GridBagConstraints.WEST,GridBagConstraints.NONE,new Insets(0,10,0,0),10,0));
		nr = new JTextField();
		frame.add(nr, new GridBagConstraints(1,1,2,1,2.0,1.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));
		frame.add(new JLabel("City"), new GridBagConstraints(0,2,1,1,1.0,1.0,GridBagConstraints.WEST,GridBagConstraints.NONE,new Insets(0,10,0,0),10,0));
		city = new JTextField();
		frame.add(city, new GridBagConstraints(1,2,2,1,2.0,1.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));
		frame.add(new JLabel("PLZ"), new GridBagConstraints(0,3,1,1,1.0,1.0,GridBagConstraints.WEST,GridBagConstraints.NONE,new Insets(0,10,0,0),10,0));
		plz = new JTextField();
		frame.add(plz, new GridBagConstraints(1,3,2,1,2.0,1.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));
		frame.add(new JLabel("Description"), new GridBagConstraints(0,4,1,1,1.0,1.0,GridBagConstraints.WEST,GridBagConstraints.NONE,new Insets(0,10,0,0),10,0));
		description = new JTextField();
		frame.add(description, new GridBagConstraints(1,4,2,3,2.0,6.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));
		JButton button = new JButton("Send");
		frame.add(button, new GridBagConstraints(2,7,1,1,1.0,1.0,GridBagConstraints.WEST,GridBagConstraints.NONE,new Insets(0,0,0,0),0,0));
		button.addActionListener(new ButtonListener());
		frame.setVisible(true);

	}
}
