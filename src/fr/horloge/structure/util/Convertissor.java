package fr.horloge.structure.util;

public class Convertissor
{

    public static boolean[] convertHexToBin(String _hex)
    {

    	boolean[] res = new boolean[4];

        if ("0".equals(_hex)) { res[0] = false; res[1] = false; res[2] = false; res[3] = false; }

        if ("1".equals(_hex)) { res[0] = true; res[1] = false; res[2] = false; res[3] = false; }

        if ("2".equals(_hex)) { res[0] = false; res[1] = true; res[2] = false; res[3] = false; }

        if ("3".equals(_hex)) { res[0] = true; res[1] = true; res[2] = false; res[3] = false; }

        if ("4".equals(_hex)) { res[0] = false; res[1] = false; res[2] = true; res[3] = false; }

        if ("5".equals(_hex)) { res[0] = true; res[1] = false; res[2] = true; res[3] = false; }

        if ("6".equals(_hex)) { res[0] = false; res[1] = true; res[2] = true; res[3] = false; }

        if ("7".equals(_hex)) { res[0] = true; res[1] = true; res[2] = true; res[3] = false; }

        if ("8".equals(_hex)) { res[0] = false; res[1] = false; res[2] = false; res[3] = true; }

        if ("9".equals(_hex)) { res[0] = true; res[1] = false; res[2] = false; res[3] = true; }

        if ("A".equals(_hex) || "a".equals(_hex)) { res[0] = false; res[1] = true; res[2] = false; res[3] = true; }

        if ("B".equals(_hex) || "b".equals(_hex)) { res[0] = true; res[1] = true; res[2] = false; res[3] = true; }

        if ("C".equals(_hex) || "c".equals(_hex)) { res[0] = false; res[1] = false; res[2] = true; res[3] = true; }

        if ("D".equals(_hex) || "d".equals(_hex)) { res[0] = true; res[1] = false; res[2] = true; res[3] = true; }

        if ("E".equals(_hex) || "E".equals(_hex)) { res[0] = false; res[1] = true; res[2] = true; res[3] = true; }

        if ("F".equals(_hex) || "f".equals(_hex)) { res[0] = true; res[1] = true; res[2] = true; res[3] = true; }

        return res;

    }

    public static String convertBinToHex(boolean _b3, boolean _b2, boolean _b1, boolean _b0)
    {

        String res = "0";

        if (!_b3 && !_b2 && !_b1 && !_b0) { res = "0"; }
        if (!_b3 && !_b2 && !_b1 && _b0) { res = "1"; }
        if (!_b3 && !_b2 && _b1 && !_b0) { res = "2"; }
        if (!_b3 && !_b2 && _b1 && _b0) { res = "3"; }
        if (!_b3 && _b2 && !_b1 && !_b0) { res = "4"; }
        if (!_b3 && _b2 && !_b1 && _b0) { res = "5"; }
        if (!_b3 && _b2 && _b1 && !_b0) { res = "6"; }
        if (!_b3 && _b2 && _b1 && _b0) { res = "7"; }
        if (_b3 && !_b2 && !_b1 && !_b0) { res = "8"; }
        if (_b3 && !_b2 && !_b1 && _b0) { res = "9"; }
        if (_b3 && !_b2 && _b1 && !_b0) { res = "A"; }
        if (_b3 && !_b2 && _b1 && _b0) { res = "B"; }
        if (_b3 && _b2 && !_b1 && !_b0) { res = "C"; }
        if (_b3 && _b2 && !_b1 && _b0) { res = "D"; }
        if (_b3 && _b2 && _b1 && !_b0) { res = "E"; }
        if (_b3 && _b2 && _b1 && _b0) { res = "F"; }

        return res;

    }
	
}
