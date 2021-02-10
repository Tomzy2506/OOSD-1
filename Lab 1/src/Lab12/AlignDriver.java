package Lab12;

import javax.swing.JFrame;

public class AlignDriver {

	public static void main(String[] args) {
		
		Align  convertTemp = new Align("Align");
		convertTemp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		convertTemp.setSize(500, 200);
		convertTemp.setLocation(500,400);
		convertTemp.setVisible(true);

	}//end main

}//end class