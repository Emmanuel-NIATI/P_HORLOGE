package fr.horloge.structure;

import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.RaspiPin;

import fr.horloge.structure.digital.button.Button;
import fr.horloge.structure.digital.buzzer.Buzzer;
import fr.horloge.structure.digital.led.Led;
import fr.horloge.structure.system.DiskFileMp3Explorer;

public class FactoryRaspberry
{

	private static final FactoryRaspberry instance = new FactoryRaspberry();

	private DiskFileMp3Explorer diskFileMp3Explorer;

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
	
	private FactoryRaspberry()
	{

		super();

		diskFileMp3Explorer = new DiskFileMp3Explorer( "/home/pi/Music" );

		buttonViolet = new Button( RaspiPin.GPIO_12, PinPullResistance.PULL_DOWN );
		buttonOrange = new Button( RaspiPin.GPIO_13, PinPullResistance.PULL_DOWN );
		buttonBlack = new Button( RaspiPin.GPIO_14, PinPullResistance.PULL_DOWN );
		
		buttonGray = new Button( RaspiPin.GPIO_02, PinPullResistance.PULL_DOWN );
		buttonWhite = new Button( RaspiPin.GPIO_21, PinPullResistance.PULL_DOWN );
		buttonGreen = new Button( RaspiPin.GPIO_23, PinPullResistance.PULL_DOWN );
		buttonBlue = new Button( RaspiPin.GPIO_24, PinPullResistance.PULL_DOWN );
		buttonYellow = new Button( RaspiPin.GPIO_25, PinPullResistance.PULL_DOWN );

		buzzer = new Buzzer( RaspiPin.GPIO_11 );

		ledGreen = new Led( RaspiPin.GPIO_26 );

	}

	public static final FactoryRaspberry getInstance()
	{
		
		return instance;
	}

	public DiskFileMp3Explorer createGestionDiskFileMp3Explorer()
	{

		return this.diskFileMp3Explorer;
	}
	
	public Button createGestionButtonViolet()
	{
		
		return this.buttonViolet;
	}
	
	public Button createGestionButtonOrange()
	{
		
		return this.buttonOrange;
	}
	
	public Button createGestionButtonBlack()
	{
		
		return this.buttonBlack;
	}
	
	public Button createGestionButtonGray()
	{
		
		return this.buttonGray;
	}
	
	public Button createGestionButtonWhite()
	{
		
		return this.buttonWhite;
	}
	
	public Button createGestionButtonGreen()
	{
		
		return this.buttonGreen;
	}
	
	public Button createGestionButtonBlue()
	{
		
		return this.buttonBlue;
	}
	
	public Button createGestionButtonYellow()
	{
		
		return this.buttonYellow;
	}

	public Buzzer createGestionBuzzer()
	{
		
		return this.buzzer;
	}

	public Led createGestionLedGreen()
	{
		
		return this.ledGreen;
	}
	
}
