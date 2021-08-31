package fr.horloge.structure;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import fr.horloge.ihm.swing.JFrameReveil;

public abstract class AbstractApplication
{

	public static final String LOOK_AND_FEEL_METAL = "javax.swing.plaf.metal.MetalLookAndFeel";
	public static final String LOOK_AND_FEEL_NIMBUS = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
	public static final String LOOK_AND_FEEL_WINDOWS = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";

	public static final String REVEIL_MODE_CLOCK = "fr.reveil.structure.AbstractApplication.REVEIL_MODE_CLOCK";
	public static final String REVEIL_MODE_ALARM = "fr.reveil.structure.AbstractApplication.REVEIL_MODE_ALARM";
	public static final String REVEIL_MODE_TONES = "fr.reveil.structure.AbstractApplication.REVEIL_MODE_TONES";
	public static final String REVEIL_MODE_RADIO = "fr.reveil.structure.AbstractApplication.REVEIL_MODE_RADIO";
	public static final String REVEIL_MODE_TRACK = "fr.reveil.structure.AbstractApplication.REVEIL_MODE_TRACK";

	private JFrameReveil jFrameReveil;

	private String mode;
	
	boolean actionGray = false;
	boolean actionWhite = false;
	boolean actionGreen = false;
	boolean actionBlue = false;
	boolean actionYellow = false;

	public AbstractApplication()
	{

		super();

		// Création de la JFrame
		jFrameReveil = new JFrameReveil();

		// Création de l'adaptateur de fenêtre
		FenetreAdapteur fenetreAdapteur = new FenetreAdapteur();
		
		// Gestion de l'adaptateur de fenêtre
		jFrameReveil.addWindowListener(fenetreAdapteur);

		// Création de l'écouteur modal
		ActionEcouteurModal actionEcouteurModal = new ActionEcouteurModal();

		// Gestion de la partie modale
		jFrameReveil.getJButtonClock().addActionListener( actionEcouteurModal );
		jFrameReveil.getJButtonAlarm().addActionListener( actionEcouteurModal );
		jFrameReveil.getJButtonTones().addActionListener( actionEcouteurModal );
		jFrameReveil.getJButtonRadio().addActionListener( actionEcouteurModal );
		jFrameReveil.getJButtonTrack().addActionListener( actionEcouteurModal );
		
		// Création de l'écouteur interactif
		ActionEcouteurInteractif actionEcouteurInteractif = new ActionEcouteurInteractif();

		// Gestion de la partie interactive
		jFrameReveil.getJButtonGray().addActionListener( actionEcouteurInteractif );
		jFrameReveil.getJButtonWhite().addActionListener( actionEcouteurInteractif );
		jFrameReveil.getJButtonGreen().addActionListener( actionEcouteurInteractif );
		jFrameReveil.getJButtonBlue().addActionListener( actionEcouteurInteractif );
		jFrameReveil.getJButtonYellow().addActionListener( actionEcouteurInteractif );

		// Création du thread Time de l'application
		ApplicationThreadTime applicationThreadTime = new ApplicationThreadTime();
		applicationThreadTime.start();
		
	}

	public void doClose()
	{
		
		System.exit(0);
	}
		
	public class FenetreAdapteur extends WindowAdapter
	{

		public void windowClosing( WindowEvent e )
		{

			doClose();
		}

	}

	// Partie modale
	
	public void doClock()
	{
		
		this.jFrameReveil.setModeClock();
		
		this.mode = AbstractApplication.REVEIL_MODE_CLOCK;
	}
	
	public void doAlarm()
	{

		jFrameReveil.setModeAlarm();		
		
		this.mode = AbstractApplication.REVEIL_MODE_ALARM;
	}
	
	public void doTones()
	{

		this.jFrameReveil.setModeTones();
		
		this.mode = AbstractApplication.REVEIL_MODE_TONES;
	}
	
	public void doRadio()
	{

		this.jFrameReveil.setModeRadio();
		
		this.mode = AbstractApplication.REVEIL_MODE_RADIO;
	}
	
	public void doTrack()
	{

		this.jFrameReveil.setModeTrack();
		
		this.mode = AbstractApplication.REVEIL_MODE_TRACK;
	}
	
