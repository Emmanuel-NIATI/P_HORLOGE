package fr.horloge.structure.driver;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;

import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

import com.pi4j.io.spi.SpiChannel;
import com.pi4j.io.spi.SpiDevice;
import com.pi4j.io.spi.SpiFactory;
import com.pi4j.io.spi.SpiMode;

import fr.horloge.structure.util.Convertissor;

public class ILI9341
{

	// Plan de cablâge
	
	// LCD ILI9341		RPI0W	-	RPI2b	-	RPI3b
	//					pi4j					python / C#
	
    // 1) +Vcc			 1) +3.3V				 1) +3.3V 					Fil rouge
    // 2) GND			20) GND					20) GND						Fil noir
    // 3) CS			24) CE0 (SPI) GPIO 10	24) CE0 (SPI) GPIO 8		Fil blanc
    // 4) RESET			16) GPIO 4				16) GPIO 23					Fil jaune
    // 5) DC/RS			15) GPIO 3				15) GPIO 22					Fil violet
    // 6) MOSI			19) MOSI (SPI) GPIO 12	19) MOSI (SPI) GPIO 10		Fil bleu
    // 7) SCK			23) SCLK (SPI) GPIO 14	23) SCLK (SPI) GPIO 11		Fil orange
    // 8) LED			17) +3.3V				17) +3.3V					Fil vert
    // 9) MISO			21) MISO (SPI) GPIO 13	21) MISO (SPI) GPIO 9		Fil marron
	
	
	// Mémo

	// byte		Signed 1 byte	Stores whole numbers from -128 to 127

	// short	Signed 2 bytes	Stores whole numbers from -32,768 to 32,767

	// int		Signed 4 bytes	Stores whole numbers from -2,147,483,648 to 2,147,483,647

	// long		Signed 8 bytes	Stores whole numbers from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
	
	
	// Liste des variables
	
	private final static int LCD_W = 240;
	private final static int LCD_H = 320;
	
 	private GpioPinDigitalOutput dc;
 	private GpioPinDigitalOutput rst;

 	private SpiDevice spiDeviceCS0;

 	private int resolution;

 	private int cursorX;
 	private int cursorY;
 	
 	// Liste des résolutions

 	private final static int HEIGHT_04 = 4;
 	private final static int HEIGHT_08 = 8;
 	private final static int HEIGHT_10 = 10;
 	private final static int HEIGHT_16 = 16;
 	private final static int HEIGHT_32 = 32;

    // Liste des commandes

 	private final static short[] CMD_NO_OPERATION 								= { 0x00 };
 	private final static short[] CMD_SOFTWARE_RESET 							= { 0x01 };
 	private final static short[] CMD_READ_DISPLAY_IDENTIFICATION_INFORMATION 	= { 0x04 };
 	private final static short[] CMD_READ_DISPLAY_STATUS 						= { 0x09 };
 	private final static short[] CMD_READ_DISPLAY_POWER_MODE 					= { 0x0A };
 	private final static short[] CMD_READ_DISPLAY_MADCTL 						= { 0x0B };
 	private final static short[] CMD_READ_DISPLAY_PIXEL_FORMAT 					= { 0x0C };
 	private final static short[] CMD_READ_DISPLAY_IMAGE_FORMAT 					= { 0x0D };
 	private final static short[] CMD_READ_DISPLAY_SIGNAL_MODE 					= { 0x0E };
 	private final static short[] CMD_READ_DISPLAY_SELF_DIAGNOSTIC_RESULT 		= { 0x0F };
 	
 	private final static short[] CMD_ENTER_SLEEP_MODE 							= { 0x10 };
 	private final static short[] CMD_SLEEP_OUT 									= { 0x11 };
 	private final static short[] CMD_PARTIAL_MODE_ON 							= { 0x12 };
 	private final static short[] CMD_NORMAL_DISPLAY_MODE 						= { 0x13 };
 	
