package fr.horloge.ihm.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelDigitalClock extends JPanel
{
	
	private GridBagLayout gridBagLayoutDigitalClock;
	private GridBagConstraints gridBagConstraintsDigitalClock;
		
	private JLabel jLabelIconDigitalClock_00_00;
	private JLabel jLabelIconDigitalClock_03_00;
	private JLabel jLabelIconDigitalClock_06_00;
	private JLabel jLabelIconDigitalClock_09_00;
	private JLabel jLabelIconDigitalClock_12_00;
	private JLabel jLabelIconDigitalClock_15_00;
	private JLabel jLabelIconDigitalClock_17_00;
	private JLabel jLabelIconDigitalClock_19_00;

	private JLabel jLabelIconDigitalClock_00_04;

	private JLabel jLabelIconDigitalClock_00_05;
	private JLabel jLabelIconDigitalClock_01_05;
	private JLabel jLabelIconDigitalClock_02_05;
	private JLabel jLabelIconDigitalClock_03_05;
	private JLabel jLabelIconDigitalClock_04_05;
	private JLabel jLabelIconDigitalClock_05_05;
	private JLabel jLabelIconDigitalClock_06_05;
	private JLabel jLabelIconDigitalClock_07_05;
	private JLabel jLabelIconDigitalClock_08_05;
	private JLabel jLabelIconDigitalClock_09_05;
	private JLabel jLabelIconDigitalClock_10_05;
	private JLabel jLabelIconDigitalClock_11_05;
	private JLabel jLabelIconDigitalClock_12_05;
	private JLabel jLabelIconDigitalClock_13_05;
	private JLabel jLabelIconDigitalClock_14_05;
	private JLabel jLabelIconDigitalClock_15_05;

	public JPanelDigitalClock( Color colorReveil )
	{
		
		// Gestion du panel
		this.setPreferredSize( new Dimension( 800, 320) );
		this.setOpaque( false );
		this.setForeground( colorReveil );
		
		// Gestion de la disposition du panel
		gridBagLayoutDigitalClock = new GridBagLayout();
		
		this.setLayout( gridBagLayoutDigitalClock );

		gridBagConstraintsDigitalClock = new GridBagConstraints(); 

		jLabelIconDigitalClock_00_00 = new JLabel();
		jLabelIconDigitalClock_03_00 = new JLabel();
		jLabelIconDigitalClock_06_00 = new JLabel();
		jLabelIconDigitalClock_09_00 = new JLabel();
		jLabelIconDigitalClock_12_00 = new JLabel();
		jLabelIconDigitalClock_15_00 = new JLabel();
		jLabelIconDigitalClock_17_00 = new JLabel();
		jLabelIconDigitalClock_19_00 = new JLabel();

		jLabelIconDigitalClock_00_04 = new JLabel();

		jLabelIconDigitalClock_00_05 = new JLabel();
		jLabelIconDigitalClock_01_05 = new JLabel();
		jLabelIconDigitalClock_02_05 = new JLabel();
		jLabelIconDigitalClock_03_05 = new JLabel();
		jLabelIconDigitalClock_04_05 = new JLabel();
		jLabelIconDigitalClock_05_05 = new JLabel();
		jLabelIconDigitalClock_06_05 = new JLabel();
		jLabelIconDigitalClock_07_05 = new JLabel();
		jLabelIconDigitalClock_08_05 = new JLabel();
		jLabelIconDigitalClock_09_05 = new JLabel();
		jLabelIconDigitalClock_10_05 = new JLabel();
		jLabelIconDigitalClock_11_05 = new JLabel();
		jLabelIconDigitalClock_12_05 = new JLabel();
		jLabelIconDigitalClock_13_05 = new JLabel();
		jLabelIconDigitalClock_14_05 = new JLabel();
		jLabelIconDigitalClock_15_05 = new JLabel();
		
		jLabelIconDigitalClock_00_00.setIcon( number('1', 3) );
		jLabelIconDigitalClock_03_00.setIcon( number('4', 3) );
		jLabelIconDigitalClock_06_00.setIcon( spacer('2', 3) );
		jLabelIconDigitalClock_09_00.setIcon( number('2', 3) );
		jLabelIconDigitalClock_12_00.setIcon( number('5', 3) );
		jLabelIconDigitalClock_15_00.setIcon( spacer('2', 2) );
		jLabelIconDigitalClock_17_00.setIcon( number('1', 2) );
		jLabelIconDigitalClock_19_00.setIcon( number('0', 2) );

		jLabelIconDigitalClock_00_04.setIcon( spacer('0', 1) );
		
		jLabelIconDigitalClock_00_05.setIcon( letter('L', 1) );
		jLabelIconDigitalClock_01_05.setIcon( letter('U', 1) );
		jLabelIconDigitalClock_02_05.setIcon( letter('N', 1) );
		jLabelIconDigitalClock_03_05.setIcon( spacer('0', 1) );
		jLabelIconDigitalClock_04_05.setIcon( number('1', 1) );
		jLabelIconDigitalClock_05_05.setIcon( number('5', 1) );
		jLabelIconDigitalClock_06_05.setIcon( spacer('0', 1) );
		jLabelIconDigitalClock_07_05.setIcon( letter('J', 1) );
		jLabelIconDigitalClock_08_05.setIcon( letter('U', 1) );
		jLabelIconDigitalClock_09_05.setIcon( letter('I', 1) );
		jLabelIconDigitalClock_10_05.setIcon( letter('N', 1) );
		jLabelIconDigitalClock_11_05.setIcon( spacer('0', 1) );
		jLabelIconDigitalClock_12_05.setIcon( number('2', 1) );
		jLabelIconDigitalClock_13_05.setIcon( number('0', 1) );
		jLabelIconDigitalClock_14_05.setIcon( number('2', 1) );
		jLabelIconDigitalClock_15_05.setIcon( number('0', 1) );
		
		gridBagConstraintsDigitalClock.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraintsDigitalClock.gridwidth = 3;
		gridBagConstraintsDigitalClock.gridheight = 3;
		gridBagConstraintsDigitalClock.gridx = 0;
		gridBagConstraintsDigitalClock.gridy = 0;
		this.add(jLabelIconDigitalClock_00_00, gridBagConstraintsDigitalClock); 

		gridBagConstraintsDigitalClock.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraintsDigitalClock.gridwidth = 3;
		gridBagConstraintsDigitalClock.gridheight = 3;
		gridBagConstraintsDigitalClock.gridx = 3;
		gridBagConstraintsDigitalClock.gridy = 0;
		this.add(jLabelIconDigitalClock_03_00, gridBagConstraintsDigitalClock);

		gridBagConstraintsDigitalClock.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraintsDigitalClock.gridwidth = 3;
		gridBagConstraintsDigitalClock.gridheight = 3;
		gridBagConstraintsDigitalClock.gridx = 6;
		gridBagConstraintsDigitalClock.gridy = 0;
		this.add(jLabelIconDigitalClock_06_00, gridBagConstraintsDigitalClock);

		gridBagConstraintsDigitalClock.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraintsDigitalClock.gridwidth = 3;
		gridBagConstraintsDigitalClock.gridheight = 3;
		gridBagConstraintsDigitalClock.gridx = 9;
		gridBagConstraintsDigitalClock.gridy = 0;
		this.add(jLabelIconDigitalClock_09_00, gridBagConstraintsDigitalClock);

		gridBagConstraintsDigitalClock.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraintsDigitalClock.gridwidth = 3;
		gridBagConstraintsDigitalClock.gridheight = 3;
		gridBagConstraintsDigitalClock.gridx = 12;
		gridBagConstraintsDigitalClock.gridy = 0;
		this.add(jLabelIconDigitalClock_12_00, gridBagConstraintsDigitalClock);

		gridBagConstraintsDigitalClock.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraintsDigitalClock.gridwidth = 2;
		gridBagConstraintsDigitalClock.gridheight = 2;
		gridBagConstraintsDigitalClock.gridx = 15;
		gridBagConstraintsDigitalClock.gridy = 0;
		this.add(jLabelIconDigitalClock_15_00, gridBagConstraintsDigitalClock);

		gridBagConstraintsDigitalClock.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraintsDigitalClock.gridwidth = 2;
		gridBagConstraintsDigitalClock.gridheight = 2;
		gridBagConstraintsDigitalClock.gridx = 17;
		gridBagConstraintsDigitalClock.gridy = 0;
		this.add(jLabelIconDigitalClock_17_00, gridBagConstraintsDigitalClock);
		
		gridBagConstraintsDigitalClock.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraintsDigitalClock.gridwidth = 2;
		gridBagConstraintsDigitalClock.gridheight = 2;
		gridBagConstraintsDigitalClock.gridx = 19;
		gridBagConstraintsDigitalClock.gridy = 0;
		this.add(jLabelIconDigitalClock_19_00, gridBagConstraintsDigitalClock);

		gridBagConstraintsDigitalClock.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraintsDigitalClock.gridwidth = 1;
		gridBagConstraintsDigitalClock.gridheight = 1;
		gridBagConstraintsDigitalClock.gridx = 0;
		gridBagConstraintsDigitalClock.gridy = 4;
		this.add(jLabelIconDigitalClock_00_04, gridBagConstraintsDigitalClock);
		
		gridBagConstraintsDigitalClock.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraintsDigitalClock.gridwidth = 1;
		gridBagConstraintsDigitalClock.gridheight = 1;
		gridBagConstraintsDigitalClock.gridx = 0;
		gridBagConstraintsDigitalClock.gridy = 5;
		this.add(jLabelIconDigitalClock_00_05, gridBagConstraintsDigitalClock);

		gridBagConstraintsDigitalClock.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraintsDigitalClock.gridwidth = 1;
		gridBagConstraintsDigitalClock.gridheight = 1;
		gridBagConstraintsDigitalClock.gridx = 1;
		gridBagConstraintsDigitalClock.gridy = 5;
		this.add(jLabelIconDigitalClock_01_05, gridBagConstraintsDigitalClock);
		
		gridBagConstraintsDigitalClock.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraintsDigitalClock.gridwidth = 1;
		gridBagConstraintsDigitalClock.gridheight = 1;
		gridBagConstraintsDigitalClock.gridx = 2;
		gridBagConstraintsDigitalClock.gridy = 5;
		this.add(jLabelIconDigitalClock_02_05, gridBagConstraintsDigitalClock);

		gridBagConstraintsDigitalClock.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraintsDigitalClock.gridwidth = 1;
		gridBagConstraintsDigitalClock.gridheight = 1;
		gridBagConstraintsDigitalClock.gridx = 3;
		gridBagConstraintsDigitalClock.gridy = 5;
		this.add(jLabelIconDigitalClock_03_05, gridBagConstraintsDigitalClock);
		
		gridBagConstraintsDigitalClock.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraintsDigitalClock.gridwidth = 1;
		gridBagConstraintsDigitalClock.gridheight = 1;
		gridBagConstraintsDigitalClock.gridx = 4;
		gridBagConstraintsDigitalClock.gridy = 5;
		this.add(jLabelIconDigitalClock_04_05, gridBagConstraintsDigitalClock);

		gridBagConstraintsDigitalClock.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraintsDigitalClock.gridwidth = 1;
		gridBagConstraintsDigitalClock.gridheight = 1;
		gridBagConstraintsDigitalClock.gridx = 5;
		gridBagConstraintsDigitalClock.gridy = 5;
		this.add(jLabelIconDigitalClock_05_05, gridBagConstraintsDigitalClock);

		gridBagConstraintsDigitalClock.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraintsDigitalClock.gridwidth = 1;
		gridBagConstraintsDigitalClock.gridheight = 1;
		gridBagConstraintsDigitalClock.gridx = 6;
		gridBagConstraintsDigitalClock.gridy = 5;
		this.add(jLabelIconDigitalClock_06_05, gridBagConstraintsDigitalClock);
		
		gridBagConstraintsDigitalClock.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraintsDigitalClock.gridwidth = 1;
		gridBagConstraintsDigitalClock.gridheight = 1;
		gridBagConstraintsDigitalClock.gridx = 7;
		gridBagConstraintsDigitalClock.gridy = 5;
		this.add(jLabelIconDigitalClock_07_05, gridBagConstraintsDigitalClock);

		gridBagConstraintsDigitalClock.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraintsDigitalClock.gridwidth = 1;
		gridBagConstraintsDigitalClock.gridheight = 1;
		gridBagConstraintsDigitalClock.gridx = 8;
		gridBagConstraintsDigitalClock.gridy = 5;
		this.add(jLabelIconDigitalClock_08_05, gridBagConstraintsDigitalClock);
		
		gridBagConstraintsDigitalClock.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraintsDigitalClock.gridwidth = 1;
		gridBagConstraintsDigitalClock.gridheight = 1;
		gridBagConstraintsDigitalClock.gridx = 9;
		gridBagConstraintsDigitalClock.gridy = 5;
		this.add(jLabelIconDigitalClock_09_05, gridBagConstraintsDigitalClock);

		gridBagConstraintsDigitalClock.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraintsDigitalClock.gridwidth = 1;
		gridBagConstraintsDigitalClock.gridheight = 1;
		gridBagConstraintsDigitalClock.gridx = 10;
		gridBagConstraintsDigitalClock.gridy = 5;
		this.add(jLabelIconDigitalClock_10_05, gridBagConstraintsDigitalClock);

		gridBagConstraintsDigitalClock.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraintsDigitalClock.gridwidth = 1;
		gridBagConstraintsDigitalClock.gridheight = 1;
		gridBagConstraintsDigitalClock.gridx = 11;
		gridBagConstraintsDigitalClock.gridy = 5;
		this.add(jLabelIconDigitalClock_11_05, gridBagConstraintsDigitalClock);
		
		gridBagConstraintsDigitalClock.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraintsDigitalClock.gridwidth = 1;
		gridBagConstraintsDigitalClock.gridheight = 1;
		gridBagConstraintsDigitalClock.gridx = 12;
		gridBagConstraintsDigitalClock.gridy = 5;
		this.add(jLabelIconDigitalClock_12_05, gridBagConstraintsDigitalClock);

		gridBagConstraintsDigitalClock.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraintsDigitalClock.gridwidth = 1;
		gridBagConstraintsDigitalClock.gridheight = 1;
		gridBagConstraintsDigitalClock.gridx = 13;
		gridBagConstraintsDigitalClock.gridy = 5;
		this.add(jLabelIconDigitalClock_13_05, gridBagConstraintsDigitalClock);
		
		gridBagConstraintsDigitalClock.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraintsDigitalClock.gridwidth = 1;
		gridBagConstraintsDigitalClock.gridheight = 1;
		gridBagConstraintsDigitalClock.gridx = 14;
		gridBagConstraintsDigitalClock.gridy = 5;
		this.add(jLabelIconDigitalClock_14_05, gridBagConstraintsDigitalClock);

		gridBagConstraintsDigitalClock.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraintsDigitalClock.gridwidth = 1;
		gridBagConstraintsDigitalClock.gridheight = 1;
		gridBagConstraintsDigitalClock.gridx = 15;
		gridBagConstraintsDigitalClock.gridy = 5;
		this.add(jLabelIconDigitalClock_15_05, gridBagConstraintsDigitalClock);
		
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
		
		jLabelIconDigitalClock_00_00.setIcon( number( hourD.charAt(0), 3 ) );
		jLabelIconDigitalClock_03_00.setIcon( number( hourU.charAt(0), 3 ) );

		jLabelIconDigitalClock_09_00.setIcon( number( minuteD.charAt(0), 3 ) );
		jLabelIconDigitalClock_12_00.setIcon( number( minuteU.charAt(0), 3 ) );
		
		jLabelIconDigitalClock_17_00.setIcon( number( secondeD.charAt(0), 2 ) );
		jLabelIconDigitalClock_19_00.setIcon( number( secondeU.charAt(0), 2 ) );
		
		if( dayOfWeek_.equals( "1" ) ) 
		{ 
			
			jLabelIconDigitalClock_00_05.setIcon( letter( 'L', 1 ) );
			jLabelIconDigitalClock_01_05.setIcon( letter( 'U', 1 ) );
			jLabelIconDigitalClock_02_05.setIcon( letter( 'N', 1 ) );

		}
		
		if( dayOfWeek_.equals( "2" ) ) 
		{
			
			jLabelIconDigitalClock_00_05.setIcon( letter( 'M', 1 ) );
			jLabelIconDigitalClock_01_05.setIcon( letter( 'A', 1 ) );
			jLabelIconDigitalClock_02_05.setIcon( letter( 'R', 1 ) );

		}
		
		if( dayOfWeek_.equals( "3" ) ) 
		{ 
			
			jLabelIconDigitalClock_00_05.setIcon( letter( 'M', 1 ) );
			jLabelIconDigitalClock_01_05.setIcon( letter( 'E', 1 ) );
			jLabelIconDigitalClock_02_05.setIcon( letter( 'R', 1 ) );

		}
		
		if( dayOfWeek_.equals( "4" ) ) 
		{ 

			jLabelIconDigitalClock_00_05.setIcon( letter( 'J', 1 ) );
			jLabelIconDigitalClock_01_05.setIcon( letter( 'E', 1 ) );
			jLabelIconDigitalClock_02_05.setIcon( letter( 'U', 1 ) );

		}

		if( dayOfWeek_.equals( "5" ) ) 
		{ 

			jLabelIconDigitalClock_00_05.setIcon( letter( 'V', 1 ) );
			jLabelIconDigitalClock_01_05.setIcon( letter( 'E', 1 ) );
			jLabelIconDigitalClock_02_05.setIcon( letter( 'N', 1 ) );

		}

		if( dayOfWeek_.equals( "6" ) ) 
		{

			jLabelIconDigitalClock_00_05.setIcon( letter( 'S', 1 ) );
			jLabelIconDigitalClock_01_05.setIcon( letter( 'A', 1 ) );
			jLabelIconDigitalClock_02_05.setIcon( letter( 'M', 1 ) );

		}

		if( dayOfWeek_.equals( "7" ) ) 
		{

			jLabelIconDigitalClock_00_05.setIcon( letter( 'D', 1 ) );
			jLabelIconDigitalClock_01_05.setIcon( letter( 'I', 1 ) );
			jLabelIconDigitalClock_02_05.setIcon( letter( 'M', 1 ) );

		}

		jLabelIconDigitalClock_04_05.setIcon( number( dayD.charAt(0), 1 ) );
		jLabelIconDigitalClock_05_05.setIcon( number( dayU.charAt(0), 1 ) );
		
		if( month_.equals( "01" ) ) 
		{ 

			jLabelIconDigitalClock_07_05.setIcon( letter( 'J', 1 ) );
			jLabelIconDigitalClock_08_05.setIcon( letter( 'A', 1 ) ); 
			jLabelIconDigitalClock_09_05.setIcon( letter( 'N', 1 ) );
			jLabelIconDigitalClock_10_05.setIcon( spacer( '0', 1 ) );
			
		}
		
		if( month_.equals( "02" ) ) 
		{ 

			jLabelIconDigitalClock_07_05.setIcon( letter( 'F', 1 ) );
			jLabelIconDigitalClock_08_05.setIcon( letter( 'E', 1 ) );
			jLabelIconDigitalClock_09_05.setIcon( letter( 'V', 1 ) ); 
			jLabelIconDigitalClock_10_05.setIcon( spacer( '0', 1 ) );
			
		}
		
		if( month_.equals( "03" ) ) 
		{ 

			jLabelIconDigitalClock_07_05.setIcon( letter( 'M', 1 ) );
			jLabelIconDigitalClock_08_05.setIcon( letter( 'A', 1 ) );
			jLabelIconDigitalClock_09_05.setIcon( letter( 'R', 1 ) );
			jLabelIconDigitalClock_10_05.setIcon( spacer( '0', 1 ) );
			
		}
		
		if( month_.equals( "04" ) ) 
		{ 

			jLabelIconDigitalClock_07_05.setIcon( letter( 'A', 1 ) );
			jLabelIconDigitalClock_08_05.setIcon( letter( 'V', 1 ) );
			jLabelIconDigitalClock_09_05.setIcon( letter( 'R', 1 ) );
			jLabelIconDigitalClock_10_05.setIcon( spacer( '0', 1 ) );
			
		}
		
		if( month_.equals( "05" ) ) 
		{ 

			jLabelIconDigitalClock_07_05.setIcon( letter( 'M', 1 ) );
			jLabelIconDigitalClock_08_05.setIcon( letter( 'A', 1 ) );
			jLabelIconDigitalClock_09_05.setIcon( letter( 'I', 1 ) );
			jLabelIconDigitalClock_10_05.setIcon( spacer( '0', 1 ) );
			
		}
		
		if( month_.equals( "06" ) ) 
		{ 

			jLabelIconDigitalClock_07_05.setIcon( letter( 'J', 1 ) );
			jLabelIconDigitalClock_08_05.setIcon( letter( 'U', 1 ) );
			jLabelIconDigitalClock_09_05.setIcon( letter( 'I', 1 ) );
			jLabelIconDigitalClock_10_05.setIcon( letter( 'N', 1 ) );
			
		}
		
		if( month_.equals( "07" ) ) 
		{ 

			jLabelIconDigitalClock_07_05.setIcon( letter( 'J', 1 ) );
			jLabelIconDigitalClock_08_05.setIcon( letter( 'U', 1 ) );
			jLabelIconDigitalClock_09_05.setIcon( letter( 'I', 1 ) );
			jLabelIconDigitalClock_10_05.setIcon( letter( 'L', 1 ) );
			
		}
		
		if( month_.equals( "08" ) ) 
		{ 

			jLabelIconDigitalClock_07_05.setIcon( letter( 'A', 1 ) );
			jLabelIconDigitalClock_08_05.setIcon( letter( 'O', 1 ) );
			jLabelIconDigitalClock_09_05.setIcon( letter( 'U', 1 ) );
			jLabelIconDigitalClock_10_05.setIcon( spacer( '0', 1 ) );

		}
		
		if( month_.equals( "09" ) ) 
		{ 

			jLabelIconDigitalClock_07_05.setIcon( letter( 'S', 1 ) );
			jLabelIconDigitalClock_08_05.setIcon( letter( 'E', 1 ) );
			jLabelIconDigitalClock_09_05.setIcon( letter( 'P', 1 ) );
			jLabelIconDigitalClock_10_05.setIcon( spacer( '0', 1 ) );
			
		}
		
		if( month_.equals( "10" ) ) 
		{ 

			jLabelIconDigitalClock_07_05.setIcon( letter( 'O', 1 ) );
			jLabelIconDigitalClock_08_05.setIcon( letter( 'C', 1 ) );
			jLabelIconDigitalClock_09_05.setIcon( letter( 'T', 1 ) );
			jLabelIconDigitalClock_10_05.setIcon( spacer( '0', 1 ) );
			
		}

		if( month_.equals( "11" ) ) 
		{ 

			jLabelIconDigitalClock_07_05.setIcon( letter( 'N', 1 ) );
			jLabelIconDigitalClock_08_05.setIcon( letter( 'O', 1 ) );
			jLabelIconDigitalClock_09_05.setIcon( letter( 'V', 1 ) );
			jLabelIconDigitalClock_10_05.setIcon( spacer( '0', 1 ) );

		}
		
		if( month_.equals( "12" ) ) 
		{ 

			jLabelIconDigitalClock_07_05.setIcon( letter( 'D', 1 ) );
			jLabelIconDigitalClock_08_05.setIcon( letter( 'E', 1 ) );
			jLabelIconDigitalClock_09_05.setIcon( letter( 'C', 1 ) );
			jLabelIconDigitalClock_10_05.setIcon( spacer( '0', 1 ) );

		}
		
		jLabelIconDigitalClock_12_05.setIcon( number( yearM.charAt(0), 1 ) );
		jLabelIconDigitalClock_13_05.setIcon( number( yearC.charAt(0), 1 ) );
		jLabelIconDigitalClock_14_05.setIcon( number( yearD.charAt(0), 1 ) );
		jLabelIconDigitalClock_15_05.setIcon( number( yearU.charAt(0), 1 ) );
		
	}

}
