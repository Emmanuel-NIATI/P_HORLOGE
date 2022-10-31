package fr.horloge.structure.driver;

import java.io.IOException;

import javax.swing.ImageIcon;

public interface IDisplay
{

	public void sleepIn() throws IOException, InterruptedException;
	
	public void sleepOut() throws IOException, InterruptedException;
	
	public void powerOnSequence() throws IOException, InterruptedException;
	
	public void fillRectangle(int x0, int y0, int width, int height, int color) throws IOException;

    public void colorScreen(int color) throws IOException;

    public void clearScreen() throws IOException;

    public int[] loadImage( ImageIcon imageIcon );

    public void drawPicture(int[] _picture, int x0, int y0, int width, int height) throws IOException;

    public void placeCursor( int x, int y );

    public void print( String s, int size, int color ) throws IOException;

    public void println( String s, int size, int color ) throws IOException;

    public void LCDPixel(int x0, int y0, int color) throws IOException;

    public void drawLine(int x1, int y1, int x2, int y2, int color) throws IOException;

    public void drawArc(int x0, int y0, int Radius, int startAngle, int endAngle, int color) throws IOException;

    public void drawCircle(int x0, int y0, int radius, int color) throws IOException;

    public void drawRectangle(int x0, int y0, int width, int height, int color) throws IOException;

}