 	private final static short[] CMD_DISPLAY_INVERSION_OFF 						= { 0x20 };
 	private final static short[] CMD_DISPLAY_INVERSION_ON 						= { 0x21 };
 	private final static short[] CMD_GAMMA_SET 									= { 0x26 };
 	private final static short[] CMD_DISPLAY_OFF 								= { 0x28 };
 	private final static short[] CMD_DISPLAY_ON 								= { 0x29 };
 	private final static short[] CMD_COLUMN_ADDRESS_SET							= { 0x2A };
 	private final static short[] CMD_PAGE_ADDRESS_SET 							= { 0x2B };
 	private final static short[] CMD_MEMORY_WRITE 								= { 0x2C };
 	private final static short[] CMD_COLOR_SET 									= { 0x2D };
 	private final static short[] CMD_MEMORY_READ 								= { 0x2E };

 	private final static short[] CMD_PARTIAL_AREA 								= { 0x30 };
 	private final static short[] CMD_VERTICAL_SCROLLING_DEFINITION 				= { 0x33 }; 	
 	private final static short[] CMD_TEARING_EFFECT_LINE_OFF 					= { 0x34 };
 	private final static short[] CMD_TEARING_EFFECT_LINE_ON 					= { 0x35 };
 	private final static short[] CMD_MEMORY_ACCESS_CONTROL 						= { 0x36 };
 	private final static short[] CMD_VERTICAL_SCROLLING_START_ADDRESS 			= { 0x37 };
 	private final static short[] CMD_IDLE_MODE_OFF 								= { 0x38 };
 	private final static short[] CMD_IDLE_MODE_ON 								= { 0x39 };
 	
 	private final static short[] CMD_PIXEL_FORMAT_SET							= { 0x3A };
 	private final static short[] CMD_WRITE_MEMORY_CONTINUE						= { 0x3C };
 	private final static short[] CMD_READ_MEMORY_CONTINUE 						= { 0x3E };

 	private final static short[] CMD_SET_TEAR_SCANLINE 							= { 0x44 };
 	private final static short[] CMD_GET_SCANLINE 								= { 0x45 };
 	
 	private final static short[] CMD_WRITE_DISPLAY_BRIGHTNESS 					= { 0x51 };
	private final static short[] CMD_READ_DISPLAY_BRIGHTNESS 					= { 0x52 };
 	private final static short[] CMD_WRITE_CTRL_DISPLAY							= { 0x53 };
 	private final static short[] CMD_READ_CTRL_DISPLAY 							= { 0x54 };
 	private final static short[] CMD_WRITE_CONTENT_ADAPTIVE_BRIGHTNESS_CONTROL 	= { 0x55 };
 	private final static short[] CMD_READ_CONTENT_ADAPTIVE_BRIGHTNESS_CONTROL 	= { 0x56 };
 	private final static short[] CMD_WRITE_CABC_MINIMUM_BRIGHTNESS 				= { 0x5E };
 	private final static short[] CMD_READ_CABC_MINIMUM_BRIGHTNESS 				= { 0x5F };

 	private final static short[] CMD_RGB_INTERFACE_SIGNAL_CONTROL				= { 0xB0 };
 	private final static short[] CMD_FRAME_CONTROL_NORMAL_MODE 					= { 0xB1 };
 	private final static short[] CMD_FRAME_CONTROL_IDLE_MODE					= { 0xB2 };
 	private final static short[] CMD_FRAME_CONTROL_PARTIAL_MODE 				= { 0xB3 };
 	private final static short[] CMD_DISPLAY_INVERSION_CONTROL					= { 0xB4 };
 	private final static short[] CMD_BLANKING_PORCH_CONTROL						= { 0xB5 };
 	private final static short[] CMD_DISPLAY_FUNCTION_CONTROL 					= { 0xB6 };
 	private final static short[] CMD_ENTRY_MODE_SET								= { 0xB7 };
 	private final static short[] CMD_BACKLIGHT_CONTROL_1						= { 0xB8 };
 	private final static short[] CMD_BACKLIGHT_CONTROL_2						= { 0xB9 };
 	private final static short[] CMD_BACKLIGHT_CONTROL_3						= { 0xBA };
 	private final static short[] CMD_BACKLIGHT_CONTROL_4						= { 0xBB };
 	private final static short[] CMD_BACKLIGHT_CONTROL_5						= { 0xBc };
 	private final static short[] CMD_BACKLIGHT_CONTROL_7						= { 0xBe };
 	private final static short[] CMD_BACKLIGHT_CONTROL_8						= { 0xBf };