	public class ActionEcouteurModal implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			
			if( e.getSource() == jFrameReveil.getJButtonClock() )
			{
				
				doClock();
			}
			else if( e.getSource() == jFrameReveil.getJButtonAlarm() )
			{

				doAlarm();
			}
			else if( e.getSource() == jFrameReveil.getJButtonTones() )
			{

				doTones();
			}
			else if( e.getSource() == jFrameReveil.getJButtonRadio() )
			{

				doRadio();
			}
			else if( e.getSource() == jFrameReveil.getJButtonTrack() )
			{

				doTrack();
			}
			
		}

	}
	
	// Partie interactive
	
	public void doViolet()
	{
		
	}

	public void doOrange()
	{
		
	}

	public void doBlack()
	{
		
	}
	
	public void doGray()
	{

		if( !actionGray )
		{
	
			actionGray = true;
		}
		else
		{
			
			actionGray = false;					
		}
		
	}

	public void doWhite()
	{

		if( !actionWhite )
		{
	
			actionWhite = true;
		}
		else
		{
			
			actionWhite = false;					
		}

	}

	public void doGreen()
	{

		if( !actionGreen )
		{

			actionGreen = true;
		}
		else
		{

			actionGreen = false;					
		}

	}
	
	public void doBlue()
	{

		if( !actionBlue )
		{
	

			actionBlue = true;
		}
		else
		{

			actionBlue = false;					
		}

	}
	
	public void doYellow()
	{

		if( !actionYellow )
		{
	

			actionYellow = true;
		}
		else
		{

			actionYellow = false;					
		}
		
	}
	
	
	public class ActionEcouteurInteractif implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			
			if( e.getSource() == jFrameReveil.getJButtonGray() )
			{
				
				doGray();
			}
			else if( e.getSource() == jFrameReveil.getJButtonWhite() )
			{

				doWhite();
			}
			else if( e.getSource() == jFrameReveil.getJButtonGreen() )
			{

				doGreen();
			}
			else if( e.getSource() == jFrameReveil.getJButtonBlue() )
			{

				doBlue();
			}
			else if( e.getSource() == jFrameReveil.getJButtonYellow() )
			{

				doYellow();
			}
			
		}

	}

	public class ApplicationThreadTime extends Thread
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
			
			Date date;
			
			while( true )
			{
				
				date = Calendar.getInstance().getTime();

				SimpleDateFormat simpleDateFormatHour = new SimpleDateFormat("HH");
				SimpleDateFormat simpleDateFormatMinute = new SimpleDateFormat("mm");
				SimpleDateFormat simpleDateFormatSeconde = new SimpleDateFormat("ss");
				
				SimpleDateFormat simpleDateFormatDayOfWeek = new SimpleDateFormat("u");
				SimpleDateFormat simpleDateFormatDay = new SimpleDateFormat("dd");
				SimpleDateFormat simpleDateFormatMonth = new SimpleDateFormat("MM");
				SimpleDateFormat simpleDateFormatYear = new SimpleDateFormat("yyyy");
				
				String hour_ =  simpleDateFormatHour.format(date);
				String minute_ = simpleDateFormatMinute.format(date);
				String seconde_ = simpleDateFormatSeconde.format(date);

				String dayOfWeek_ = simpleDateFormatDayOfWeek.format(date);
				String day_ = simpleDateFormatDay.format(date);
				String month_ = simpleDateFormatMonth.format(date);
				String year_ = simpleDateFormatYear.format(date);
				
				jFrameReveil.setTime( hour_, minute_, seconde_, dayOfWeek_, day_, month_, year_);
				
				this.pause( 200 );
			}

		}

	}

	public JFrameReveil getJFrameReveil()
	{
		
		return this.jFrameReveil;
	}
	public void setJFrameReveil( JFrameReveil jFrameReveil_ )
	{

		this.jFrameReveil = jFrameReveil_;
	}
	
	private String getMode()
	{
		
		return this.mode;
	}
	private void setMode( String mode_ )
	{
	
		this.mode = mode_;
	}
		
}
