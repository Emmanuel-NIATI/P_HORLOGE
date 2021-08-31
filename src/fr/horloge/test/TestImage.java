package fr.horloge.test;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TestImage
{

	public static void main(String[] args)
	{

		int _width = 1920;
		int _height = 1080;
		
		try
		{

			String pathOut = "D:\\EclipseWorking\\out";

			BufferedImage bufferedImage = new BufferedImage( _width, _height, BufferedImage.TYPE_INT_ARGB );

			for ( int y = 0; y < _height; y++ )
			{

				for ( int x = 0; x < _width; x++ )
				{

					int rgb = ( new Color(255,255,255) ).getRGB();

					bufferedImage.setRGB( x, y, rgb );

				}

			}

			ImageIO.write( bufferedImage, "png", new File( pathOut + "\\" + "image_" + _width + "x" + _height + ".png" ) );

		}
		catch(IOException ioe)
		{

			System.out.println("IOException : " + ioe.getMessage() );
		}

	}

}
