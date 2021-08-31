package fr.horloge.test;

import java.io.IOException;

import javax.swing.ImageIcon;

import fr.horloge.structure.driver.ILI9341;

public class TestLCD
{

	public static void main(String[] args)
	{
	
		ILI9341 display = new ILI9341();

		try
		{

			display.powerOnSequence();

			display.ClearScreen();

			ImageIcon imageIcon02 = new ImageIcon( TestLCD.class.getResource( "justine02.png" ) );

			int[] rgb_fo_02 = display.loadImage( imageIcon02 );

			display.drawPicture(rgb_fo_02, 240, 320, 0, 0);

		}
		catch(IOException ioe)
		{

			System.out.println( ioe.getMessage() );
		}
		catch(InterruptedException ie)
		{

			System.out.println( ie.getMessage() );
		}

	}

}
