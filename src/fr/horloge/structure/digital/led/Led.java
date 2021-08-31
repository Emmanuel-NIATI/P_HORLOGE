package fr.horloge.structure.digital.led;

import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;

import fr.horloge.structure.digital.AbstractGpioPinDigital;

public class Led extends AbstractGpioPinDigital
{

	private GpioPinDigitalOutput led;
	
	public Led( Pin pin)
	{
		
		super();
		
		if( this.gpio != null )
		{
		
			led = this.gpio.provisionDigitalOutputPin( pin );
		}
		
	}

	public void allumer()
	{
		
		led.setState(PinState.HIGH);
	}

	public void eteindre()
	{
		
		led.setState(PinState.LOW);
	}
	
	public GpioPinDigitalOutput getLed()
	{
		
		return this.led;
	}
	
}