 	private final static short[] CMD_POWER_CONTROL_1							= { 0xC0 };
 	private final static short[] CMD_POWER_CONTROL_2							= { 0xC1 };
 	private final static short[] CMD_VCOM_CONTROL_1								= { 0xC5 };
 	private final static short[] CMD_VCOM_CONTROL_2								= { 0xC7 };
 	private final static short[] CMD_POWER_CONTROL_A 							= { 0xCB };
 	private final static short[] CMD_POWER_CONTROL_B 							= { 0xCF };

 	private final static short[] CMD_NV_MEMORY_WRITE							= { 0xD0 };
 	private final static short[] CMD_NV_MEMORY_PROTECTION_KEY 					= { 0xD1 };
 	private final static short[] CMD_NV_MEMORY_STATUS_READ						= { 0xD2 };
 	private final static short[] CMD_READ_ID4									= { 0xD3 };
 	private final static short[] CMD_READ_ID1									= { 0xDA };
 	private final static short[] CMD_READ_ID2									= { 0xDB };
 	private final static short[] CMD_READ_ID3									= { 0xDC };

 	private final static short[] CMD_POSITIVE_GAMMA_CORRECTION					= { 0xE0 };
 	private final static short[] CMD_NEGATIVE_GAMMA_CORRECTION					= { 0xE1 };
 	private final static short[] CMD_DIGITAL_GAMMA_CONTROL_1					= { 0xE2 };
 	private final static short[] CMD_DIGITAL_GAMMA_CONTROL_2					= { 0xE3 };
 	private final static short[] CMD_DRIVER_TIMING_CONTROL_A 					= { 0xE8 };
 	private final static short[] CMD_DRIVER_TIMING_CONTROL_B 					= { 0xEA };
 	private final static short[] CMD_POWER_ON_SEQUENCE_CONTROL 					= { 0xED };
 	private final static short[] CMD_ENABLE_3G 									= { 0xF2 };
 	private final static short[] CMD_INTERFACE_CONTROL							= { 0xF6 };
 	private final static short[] CMD_PUMP_RATIO_CONTROL 						= { 0xF7 };

 	
 	// Liste des couleurs
 	
 	public final static int COLOR_BLACK											= 0x0000;  //   0,   0,   0
 	public final static int COLOR_NAVY											= 0x000F;  //   0,   0, 123
 	public final static int COLOR_DARKGREEN										= 0x03E0;  //   0, 125,   0
 	public final static int COLOR_DARKCYAN										= 0x03EF;  //   0, 125, 123
 	public final static int COLOR_MAROON										= 0x7800;  // 123,   0,   0
 	public final static int COLOR_PURPLE     									= 0x780F;  // 123,   0, 123
 	public final static int COLOR_OLIVE      									= 0x7BE0;  // 123, 125,   0
 	public final static int COLOR_LIGHTGREY										= 0xC618;  // 198, 195, 198
 	public final static int COLOR_DARKGREY   									= 0x7BEF;  // 123, 125, 123
 	public final static int COLOR_BLUE       									= 0x001F;  //   0,   0, 255
 	public final static int COLOR_GREEN       									= 0x07E0;  //   0, 255,   0
 	public final static int COLOR_CYAN        									= 0x07FF;  //   0, 255, 255
 	public final static int COLOR_RED         									= 0xF800;  // 255,   0,   0
 	public final static int COLOR_MAGENTA     									= 0xF81F;  // 255,   0, 255
 	public final static int COLOR_YELLOW      									= 0xFFE0;  // 255, 255,   0
 	public final static int COLOR_WHITE       									= 0xFFFF;  // 255, 255, 255
 	public final static int COLOR_ORANGE										= 0xFD20;  // 255, 165,   0
 	public final static int COLOR_GREENYELLOW									= 0xAFE5;  // 173, 255,  41
 	public final static int COLOR_PINK											= 0xFC18;  // 255, 130, 198

 	public final static int COLOR_BLUE_WINDOWS									= 0x0B98;  //   8, 113, 196

 	public final static int COLOR_PINK_PAULINE									= 0xFD38;  // 255, 165, 198

