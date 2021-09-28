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
 * 1) Préparation de la carte uSD :
 * 
 * 	Raspberry Pi Imager v1.4
 * 	2020-05-27-raspios-buster-desktop-armhf.img
 * 
 * 
 * 2) Accès à distance :
 * 
 * 	- Créer le fichier wpa-supplicant.conf
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
 *	- Créer le fichier vide SSH
 *
 * 	- Copier les deux fichiers à la racine de la carte uSD
 * 
 * 	- Insérer la carte uSD dans le Raspberry Pi 
 * 
 * 	- Démarrer le Raspberry Pi (pi/raspberry)
 * 
 * 
 * 	3) Configuration :
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
 *
 *	pi@raspberrypi:~$sudo apt-get install xscreensaver
 *	
 *		- Mode : Disable Screen Saver
 *
 *	
 *	4) Installation de java :
 *
 *	pi@raspberrypi:~$sudo apt-get update
 *	pi@raspberrypi:~$sudo apt-get upgrade
 *	pi@raspberrypi:~$mkdir java
 *	pi@raspberrypi:~$sudo apt-get install openjdk-8-jdk
 *
 *
 *	5) Installation de Pi4j :
 *
 *	pi@raspberrypi:~$curl -s get.pi4j.com|sudo bash
 * 	pi@raspberrypi:~$sudo /opt/pi4j/examples/build
 *	
 *
 */


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

			System.out.println( "OS non prévu : " + System.getProperty("os.name") );
		}
		
	}

}
