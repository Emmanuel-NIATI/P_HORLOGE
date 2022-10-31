package fr.horloge.structure;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;

import fr.horloge.structure.driver.IDisplay;
import fr.horloge.structure.driver.ILI9341;
import fr.horloge.structure.system.DiskFileMp3Explorer;

public class ApplicationRaspberry extends AbstractApplication 
{

	private static final ApplicationRaspberry instance = new ApplicationRaspberry();

	private DiskFileMp3Explorer diskFileMp3Explorer = FactoryRaspberry.getInstance().createGestionDiskFileMp3Explorer();

	private IDisplay ecran = FactoryRaspberry.getInstance().createGestionEcran();
	
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

	// Mise à l'heure
	public void setTime(Date date_) throws IOException
	{
		
		// Mise en forme de la date
		
		SimpleDateFormat simpleDateFormatHour = new SimpleDateFormat("HH");
		SimpleDateFormat simpleDateFormatMinute = new SimpleDateFormat("mm");
		SimpleDateFormat simpleDateFormatSeconde = new SimpleDateFormat("ss");
		
		SimpleDateFormat simpleDateFormatDayOfWeek = new SimpleDateFormat("E");
		SimpleDateFormat simpleDateFormatDay = new SimpleDateFormat("dd");
		SimpleDateFormat simpleDateFormatMonth = new SimpleDateFormat("MM");
		SimpleDateFormat simpleDateFormatYear = new SimpleDateFormat("yyyy");
		
		String hour_ =  simpleDateFormatHour.format(date_);
		String minute_ = simpleDateFormatMinute.format(date_);
		String seconde_ = simpleDateFormatSeconde.format(date_);

		String dow_ = simpleDateFormatDayOfWeek.format(date_);
		String day_ = simpleDateFormatDay.format(date_);
		String month_ = simpleDateFormatMonth.format(date_);
		String year_ = simpleDateFormatYear.format(date_);
		
        // Affiche HH:MM:SS

        ecran.placeCursor(0, 34 * 8);
        ecran.print( hour_ + ":" + minute_, 4, ILI9341.COLOR_BLUE_WINDOWS);

        ecran.placeCursor(20 * 6, 34 * 8);
        ecran.print( ":" + seconde_, 3, ILI9341.COLOR_BLUE_WINDOWS);

        // Affiche Dow dd/mm/yyyy

        ecran.placeCursor(0, 38 * 8);
        ecran.print( dow_ + " " + day_ + "/" + month_ + "/" + year_, 2, ILI9341.COLOR_BLUE_WINDOWS);

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

			Date date_ = Calendar.getInstance().getTime();
			
            setTime( date_ );

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

		// Création du Thread Horloge
		ThreadHorloge threadHorloge = new ThreadHorloge();
		threadHorloge.start();

	}
	
	public class ThreadHorloge extends Thread
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

					for( int i = 0; i < 10; i++ )	
					{

						setTime( Calendar.getInstance().getTime() );	
						
						this.pause( 200 );

					}

					if( "raspios".equals( rgb ) )
					{

						ecran.drawPicture(rgb_csa, 0, 0, 240, 240);

						rgb="csa";
						
					}
					else if( "csa".equals( rgb ) )
					{

						ecran.drawPicture(rgb_admin, 0, 0, 240, 240);

						rgb="admin";
						
					}
					else if( "admin".equals( rgb ) )
					{

						ecran.drawPicture(rgb_gamer, 0, 0, 240, 240);

						rgb="gamer";
						
					}
					else if( "gamer".equals( rgb ) )
					{

						ecran.drawPicture(rgb_blast, 0, 0, 240, 240);

						rgb="blast";
						
					}
					else if( "blast".equals( rgb ) )
					{

						ecran.drawPicture(rgb_csa, 0, 0, 240, 240);

						rgb="csa";

					}

					this.pause( 200 );
						
				}
				catch (IOException ioe)
				{

					System.out.println( ">>>>>>>>>> IOException : " + ioe.getMessage() );

				}

			}

		}

	}

	public static final ApplicationRaspberry getInstance()
	{

		return instance;
	}

}
