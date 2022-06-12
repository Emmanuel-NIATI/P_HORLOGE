package fr.horloge.structure.digital;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;

public abstract class AbstractGpioPinDigital
{

	protected GpioController gpio;
	
	public AbstractGpioPinDigital()
	{

		this.gpio = GpioFactory.getInstance();
		
	}

	public GpioController getGpio()
	{
		
		return this.gpio;
	}

	public void setGpio(GpioController _gpio)
	{
		
		this.gpio = _gpio;
	}
	
}
