package Lab10;

import javax.swing.JFrame;

public class ChangeColourDriver 
{

	public static void main(String[] args) 
	{
	
		MyColours changeColour = new MyColours("Button");
		changeColour.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		changeColour.setSize(200, 200);
		changeColour.setVisible(true);

	}//end main

}//end class