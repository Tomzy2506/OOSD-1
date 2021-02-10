package Lab11;



//Converts a Fahrenheit temperature entered by the user to Celsius, or vice versa

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ConvertTemp extends JFrame {
	static final long serialVersionUID=0;
	private JTextField fahrenField = new JTextField();
	private JTextField celsiusField = new JTextField();
	private boolean check;
	
	// Constructor
	public ConvertTemp(String title)	{
		// Set title for frame and choose layout
		super(title);
		getContentPane().setLayout(new GridLayout(2, 2));

		// Add Fahrenheit label and text field to frame
		add(new JLabel("Fahrenheit"));
		add(fahrenField);
		// Attach listener to text field

		// Add Celsius label and text field to frame
		add(new JLabel("Celsius"));
		add(celsiusField);
		// Attach listener to text field
		fahrenField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
		        check=true;
		      }
			@Override
		      public void focusLost(FocusEvent e) {
				check=false;
		      }
		      
		});
		// Attach window listener
		addWindowListener(new WindowCloser());
		Action action = new AbstractAction()
		{
			private static final long serialVersionUID = 1L;

			@Override
		    public void actionPerformed(ActionEvent e)
		    {
		        if(check==true)
		        {
		        	celsiusField.setText(String.valueOf((int)(Double.parseDouble(fahrenField.getText())-32)*5/9));
		        }
		        else
		        {
		        	fahrenField.setText(String.valueOf((int)(Double.parseDouble(celsiusField.getText()))*9/5+32));
		        }
		    }
		};
			celsiusField.addActionListener( action );
			fahrenField.addActionListener( action );
		
		
	}//end costructor

	// Listener for window
	class WindowCloser extends WindowAdapter {
		public void windowClosing(WindowEvent evt) {
			System.exit(0);
		}
	}

}//end class