package fr.horloge.test;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import fr.horloge.ihm.swing.JPanelReveil;

public class TestHorloge
{
	
	private JPanelReveil jPanelReveilPhoto;
	private JPanelReveil jPanelReveilHorloge;
	private JPanelReveil jPanelReveilHorlogeHeure;
	private JPanelReveil jPanelReveilHorlogeMinute;
	private JPanelReveil jPanelReveilHorlogeSeconde;
		
	public TestHorloge()
	{

		// jFrameHorloge

		JFrame jFrameHorloge = new JFrame(); 

		jFrameHorloge.setTitle("Horloge");
		jFrameHorloge.setUndecorated( true );
		jFrameHorloge.setSize( 1920, 1080 );

		BorderLayout borderLayouJFrametHorloge = new BorderLayout();

		borderLayouJFrametHorloge.setHgap(0);
		borderLayouJFrametHorloge.setVgap(0);

		jFrameHorloge.setLayout( borderLayouJFrametHorloge );

		
		// jPanelReveilPhoto
	
		jPanelReveilPhoto = new JPanelReveil();
		jPanelReveilPhoto.setOpaque( false );
		jPanelReveilPhoto.setImage( ( new ImageIcon( this.getClass().getResource( "horloge_1920x1080_photo_00.png" ) ) ).getImage() );
		
		BorderLayout borderLayouJPanelReveilPhoto = new BorderLayout();

		borderLayouJPanelReveilPhoto.setHgap(0);
		borderLayouJPanelReveilPhoto.setVgap(0);

		jPanelReveilPhoto.setLayout( borderLayouJPanelReveilPhoto );
		
		
		// jPanelReveilHorloge
				
		jPanelReveilHorloge = new JPanelReveil();
		jPanelReveilHorloge.setOpaque( false );
		jPanelReveilHorloge.setImage( ( new ImageIcon( this.getClass().getResource( "horloge_1920x1080_00.png" ) ) ).getImage() );
		
		BorderLayout borderLayouJPanelReveilHorloge = new BorderLayout();

		borderLayouJPanelReveilHorloge.setHgap(0);
		borderLayouJPanelReveilHorloge.setVgap(0);

		jPanelReveilHorloge.setLayout( borderLayouJPanelReveilHorloge );

		
		// jPanelReveilHorlogeHeure

		jPanelReveilHorlogeHeure = new JPanelReveil();
		jPanelReveilHorlogeHeure.setOpaque( false );
		jPanelReveilHorlogeHeure.setImage( ( new ImageIcon( this.getClass().getResource( "horloge_1920x1080_heure_00.png" ) ) ).getImage() );

		BorderLayout borderLayouJPanelReveilHorlogeHeure = new BorderLayout();

		borderLayouJPanelReveilHorlogeHeure.setHgap(0);
		borderLayouJPanelReveilHorlogeHeure.setVgap(0);

		jPanelReveilHorlogeHeure.setLayout( borderLayouJPanelReveilHorlogeHeure );

		
		// jPanelReveilHorlogeMinute		
		
		jPanelReveilHorlogeMinute = new JPanelReveil();
		jPanelReveilHorlogeMinute.setOpaque( false );
		jPanelReveilHorlogeMinute.setImage( ( new ImageIcon( this.getClass().getResource( "horloge_1920x1080_minute_00.png" ) ) ).getImage() );

		BorderLayout borderLayouJPanelReveilHorlogeMinute = new BorderLayout();

		borderLayouJPanelReveilHorlogeMinute.setHgap(0);
		borderLayouJPanelReveilHorlogeMinute.setVgap(0);

		jPanelReveilHorlogeMinute.setLayout( borderLayouJPanelReveilHorlogeMinute );
		
		
		// jPanelReveilHorlogeSeconde		
				
		jPanelReveilHorlogeSeconde = new JPanelReveil();
		jPanelReveilHorlogeSeconde.setOpaque( false );
		jPanelReveilHorlogeSeconde.setImage( ( new ImageIcon( this.getClass().getResource( "horloge_1920x1080_seconde_00.png" ) ) ).getImage() );

		BorderLayout borderLayouJPanelReveilHorlogeSeconde = new BorderLayout();

		borderLayouJPanelReveilHorlogeSeconde.setHgap(0);
		borderLayouJPanelReveilHorlogeSeconde.setVgap(0);

		jPanelReveilHorlogeSeconde.setLayout( borderLayouJPanelReveilHorlogeSeconde );
		
		
		jFrameHorloge.getContentPane().add( jPanelReveilPhoto );
		
		jPanelReveilPhoto.add( jPanelReveilHorloge );
		jPanelReveilHorloge.add( jPanelReveilHorlogeHeure );
		jPanelReveilHorlogeHeure.add( jPanelReveilHorlogeMinute);
		jPanelReveilHorlogeMinute.add( jPanelReveilHorlogeSeconde);
		
		
		jFrameHorloge.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		jFrameHorloge.setResizable( false );
		jFrameHorloge.setVisible( true );
		
		
		// Création du thread Time de l'application
		ThreadTime threadTime = new ThreadTime();
		threadTime.start();
		
	}
	
