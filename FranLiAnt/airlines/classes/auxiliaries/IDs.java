package airlines.classes.auxiliaries;
import airlines.classes.objects.*;
/**
*   Clase auxiliar creada para crear los identificadores de los objetos
*	Aircompany, Airplane y Flight.
*   @author Francisco Miguel Carrasquilla Rodríguez-Córdoba
*   @version 1.0
*/
public class IDs{
	
	private static final int N_NUMBERS=4;
	private static final int N_LETTERS_2=2;
	private static final int N_LETTERS_3=3;

	public String id;
/** Constructor para el ID de Aircompany */
	public IDs(Object obj){
		this.setID1(obj);
	}
/** Constructor para el ID de Airplane */
	public IDs(AirCompany company, Airplane plane, int number){
		this.setID2(company,plane,number);
	}
/** Constructor para el ID de Flight */
	public IDs(AirCompany company, Date hour, Airport airport){
		this.setID3(company,hour,airport);
	}
	public IDs(Flight flight, int row, char letter,Date date){
		this.setID4(flight,row,letter,date);
	}
	public IDs(int n){
		this.setID5(n);
	}
/**
*   Metodo para regular el primer constructor, dependiendo del objeto
*	coje un atributo u otro para crear el id.
*   @param obj objeto que era de tipo AirCompany o Airport.
*/
	public void setID1(Object obj){
		String aux="";
		if (obj instanceof AirCompany) {
			AirCompany tmp = (AirCompany)obj;
			aux = tmp.name;
		}else if (obj instanceof Airport) {
			Airport tmp = (Airport)obj;
			aux = tmp.city;
		}
		if (aux.length()>=N_LETTERS_3 &&
			Character.isLetter(aux.charAt(0)) &&
			Character.isLetter(aux.charAt(1)) &&
			Character.isLetter(aux.charAt(2))) {
            	String code = aux.substring(0, N_LETTERS_3);
            	code = code.toUpperCase();
            	this.id = code;
        }
	}
/**
*   Metodo para regular el segundo constructor.
*   @param company objeto AirCompany. 
*   @param plane objeto Airplane.
*   @param number numero de aviones creados.
*/
	public void setID2(AirCompany company, Airplane plane, int number){
		StringBuilder sb=new StringBuilder();
		this.setID1(company);
		String code = this.id;
		code = code.substring(0, N_LETTERS_2);
		sb.append(code);
		if (plane instanceof AirBusA320) {
            sb.append('A');
        }else if (plane instanceof Boing787){
            sb.append('B');
        }
		setID5(number);
		sb.append(this.id);
		this.id = sb.toString();
	}
/**
*   Metodo para regular el tercer constructor.
*   @param company objeto AirCompany. 
*   @param hour objeto Date solo con la hora.
*   @param airport objeto Airport.
*/

	public void setID3(AirCompany company, Date hour, Airport airport){
		StringBuilder sb=new StringBuilder();
		this.setID1(company);
		sb.append(this.id);
		if (hour.getHour() < 10) {
                sb.append("0");
            }
		sb.append(hour.getHour());
		if (hour.getMinute() < 10) {
                sb.append("0");
            }
		sb.append(hour.getMinute());
		this.setID1(airport);
		sb.append(this.id);
		this.id = sb.toString();
	}

/**
*   Metodo para regular el cuarto constructor.
*   @param flight objeto Flight. 
*   @param site objeto Site.
*   @param date objeto Date sin hora.
*/
	public void setID4(Flight flight, int row, char letter, Date date){
		StringBuilder sb=new StringBuilder();
		sb.append(flight.id);
		if (row < 10) {
                sb.append("0");
            }
		sb.append(row);
		sb.append(letter);
		if (date.getDay() < 10) {
            sb.append("0");
        }
        sb.append(date.getDay());
        if (date.getMonth() < 10) {
            sb.append("0");
        }
        sb.append(date.getMonth());
       	sb.append(date.getYear());
		this.id = sb.toString();
	}

/**
*   Metodo para regular el quinto constructor.
*   @param n entero al que se le añade ceros.
*/
	public void setID5(int n){
		StringBuilder sb=new StringBuilder();
		String myNumber=Integer.toString(n);
		for(int i=myNumber.length();i<N_NUMBERS;i++){
			sb.append("0");
		}
		sb.append(myNumber);
		this.id = sb.toString();
	}


	public String getID(){
		return this.id;
	}

	@Override
	public String toString(){
		return this.id;
	}


}