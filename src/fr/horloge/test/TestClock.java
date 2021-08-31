package fr.horloge.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import fr.horloge.ihm.swing.JPanelReveil;

public class TestClock
{
	
	public TestClock()
	{

		try
		{
			
			JFrame jFrame = new JFrame();

			// Gestion de l'apparence de la fenêtre 
			jFrame.setTitle("Réveil");
			jFrame.setLocation(0, 0);
			jFrame.setSize(400, 400);
			jFrame.setUndecorated( true );

			// Création du panel Clock
			JPanelReveil jPanelReveil = new JPanelReveil();

			jPanelReveil.setPreferredSize( new Dimension( 320, 320 ) );

			BufferedImage bufferedImage = ImageIO.read( this.getClass().getResource( "horloge_320x320.png" ) );

			AffineTransform at = new AffineTransform();

			at.setToRotation( Math.toRadians( 90 ), 160, 160 );
                        
            // draw the image
            Graphics2D g2D = bufferedImage.createGraphics();
            
            g2D.drawImage(bufferedImage, at, null );
            g2D.dispose();
			
			
            /*
			
			g2D.clearRect(0, 0, 50, 50);
			g2D.rotate( Math.toRadians ( 15 ), 160 , 160 );
			g2D.dispose();
			
			
			
			
			GraphicsConfiguration configuration = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
	        BufferedImage bufferedImageNew = configuration.createCompatibleImage(320, 320);
			
			Graphics2D g2DNew = bufferedImageNew.createGraphics();
			
			g2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
			g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);

			g2D.drawImage( bufferedImage, 0, 0, null );
			g2D.rotate( Math.toRadians ( 15 ),160,160 );		
			g2D.dispose();
			*/			
			
			
			
			jPanelReveil.setImage( bufferedImage ) ;   
			
			jFrame.getContentPane().add( jPanelReveil );
			
			jFrame.setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
			jFrame.setResizable( false );
			jFrame.setVisible( true );


		}
		catch(IOException ioe)
		{
			
			System.out.println("IOException : " + ioe.getMessage() );
		}

		
	}
		
	public static void main(String[] args)
	{
		
		new TestClock();
	}

}