    public ILI9341()
    {

    	this.resolution = HEIGHT_04;
    }
    
    private void configuration() throws IOException, InterruptedException
    {

     	dc = GpioFactory.getInstance().provisionDigitalOutputPin( RaspiPin.GPIO_03 );

    	rst = GpioFactory.getInstance().provisionDigitalOutputPin( RaspiPin.GPIO_04 );
    	rst.setState( PinState.HIGH );

    	spiDeviceCS0 = SpiFactory.getInstance( SpiChannel.CS0, SpiDevice.DEFAULT_SPI_SPEED , SpiMode.MODE_0 );

    }
    
    private short[] sendCommand(short[] command) throws IOException
    {

    	dc.setState( PinState.LOW );

    	return spiDeviceCS0.write( command );

    }
    
    private short[] sendData(short[] data) throws IOException
    {

    	dc.setState( PinState.HIGH );

    	return spiDeviceCS0.write( data );

    }

    private void sendReset() throws IOException, InterruptedException
    {

        rst.setState( PinState.HIGH );
        Thread.sleep( 5 );
        rst.setState( PinState.LOW );
        Thread.sleep( 5 );
        rst.setState( PinState.HIGH );
        Thread.sleep( 20 );

    }
    
    public void sleepIn() throws IOException, InterruptedException
    {

    	sendCommand( CMD_DISPLAY_OFF );

    	Thread.sleep( 20 );

    	sendCommand( CMD_ENTER_SLEEP_MODE );

    }

    public void sleepOut() throws IOException, InterruptedException
    {

    	sendCommand( CMD_SLEEP_OUT );

    	Thread.sleep( 120 );

    	sendCommand( CMD_DISPLAY_ON );

    }
  
    public void powerOnSequence() throws IOException, InterruptedException
    {

    	configuration();
    	
    	sendReset();
    	
        sendCommand(CMD_GAMMA_SET);
        sendData(new short[] { 0x01 });

        sendCommand(CMD_MEMORY_ACCESS_CONTROL);
        sendData(new short[] { 0x48 });

        sendCommand(CMD_PIXEL_FORMAT_SET);
        sendData(new short[] { 0x55 });

        sendCommand(CMD_FRAME_CONTROL_NORMAL_MODE);
        sendData(new short[] { 0x00, 0x18 });

        sendCommand(CMD_DISPLAY_FUNCTION_CONTROL);
        sendData(new short[] { 0x08, 0x82, 0x27 });

        sendCommand(CMD_POWER_CONTROL_1);
        sendData(new short[] { 0x23 });

        sendCommand(CMD_POWER_CONTROL_2);
        sendData(new short[] { 0x10 });

        sendCommand(CMD_VCOM_CONTROL_1);
        sendData(new short[] { 0x3E, 0x28 });

        sendCommand(CMD_VCOM_CONTROL_2);
        sendData(new short[] { 0x86 });

        sendCommand(CMD_POWER_CONTROL_A);
        sendData(new short[] { 0x39, 0x2C, 0x00, 0x34, 0x02 });

        sendCommand(CMD_POWER_CONTROL_B);
        sendData(new short[] { 0x00, 0xC1, 0x30 });

        sendCommand(CMD_POSITIVE_GAMMA_CORRECTION);
        sendData(new short[] { 0x0F, 0x31, 0x2B, 0x0C, 0x0E, 0x08, 0x4E, 0xF1, 0x37, 0x07, 0x10, 0x03, 0x0E, 0x09, 0x00 });

        sendCommand(CMD_NEGATIVE_GAMMA_CORRECTION);
        sendData(new short[] { 0x00, 0x0E, 0x14, 0x03, 0x11, 0x07, 0x31, 0xC1, 0x48, 0x08, 0x0F, 0x0C, 0x31, 0x36, 0x0F });
        
        sendCommand(CMD_DRIVER_TIMING_CONTROL_A);
        sendData(new short[] { 0x85, 0x00, 0x78 });

        sendCommand(CMD_DRIVER_TIMING_CONTROL_B);
        sendData(new short[] { 0x00, 0x00 });

        sendCommand(CMD_POWER_ON_SEQUENCE_CONTROL);
        sendData(new short[] { 0x64, 0x03, 0x12, 0x81 });

        sendCommand(CMD_ENABLE_3G);
        sendData(new short[] { 0x00 });

        sendCommand(CMD_PUMP_RATIO_CONTROL);
        sendData(new short[] { 0x20 });

        sleepOut();

    }

