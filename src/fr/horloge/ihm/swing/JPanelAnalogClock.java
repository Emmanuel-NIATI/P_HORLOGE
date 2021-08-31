package fr.horloge.ihm.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class JPanelAnalogClock extends JPanel
{

	private JPanelReveil jPanelAnalogClockHorloge;
	private JPanelReveil jPanelAnalogClockHorlogeHeure;
	
	public JPanelAnalogClock( Color colorReveil )
	{
		
		// Gestion du panel
		this.setPreferredSize( new Dimension( 800, 320) );
		this.setOpaque( false );
		this.setForeground( colorReveil );
				
		// Gestion de la disposition du panel
		BorderLayout borderLayoutAnalogClock = new BorderLayout();

		borderLayoutAnalogClock.setHgap(10);
		borderLayoutAnalogClock.setVgap(0);

		this.setLayout( borderLayoutAnalogClock );

		
		// jPanelReveilHorloge
		
		jPanelAnalogClockHorloge = new JPanelReveil();
		jPanelAnalogClockHorloge.setPreferredSize( new Dimension( 320, 320) );
		jPanelAnalogClockHorloge.setOpaque( false );
		jPanelAnalogClockHorloge.setImage( picture( "horloge" , 1 ).getImage() );
	
		
		// jPanelReveilHorlogeHeure

		jPanelAnalogClockHorlogeHeure = new JPanelReveil();
		jPanelAnalogClockHorlogeHeure.setPreferredSize( new Dimension( 320, 320) );
		jPanelAnalogClockHorlogeHeure.setOpaque( false );
		jPanelAnalogClockHorlogeHeure.setImage( picture( "heure_00" , 1 ).getImage() );

		BorderLayout borderLayoutAnalogClockHorlogeHeure = new BorderLayout();

		borderLayoutAnalogClockHorlogeHeure.setHgap(0);
		borderLayoutAnalogClockHorlogeHeure.setVgap(0);

		jPanelAnalogClockHorlogeHeure.setLayout( borderLayoutAnalogClockHorlogeHeure );

		
		
		
		// Gestion du panel
		jPanelAnalogClockHorloge.add( jPanelAnalogClockHorlogeHeure );
		
		this.add( jPanelAnalogClockHorloge, BorderLayout.WEST );
		
	}
		
	
	// Génération transparence
	private ImageIcon transparent( ImageIcon imageIcon )
	{
		
		Image image = imageIcon.getImage();
		
		BufferedImage bufferedImage = new BufferedImage(  image.getWidth( null ), image.getHeight( null ), BufferedImage.TYPE_INT_ARGB );    

		Graphics2D graphics2D = bufferedImage.createGraphics();
		graphics2D.drawImage(image, 0, 0, null);
		graphics2D.dispose();
		
		for( int c = 0; c < imageIcon.getIconWidth(); c++ )
		{

			for( int l = 0; l < imageIcon.getIconHeight(); l++ )
			{

				int rgb = bufferedImage.getRGB(c, l);

				if( rgb != -16777216 )
				{

					bufferedImage.setRGB(c,  l, 16777215);
				}

			}

		}

		ImageIcon imageIconTransparent = new ImageIcon( bufferedImage );

		return imageIconTransparent;

	}
	
	// Génération couleur
	private ImageIcon colorize( ImageIcon imageIcon)
	{

		Image image = imageIcon.getImage();
		
		BufferedImage bufferedImage = new BufferedImage(  image.getWidth( null ), image.getHeight( null ), BufferedImage.TYPE_INT_ARGB );    

		Graphics2D graphics2D = bufferedImage.createGraphics();
		graphics2D.drawImage(image, 0, 0, null);
		graphics2D.dispose();

		for( int c = 0; c < imageIcon.getIconWidth(); c++ )
		{

			for( int l = 0; l < imageIcon.getIconHeight(); l++ )
			{

				int rgb = bufferedImage.getRGB(c, l);
				
				if( rgb == -16777216 )
				{

					bufferedImage.setRGB( c,  l, getForeground().getRGB() );
				}

			}

		}
		
		ImageIcon imageIconColorized = new ImageIcon( bufferedImage );

		return imageIconColorized;
		
	}
	
	// Génération taille
	private ImageIcon resize( ImageIcon imageIcon, int size )
	{

		Image image = imageIcon.getImage();
		
		BufferedImage bufferedImageOriginal = new BufferedImage(  image.getWidth( null ), image.getHeight( null ), BufferedImage.TYPE_INT_ARGB );    

		Graphics2D graphics2D = bufferedImageOriginal.createGraphics();
		graphics2D.drawImage(image, 0, 0, null);
		graphics2D.dispose();

		int widthOriginal = bufferedImageOriginal.getWidth();
		int heightOriginal = bufferedImageOriginal.getHeight();
		
		int type = bufferedImageOriginal.getType();
		
		int widthSized = widthOriginal * size;
		int heightSized = heightOriginal * size;

		BufferedImage bufferedImageSized = new BufferedImage(widthSized, heightSized, type);		
		
		for (int ho = 0; ho < heightOriginal; ho++)
		{

			for (int hv = 0; hv < size; hv++)
			{

				for (int wo = 0; wo < widthOriginal; wo++)
				{

					for (int wv = 0; wv < size; wv++)
					{

						int ws = wo * size + wv;
						int hs = ho * size + hv;
						
						bufferedImageSized.setRGB( ws, hs, bufferedImageOriginal.getRGB( wo, ho) );

					}

				}

			}

		}

		ImageIcon imageIconSized = new ImageIcon( bufferedImageSized );

		return imageIconSized;

	}
	
	// Génération espacement
	private ImageIcon spacer( char c, int size )
	{
		
		ImageIcon imageIcon = new ImageIcon( this.getClass().getResource("spacer_" + c + ".png") );
		
		imageIcon = transparent( imageIcon );
		imageIcon = colorize( imageIcon );
		
		if ( size == 2 )
		{
		
			imageIcon = resize( imageIcon, 2 );
			
		}
		else if ( size == 3 )
		{

			imageIcon = resize( imageIcon, 3 );

		}

		return imageIcon;

	}

	// Génération nombre
	private ImageIcon number( char c, int size )
	{
		
		ImageIcon imageIcon = new ImageIcon( this.getClass().getResource("number_" + c + ".png") );
		
		imageIcon = transparent( imageIcon );
		imageIcon = colorize( imageIcon );
		
		if ( size == 2 )
		{
		
			imageIcon = resize( imageIcon, 2 );
			
		}
		else if ( size == 3 )
		{

			imageIcon = resize( imageIcon, 3 );

		}

		return imageIcon;

	}
	
	// Génération lettre
	private ImageIcon letter( char c, int size )
	{
		
		ImageIcon imageIcon = new ImageIcon( this.getClass().getResource("letter_" + c + ".png") );

		imageIcon = transparent( imageIcon );
		imageIcon = colorize( imageIcon );
		
		if ( size == 2 )
		{
		
			imageIcon = resize( imageIcon, 2 );
			
		}
		else if ( size == 3 )
		{

			imageIcon = resize( imageIcon, 3 );

		}

		return imageIcon;

	}

	// Génération picture
	private ImageIcon picture( String name, int size )
	{

		ImageIcon imageIcon = new ImageIcon( this.getClass().getResource( name + ".png") );

		imageIcon = transparent( imageIcon );
		imageIcon = colorize( imageIcon );
		
		if ( size == 2 )
		{
		
			imageIcon = resize( imageIcon, 2 );
			
		}
		else if ( size == 3 )
		{

			imageIcon = resize( imageIcon, 3 );

		}

		return imageIcon;
		
	}
	
	// Mise à l'heure
	public void setTime( String hour_, String minute_, String seconde_, String dayOfWeek_, String day_, String month_, String year_)
	{
		
		String hourD = hour_.substring(0, 1);
		String hourU = hour_.substring(1, 2);
		String minuteD = minute_.substring(0, 1);
		String minuteU = minute_.substring(1, 2);
		String secondeD = seconde_.substring(0, 1);
		String secondeU = seconde_.substring(1, 2);

		String dayD = day_.substring(0, 1);
		String dayU = day_.substring(1, 2);
		
		String yearM = year_.substring(0, 1);
		String yearC = year_.substring(1, 2);
		String yearD = year_.substring(2, 3);
		String yearU = year_.substring(3, 4);
		
	}

}
