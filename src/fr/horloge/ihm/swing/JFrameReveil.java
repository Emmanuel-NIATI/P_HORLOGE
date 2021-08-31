package fr.horloge.ihm.swing;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class JFrameReveil extends JFrame 
{
	
	private JPanelReveil jPanelReveil;
	private Color colorReveil;
	private Border borderReveil;
	
	
	private JPanel jPanelNorth;
	private JPanel jPanelCenter;
	private JPanel jPanelSouth;

	private static final Color COLOR_GRAY = Color.GRAY;
	private static final Color COLOR_WHITE = Color.WHITE;
	private static final Color COLOR_GREEN = Color.GREEN;
	private static final Color COLOR_BLUE = Color.BLUE;
	private static final Color COLOR_YELLOW = Color.YELLOW;
	
	// 1. Panel NORTH

	private JButton jButtonClock;
	private JButton jButtonAlarm;
	private JButton jButtonTones;
	private JButton jButtonRadio;
	private JButton jButtonTrack;
		
	// 2. Panel CENTER

	private static final String PANEL_CENTER_CLOCK = "fr.reveil.ihm.swing.JFrameReveil.PANEL_CENTER_CLOCK";
	private static final String PANEL_CENTER_ALARM = "fr.reveil.ihm.swing.JFrameReveil.PANEL_CENTER_ALARM";
	private static final String PANEL_CENTER_TONES = "fr.reveil.ihm.swing.JFrameReveil.PANEL_CENTER_TONES";
	private static final String PANEL_CENTER_RADIO = "fr.reveil.ihm.swing.JFrameReveil.PANEL_CENTER_RADIO";
	private static final String PANEL_CENTER_TRACK = "fr.reveil.ihm.swing.JFrameReveil.PANEL_CENTER_TRACK";
	
	private CardLayout cardLayoutCenter;
	
	// 2.1. Panel CENTER-CLOCK

	private JPanelDigitalClock jPanelCenterClock;
	
	
	// 2.2. Panel CENTER-ALARM
	
	private JPanel jPanelCenterAlarm;
		
	private JButton jButtonBlack;
	
	// 2.3. Panel CENTER-TONES
	
	private JPanel jPanelCenterTones;
	
	
	// 2.4. Panel CENTER-RADIO
	
	
	private JPanel jPanelCenterRadio;
	
		
	// 2.5. Panel CENTER-TRACK

	private JPanel jPanelCenterTrack;
		
	private Font fontConsolasItalicBold009;
	private Font fontConsolasItalicBold014;
		

	// 3. Panel SOUTH
	
	private JButton jButtonGray;
	private JButton jButtonWhite;
	private JButton jButtonGreen;
	private JButton jButtonBlue;
	private JButton jButtonYellow;

	public JFrameReveil()
	{

		super();

		// Gestion de l'apparence de la fenêtre 
		this.setTitle("Réveil");
		this.setLocation(0, 0);
		this.setSize(800, 480);
		this.setUndecorated( true );

		// Création du panel
		jPanelReveil = new JPanelReveil();
		jPanelReveil.setSize( 800, 480 );

		// Gestion de la disposition du panel
		BorderLayout borderLayoutReveil = new BorderLayout();

		borderLayoutReveil.setHgap(0);
		borderLayoutReveil.setVgap(0);

		jPanelReveil.setLayout( borderLayoutReveil );

		jPanelReveil.setImage( ( new ImageIcon( this.getClass().getResource( "wallpaper_cat_01.png" ) ) ).getImage()   );

		colorReveil = Color.BLUE;
				
		// Création des panels
		jPanelNorth = new JPanel();
		jPanelCenter = new JPanel();
		jPanelSouth = new JPanel();

		// Gestion des panels
		jPanelNorth.setPreferredSize( new Dimension( 800, 60) );
		jPanelNorth.setOpaque( false );
		
		jPanelCenter.setPreferredSize( new Dimension( 800, 320) );
		jPanelCenter.setOpaque( false );
		
		jPanelSouth.setPreferredSize( new Dimension( 800, 60) );
		jPanelSouth.setOpaque( false );
				
		// Création des polices de caractère
		
		fontConsolasItalicBold009 = new Font("Consolas", Font.ITALIC | Font.BOLD, 9);
		fontConsolasItalicBold014 = new Font("Consolas", Font.ITALIC | Font.BOLD, 14);
		

		// 1. Panel NORTH

		// Gestion de la disposition du panel NORTH
		FlowLayout flowLayoutNorth = (FlowLayout) jPanelNorth.getLayout();

		flowLayoutNorth.setHgap(10);
		flowLayoutNorth.setVgap(10);
		
		// Création des boutons modaux
		
		jButtonClock = new JButton();
		jButtonClock.setSize(40, 120);
		jButtonClock.setMargin( new Insets(0, 0, 0, 0) );
		jButtonClock.setIcon( new ImageIcon( this.getClass().getResource("btn_clock.png") ) );
		
		jButtonAlarm = new JButton();
		jButtonAlarm.setSize(40, 120);
		jButtonAlarm.setMargin( new Insets(0, 0, 0, 0) );
		jButtonAlarm.setIcon( new ImageIcon( this.getClass().getResource("btn_alarm.png") ) );
		
		jButtonTones = new JButton();
		jButtonTones.setSize(40, 120);
		jButtonTones.setMargin( new Insets(0, 0, 0, 0) );
		jButtonTones.setIcon( new ImageIcon( this.getClass().getResource("btn_tones.png") ) );
		
		jButtonRadio = new JButton();
		jButtonRadio.setSize(40, 120);
		jButtonRadio.setMargin( new Insets(0, 0, 0, 0) );
		jButtonRadio.setIcon( new ImageIcon( this.getClass().getResource("btn_radio.png") ) );
		
		jButtonTrack = new JButton();
		jButtonTrack.setSize(40, 120);
		jButtonTrack.setMargin( new Insets(0, 0, 0, 0) );
		jButtonTrack.setIcon( new ImageIcon( this.getClass().getResource("btn_track.png") ) );

		// Ajout des boutons modaux au panel NORTH
		jPanelNorth.add( jButtonClock );
		jPanelNorth.add( jButtonAlarm );
		jPanelNorth.add( jButtonTones );
		jPanelNorth.add( jButtonRadio );
		jPanelNorth.add( jButtonTrack );

		
		// 2. Panel CENTER
		
		// Gestion de la disposition du panel CENTER
		cardLayoutCenter = new CardLayout( 0, 0);
		cardLayoutCenter.setHgap( 0 );
		cardLayoutCenter.setVgap( 0 ); 
		
		jPanelCenter.setLayout( cardLayoutCenter );

		// 2.1. Panel CENTER-CLOCK
		
		// Création du panel CENTER-CLOCK
		jPanelCenterClock = new JPanelDigitalClock( colorReveil );
		
		// Gestion du panel CENTER-CLOCK
		jPanelCenterClock.setPreferredSize( new Dimension( 800, 320) );
		jPanelCenterClock.setOpaque( false );
		
		
		// 2.2. Panel CENTER-ALARM
		
		// Création du panel CENTER-ALARM
		jPanelCenterAlarm = new JPanelAnalogClock( colorReveil );
		
		// Gestion du panel CENTER-ALARM
		jPanelCenterAlarm.setPreferredSize( new Dimension( 800, 320) );
		jPanelCenterAlarm.setOpaque( false );

		
		// 2.3. Panel CENTER-TONES
		
		// Création du panel CENTER-TONES
		jPanelCenterTones = new JPanel();
		
		// Gestion du panel CENTER-TONES
		jPanelCenterTones.setPreferredSize( new Dimension( 800, 320) );
		jPanelCenterTones.setOpaque( false );

		
		// 2.4. Panel CENTER-RADIO
		
		// Création du panel CENTER-RADIO
		jPanelCenterRadio = new JPanel();

		// Gestion du panel CENTER-RADIO		
		jPanelCenterRadio.setPreferredSize( new Dimension( 800, 320) );
		jPanelCenterRadio.setOpaque( false );
		
		
		// 2.5. Panel CENTER-TRACK
		
		// Création du panel CENTER-TRACK
		jPanelCenterTrack = new JPanel();
		
		// Gestion du panel CENTER-TRACK
		jPanelCenterTrack.setPreferredSize( new Dimension( 800, 320) );
		jPanelCenterTrack.setOpaque( false );

		
		// Gestion du panel CENTER

		cardLayoutCenter.addLayoutComponent( jPanelCenterClock, PANEL_CENTER_CLOCK );
		jPanelCenter.add( jPanelCenterClock );
		
		cardLayoutCenter.addLayoutComponent( jPanelCenterAlarm, PANEL_CENTER_ALARM );
		jPanelCenter.add( jPanelCenterAlarm );

		cardLayoutCenter.addLayoutComponent( jPanelCenterTones, PANEL_CENTER_TONES );
		jPanelCenter.add( jPanelCenterTones );
		
		cardLayoutCenter.addLayoutComponent( jPanelCenterRadio, PANEL_CENTER_RADIO );
		jPanelCenter.add( jPanelCenterRadio );
		
		cardLayoutCenter.addLayoutComponent( jPanelCenterTrack, PANEL_CENTER_TRACK );
		jPanelCenter.add( jPanelCenterTrack );
		

		// Mise au mode Horloge à la construction
		this.setModeClock();

		
		// 3. Panel SOUTH

		// Gestion de la disposition du panel SOUTH
		FlowLayout flowLayoutSouth = (FlowLayout) jPanelSouth.getLayout();

		flowLayoutSouth.setHgap(20);
		flowLayoutSouth.setVgap(10);
			
		// Création des boutons interactifs
		jButtonGray = new JButton();
		jButtonGray.setSize(40, 40);
		jButtonGray.setMargin( new Insets(0, 0, 0, 0) );
		jButtonGray.setIcon( new ImageIcon( this.getClass().getResource("btn_gray.png") ) );

		jButtonWhite = new JButton();
		jButtonWhite.setSize(40, 40);
		jButtonWhite.setMargin( new Insets(0, 0, 0, 0) );
		jButtonWhite.setIcon( new ImageIcon( this.getClass().getResource("btn_white.png") ) );

		jButtonGreen = new JButton();
		jButtonGreen.setSize(40, 40);
		jButtonGreen.setMargin( new Insets(0, 0, 0, 0) );
		jButtonGreen.setIcon( new ImageIcon( this.getClass().getResource("btn_green.png") ) );

		jButtonBlue = new JButton();
		jButtonBlue.setSize(40, 40);
		jButtonBlue.setMargin( new Insets(0, 0, 0, 0) );
		jButtonBlue.setIcon( new ImageIcon( this.getClass().getResource("btn_blue.png") ) );
		
		jButtonYellow = new JButton();
		jButtonYellow.setSize(40, 40);
		jButtonYellow.setMargin( new Insets(0, 0, 0, 0) );
		jButtonYellow.setIcon( new ImageIcon( this.getClass().getResource("btn_yellow.png") ) );

		// Ajout des boutons interactifs au panel SUD
		jPanelSouth.add( jButtonGray );
		jPanelSouth.add( jButtonWhite );
		jPanelSouth.add( jButtonGreen);
		jPanelSouth.add( jButtonBlue);
		jPanelSouth.add( jButtonYellow);

		// Gestion de la position des panels
		jPanelReveil.add( jPanelNorth, BorderLayout.NORTH );
		jPanelReveil.add( jPanelCenter, BorderLayout.CENTER );
		jPanelReveil.add( jPanelSouth, BorderLayout.SOUTH );

		// Gestion du panel
		this.getContentPane().add( jPanelReveil );
		
		// Gestion de la fenêtre
		this.setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
		this.setResizable( false );
		this.setVisible( true );

	}
			
	
	// Mise à l'heure
	public void setTime( String hour_, String minute_, String seconde_, String dayOfWeek_, String day_, String month_, String year_)
	{
		
		// Mise à l'heure en mode clock
		this.jPanelCenterClock.setTime(hour_, minute_, seconde_, dayOfWeek_, day_, month_, year_);
				
		
		// Mise à l'heure dans les autres modes

		
			
		
		
	}

	// Mode Horloge (Clock)
	public void setModeClock()
	{

		cardLayoutCenter.show( jPanelCenter, PANEL_CENTER_CLOCK );
		
		borderReveil = BorderFactory.createLineBorder( colorReveil, 1 );
		borderReveil = BorderFactory.createTitledBorder( borderReveil, "Horloge", TitledBorder.LEFT, TitledBorder.TOP, fontConsolasItalicBold014 );
		jPanelReveil.setBorder( borderReveil );
		
	}
	
	// Mode Réveil (Alarm) 
	public void setModeAlarm()
	{

		cardLayoutCenter.show( jPanelCenter, PANEL_CENTER_ALARM );
		
		borderReveil = BorderFactory.createLineBorder( colorReveil, 1 );
		borderReveil = BorderFactory.createTitledBorder( borderReveil, "Réveil", TitledBorder.LEFT, TitledBorder.TOP, fontConsolasItalicBold014 );
		jPanelReveil.setBorder( borderReveil );

	}
	
	// Mode Sonnerie (Tones)
	public void setModeTones()
	{

		cardLayoutCenter.show( jPanelCenter, PANEL_CENTER_TONES );

		borderReveil = BorderFactory.createLineBorder( colorReveil, 1 );
		borderReveil = BorderFactory.createTitledBorder( borderReveil, "Sonnerie", TitledBorder.LEFT, TitledBorder.TOP, fontConsolasItalicBold014 );
		jPanelReveil.setBorder( borderReveil );

		
	}
	
	// Mode Radio (Radio)
	public void setModeRadio()
	{

		cardLayoutCenter.show( jPanelCenter, PANEL_CENTER_RADIO );

		borderReveil = BorderFactory.createLineBorder( colorReveil, 1 );
		borderReveil = BorderFactory.createTitledBorder( borderReveil, "Radio", TitledBorder.LEFT, TitledBorder.TOP, fontConsolasItalicBold014 );
		jPanelReveil.setBorder( borderReveil );

		
	}
	
	// Mode mp3 (mp3)
	public void setModeTrack()
	{

		cardLayoutCenter.show( jPanelCenter, PANEL_CENTER_TRACK );
		
		borderReveil = BorderFactory.createLineBorder( colorReveil, 1 );
		borderReveil = BorderFactory.createTitledBorder( borderReveil, "Lecteur MP3", TitledBorder.LEFT, TitledBorder.TOP, fontConsolasItalicBold014 );
		jPanelReveil.setBorder( borderReveil );
		
	}

	
	// get / set
	
	public JPanel getJPanelNorth()
	{
		
		return this.jPanelNorth;
	}
	public void setJPanelNorth(JPanel jPanelNorth_)
	{
		
		this.jPanelNorth = jPanelNorth_;
	}

	public JPanel getJPanelCenter()
	{
		
		return this.jPanelCenter;
	}
	public void setJPanelCenter(JPanel jPanelCenter_)
	{
		
		this.jPanelCenter = jPanelCenter_;
	}
	
	public JPanel getJPanelSouth()
	{
		
		return this.jPanelSouth;
	}
	public void setJPanelSouth(JPanel jPanelSouth_)
	{

		this.jPanelSouth = jPanelSouth_;
	}
	
	public JButton getJButtonClock()
	{
		
		return this.jButtonClock;
	}
	public void setJButtonClock(JButton jButtonClock_)
	{
		
		this.jButtonClock = jButtonClock_;
	}

	public JButton getJButtonAlarm()
	{
		
		return this.jButtonAlarm;
	}
	public void setJButtonAlarm(JButton jButtonAlarm_)
	{
		
		this.jButtonAlarm = jButtonAlarm_;
	}

	public JButton getJButtonTones()
	{

		return this.jButtonTones;
	}
	public void setJButtonTones(JButton jButtonTones_)
	{
		
		this.jButtonTones = jButtonTones_;
	}

	public JButton getJButtonRadio()
	{
		
		return this.jButtonRadio;
	}
	public void setJButtonRadio(JButton jButtonRadio_)
	{

		this.jButtonRadio = jButtonRadio_;
	}

	public JButton getJButtonTrack()
	{

		return this.jButtonTrack;
	}
	public void setJButtonTrack(JButton jButtonTrack_)
	{
		this.jButtonTrack = jButtonTrack_;
	}
	
	public JButton getJButtonBlack()
	{
		
		return this.jButtonBlack;
	}
	public void setJButtonBlack(JButton jButtonBlack_)
	{
		
		this.jButtonBlack = jButtonBlack_;
	}
	
	public JButton getJButtonGray()
	{
		
		return this.jButtonGray;
	}
	public void setJButtonGray(JButton jButtonGray_)
	{
		
		this.jButtonGray = jButtonGray_;
	}

	public JButton getJButtonWhite()
	{

		return this.jButtonWhite;
	}
	public void setJButtonWhite(JButton jButtonWhite)
	{
		
		this.jButtonWhite = jButtonWhite;
	}

	public JButton getJButtonGreen()
	{

		return this.jButtonGreen;
	}
	public void setJButtonGreen(JButton jButtonGreen_)
	{

		this.jButtonGreen = jButtonGreen_;
	}

	public JButton getJButtonBlue()
	{

		return this.jButtonBlue;
	}
	public void setJButtonBlue(JButton jButtonBlue_)
	{

		this.jButtonBlue = jButtonBlue_;
	}

	public JButton getJButtonYellow()
	{
		
		return this.jButtonYellow;
	}
	public void setJButtonYellow(JButton jButtonYellow_)
	{

		this.jButtonYellow = jButtonYellow_;
	}

}
