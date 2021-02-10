package Lab12;


import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Align extends JFrame {
	private static final long serialVersionUID = 1L;
	private JCheckBox checkbox1 = new JCheckBox("Snap to Grid");
	private JCheckBox checkbox2 = new JCheckBox("Show Grid");
	private JTextField textfield1=new JTextField("X:");
	private JTextField textfield2=new JTextField("Y:");
	private JButton button1=new JButton("OK");
	private JButton button2=new JButton("Cancel");
	private JButton button3=new JButton("Help");
	
	
	
	// Constructor
	public Align(String title)	{
		super(title);
		getContentPane().setLayout(new GridLayout(3, 3));
		add(checkbox1);
		add(textfield1);
		add(button1);
		add(checkbox2);
		add(textfield2);
		add(button2);
		add(new JLabel());
		add(new JLabel());
		add(button3);
		
		// Attach listener to text field

		// Attach window listener
		addWindowListener(new WindowCloser());
	}//end costructor


	// Listener for window
	class WindowCloser extends WindowAdapter {
		public void windowClosing(WindowEvent evt) {
			System.exit(0);
		}
	}

}//end class