	public class ThreadTime extends Thread
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

				String stringHH = "00";
				String stringHour =  simpleDateFormatHour.format(date);
				String stringMinute = simpleDateFormatMinute.format(date);
				String stringSeconde = simpleDateFormatSeconde.format(date);

				int intHour = new Integer( stringHour ).intValue();
				int intMinute = new Integer( stringMinute ).intValue();

				
				// 0 ou 12 heures
				
				if( (intHour == 0 && intMinute >= 0 && intMinute < 12 ) || (intHour == 12 && intMinute >= 0 && intMinute < 12 ) )
				{
					stringHH = "00";	
				}
				
				if( (intHour == 0 && intMinute >= 12 && intMinute < 24 ) || (intHour == 12 && intMinute >= 12 && intMinute < 24 ))
				{
					stringHH = "01";
				}
				
				if( (intHour == 0 && intMinute >= 24 && intMinute < 36 ) || (intHour == 12 && intMinute >= 24 && intMinute < 36 ) )
				{
					stringHH = "02";
				}
				
				if( (intHour == 0 && intMinute >= 36 && intMinute < 48 ) || (intHour == 12 && intMinute >= 36 && intMinute < 48 ) )
				{
					stringHH = "03";
				}
				
				if( (intHour == 0 && intMinute >= 48 && intMinute < 60 ) || (intHour == 12 && intMinute >= 48 && intMinute < 60 ) )
				{
					stringHH = "04";
				}

				
				// 1 ou 13 heures

				if( (intHour == 1 && intMinute >= 0 && intMinute < 12 ) || (intHour == 13 && intMinute >= 0 && intMinute < 12 ) )
				{
					stringHH = "05";
				}
				
				if( (intHour == 1 && intMinute >= 12 && intMinute < 24 ) || (intHour == 13 && intMinute >= 12 && intMinute < 24 ))
				{
					stringHH = "06";
				}
				
				if( (intHour == 1 && intMinute >= 24 && intMinute < 36 ) || (intHour == 13 && intMinute >= 24 && intMinute < 36 ) )
				{
					stringHH = "07";
				}
				
				if( (intHour == 1 && intMinute >= 36 && intMinute < 48 ) || (intHour == 13 && intMinute >= 36 && intMinute < 48 ) )
				{
					stringHH = "08";
				}
				
				if( (intHour == 1 && intMinute >= 48 && intMinute < 60 ) || (intHour == 13 && intMinute >= 48 && intMinute < 60 ) )
				{
					stringHH = "09";
				}

				
				// 2 ou 14 heures

				if( (intHour == 2 && intMinute >= 0 && intMinute < 12 ) || (intHour == 14 && intMinute >= 0 && intMinute < 12 ) )
				{
					stringHH = "10";
				}
				