    private void setAddress( int x0, int y0, int x1, int y1) throws IOException
    {

    	sendCommand( CMD_COLUMN_ADDRESS_SET );
    	sendData(new short[] { (short)((x0 >> 8) & 0xFF), (short)(x0 & 0xFF), (short)((x1 >> 8) & 0xFF), (short)(x1 & 0xFF) });

    	sendCommand( CMD_PAGE_ADDRESS_SET );
    	sendData(new short[] { (short)((y0 >> 8) & 0xFF), (short)(y0 & 0xFF), (short)((y1 >> 8) & 0xFF), (short)(y1 & 0xFF) });

        sendCommand( CMD_MEMORY_WRITE );

    }

    
    // Zone Couleur
    
    private int RGB888ToRGB565(short r8, short g8, short b8)
    {

    	short r5 = (short)((r8 * 249 + 1014) >> 11);
    	short g6 = (short)((g8 * 253 + 505) >> 10);
    	short b5 = (short)((b8 * 249 + 1014) >> 11);

        return (r5 << 11 | g6 << 5 | b5);

    }

    
    // Zone Ecran

    public void fillRectangle(int x0, int y0, int width, int height, int color) throws IOException
	{
    	   	
    	int nbrBande = height / resolution; 

    	short[] buffer = new short[width * resolution * 2];

    	short VH = (short)((color >> 8) & 0xFF); 
    	short VL = (short)(color & 0xFF);
    	
        for (int index = 0; index < buffer.length; index = index +2)
        {

            buffer[index] = VH;
            buffer[index + 1] = VL;

        }

        for(int b = 0; b < nbrBande; b++)
        {

        	setAddress(x0, y0 + b * resolution, width, y0 + ( b + 1 ) * resolution);
            sendData(buffer);

        }

	}

    public void colorScreen(int color) throws IOException
    {

        this.fillRectangle(0, 0, LCD_W, LCD_H, color);
    }

    public void clearScreen() throws IOException
    {

        this.colorScreen( COLOR_BLACK );
    }
   
    
    // Zone Image

    public int[] loadImage( ImageIcon imageIcon )
    {

    	int w = imageIcon.getIconWidth();
    	int h = imageIcon.getIconHeight();
    	
    	int[] rgb = new int[ w * h ];
    	
		BufferedImage bufferedImage = new BufferedImage( w, h, BufferedImage.TYPE_INT_RGB);

		Image image = imageIcon.getImage();
		
		Graphics graphics = bufferedImage.getGraphics();
		
		graphics.drawImage(image, 0, 0, null);
		
		for(int j = 0; j < h; j++ )
		{

			for(int i = 0; i < w; i++ )
			{
				
				int color = bufferedImage.getRGB(i,j);
				
				int a8 = ( color >> 24 ) & 0xFF;
				int r8 = ( color >> 16 ) & 0xFF;
				int g8 = ( color >> 8 ) & 0xFF;
				int b8 = color & 0xFF;
				
				int r5 = (r8 * 249 + 1014) >> 11;
				int g6 = (g8 * 253 + 505) >> 10;
				int b5 = (b8 * 249 + 1014) >> 11;

				color = (r5 << 11 | g6 << 5 | b5);

				rgb[ j * w + i ] = color;		

			}

		}

		return rgb;

    }
    
    public void drawPicture(int[] _picture, int x0, int y0, int width, int height) throws IOException
    {

    	int block_size = width * resolution;
     
        short[] buffer = new short[block_size * 2];

        int i = 0;
        int line = 0;

        for(int s : _picture)
        {

            buffer[i * 2] = (short)((s >> 8) & 0xFF);
            buffer[i * 2 + 1] = (short)(s & 0xFF);
            i++;

            if (i >= block_size)
            {

                i = 0;
                setAddress( x0, y0 + line * resolution, x0 + width - 1, y0 + (line + 1) * resolution - 1);
                sendData(buffer);
                line++;

            }

        }

    }


    // Zone Texte

