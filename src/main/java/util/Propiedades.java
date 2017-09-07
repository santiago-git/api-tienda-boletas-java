package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Propiedades {
	private Properties prop;

	public Propiedades() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream("C:\\apl/test.properties"));
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public String consultar(String llave) {

		if (prop != null) {
			String valor = prop.getProperty(llave);
			return valor;
		}
		return null;
	}
}
