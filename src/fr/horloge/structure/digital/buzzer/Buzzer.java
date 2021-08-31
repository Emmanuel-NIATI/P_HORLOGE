package fr.horloge.structure.digital.buzzer;

import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;

import fr.horloge.structure.digital.AbstractGpioPinDigital;

public class Buzzer extends AbstractGpioPinDigital
{

	private GpioPinDigitalOutput buzzer;
	
	public Buzzer( Pin pin)
	{
		
		super();
		
		if( this.gpio != null )
		{
		
			buzzer = this.gpio.provisionDigitalOutputPin( pin );
		}
		
	}

	public void sonner()
	{
		
		buzzer.setState(PinState.HIGH);
	}

	public void stopper()
	{
		
		buzzer.setState(PinState.LOW);
	}
	
	public GpioPinDigitalOutput getBuzzer()
	{
		
		return this.buzzer;
	}
	
}