    private void makeChar(char c, int x0, int y0, int size, int color) throws IOException
    {

    	int widthCharOriginal = 6;
    	int heightCharOriginal = 8;
    	
    	int widthCharSized = widthCharOriginal * size;
    	int heightCharSized = heightCharOriginal * size;

        // bounds checks
        if ((x0 >= LCD_W) || (y0 >= LCD_H) || ((x0 + widthCharSized - 1) < 0) || ((y0 + heightCharSized - 1) < 0))
        {

            return;
        }
        
        byte[] car = DisplayFontTable.getFontCharacterDescriptorFromFontTableStandart(c).getData();

		String c0 = Integer.toHexString( car[0] ); 
        String c1 = Integer.toHexString( car[1] );
        String c2 = Integer.toHexString( car[2] );
        String c3 = Integer.toHexString( car[3] );
        String c4 = Integer.toHexString( car[4] );

        if( c0.length() < 2 ) { c0 = "0" + c0; }
        if( c1.length() < 2 ) { c1 = "0" + c1; }
        if( c2.length() < 2 ) { c2 = "0" + c2; }
        if( c3.length() < 2 ) { c3 = "0" + c3; }
        if( c4.length() < 2 ) { c4 = "0" + c4; }
        
        String c01 = c0.substring( 0, 1);
        String c00 = c0.substring( 1, 2);

        String c11 = c1.substring( 0, 1);
        String c10 = c1.substring( 1, 2);

        String c21 = c2.substring( 0, 1);
        String c20 = c2.substring( 1, 2);

        String c31 = c3.substring( 0, 1);
        String c30 = c3.substring( 1, 2);

        String c41 = c4.substring( 0, 1);
        String c40 = c4.substring( 1, 2);
        
        boolean[] b01 = Convertissor.convertHexToBin(c01);
        boolean[] b00 = Convertissor.convertHexToBin(c00);

        boolean[] b11 = Convertissor.convertHexToBin(c11);
        boolean[] b10 = Convertissor.convertHexToBin(c10);

        boolean[] b21 = Convertissor.convertHexToBin(c21);
        boolean[] b20 = Convertissor.convertHexToBin(c20);

        boolean[] b31 = Convertissor.convertHexToBin(c31);
        boolean[] b30 = Convertissor.convertHexToBin(c30);

        boolean[] b41 = Convertissor.convertHexToBin(c41);
        boolean[] b40 = Convertissor.convertHexToBin(c40);

        int[] _charOriginal = new int[ widthCharOriginal * heightCharOriginal ];

        if (b00[0]) { _charOriginal[0] = color; } else { _charOriginal[0] = 0x0000; }
        if (b10[0]) { _charOriginal[1] = color; } else { _charOriginal[1] = 0x0000; }
        if (b20[0]) { _charOriginal[2] = color; } else { _charOriginal[2] = 0x0000; }
        if (b30[0]) { _charOriginal[3] = color; } else { _charOriginal[3] = 0x0000; }
        if (b40[0]) { _charOriginal[4] = color; } else { _charOriginal[4] = 0x0000; }
        _charOriginal[5] = 0x0000;

        if (b00[1]) { _charOriginal[6] = color; } else { _charOriginal[6] = 0x0000; }
        if (b10[1]) { _charOriginal[7] = color; } else { _charOriginal[7] = 0x0000; }
        if (b20[1]) { _charOriginal[8] = color; } else { _charOriginal[8] = 0x0000; }
        if (b30[1]) { _charOriginal[9] = color; } else { _charOriginal[9] = 0x0000; }
        if (b40[1]) { _charOriginal[10] = color; } else { _charOriginal[10] = 0x0000; }
        _charOriginal[11] = 0x0000;

        if (b00[2]) { _charOriginal[12] = color; } else { _charOriginal[12] = 0x0000; }
        if (b10[2]) { _charOriginal[13] = color; } else { _charOriginal[13] = 0x0000; }
        if (b20[2]) { _charOriginal[14] = color; } else { _charOriginal[14] = 0x0000; }
        if (b30[2]) { _charOriginal[15] = color; } else { _charOriginal[15] = 0x0000; }
        if (b40[2]) { _charOriginal[16] = color; } else { _charOriginal[16] = 0x0000; }
        _charOriginal[17] = 0x0000;

        if (b00[3]) { _charOriginal[18] = color; } else { _charOriginal[18] = 0x0000; }
        if (b10[3]) { _charOriginal[19] = color; } else { _charOriginal[19] = 0x0000; }
        if (b20[3]) { _charOriginal[20] = color; } else { _charOriginal[20] = 0x0000; }
        if (b30[3]) { _charOriginal[21] = color; } else { _charOriginal[21] = 0x0000; }
        if (b40[3]) { _charOriginal[22] = color; } else { _charOriginal[22] = 0x0000; }
        _charOriginal[23] = 0x0000;

        if (b01[0]) { _charOriginal[24] = color; } else { _charOriginal[24] = 0x0000; }
        if (b11[0]) { _charOriginal[25] = color; } else { _charOriginal[25] = 0x0000; }
        if (b21[0]) { _charOriginal[26] = color; } else { _charOriginal[26] = 0x0000; }
        if (b31[0]) { _charOriginal[27] = color; } else { _charOriginal[27] = 0x0000; }
        if (b41[0]) { _charOriginal[28] = color; } else { _charOriginal[28] = 0x0000; }
        _charOriginal[29] = 0x0000;

        if (b01[1]) { _charOriginal[30] = color; } else { _charOriginal[30] = 0x0000; }
        if (b11[1]) { _charOriginal[31] = color; } else { _charOriginal[31] = 0x0000; }
        if (b21[1]) { _charOriginal[32] = color; } else { _charOriginal[32] = 0x0000; }
        if (b31[1]) { _charOriginal[33] = color; } else { _charOriginal[33] = 0x0000; }
        if (b41[1]) { _charOriginal[34] = color; } else { _charOriginal[34] = 0x0000; }
        _charOriginal[35] = 0x0000;

        if (b01[2]) { _charOriginal[36] = color; } else { _charOriginal[36] = 0x0000; }
        if (b11[2]) { _charOriginal[37] = color; } else { _charOriginal[37] = 0x0000; }
        if (b21[2]) { _charOriginal[38] = color; } else { _charOriginal[38] = 0x0000; }
        if (b31[2]) { _charOriginal[39] = color; } else { _charOriginal[39] = 0x0000; }
        if (b41[2]) { _charOriginal[40] = color; } else { _charOriginal[40] = 0x0000; }
        _charOriginal[41] = 0x0000;

        _charOriginal[42] = 0x0000;
        _charOriginal[43] = 0x0000;
        _charOriginal[44] = 0x0000;
        _charOriginal[45] = 0x0000;
        _charOriginal[46] = 0x0000;
        _charOriginal[47] = 0x0000;

        int[] _charSized = new int[widthCharSized * heightCharSized];

        int cs = 0;

        for (int hco = 0; hco < heightCharOriginal; hco++)
        {

            for (int hts = 0; hts < size; hts++)
            {

                for (int wco = 0; wco < widthCharOriginal; wco++)
                {

                    for (int wts = 0; wts < size; wts++)
                    {

                        _charSized[cs] = _charOriginal[ hco * widthCharOriginal + wco];

                        cs++;

                    }

                }

            }

        }

        drawPicture(_charSized, x0, y0, widthCharSized, heightCharSized);
            	
    }

