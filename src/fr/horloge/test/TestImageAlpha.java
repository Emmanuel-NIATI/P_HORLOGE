package fr.horloge.test;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;

import javax.imageio.ImageIO;


// RGBA (Red Green Blue Alpha) est une extension du format de codage des couleurs RGB qui lui ajoute un canal alpha qui détermine l’opacité, pour calculer une image numérique composée de calques virtuels, superposés.
// A = 0 => Transparent
// A = 255 => Opaque

public class TestImageAlpha
{

	public static void main(String[] args)
	{

		try
		{

			String pathIn = "C:\\Users\\emman\\Documents\\Clock\\in"; 
			String pathOut = "C:\\Users\\emman\\Documents\\Clock\\out";
			
			File fileOut = new File( pathOut );
			
			File[] filesOut = fileOut.listFiles();
			File fOut;
			
			File fileIn = new File( pathIn ); 

			File[] filesIn = fileIn.listFiles();
			File fIn;

			ArrayList<File> arrayListFileIn = new ArrayList<File>();

			for(int i = 0; i < filesIn.length; i++ )
			{
				
				fIn = filesIn[i];
				
				if( fIn.isFile() )
				{
					
					String ext = "dtc";
					String name = fIn.getName();
					
					int j = name.lastIndexOf('.');
					
					if (j > 0)
					{

					    ext = name.substring(j+1);
					}
					
					if( "png".equals( ext ) )
					{

						arrayListFileIn.add(fIn);
					}
				
					
				}
				
			}
			
			// Génération des fichiers en transparence
			
			for( File f : arrayListFileIn )
			{
		
				System.out.println( "Fichier : " + f.getName() );
				System.out.println( "" );
				
				BufferedImage bufferedImageOriginal = ImageIO.read( f );

				int widthOriginal = bufferedImageOriginal.getWidth();
				int heightOriginal = bufferedImageOriginal.getHeight();
				
				int type = bufferedImageOriginal.getType();

				String fileName = f.getName();
				int indexEnd = fileName.indexOf('.');
				String fileNameSubExt = fileName.substring(0, indexEnd);
				
				for( int c = 0; c < widthOriginal; c++ )
				{

					for( int l = 0; l < heightOriginal; l++ )
					{
						
						int rgb = bufferedImageOriginal.getRGB(c, l);
						
						System.out.println( "color : " + rgb  );

						
						if( rgb == -513 )
						{

							bufferedImageOriginal.setRGB(c,  l, 16777215);
						}

						
						if( rgb == -3 )
						{

							bufferedImageOriginal.setRGB(c,  l, 16777215);
						}

						
						if( rgb == -1 )
						{

							bufferedImageOriginal.setRGB(c,  l, 16777215);
						}

					}

				}
				
				String strWidthOriginal = "" + widthOriginal;
				
				if( strWidthOriginal.length() == 1 )
				{
					strWidthOriginal = "00" + strWidthOriginal;
				}
				else if( strWidthOriginal.length() == 2 )
				{
					strWidthOriginal = "0" + strWidthOriginal;
				}
				
				String strHeightOriginal = "" + heightOriginal;

				if( strHeightOriginal.length() == 1 )
				{
					strHeightOriginal = "00" + strHeightOriginal;
				}
				else if( strHeightOriginal.length() == 2 )
				{
					strHeightOriginal = "0" + strHeightOriginal;
				}
				
				ImageIO.write( bufferedImageOriginal, "png", new File( pathOut + "\\" + fileNameSubExt + "_" + strWidthOriginal + "x" + strHeightOriginal + ".png" ) );
				
			}

			System.out.println( "" );
			
			System.out.println("Image Successfully Manipulated!");

		}
		catch(IOException ioe)
		{
			
			System.out.println("IOException : " + ioe.getMessage() );
		}

	}

}
