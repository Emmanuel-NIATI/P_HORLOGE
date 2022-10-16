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
 * 	Raspberry Pi Imager v1.4 :
 * 	2021-05-07-raspios-buster-armhf.img
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
 * 	- Démarrer le Raspberry Pi
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
 *	4 bis) Installation alternative de java sur raspberry pi 0 w :
 *
 *	pi@raspberrypi:~$cd /usr/lib/jvm
 *	pi@raspberrypi:~$sudo wget https://cdn.azul.com/zulu-embedded/bin/zulu11.41.75-ca-jdk11.0.8-linux_aarch32hf.tar.gz
 *	pi@raspberrypi:~$sudo tar -xzvf zulu11.41.75-ca-jdk11.0.8-linux_aarch32hf.tar.gz
 *	pi@raspberrypi:~$sudo rm zulu11.41.75-ca-jdk11.0.8-linux_aarch32hf.tar.gz
 *
 *	pi@raspberrypi:~$sudo update-alternatives --install /usr/bin/java java /usr/lib/jvm/zulu11.41.75-ca-jdk11.0.8-linux_aarch32hf/bin/java 1
 *	pi@raspberrypi:~$sudo update-alternatives --install /usr/bin/javac javac /usr/lib/jvm/zulu11.41.75-ca-jdk11.0.8-linux_aarch32hf/bin/javac 1
 *
 *	pi@raspberrypi:~$sudo update-alternatives --config java (Press <enter> to keep the current choice[*], or type selection number: 2)
 *	pi@raspberrypi:~$sudo update-alternatives --config javac (Press <enter> to keep the current choice[*], or type selection number: 2)
 *
 *
 *	5) Installation de Pi4j (V 1.4) :
 *
 *	pi@raspberrypi:~$sudo dpkg -i pi4j-1.4.deb
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

				System.out.println(">>>>>>>>>> " + e.getClass() + e.getMessage() );
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

				System.out.println(">>>>>>>>>> " + e.getClass() + e.getMessage() );
			}
			
		}
		else
		{

			System.out.println( ">>>>>>>>>> OS non prévu : " + System.getProperty("os.name") );
		}
		
	}

}
