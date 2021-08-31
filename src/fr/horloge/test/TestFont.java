package fr.horloge.test;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TestFont
{

    
	
	public static void main(String[] args)
	{

		
		
		
		Font font = new Font("Consolas", Font.ITALIC | Font.BOLD, 14);
		JFrame jFrame = new JFrame();
		jFrame.setSize(800, 480);
		JTextField jTextField = new JTextField();
		
		jTextField.setColumns(45);
		jTextField.setFont(font);
		
		GraphicsEnvironment ge;  
	    ge = GraphicsEnvironment.getLocalGraphicsEnvironment();  

	    String[] names = ge.getAvailableFontFamilyNames();
	    Font[] allFonts = ge.getAllFonts();
	    
	    ArrayList al = new ArrayList();
	    
	    for(int i=0; i<names.length; i++)
	    {
	    	al.add( names[i] );
	    }
	    
	    Iterator it = al.iterator();
	    
	    
	    
		JPanel jPanel = new JPanel();
		JButton jButton = new JButton("Next...");
		
		jPanel.add(jTextField, BorderLayout.NORTH);
		jPanel.add(jButton, BorderLayout.SOUTH);
		
		jFrame.add( jPanel );
		
		 
		
		jButton.addActionListener(
				
				new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e)
					{
						
						if( e.getSource() == jButton )
						{
							
							jTextField.setSize(300, 100);
							jTextField.setText( (String) it.next() );

							jTextField.setFont( new Font(  jTextField.getText()  , Font.ITALIC | Font.BOLD, 50));      
						}
				
					}
					
				}
				
				);
		
		
		

		jFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		jFrame.setVisible( true );

		
		
		/*		
		
		GraphicsEnvironment ge;  
	    ge = GraphicsEnvironment.getLocalGraphicsEnvironment();  

	    String[] names = ge.getAvailableFontFamilyNames();
	    Font[] allFonts = ge.getAllFonts();

	    for(int x=0; x<names.length; x++)
	    {
	    	System.out.println(names[x]);
	    }
	        

	    for(int x=0; x<allFonts.length; x++)
	    {           
	        System.out.println(allFonts[x].getName());
	        System.out.println(allFonts[x].getFontName());
	        System.out.println(allFonts[x].getFamily());
	        System.out.println(allFonts[x].getPSName());
	    }
*/
		

	}
	
	
	

}
