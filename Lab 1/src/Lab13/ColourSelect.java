package Lab13;

import javax.swing.JFrame;

public class ColourSelect {
	
	public static void main(String[] args) {
		
		ColorSelectFrame colourFrameSelect = new ColorSelectFrame();
		colourFrameSelect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		colourFrameSelect.setSize(300, 125);
		colourFrameSelect.setLocation(500, 400);
		colourFrameSelect.setVisible(true);
	}

}
