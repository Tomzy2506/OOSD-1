package Lab13;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorSelectFrame extends JFrame {
	
	private JButton okButton;
	private JButton cancelButton;
	private JCheckBox backgroundCheckBox;
	private JCheckBox foregroundCheckBox;
	private JComboBox colourComboBox;
	private JPanel panel;
	private JPanel panel2;
	
	public ColorSelectFrame() {
		super("ColourSelect");
		setLayout(new BorderLayout());
		
		colourComboBox = new JComboBox();
		colourComboBox.addItem("RED");
		colourComboBox.addItem("BLUE");
		add(colourComboBox, BorderLayout.NORTH);
		
		panel = new JPanel();
		backgroundCheckBox = new JCheckBox("background");
		foregroundCheckBox = new JCheckBox("foreground");
		panel.add(backgroundCheckBox);
		panel.add(foregroundCheckBox);
		add(panel, BorderLayout.CENTER);
		
		panel2 = new JPanel();
		okButton = new JButton("Ok");
		cancelButton = new JButton("Cancel");
		panel2.add(okButton);
		panel2.add(cancelButton);
		add(panel2, BorderLayout.SOUTH);
	}
	
}
