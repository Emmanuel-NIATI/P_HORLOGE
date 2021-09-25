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

	private ApplicationRaspberry()
	{

		super();
	
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
