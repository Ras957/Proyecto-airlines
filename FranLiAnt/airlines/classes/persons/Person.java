package airlines.classes.persons;
import airlines.classes.auxiliaries.Date;
import airlines.interfaces.IPerson;
/**
*    Clase abstracta para que hereden clientes y empleados.
*    @author Antonio Manuel Guerrero Trujillo
*    @version 1.0
*/
abstract public class Person implements IPerson{

	public String name;    // Nombre
	public String lastname; // Apellido
	protected String dni; //DNI
	public String nationality;  // Nacionalidad
	public Date birthdate; // Fecha de nacimiento

//Constructor que le da valores a todos los atributos
  	protected Person(String n,String lm ,String d, String ny, Date bd) throws Exception{
	    this.name=n;
	    this.lastname=lm;
	    setDNI(d);
	    this.nationality=ny;
	    this.birthdate=bd;
	}

  	public String getDNI(){
   		return this.dni;
  	}

	/** 
	* Setter para el DNI
	* @param dni dni a vereficar para crear la persona.
	*/
	public void setDNI(String dni) throws Exception{
		if(validateDNI(dni)){
	        this.dni=dni.toUpperCase();
	    }else{
	      throw new Exception("DNI no valido.");
	    }
	}

  	/** 
  	* Metodo que calcula la letra de un DNI.
  	* @param dni dni sin letra.
  	* @return devuelve la letra del DNI.
  	*/
  	public static String calculateLetter(String dni){
		int miDNI = Integer.parseInt(dni.substring(0,8));
        int resto = 0;
        String miLetra = "";
        String[] asignacionLetra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V",
				 "H", "L", "C", "K", "E"};
        resto = miDNI%23;
        miLetra = asignacionLetra[resto];
        return miLetra;
	}

	/** 
	* Metodo que valida un DNI.
	* @param dni dni a validar.
	* @return devuelve true si es valido.
	*/
	public static boolean validateDNI(String dni){
		boolean valido=false;
		if(dni.length()==9){
			if(Character.isDigit(dni.charAt(0))&&Character.isDigit(dni.charAt(1))&&
		      Character.isDigit(dni.charAt(2))&&Character.isDigit(dni.charAt(3))&&
		      Character.isDigit(dni.charAt(4))&&Character.isDigit(dni.charAt(5))&&
		      Character.isDigit(dni.charAt(6))&&Character.isDigit(dni.charAt(7))&&
		      Character.isLetter(dni.charAt(8))){
		        String miletra=""+dni.charAt(8);
		        if(miletra.toUpperCase().equals(Person.calculateLetter(dni.substring(0,8)))){
		          valido=true;
	        	}
	   	 	}
		}
		return valido;
	}

	@Override
	public String toString(){
  		return this.name+" "+this.lastname+" "+this.dni+" "+
    		this.nationality+" "+this.birthdate;
	}
}