package fr.horloge.structure.system;

import java.io.File;
import java.util.Arrays;
 
public class DiskFileMp3Explorer
{
 
    private String path = "";
 
    public DiskFileMp3Explorer(String path_)
    {
    	
        super();
        this.path = path_;
    }
 
    public File[] listMp3()
    {
    	
    	return this.listMp3Directory( this.path );
    }
    
    private File[] listMp3Directory( String dir )
    {
    	
    	int taille = 0;
    	
        File file = new File( dir );
        File f;
        
        File[] files = file.listFiles();
        
        for( int i = 0; i < files.length; i++ )
        {
        	
        	f = files[i];
        	
        	if( f.isFile() && f.getName().matches( (".*\\.mp3") )  )
        	{

        		taille++;
        	}

        }
        
        File[] filesMp3 = new File[taille];
        
        for( int i = 0; i < files.length; i++ )
        {
        	
        	f = files[i];
        	
        	if( f.isFile() && f.getName().matches( (".*\\.mp3") )  )
        	{

        		filesMp3[i] = f;
        	}

        }
        
        Arrays.sort( filesMp3 );
        
        return filesMp3;
        
    }
    
}