				if( (intHour == 2 && intMinute >= 12 && intMinute < 24 ) || (intHour == 14 && intMinute >= 12 && intMinute < 24 ))
				{
					stringHH = "11";
				}
				
				if( (intHour == 2 && intMinute >= 24 && intMinute < 36 ) || (intHour == 14 && intMinute >= 24 && intMinute < 36 ) )
				{
					stringHH = "12";
				}
				
				if( (intHour == 2 && intMinute >= 36 && intMinute < 48 ) || (intHour == 14 && intMinute >= 36 && intMinute < 48 ) )
				{
					stringHH = "13";
				}
				
				if( (intHour == 2 && intMinute >= 48 && intMinute < 60 ) || (intHour == 14 && intMinute >= 48 && intMinute < 60 ) )
				{
					stringHH = "14";
				}
				
				
				// 3 ou 15 heures

				if( (intHour == 3 && intMinute >= 0 && intMinute < 12 ) || (intHour == 15 && intMinute >= 0 && intMinute < 12 ) )
				{
					stringHH = "15";
				}
				
				if( (intHour == 3 && intMinute >= 12 && intMinute < 24 ) || (intHour == 15 && intMinute >= 12 && intMinute < 24 ))
				{
					stringHH = "16";
				}
				
				if( (intHour == 3 && intMinute >= 24 && intMinute < 36 ) || (intHour == 15 && intMinute >= 24 && intMinute < 36 ) )
				{
					stringHH = "17";
				}
				
				if( (intHour == 3 && intMinute >= 36 && intMinute < 48 ) || (intHour == 15 && intMinute >= 36 && intMinute < 48 ) )
				{
					stringHH = "18";
				}
				
				if( (intHour == 3 && intMinute >= 48 && intMinute < 60 ) || (intHour == 15 && intMinute >= 48 && intMinute < 60 ) )
				{
					stringHH = "19";
				}
				
				
				// 4 ou 16 heures

				if( (intHour == 4 && intMinute >= 0 && intMinute < 12 ) || (intHour == 16 && intMinute >= 0 && intMinute < 12 ) )
				{
					stringHH = "20";
				}
				
				if( (intHour == 4 && intMinute >= 12 && intMinute < 24 ) || (intHour == 16 && intMinute >= 12 && intMinute < 24 ))
				{
					stringHH = "21";
				}
				
				if( (intHour == 4 && intMinute >= 24 && intMinute < 36 ) || (intHour == 16 && intMinute >= 24 && intMinute < 36 ) )
				{
					stringHH = "22";	
				}
				
				if( (intHour == 4 && intMinute >= 36 && intMinute < 48 ) || (intHour == 16 && intMinute >= 36 && intMinute < 48 ) )
				{
					stringHH = "23";	
				}
				
				if( (intHour == 4 && intMinute >= 48 && intMinute < 60 ) || (intHour == 16 && intMinute >= 48 && intMinute < 60 ) )
				{
					stringHH = "24";	
				}
				
				
				// 5 ou 17 heures

				if( (intHour == 5 && intMinute >= 0 && intMinute < 12 ) || (intHour == 17 && intMinute >= 0 && intMinute < 12 ) )
				{
					stringHH = "25";	
				}
				
				if( (intHour == 5 && intMinute >= 12 && intMinute < 24 ) || (intHour == 17 && intMinute >= 12 && intMinute < 24 ))
				{
					stringHH = "26";	
				}
				
				if( (intHour == 5 && intMinute >= 24 && intMinute < 36 ) || (intHour == 17 && intMinute >= 24 && intMinute < 36 ) )
				{
					stringHH = "27";	
				}
				
				if( (intHour == 5 && intMinute >= 36 && intMinute < 48 ) || (intHour == 17 && intMinute >= 36 && intMinute < 48 ) )
				{
					stringHH = "28";	
				}
				
