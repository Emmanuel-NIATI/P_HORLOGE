package fr.horloge.structure;

import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.RaspiPin;

import fr.horloge.structure.digital.button.Button;
import fr.horloge.structure.digital.buzzer.Buzzer;
import fr.horloge.structure.digital.led.Led;
import fr.horloge.structure.driver.ILI9341;
import fr.horloge.structure.system.DiskFileMp3Explorer;

public class FactoryRaspberry
{

	private static final FactoryRaspberry instance = new FactoryRaspberry();

	private DiskFileMp3Explorer diskFileMp3Explorer;
	
	private ILI9341 ecran;
	
	private FactoryRaspberry()
	{

		super();

		diskFileMp3Explorer = new DiskFileMp3Explorer( "/home/pi/Music" );
		
		ecran = new ILI9341();

	}

	public static final FactoryRaspberry getInstance()
	{
		
		return instance;
	}

	public DiskFileMp3Explorer createGestionDiskFileMp3Explorer()
	{

		return this.diskFileMp3Explorer;
	}

	public ILI9341 createGestionEcran()
	{

		return this.ecran;
	}
	
}
