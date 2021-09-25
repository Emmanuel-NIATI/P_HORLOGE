package fr.horloge.structure.driver;

public class FontCharacterDescriptor
{
	
	  private char character;
	  private byte[] data;
	  private String description;
	  
      public char getCharacter()
      {

    	  return this.character;
      }
      
      public void setCharacter(char _character)
      {

    	  this.character = _character;
      }
      
      public byte[] getData()
      {

    	  return this.data;
      }
      
      public void setData(byte[] _data)
      {

    	  this.data = _data;
      }
      
      public String getDescription()
      {
    	  
    	  return this.description;
      }

      public void setDescription(String _description)
      {
    	  
    	  this.description = _description;
      }

      public FontCharacterDescriptor( char _character, byte[] _data, String _description)
      {

    	  this.character = _character;
    	  this.data = _data;
    	  this.description = _description;

      }

}