				if( (intHour == 5 && intMinute >= 48 && intMinute < 60 ) || (intHour == 17 && intMinute >= 48 && intMinute < 60 ) )
				{
					stringHH = "29";	
				}
				
				
				// 6 ou 18 heures

				if( (intHour == 6 && intMinute >= 0 && intMinute < 12 ) || (intHour == 18 && intMinute >= 0 && intMinute < 12 ) )
				{
					stringHH = "30";	
				}
				
				if( (intHour == 6 && intMinute >= 12 && intMinute < 24 ) || (intHour == 18 && intMinute >= 12 && intMinute < 24 ))
				{
					stringHH = "31";	
				}
				
				if( (intHour == 6 && intMinute >= 24 && intMinute < 36 ) || (intHour == 18 && intMinute >= 24 && intMinute < 36 ) )
				{
					stringHH = "32";	
				}
				
				if( (intHour == 6 && intMinute >= 36 && intMinute < 48 ) || (intHour == 18 && intMinute >= 36 && intMinute < 48 ) )
				{
					stringHH = "33";	
				}
				
				if( (intHour == 6 && intMinute >= 48 && intMinute < 60 ) || (intHour == 18 && intMinute >= 48 && intMinute < 60 ) )
				{
					stringHH = "34";	
				}
				
				
				// 7 ou 19 heures

				if( (intHour == 7 && intMinute >= 0 && intMinute < 12 ) || (intHour == 19 && intMinute >= 0 && intMinute < 12 ) )
				{
					stringHH = "35";	
				}
				
				if( (intHour == 7 && intMinute >= 12 && intMinute < 24 ) || (intHour == 19 && intMinute >= 12 && intMinute < 24 ))
				{
					stringHH = "36";
				}
				
				if( (intHour == 7 && intMinute >= 24 && intMinute < 36 ) || (intHour == 19 && intMinute >= 24 && intMinute < 36 ) )
				{
					stringHH = "37";	
				}
				
				if( (intHour == 7 && intMinute >= 36 && intMinute < 48 ) || (intHour == 19 && intMinute >= 36 && intMinute < 48 ) )
				{
					stringHH = "38";
				}
				
				if( (intHour == 7 && intMinute >= 48 && intMinute < 60 ) || (intHour == 19 && intMinute >= 48 && intMinute < 60 ) )
				{
					stringHH = "39";	
				}
				
								
				// 8 ou 20 heures

				if( (intHour == 8 && intMinute >= 0 && intMinute < 12 ) || (intHour == 20 && intMinute >= 0 && intMinute < 12 ) )
				{
					stringHH = "40";	
				}
				
				if( (intHour == 8 && intMinute >= 12 && intMinute < 24 ) || (intHour == 20 && intMinute >= 12 && intMinute < 24 ))
				{
					stringHH = "41";	
				}
				
				if( (intHour == 8 && intMinute >= 24 && intMinute < 36 ) || (intHour == 20 && intMinute >= 24 && intMinute < 36 ) )
				{
					stringHH = "42";	
				}
				
				if( (intHour == 8 && intMinute >= 36 && intMinute < 48 ) || (intHour == 20 && intMinute >= 36 && intMinute < 48 ) )
				{
					stringHH = "43";	
				}
				
				if( (intHour == 8 && intMinute >= 48 && intMinute < 60 ) || (intHour == 20 && intMinute >= 48 && intMinute < 60 ) )
				{
					stringHH = "44";
				}

				
				// 9 ou 21 heures

				if( (intHour == 9 && intMinute >= 0 && intMinute < 12 ) || (intHour == 21 && intMinute >= 0 && intMinute < 12 ) )
				{
					stringHH = "45";	
				}
				
				if( (intHour == 9 && intMinute >= 12 && intMinute < 24 ) || (intHour == 21 && intMinute >= 12 && intMinute < 24 ))
				{
					stringHH = "46";	
				}
				
