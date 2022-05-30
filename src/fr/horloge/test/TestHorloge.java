package fr.horloge.test;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import fr.horloge.structure.AbstractApplication;
import fr.horloge.structure.ApplicationRaspberry;
import fr.horloge.structure.ApplicationWindows;

/**
 * 
 * @author Emmanuel-NIATI
 * @version 1.00
 * 
 * Projet Java Horloge
 * 
 * 1) Pr�paration de la carte uSD :
 * 
 * 	Raspberry Pi Imager v1.4 :
 * 	2021-05-07-raspios-buster-armhf.img
 * 
 * 
 * 2) Acc�s � distance :
 * 
 * 	- Cr�er le fichier wpa-supplicant.conf
 * 
 * 	country=FR
 * 	update-config=1
 * 	ctrl-interface=DIR=/var/run/wpa-supplicant GROUP=netdev
 *	network = {
 *	ssid="****"
 *	psk="****"
 *	key_mgmt=WPA-PSK
 * 	}
 *
 *	- Cr�er le fichier vide SSH
 *
 * 	- Copier les deux fichiers � la racine de la carte uSD
 * 
 * 	- Ins�rer la carte uSD dans le Raspberry Pi 
 * 
 * 	- D�marrer le Raspberry Pi
 * 
 * 
 * 	3) Configuration (PuTTY pi/raspberry) :
 * 
 * 	pi@raspberrypi:~$sudo raspi-config
 * 
 * 		- Change User Password : ****
 * 		- Hostname : ****
 * 		- Boot Option : B4 Desktop Autologin
 * 		- Localisation Options : Europe >> Paris
 * 		- Interfacing Options : 
 * 			- SSH : Enabled
 * 			- VNC : Enabled
 * 			- SPI : Enabled
 * 			- I2C : Enabled
 *
 *	pi@raspberrypi:~$sudo apt-get install xscreensaver
 *	
 *		- Mode : Disable Screen Saver
 *
 * 	pi@raspberrypi:~$sudo apt-get update
 *	pi@raspberrypi:~$sudo apt-get upgrade
 *
 *	
 *	4) Installation de java :
 *
 *	pi@raspberrypi:~$sudo apt-get install openjdk-11-jdk
 *	pi@raspberrypi:~$mkdir java
 *
 *
 *	5) Installation de Pi4j :
 *
 *	pi@raspberrypi:~$curl -sSL https://pi4j.com/install | sudo bash
 * 	pi@raspberrypi:~$sudo /opt/pi4j/examples/build
 *	
 *
 */

// main
public class TestHorloge
{

	public static void main(String[] args)
	{

		AbstractApplication application;

		if( "arm".equals( System.getProperty("os.arch") ) )
		{
			
			try
			{

				UIManager.setLookAndFeel( AbstractApplication.LOOK_AND_FEEL_METAL );
				application = ApplicationRaspberry.getInstance();
			}
			catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e)
			{

				System.out.println(">>> " + e.getClass() + e.getMessage() );
			}
			
		}
		else if( "amd64".equals( System.getProperty("os.arch") ) )
		{

			try
			{

				UIManager.setLookAndFeel( AbstractApplication.LOOK_AND_FEEL_WINDOWS );
				application = ApplicationWindows.getInstance();
			}
			catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e)
			{

				System.out.println(">>> " + e.getClass() + e.getMessage() );
			}
			
		}
		else
		{

			System.out.println( "OS non pr�vu : " + System.getProperty("os.name") );
		}
		
	}

}
