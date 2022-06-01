package fr.horloge.structure.driver;

public class DisplayFontTable
{

        public static FontCharacterDescriptor getFontCharacterDescriptorFromFontTableStandart(char _car)
        {

        	FontCharacterDescriptor fcd = new FontCharacterDescriptor(' ', new byte[]{ 0x00, 0x00, 0x00, 0x00, 0x00}, "Caractère  ");

        	for(FontCharacterDescriptor fontCharacterDescriptor : fontTableStandart )
        	{

        		if( Character.compare( fontCharacterDescriptor.getCharacter(), _car ) == 0 )
        		{

        			fcd = fontCharacterDescriptor;

        		}

        	}

        	return fcd;

        }

        public static int getFontTableStandartLength()
        {

            return fontTableStandart.length;

        }

        public static FontCharacterDescriptor getFontCharacterDescriptorFromFontTableStandart(int _Order)
        {

            return fontTableStandart[_Order];

        }

        public static FontCharacterDescriptor[] fontTableStandart =
        {

            new FontCharacterDescriptor(' ', new byte[]{ 0x00, 0x00, 0x00, 0x00, 0x00}, "Caractère  "),
            new FontCharacterDescriptor('!', new byte[]{ 0x00, 0x00, 0x5F, 0x00, 0x00}, "Caractère !"),
            new FontCharacterDescriptor('"', new byte[]{ 0x04, 0x03, 0x04, 0x03, 0x00}, "Caractère \""),
            new FontCharacterDescriptor('#', new byte[]{ 0x14, 0x7F, 0x14, 0x7F, 0x14}, "Caractère #"),
            new FontCharacterDescriptor('$', new byte[]{ 0x24, 0x2A, 0x7F, 0x2A, 0x12}, "Caractère $"),
            new FontCharacterDescriptor('%', new byte[]{ 0x23, 0x13, 0x08, 0x64, 0x62}, "Caractère %"),
            new FontCharacterDescriptor('&', new byte[]{ 0x36, 0x49, 0x56, 0x20, 0x50}, "Caractère &"),
            new FontCharacterDescriptor('\'', new byte[]{ 0x00, 0x00, 0x04, 0x03, 0x00}, "Caractère \'"),

            new FontCharacterDescriptor('(', new byte[]{ 0x00, 0x1C, 0x22, 0x41, 0x00}, "Caractère ("),
            new FontCharacterDescriptor(')', new byte[]{ 0x00, 0x41, 0x22, 0x1C, 0x00}, "Caractère )"),
            new FontCharacterDescriptor('*', new byte[]{ 0x2A, 0x1C, 0x3E, 0x1C, 0x2A}, "Caractère *"),
            new FontCharacterDescriptor('+', new byte[]{ 0x08, 0x08, 0x3E, 0x08, 0x08}, "Caractère +"),
            new FontCharacterDescriptor(',', new byte[]{ 0x00, 0x00, 0x40, 0x30, 0x00}, "Caractère ,"),
            new FontCharacterDescriptor('-', new byte[]{ 0x08, 0x08, 0x08, 0x08, 0x08}, "Caractère -"),
            new FontCharacterDescriptor('.', new byte[]{ 0x00, 0x00, 0x60, 0x60, 0x00}, "Caractère ."),
            new FontCharacterDescriptor('/', new byte[]{ 0x20, 0x10, 0x08, 0x04, 0x02}, "Caractère /"),

            new FontCharacterDescriptor('0', new byte[]{ 0x3E, 0x51, 0x49, 0x45, 0x3E}, "Chiffre 0"),
            new FontCharacterDescriptor('1', new byte[]{ 0x00, 0x42, 0x7F, 0x40, 0x00}, "Chiffre 1"),
            new FontCharacterDescriptor('2', new byte[]{ 0x42, 0x61, 0x51, 0x49, 0x46}, "Chiffre 2"),
            new FontCharacterDescriptor('3', new byte[]{ 0x21, 0x41, 0x45, 0x4B, 0x31}, "Chiffre 3"),
            new FontCharacterDescriptor('4', new byte[]{ 0x18, 0x14, 0x12, 0x7F, 0x10}, "Chiffre 4"),
            new FontCharacterDescriptor('5', new byte[]{ 0x27, 0x45, 0x45, 0x45, 0x39}, "Chiffre 5"),
            new FontCharacterDescriptor('6', new byte[]{ 0x3C, 0x4A, 0x49, 0x49, 0x30}, "Chiffre 6"),
            new FontCharacterDescriptor('7', new byte[]{ 0x01, 0x71, 0x09, 0x05, 0x03}, "Chiffre 7"),

            new FontCharacterDescriptor('8', new byte[]{ 0x36, 0x49, 0x49, 0x49, 0x36}, "Chiffre 8"),
            new FontCharacterDescriptor('9', new byte[]{ 0x06, 0x49, 0x49, 0x29, 0x1E}, "Chiffre 9"),
            new FontCharacterDescriptor(':', new byte[]{ 0x00, 0x00, 0x14, 0x00, 0x00}, "Caractère :"),
            new FontCharacterDescriptor(';', new byte[]{ 0x00, 0x00, 0x40, 0x34, 0x00}, "Caractère ;"),
            new FontCharacterDescriptor('<', new byte[]{ 0x00, 0x08, 0x14, 0x22, 0x41}, "Caractère <"),
            new FontCharacterDescriptor('=', new byte[]{ 0x14, 0x14, 0x14, 0x14, 0x14}, "Caractère ="),
            new FontCharacterDescriptor('>', new byte[]{ 0x41, 0x22, 0x14, 0x08, 0x00}, "Caractère >"),
            new FontCharacterDescriptor('?', new byte[]{ 0x02, 0x01, 0x59, 0x09, 0x06}, "Caractère ?"),

            new FontCharacterDescriptor('@', new byte[]{ 0x32, 0x49, 0x79, 0x41, 0x3E}, "Caractère @"),
            new FontCharacterDescriptor('A', new byte[]{ 0x7E, 0x11, 0x11, 0x11, 0x7E}, "Lettre A majuscule"),
            new FontCharacterDescriptor('B', new byte[]{ 0x7F, 0x49, 0x49, 0x49, 0x36}, "Lettre B majuscule"),
            new FontCharacterDescriptor('C', new byte[]{ 0x3E, 0x41, 0x41, 0x41, 0x22}, "Lettre C majuscule"),
            new FontCharacterDescriptor('D', new byte[]{ 0x7F, 0x41, 0x41, 0x22, 0x1C}, "Lettre D majuscule"),
            new FontCharacterDescriptor('E', new byte[]{ 0x7F, 0x49, 0x49, 0x49, 0x41}, "Lettre E majuscule"),
            new FontCharacterDescriptor('F', new byte[]{ 0x7F, 0x09, 0x09, 0x09, 0x01}, "Lettre F majuscule"),
            new FontCharacterDescriptor('G', new byte[]{ 0x3E, 0x41, 0x49, 0x49, 0x7A}, "Lettre G majuscule"),

            new FontCharacterDescriptor('H', new byte[]{ 0x7F, 0x08, 0x08, 0x08, 0x7F}, "Lettre H majuscule"),
            new FontCharacterDescriptor('I', new byte[]{ 0x00, 0x41, 0x7F, 0x41, 0x00}, "Lettre I majuscule"),
            new FontCharacterDescriptor('J', new byte[]{ 0x20, 0x40, 0x41, 0x3F, 0x01}, "Lettre J majuscule"),
            new FontCharacterDescriptor('K', new byte[]{ 0x7F, 0x08, 0x14, 0x22, 0x41}, "Lettre K majuscule"),
            new FontCharacterDescriptor('L', new byte[]{ 0x7F, 0x40, 0x40, 0x40, 0x40}, "Lettre L majuscule"),
            new FontCharacterDescriptor('M', new byte[]{ 0x7F, 0x02, 0x0C, 0x02, 0x7F}, "Lettre M majuscule"),
            new FontCharacterDescriptor('N', new byte[]{ 0x7F, 0x04, 0x08, 0x10, 0x7F}, "Lettre N majuscule"),
            new FontCharacterDescriptor('O', new byte[]{ 0x3E, 0x41, 0x41, 0x41, 0x3E}, "Lettre O majuscule"),

            new FontCharacterDescriptor('P', new byte[]{ 0x7F, 0x09, 0x09, 0x09, 0x06}, "Lettre P majuscule"),
            new FontCharacterDescriptor('Q', new byte[]{ 0x3E, 0x41, 0x51, 0x21, 0x5E}, "Lettre Q majuscule"),
            new FontCharacterDescriptor('R', new byte[]{ 0x7F, 0x09, 0x19, 0x29, 0x46}, "Lettre R majuscule"),
            new FontCharacterDescriptor('S', new byte[]{ 0x26, 0x49, 0x49, 0x49, 0x32}, "Lettre S majuscule"),
            new FontCharacterDescriptor('T', new byte[]{ 0x01, 0x01, 0x7F, 0x01, 0x01}, "Lettre T majuscule"),
            new FontCharacterDescriptor('U', new byte[]{ 0x3F, 0x40, 0x40, 0x40, 0x3F}, "Lettre U majuscule"),
            new FontCharacterDescriptor('V', new byte[]{ 0x1F, 0x20, 0x40, 0x20, 0x1F}, "Lettre V majuscule"),
            new FontCharacterDescriptor('W', new byte[]{ 0x3F, 0x40, 0x38, 0x40, 0x3F}, "Lettre W majuscule"),

            new FontCharacterDescriptor('X', new byte[]{ 0x63, 0x14, 0x08, 0x14, 0x63}, "Lettre X majuscule"),
            new FontCharacterDescriptor('Y', new byte[]{ 0x07, 0x08, 0x70, 0x08, 0x07}, "Lettre Y majuscule"),
            new FontCharacterDescriptor('Z', new byte[]{ 0x61, 0x51, 0x49, 0x45, 0x43}, "Lettre Z majuscule"),
            new FontCharacterDescriptor('[', new byte[]{ 0x00, 0x7F, 0x41, 0x41, 0x00}, "Caractère ["),
            new FontCharacterDescriptor('\\', new byte[]{ 0x02, 0x04, 0x08, 0x10, 0x20}, "Caractère \\"),
            new FontCharacterDescriptor(']', new byte[]{ 0x00, 0x41, 0x41, 0x7F, 0x41}, "Caractère ]"),
            new FontCharacterDescriptor('^', new byte[]{ 0x00, 0x02, 0x01, 0x02, 0x00}, "Caractère ^"),
            new FontCharacterDescriptor('_', new byte[]{ 0x40, 0x40, 0x40, 0x40, 0x40}, "Caractère _"),

            new FontCharacterDescriptor('`', new byte[]{ 0x00, 0x00, 0x03, 0x04, 0x00}, "Caractère `"),
            new FontCharacterDescriptor('a', new byte[]{ 0x20, 0x54, 0x54, 0x54, 0x78}, "Lettre a minuscule"),
            new FontCharacterDescriptor('b', new byte[]{ 0x7F, 0x28, 0x44, 0x44, 0x38}, "Lettre b minuscule"),
            new FontCharacterDescriptor('c', new byte[]{ 0x38, 0x44, 0x44, 0x44, 0x28}, "Lettre c minuscule"),
            new FontCharacterDescriptor('d', new byte[]{ 0x38, 0x44, 0x44, 0x28, 0x7F}, "Lettre d minuscule"),
            new FontCharacterDescriptor('e', new byte[]{ 0x38, 0x54, 0x54, 0x54, 0x18}, "Lettre e minuscule"),
            new FontCharacterDescriptor('f', new byte[]{ 0x00, 0x08, 0x7E, 0x09, 0x02}, "Lettre f minuscule"),
            new FontCharacterDescriptor('g', new byte[]{ 0x0C, 0x52, 0x52, 0x52, 0x3E}, "Lettre g minuscule"),

            new FontCharacterDescriptor('h', new byte[]{ 0x7F, 0x08, 0x04, 0x04, 0x78}, "Lettre h minuscule"),
            new FontCharacterDescriptor('i', new byte[]{ 0x00, 0x44, 0x7D, 0x40, 0x00}, "Lettre i minuscule"),
            new FontCharacterDescriptor('j', new byte[]{ 0x20, 0x40, 0x44, 0x3D, 0x00}, "Lettre j minuscule"),
            new FontCharacterDescriptor('k', new byte[]{ 0x7F, 0x10, 0x28, 0x44, 0x00}, "Lettre k minuscule"),
            new FontCharacterDescriptor('l', new byte[]{ 0x00, 0x41, 0x7F, 0x40, 0x00}, "Lettre l minuscule"),
            new FontCharacterDescriptor('m', new byte[]{ 0x7C, 0x04, 0x18, 0x04, 0x78}, "Lettre m minuscule"),
            new FontCharacterDescriptor('n', new byte[]{ 0x7C, 0x08, 0x04, 0x04, 0x78}, "Lettre n minuscule"),
            new FontCharacterDescriptor('o', new byte[]{ 0x38, 0x44, 0x44, 0x44, 0x38}, "Lettre o minuscule"),

            new FontCharacterDescriptor('p', new byte[]{ 0x7C, 0x08, 0x14, 0x14, 0x08}, "Lettre p minuscule"),
            new FontCharacterDescriptor('q', new byte[]{ 0x08, 0x14, 0x14, 0x08, 0x7C}, "Lettre q minuscule"),
            new FontCharacterDescriptor('r', new byte[]{ 0x7C, 0x08, 0x04, 0x04, 0x08}, "Lettre r minuscule"),
            new FontCharacterDescriptor('s', new byte[]{ 0x48, 0x54, 0x54, 0x54, 0x24}, "Lettre s minuscule"),
            new FontCharacterDescriptor('t', new byte[]{ 0x04, 0x3F, 0x44, 0x40, 0x20}, "Lettre t minuscule"),
            new FontCharacterDescriptor('u', new byte[]{ 0x3C, 0x40, 0x40, 0x20, 0x7C}, "Lettre u minuscule"),
            new FontCharacterDescriptor('v', new byte[]{ 0x1C, 0x20, 0x40, 0x20, 0x1C}, "Lettre v minuscule"),
            new FontCharacterDescriptor('w', new byte[]{ 0x3C, 0x40, 0x30, 0x40, 0x3C}, "Lettre w minuscule"),

            new FontCharacterDescriptor('x', new byte[]{ 0x44, 0x28, 0x10, 0x28, 0x44}, "Lettre x minuscule"),
            new FontCharacterDescriptor('y', new byte[]{ 0x0C, 0x50, 0x50, 0x50, 0x3C}, "Lettre y minuscule"),
            new FontCharacterDescriptor('z', new byte[]{ 0x44, 0x64, 0x54, 0x4C, 0x44}, "Lettre z minuscule"),
            new FontCharacterDescriptor('{', new byte[]{ 0x00, 0x08, 0x36, 0x41, 0x00}, "Caractère {"),
            new FontCharacterDescriptor('|', new byte[]{ 0x00, 0x00, 0x77, 0x00, 0x00}, "Caractère |"),
            new FontCharacterDescriptor('}', new byte[]{ 0x00, 0x41, 0x36, 0x08, 0x00}, "Caractère }"),
            new FontCharacterDescriptor('~', new byte[]{ 0x02, 0x01, 0x02, 0x04, 0x02}, "Caractère ~"),
            new FontCharacterDescriptor('è', new byte[]{ 0x3E, 0x41, 0x41, 0x41, 0x22}, "Lettre è majuscule"),
            
            new FontCharacterDescriptor('è', new byte[]{ 0x3C, 0x41, 0x40, 0x21, 0x7C}, "Lettre è minuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x38, 0x54, 0x56, 0x55, 0x18}, "Lettre è minuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x20, 0x56, 0x55, 0x56, 0x78}, "Lettre è minuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x20, 0x55, 0x54, 0x55, 0x78}, "Lettre è minuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x20, 0x55, 0x56, 0x54, 0x78}, "Lettre è minuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x20, 0x54, 0x55, 0x54, 0x78}, "Lettre è minuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x0E, 0x51, 0x39, 0x11, 0x0A}, "Lettre è minuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x38, 0x56, 0x55, 0x56, 0x18}, "Lettre è minuscule"),
            
            new FontCharacterDescriptor('è', new byte[]{ 0x38, 0x55, 0x54, 0x55, 0x18}, "Lettre è minuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x38, 0x55, 0x56, 0x54, 0x18}, "Lettre è minuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x00, 0x45, 0x7C, 0x41, 0x00}, "Lettre è minuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x00, 0x46, 0x7D, 0x42, 0x00}, "Lettre è minuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x00, 0x45, 0x7E, 0x40, 0x00}, "Lettre è minuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x7E, 0x11, 0x11, 0x11, 0x7E}, "Lettre è majuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x7E, 0x11, 0x11, 0x11, 0x7E}, "Lettre è majuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x7F, 0x49, 0x49, 0x49, 0x41}, "Lettre è majuscule"),

            new FontCharacterDescriptor('è', new byte[]{ 0x20, 0x54, 0x78, 0x54, 0x58}, "Lettre è minuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x7C, 0x12, 0x7F, 0x49, 0x41}, "Lettre è majuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x38, 0x46, 0x45, 0x46, 0x38}, "Lettre è minuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x38, 0x45, 0x44, 0x45, 0x38}, "Lettre è minuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x38, 0x45, 0x46, 0x44, 0x38}, "Lettre è minuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x3C, 0x42, 0x41, 0x22, 0x7C}, "Lettre è minuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x3C, 0x41, 0x42, 0x30, 0x7C}, "Lettre è minuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x0C, 0x51, 0x50, 0x51, 0x3C}, "Lettre è minuscule"),

            new FontCharacterDescriptor('è', new byte[]{ 0x3E, 0x41, 0x41, 0x41, 0x3E}, "Lettre è majuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x3E, 0x40, 0x40, 0x40, 0x3E}, "Lettre è majuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x1C, 0x32, 0x2A, 0x26, 0x1C}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x00, 0x48, 0x7F, 0x49, 0x42}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x3E, 0x51, 0x49, 0x45, 0x3E}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x44, 0x28, 0x10, 0x28, 0x44}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x00, 0x44, 0x7F, 0x05, 0x00}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x20, 0x54, 0x56, 0x55, 0x78}, "Lettre è minuscule"),

            new FontCharacterDescriptor('è', new byte[]{ 0x00, 0x04, 0x7E, 0x01, 0x00}, "Lettre è minuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x38, 0x44, 0x46, 0x45, 0x38}, "Lettre è minuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x3C, 0x40, 0x42, 0x21, 0x7C}, "Lettre è minuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x7A, 0x11, 0x0A, 0x0C, 0x72}, "Lettre è minuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x7F, 0x04, 0x08, 0x10, 0x7F}, "Lettre è majuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x48, 0x55, 0x55, 0x55, 0x5E}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x4E, 0x51, 0x51, 0x51, 0x4E}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x30, 0x48, 0x4D, 0x40, 0x20}, "Caractère è"),

            new FontCharacterDescriptor('è', new byte[]{ 0x41, 0x5D, 0x49, 0x45, 0x41}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x08, 0x08, 0x08, 0x08, 0x18}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x00, 0x44, 0x7D, 0x40, 0x00}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x08, 0x36, 0x00, 0x08, 0x36}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x36, 0x08, 0x00, 0x36, 0x08}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x7E, 0x11, 0x11, 0x11, 0x7E}, "Lettre è majuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x7E, 0x11, 0x11, 0x11, 0x7E}, "Lettre è majuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x7E, 0x11, 0x11, 0x11, 0x7E}, "Lettre è majuscule"),

            new FontCharacterDescriptor('è', new byte[]{ 0x41, 0x5D, 0x55, 0x55, 0x41}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x00, 0x1C, 0x36, 0x14, 0x00}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x01, 0x2A, 0x7C, 0x2A, 0x01}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x22, 0x55, 0x56, 0x54, 0x7A}, "Lettre è minuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x7E, 0x11, 0x11, 0x11, 0x7E}, "Lettre è majuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x22, 0x1C, 0x14, 0x1C, 0x22}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x3C, 0x45, 0x49, 0x49, 0x3E}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x08, 0x7F, 0x49, 0x41, 0x3E}, "Caractère è"),

            new FontCharacterDescriptor('è', new byte[]{ 0x7F, 0x49, 0x49, 0x49, 0x41}, "Lettre è majuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x7F, 0x49, 0x49, 0x49, 0x41}, "Lettre è majuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x7F, 0x49, 0x49, 0x49, 0x41}, "Lettre è majuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x00, 0x41, 0x7F, 0x41, 0x00}, "Lettre è majuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x00, 0x41, 0x7F, 0x41, 0x00}, "Lettre è majuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x00, 0x41, 0x7F, 0x41, 0x00}, "Lettre è majuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x00, 0x00, 0x36, 0x00, 0x00}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x00, 0x41, 0x7F, 0x41, 0x00}, "Caractère è"),

            new FontCharacterDescriptor('è', new byte[]{ 0x3E, 0x41, 0x41, 0x41, 0x3E}, "Lettre è majuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x7E, 0x01, 0x49, 0x56, 0x20}, "Lettre è majuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x3E, 0x41, 0x41, 0x41, 0x3E}, "Lettre è majuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x3E, 0x41, 0x41, 0x41, 0x3E}, "Lettre è majuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x3A, 0x45, 0x46, 0x44, 0x3A}, "Lettre è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x3E, 0x41, 0x41, 0x41, 0x3E}, "Lettre è majuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x7E, 0x08, 0x08, 0x08, 0x0F}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x00, 0x7F, 0x14, 0x1C, 0x00}, "Caractère è"),

            new FontCharacterDescriptor('è', new byte[]{ 0x00, 0x3E, 0x14, 0x1C, 0x00}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x3F, 0x40, 0x40, 0x40, 0x3F}, "Lettre è majuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x3F, 0x40, 0x40, 0x40, 0x3F}, "Lettre è majuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x3F, 0x40, 0x40, 0x40, 0x3F}, "Lettre è majuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x0C, 0x50, 0x52, 0x51, 0x3C}, "Lettre è minuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x07, 0x08, 0x70, 0x08, 0x07}, "Lettre è majuscule"),
            new FontCharacterDescriptor('è', new byte[]{ 0x00, 0x02, 0x02, 0x02, 0x00}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x00, 0x00, 0x02, 0x01, 0x00}, "Caractère è"),

            new FontCharacterDescriptor('è', new byte[]{ 0x00, 0x48, 0x5C, 0x48, 0x00}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x06, 0x09, 0x7F, 0x01, 0x7F}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x00, 0x1F, 0x55, 0x7C, 0x00}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x00, 0x08, 0x2A, 0x08, 0x00}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x00, 0x00, 0x40, 0x20, 0x00}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x00, 0x00, 0x01, 0x00, 0x00}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x00, 0x01, 0x00, 0x01, 0x00}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x00, 0x00, 0x08, 0x00, 0x00}, "Caractère è"),

            new FontCharacterDescriptor('è', new byte[]{ 0x00, 0x12, 0x1F, 0x10, 0x00}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x00, 0x15, 0x15, 0x1F, 0x00}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x00, 0x1D, 0x15, 0x17, 0x00}, "Caractère è"),
            new FontCharacterDescriptor('è', new byte[]{ 0x14, 0x3E, 0x55, 0x55, 0x55}, "Caractère è")

        };

}
