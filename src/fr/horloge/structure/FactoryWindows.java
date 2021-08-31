package fr.horloge.structure;

import fr.horloge.structure.system.DiskFileMp3Explorer;

public class FactoryWindows
{
	
	private static final FactoryWindows instance = new FactoryWindows();
	
	private DiskFileMp3Explorer diskFileMp3Explorer;
	
	private FactoryWindows()
	{
		
		super();
		
		diskFileMp3Explorer = new DiskFileMp3Explorer( "C:\\Users\\emman\\Music" );
	}

	public static final FactoryWindows getInstance()
	{
		
		return instance;
	}

	public DiskFileMp3Explorer createGestionDiskFileMp3Explorer()
	{

		return this.diskFileMp3Explorer;
	}
	
}