				if( (intHour == 9 && intMinute >= 24 && intMinute < 36 ) || (intHour == 21 && intMinute >= 24 && intMinute < 36 ) )
				{
					stringHH = "47";	
				}
				
				if( (intHour == 9 && intMinute >= 36 && intMinute < 48 ) || (intHour == 21 && intMinute >= 36 && intMinute < 48 ) )
				{
					stringHH = "48";	
				}
				
				if( (intHour == 9 && intMinute >= 48 && intMinute < 60 ) || (intHour == 21 && intMinute >= 48 && intMinute < 60 ) )
				{
					stringHH = "49";	
				}
				
				
				// 10 ou 22 heures

				if( (intHour == 10 && intMinute >= 0 && intMinute < 12 ) || (intHour == 22 && intMinute >= 0 && intMinute < 12 ) )
				{
					stringHH = "50";	
				}
				
				if( (intHour == 10 && intMinute >= 12 && intMinute < 24 ) || (intHour == 22 && intMinute >= 12 && intMinute < 24 ))
				{
					stringHH = "51";	
				}
				
				if( (intHour == 10 && intMinute >= 24 && intMinute < 36 ) || (intHour == 22 && intMinute >= 24 && intMinute < 36 ) )
				{
					stringHH = "52";	
				}
				
				if( (intHour == 10 && intMinute >= 36 && intMinute < 48 ) || (intHour == 22 && intMinute >= 36 && intMinute < 48 ) )
				{
					stringHH = "53";	
				}
				
				if( (intHour == 10 && intMinute >= 48 && intMinute < 60 ) || (intHour == 22 && intMinute >= 48 && intMinute < 60 ) )
				{
					stringHH = "54";	
				}
				
				
				// 11 ou 23 heures

				if( (intHour == 11 && intMinute >= 0 && intMinute < 12 ) || (intHour == 23 && intMinute >= 0 && intMinute < 12 ) )
				{
					stringHH = "55";	
				}
				
				if( (intHour == 11 && intMinute >= 12 && intMinute < 24 ) || (intHour == 23 && intMinute >= 12 && intMinute < 24 ))
				{
					stringHH = "56";	
				}
				
				if( (intHour == 11 && intMinute >= 24 && intMinute < 36 ) || (intHour == 23 && intMinute >= 24 && intMinute < 36 ) )
				{
					stringHH = "57";	
				}
				
				if( (intHour == 11 && intMinute >= 36 && intMinute < 48 ) || (intHour == 23 && intMinute >= 36 && intMinute < 48 ) )
				{
					stringHH = "58";	
				}
				
				if( (intHour == 11 && intMinute >= 48 && intMinute < 60 ) || (intHour == 23 && intMinute >= 48 && intMinute < 60 ) )
				{
					stringHH = "59";
				}
				/*
				jPanelReveilHorlogeMinute.setImage( ( new ImageIcon( this.getClass().getResource( "horloge_1920x1080_heure" + stringHH + ".png" ) ) ).getImage() );
				jPanelReveilHorlogeHeure.repaint();
				*/
				
				// Minute
				/*
				jPanelReveilHorlogeMinute.setImage( ( new ImageIcon( this.getClass().getResource( "horloge_1920x1080_minute" + stringMinute + ".png" ) ) ).getImage() );
				jPanelReveilHorlogeMinute.repaint();
				*/
				
				// Seconde
				
				jPanelReveilHorlogeSeconde.setImage( ( new ImageIcon( this.getClass().getResource( "horloge_1920x1080_seconde_" + stringSeconde + ".png" ) ) ).getImage() );
				jPanelReveilHorlogeSeconde.repaint();

				this.pause( 100 );

			}

		}
		
	}

	
	public static void main(String[] args)
	{

		int _width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int _height = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		System.out.println( "W : " + _width );
		System.out.println( "H : " + _height );
		
		TestHorloge testHorloge = new TestHorloge();
		
	}

}
