package fr.horloge.structure.digital.button;

import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinPullResistance;

import fr.horloge.structure.digital.AbstractGpioPinDigital;

public class Button extends AbstractGpioPinDigital
{

	private GpioPinDigitalInput button;
	
	public Button( Pin pin, PinPullResistance pinPullResistance )
	{

		super();
		
		if( this.gpio != null )
		{
		
			this.button = this.gpio.provisionDigitalInputPin( pin, pinPullResistance );
		}
		
	}
	
	public GpioPinDigitalInput getButton()
	{
		
		return this.button;
	}

}