    private void print(char c, int size, int color) throws IOException
    {

    	if ( c == '\n' )         // Nouvelle ligne
        {

            // Next line based on font size
            this.cursorY += size * 8;
            // Back to  character 0
            this.cursorX = 0;

        }
        else if ( c == '\r' )		// Retour à la ligne
        {

            // Back to  character 0
            this.cursorX = 0;

        }
        else if ( c == '\t' )		// Tabulation (4 caractères)
        {

            // 4 caractères de plus à droite
            this.cursorX += size * 6 * 4;

        }
        else
        {

            this.makeChar(c, this.cursorX, this.cursorY, size, color);

            this.cursorX += size * 6;

            if (this.cursorX > (LCD_W - size * 6))
            {

                // next line based on font size
                this.cursorY += (byte)(size * 8);
                // back to  character 0
                this.cursorX = 0;
            }

        }

    }
    
    public void placeCursor( int x, int y )
    {

    	this.cursorX = x;
        this.cursorY = y;

    }
    
    public void print( String s, int size, int color ) throws IOException
    {

        for (int i = 0; i < s.length(); i++)
        {

        	this.print( s.charAt(i), size, color );
        }

    }

    public void println( String s, int size, int color ) throws IOException
    {

        for (int i = 0; i < s.length(); i++)
        {

        	this.print( s.charAt(i), size, color );
        }

        print("\n", size, color);

    }
    
