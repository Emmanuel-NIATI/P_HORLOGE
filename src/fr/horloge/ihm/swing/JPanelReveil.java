package fr.horloge.ihm.swing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class JPanelReveil extends JPanel
{

	private Image image;
	
	public JPanelReveil()
	{

		this.image = null;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{

	    if( this.image != null )
	    {

	    	Graphics2D g2d = ( Graphics2D ) g;
	    	g2d.setRenderingHint( RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR );
	    	g2d.drawImage( image, 0, 0, getWidth(), getHeight(), null );

	    }

	}
	
	public Image getImage()
	{
		
		return this.image;
	}
	
	public void setImage( Image image_ )
	{
		
		this.image = image_;
	}

}
