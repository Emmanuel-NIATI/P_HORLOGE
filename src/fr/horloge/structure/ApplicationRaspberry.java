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
	
	private int[] rgb_raspios;
	
	private int[] rgb_black;
	
	private int[] rgb_admin;
	private int[] rgb_blast;
	private int[] rgb_csa;
	private int[] rgb_gamer;
	
	private String rgb = "";
	
	private ApplicationRaspberry()
	{

		super();
		
        // Initialisation des variables
        this.initVariable();

        // Initialisation du GPIO
        this.initGpio();

        // Initialisation de l'affichage
        this.initSpiDisplay();

        // Initialisation des thread
        this.initThread();

	}
	
	private void initVariable()
	{

		ImageIcon img_raspios = new ImageIcon( ApplicationRaspberry.class.getResource( "raspios.png" ) );
		ImageIcon img_black = new ImageIcon( ApplicationRaspberry.class.getResource( "black.png" ) );
		ImageIcon img_admin = new ImageIcon( ApplicationRaspberry.class.getResource( "admin.png" ) );
		ImageIcon img_blast = new ImageIcon( ApplicationRaspberry.class.getResource( "blast.png" ) );
		ImageIcon img_csa = new ImageIcon( ApplicationRaspberry.class.getResource( "csa.png" ) );
		ImageIcon img_gamer = new ImageIcon( ApplicationRaspberry.class.getResource( "gamer.png" ) );

		rgb_raspios = ecran.loadImage( img_raspios );
		rgb_black = ecran.loadImage( img_black );
		rgb_admin = ecran.loadImage( img_admin );
		rgb_blast = ecran.loadImage( img_blast );
		rgb_csa = ecran.loadImage( img_csa );
		rgb_gamer = ecran.loadImage( img_gamer );
		
	}

	private void initGpio()
	{
		
	}
	
	private void initSpiDisplay()
	{
		
		try
		{

			ecran.powerOnSequence();

			ecran.clearScreen();
			
			ecran.drawPicture(rgb_raspios, 0, 0, 240, 240);
			
			rgb = "raspios";
			
			ecran.drawPicture(rgb_black, 0, 240, 240, 80);
		
            // Initialiser l'affichage de l'heure et de la date
            String hh = "09";
            String mm = "30";
            String ss = "25";
            String dow = "Mar";
            String day = "18";
            String month = "10";
            String year = "2022";

            setTime(hh, mm, ss, dow, day, month, year);

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

	private void initThread()
	{
		
		// Création du Thread Horloge Picture
		ThreadHorlogePicture threadHorlogePicture = new ThreadHorlogePicture();
		threadHorlogePicture.start();

		// Création du Thread Horloge Time
		ThreadHorlogeTime threadHorlogeTime = new ThreadHorlogeTime ();
		threadHorlogeTime.start();
		
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
					
					if( "raspios".equals( rgb ) )
					{

						ecran.drawPicture(rgb_csa, 0, 0, 240, 240);

						rgb="csa";
						
						this.pause( 2000 );
						
					}
					else if( "csa".equals( rgb ) )
					{

						ecran.drawPicture(rgb_admin, 0, 0, 240, 240);

						rgb="admin";
						
						this.pause( 2000 );
						
					}
					else if( "admin".equals( rgb ) )
					{

						ecran.drawPicture(rgb_gamer, 0, 0, 240, 240);

						rgb="gamer";
						
						this.pause( 2000 );
						
					}
					else if( "gamer".equals( rgb ) )
					{

						ecran.drawPicture(rgb_blast, 0, 0, 240, 240);

						rgb="blast";
						
						this.pause( 2000 );
						
					}
					else if( "blast".equals( rgb ) )
					{

						ecran.drawPicture(rgb_csa, 0, 0, 240, 240);

						rgb="csa";
						
						this.pause( 2000 );
						
					}
					
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

			Date date = Calendar.getInstance().getTime();

			while( true )
			{



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
