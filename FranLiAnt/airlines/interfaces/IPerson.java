package airlines.interfaces;

/**
*	Interfaz para la clase persona.
*	@author Francisco Miguel Carrasquilla Rodríguez-Córdoba
*	@version 1.0
*/
public interface IPerson{

	static String calculateLetter(String dni){
		return "";
	}
	static boolean validateDNI(String dni){
		return true;
	}
	String getDNI();
	void setDNI(String dni) throws Exception;
}