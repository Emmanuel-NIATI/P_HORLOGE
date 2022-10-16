package fr.horloge.structure;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;

import fr.horloge.structure.driver.ILI9341;
import fr.horloge.structure.system.DiskFileMp3Explorer;

public class ApplicationRaspberry extends AbstractApplication 
{

	private static final ApplicationRaspberry instance = new ApplicationRaspberry();

	private DiskFileMp3Explorer diskFileMp3Explorer = FactoryRaspberry.getInstance().createGestionDiskFileMp3Explorer();

	private ILI9341 ecran = FactoryRaspberry.getInstance().createGestionEcran();
	
	private int[] rgb_chat01;
	private int[] rgb_chat02;
	private int[] rgb_chat03;
	private int[] rgb_chat04;
	private int[] rgb_chat05;
	
	private ApplicationRaspberry()
	{

		super();

		// Gestion de l'écran

		try
		{

			ecran.powerOnSequence();

			ecran.clearScreen();

			ImageIcon chat01 = new ImageIcon( ApplicationRaspberry.class.getResource( "chat01.png" ) );
			ImageIcon chat02 = new ImageIcon( ApplicationRaspberry.class.getResource( "chat02.png" ) );
			ImageIcon chat03 = new ImageIcon( ApplicationRaspberry.class.getResource( "chat03.png" ) );
			ImageIcon chat04 = new ImageIcon( ApplicationRaspberry.class.getResource( "chat04.png" ) );
			ImageIcon chat05 = new ImageIcon( ApplicationRaspberry.class.getResource( "chat05.png" ) );
			
			rgb_chat01 = ecran.loadImage( chat01 );
			rgb_chat02 = ecran.loadImage( chat02 );
			rgb_chat03 = ecran.loadImage( chat03 );
			rgb_chat04 = ecran.loadImage( chat04 );
			rgb_chat05 = ecran.loadImage( chat05 );

			// Création du Thread Horloge Picture
			ThreadHorlogePicture threadHorlogePicture = new ThreadHorlogePicture();
			threadHorlogePicture.start();

			// Création du Thread Horloge Time
			ThreadHorlogeTime threadHorlogeTime = new ThreadHorlogeTime ();
			threadHorlogeTime.start();

		}
		catch(IOException ioe)
		{

			System.out.println( ">>>>>>>>>> IOException : " + ioe.getMessage() );
		}
		catch(InterruptedException ie)
		{

			System.out.println( ">>>>>>>>>> InterruptedException : " + ie.getMessage() );
		}

	}
	
	// Mise à l'heure
	public void setTime( String _hh, String _mm, String _ss, String _dow, String _day, String _month, String _year) throws IOException
	{

        // Affiche HH:MM:SS

        ecran.placeCursor(0, 34 * 8);
        ecran.print( _hh + ":" + _mm, 4, ILI9341.COLOR_BLUE_WINDOWS);

        ecran.placeCursor(20 * 6, 34 * 8);
        ecran.print( ":" + _ss, 3, ILI9341.COLOR_BLUE_WINDOWS);

        ecran.placeCursor(23 * 6, 34 * 8);
        ecran.print(_ss, 3, ILI9341.COLOR_BLUE_WINDOWS);

        // Affiche Dow dd/mm/yyyy

        ecran.placeCursor(0, 38 * 8);
        ecran.print( _dow + " " + _day + "/" + _month + "/" + _year, 2, ILI9341.COLOR_BLUE_WINDOWS);
		
	}

	public class ThreadHorlogePicture extends Thread
	{
		
		private void pause( int ms )
		{
			
			try
			{

				Thread.sleep( ms );
			}
			catch (InterruptedException ie)
			{

				System.out.println( ">>>>>>>>>> InterruptedException : " + ie.getMessage() );
			}
			
		}
		
		public void run()
		{

			while( true )
			{
				
				try
				{

					ecran.drawPicture(rgb_chat01, 0, 0, 240, 320);

					this.pause( 2000 );

					ecran.drawPicture(rgb_chat02, 0, 0, 240, 320);

					this.pause( 2000 );

					ecran.drawPicture(rgb_chat03, 0, 0, 240, 320);

					this.pause( 2000 );

					ecran.drawPicture(rgb_chat04, 0, 0, 240, 320);

					this.pause( 2000 );

					ecran.drawPicture(rgb_chat05, 0, 0, 240, 320);

					this.pause( 2000 );				
					
				}
				catch (IOException ioe) 
				{

					System.out.println( ">>>>>>>>>> IOException : " + ioe.getMessage() );

				}

			}

		}

	}
	
	public class ThreadHorlogeTime extends Thread
	{
		
		private void pause( int ms )
		{
			
			try
			{

				Thread.sleep( ms );
			}
			catch (InterruptedException ie)
			{

				System.out.println( ">>>>>>>>>> InterruptedException : " + ie.getMessage() );
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
				
				try
				{
				
					setTime( hour_, minute_, seconde_, dayOfWeek_, day_, month_, year_);
					
				}
				catch (IOException ioe) 
				{

					System.out.println( ">>>>>>>>>> IOException : " + ioe.getMessage() );

				}

				this.pause( 200 );
			}

		}

	}

	public static final ApplicationRaspberry getInstance()
	{

		return instance;
	}

}
