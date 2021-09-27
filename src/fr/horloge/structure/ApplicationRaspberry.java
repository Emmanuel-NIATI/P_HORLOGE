package fr.horloge.structure;

import java.io.IOException;

import javax.swing.ImageIcon;

import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

import fr.horloge.structure.driver.ILI9341;
import fr.horloge.structure.system.DiskFileMp3Explorer;

public class ApplicationRaspberry extends AbstractApplication 
{

	private static final ApplicationRaspberry instance = new ApplicationRaspberry();

	private DiskFileMp3Explorer diskFileMp3Explorer;

	private ILI9341 ecran;
	
	private ApplicationRaspberry()
	{

		super();
		
		// Création des ressources système
		
		diskFileMp3Explorer = FactoryRaspberry.getInstance().createGestionDiskFileMp3Explorer();
		
		// Création de l'écran LCD

		ecran = FactoryRaspberry.getInstance().createGestionEcran();
		
		// Gestion de lécran
		
		try
		{

			ecran.powerOnSequence();
			
			ecran.clearScreen();

			ImageIcon chat01 = new ImageIcon( ApplicationRaspberry.class.getResource( "chat01.png" ) );
			ImageIcon chat02 = new ImageIcon( ApplicationRaspberry.class.getResource( "chat02.png" ) );
			ImageIcon chat03 = new ImageIcon( ApplicationRaspberry.class.getResource( "chat03.png" ) );
			ImageIcon chat04 = new ImageIcon( ApplicationRaspberry.class.getResource( "chat04.png" ) );
			ImageIcon chat05 = new ImageIcon( ApplicationRaspberry.class.getResource( "chat05.png" ) );
			
			int[] rgb_chat01 = ecran.loadImage( chat01 );
			int[] rgb_chat02 = ecran.loadImage( chat02 );
			int[] rgb_chat03 = ecran.loadImage( chat03 );
			int[] rgb_chat04 = ecran.loadImage( chat04 );
			int[] rgb_chat05 = ecran.loadImage( chat05 );

			while( true )
			{

				ecran.drawPicture(rgb_chat01, 0, 0, 240, 320);
				ecran.drawPicture(rgb_chat02, 0, 0, 240, 320);
				ecran.drawPicture(rgb_chat03, 0, 0, 240, 320);
				ecran.drawPicture(rgb_chat04, 0, 0, 240, 320);
				ecran.drawPicture(rgb_chat05, 0, 0, 240, 320);
				
			}
			
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

	public class GpioPinEcouteurDigital implements GpioPinListenerDigital
	{

		public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent e)
		{
			

		}

	}

	
	public static final ApplicationRaspberry getInstance()
	{
		
		return instance;
	}
	
}
