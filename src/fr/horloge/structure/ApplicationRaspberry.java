package fr.horloge.structure;

import com.pi4j.io.gpio.PinEdge;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

import fr.horloge.structure.digital.button.Button;
import fr.horloge.structure.digital.buzzer.Buzzer;
import fr.horloge.structure.digital.led.Led;

public class ApplicationRaspberry extends AbstractApplication 
{

	private static final ApplicationRaspberry instance = new ApplicationRaspberry();

	private Button buttonViolet;
	private Button buttonOrange;
	private Button buttonBlack;
	
	private Button buttonGray;
	private Button buttonWhite;
	private Button buttonGreen;
	private Button buttonBlue;
	private Button buttonYellow;

	private Led ledGreen;

	private Buzzer buzzer;
	
	private ApplicationRaspberry()
	{

		super();
				
		// Création des boutons digitaux
		buttonViolet = FactoryRaspberry.getInstance().createGestionButtonViolet();
		buttonOrange = FactoryRaspberry.getInstance().createGestionButtonOrange();
		buttonBlack = FactoryRaspberry.getInstance().createGestionButtonBlack();
		buttonGray = FactoryRaspberry.getInstance().createGestionButtonGray();
		buttonWhite = FactoryRaspberry.getInstance().createGestionButtonWhite();
		buttonGreen = FactoryRaspberry.getInstance().createGestionButtonGreen();
		buttonBlue = FactoryRaspberry.getInstance().createGestionButtonBlue();
		buttonYellow = FactoryRaspberry.getInstance().createGestionButtonYellow();

		// Création des led
		ledGreen = FactoryRaspberry.getInstance().createGestionLedGreen();

		// Création du buzzer
		buzzer = FactoryRaspberry.getInstance().createGestionBuzzer();
		
		// Création de l'écouteur digital
		GpioPinEcouteurDigital gpioPinEcouteurDigital = new GpioPinEcouteurDigital();

		// Gestion de la partie digitale
		buttonViolet.getButton().addListener( gpioPinEcouteurDigital );
		buttonOrange.getButton().addListener( gpioPinEcouteurDigital );
		buttonBlack.getButton().addListener( gpioPinEcouteurDigital );
		buttonGray.getButton().addListener( gpioPinEcouteurDigital );
		buttonWhite.getButton().addListener( gpioPinEcouteurDigital );
		buttonGreen.getButton().addListener( gpioPinEcouteurDigital );
		buttonBlue.getButton().addListener( gpioPinEcouteurDigital );
		buttonYellow.getButton().addListener( gpioPinEcouteurDigital );

		// Création des threads digitaux de l'application
		DigitalThreadLed digitalThreadLed = new DigitalThreadLed();
		digitalThreadLed.start();
		
		DigitalThreadBuzzer digitalThreadBuzzer = new DigitalThreadBuzzer();
		digitalThreadBuzzer.start();
		
	}
	
	@Override
	public void doClose()
	{

		// Eteindre la led
		ledGreen.eteindre();
		
		// Stopper le buzzer		
		buzzer.stopper();
		
		// Fermer l'application
		super.doClose();
	}
	
	public class GpioPinEcouteurDigital implements GpioPinListenerDigital
	{

		public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent e)
		{
			
			if( e.getPin() == buttonViolet.getButton() && e.getEdge().equals( PinEdge.RISING ) )
			{

				doViolet();
			}
			else if( e.getPin() == buttonOrange.getButton() && e.getEdge().equals( PinEdge.RISING ) )
			{

				doOrange();
			}
			else if( e.getPin() == buttonBlack.getButton() && e.getEdge().equals( PinEdge.RISING ) )
			{

				doBlack();
			}
			else if( e.getPin() == buttonGray.getButton() && e.getEdge().equals( PinEdge.RISING ) )
			{

				doGray();
			}
			else if( e.getPin() == buttonWhite.getButton() && e.getEdge().equals( PinEdge.RISING ) )
			{
	
				doWhite();				
			}
			else if( e.getPin() == buttonGreen.getButton() && e.getEdge().equals( PinEdge.RISING ) )
			{
	
				doGreen();				
			}
			else if( e.getPin() == buttonBlue.getButton() && e.getEdge().equals( PinEdge.RISING ) )
			{
	
				doBlue();				
			}
			else if( e.getPin() == buttonYellow.getButton() && e.getEdge().equals( PinEdge.RISING ) )
			{

				doYellow();
			}

		}

	}
	
	public class DigitalThreadLed extends Thread
	{
		
		private void pause( int ms )
		{
			
			try
			{

				Thread.sleep( ms );
			}
			catch (InterruptedException ie)
			{

				System.out.println( ">>> InterruptedException : " + ie.getMessage() );
			}
			
		}
		
		public void run()
		{
			
			while( true )
			{
				
				if( actionGreen )
				{
					
					ledGreen.allumer();
					pause( 500 );
					ledGreen.eteindre();
					pause( 500 );
				}
				else
				{
					
					ledGreen.eteindre();
				}

				pause( 100 );
				
			}
			
		}
		
	}
		
	public class DigitalThreadBuzzer extends Thread
	{
		
		private void pause( int ms )
		{
			
			try
			{

				Thread.sleep( ms );
			}
			catch (InterruptedException ie)
			{

				System.out.println( ">>> InterruptedException : " + ie.getMessage() );
			}
			
		}
		
		public void run()
		{
			
			while( true )
			{
				
				if( actionBlue )
				{
					
					buzzer.sonner();
					pause( 500 );
					buzzer.stopper();
					pause( 500 );
				}
				else
				{
					
					buzzer.stopper();
				}

				pause( 100 );
				
			}
			
		}
		
	}
	
	public static final ApplicationRaspberry getInstance()
	{
		
		return instance;
	}
	
}