    // Zone Graphique

    public void LCDPixel(int x0, int y0, int color) throws IOException
    {

        if ((x0 < 0) || (x0 >= LCD_W) || (y0 < 0) || (y0 >= LCD_H))
        {
            return;
        }

        int x1 = x0 + 1;
        int y1 = y0 + 1;

        short VH = (short)(color >> 8);
        short VL = (short)(color & 0xFF);

        short[] buffer = new short[2];

        for (int index = 0; index < buffer.length; index += 2)
        {
            buffer[index] = VH;
            buffer[index + 1] = VL;

        }

        setAddress(x0, y0, x1, y1);
        sendData(buffer);

    }

    public void drawLine(int x1, int y1, int x2, int y2, int color) throws IOException
    {

        if ( x1 >= LCD_W || y1 >= LCD_H || x2 >= LCD_W || y2 >= LCD_H )
        {

            return;
        }

        if (x1 == x2)
        {

            for (int n = y1; n < y2; n++)
            {

                int xn = x1;
                int yn = n;

                LCDPixel(xn, yn, color);

            }

        }
        else if (y1 == y2)
        {

            for (int n = x1; n < x2; n++)
            {

                int xn = n;
                int yn = y1;

                LCDPixel(xn, yn, color);

            }

        }
        else if (x1 == x2 && y1 == y2)
        {

            LCDPixel(x1, y1, color);

        }
        else if( x2 > x1 )
        {

            double dx = x2 - x1;
            double dy = y2 - y1;

            double a = dy / dx;

            for (int n = 0; n < (x2 - x1); n++)
            {

                int xn = n + x1;

                int yn = (int)(a * n + y1);

                LCDPixel(xn, yn, color);

            }

        }
        else if (x2 < x1)
        {

            int X1 = x2;
            int Y1 = y2;

            int X2 = x1;
            int Y2 = y1;
            
            double dX = X2 - X1;
            double dY = Y2 - Y1;

            double a = dY / dX;

            for (int n = 0; n < (X2 - X1); n++)
            {

                int xn = (int)(n + X1);

                int yn = (int)(a * n + Y1);

                LCDPixel(xn, yn, color);

            }

        }

    }
    
    public void drawArc(int x0, int y0, int Radius, int startAngle, int endAngle, int color) throws IOException
    {

        double increment = 0.1;

        double startA = startAngle;

        double endA = endAngle;

        if (startA > 360)
        {
            startA = 360;
        }

        if (endA > 360)
        {

            endA = 360;
        }

        for (double i = startA; i < endA; i += increment)
        {

            double angle = i * Math.PI / 180;

            int x = (int) (x0 + Radius * Math.sin(angle));
            int y = (int) (y0 - Radius * Math.cos(angle));

            LCDPixel(x, y, color);

        }

    }
    
    public void drawCircle(int x0, int y0, int radius, int color) throws IOException
    {

        drawArc(x0, y0, radius, 0, 360, color);
    }
    
    public void drawRectangle(int x0, int y0, int width, int height, int color) throws IOException
    {

        // bounds check
        if (x0 >= LCD_W || y0 >= LCD_H || (x0 + width - 1) >= LCD_W || (y0 + height - 1) >= LCD_H)
        {

            return;
        }

        int xa = x0;
        int ya = y0;

        int xb = x0 + width - 1;
        int yb = y0;

        int xc = x0 + width - 1;
        int yc = y0 + height - 1;

        int xd = x0;
        int yd = y0 + height - 1;

        drawLine(xa, ya, xb, yb, color);
        drawLine(xd, yd, xc, yc, color);
        drawLine(xa, ya, xd, yd, color);
        drawLine(xb, yb, xc, yc, color);

    }

}
