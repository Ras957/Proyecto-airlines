package airlines.classes.objects;
import java.util.ArrayList;
import java.util.Iterator;
import airlines.classes.auxiliaries.IDs;
/** 
*	Clase que crea objetos Airport.
*	@author Francisco Miguel Carrasquilla Rodríguez-Córdoba
*	@version 1.0
*/
public class Airport{
	
	public final static String[] AVAILABLE_SERVICES = {"cafeteria", 
		"reting car","restaurant","shop"};
	public final static String[] SERVICES_DEF = {"security", 
		"lost objects"};

	public IDs id;
	public String name;
	public String city;
	public String country;
	public ArrayList<String> services= new ArrayList<String>();

		public Airport(String name, String city, String country){
		this.name=name;
		this.city=city;
		this.country=country;
		this.setServices();
		this.setID();
	}

	/** Setter para el ID */
	public void setID(){
		IDs idAirport=new IDs(this);
		this.id=idAirport;
	}

	/** Añade un servicio al aeropuerto */
	public void addService(String service) throws Exception{
		if (this.validateService(service)&&!this.isRepeated(service)) {
			this.services.add(service);
		}else{
			StringBuilder sb=new StringBuilder();
			sb.append("El servicio "+service+" no esta disponible, ");
			sb.append("los servicios disponibles son: ");
			for (int i=0;i<AVAILABLE_SERVICES.length;i++) {
				sb.append(AVAILABLE_SERVICES[i]);
				if (i<AVAILABLE_SERVICES.length-1) {
					sb.append(", ");
				}
			}
			throw new Exception(sb.toString());
		}
	}

	/** 
	* Metodo que muestra comprueba si el servicio está
	* repetido
	* @return devuelve true si está repetido. 
	*/
	protected boolean isRepeated(String r){
		boolean repeat=false;
		if (!this.services.isEmpty()) {
			Iterator<String> i = this.services.iterator();
			while(i.hasNext()){
				String service = i.next();
				if(r.equals(service)){
					repeat=true;
				}
			}
		}
		return repeat;
	}

	/** 
	* Metodo que comprueva si el servicio está entre los
	* disponibles.
	* @return devuelve true si es valido. 
	*/
	protected boolean validateService(String s){
		boolean ok=false;
		s = s.toLowerCase();
		for (int i=0;i<AVAILABLE_SERVICES.length&&!ok;i++) {
			if (s.equals(AVAILABLE_SERVICES[i])) {
				ok=true;
			}
		}
		return ok;
	}

	/** Setter para los servicios */
	public void setServices(){
		for (int i=0;i<SERVICES_DEF.length;i++) {
			this.services.add(SERVICES_DEF[i]);
		}
	}

	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append("\nID: "+this.id.id);
		sb.append("\nNombre: "+this.name);
		sb.append("\nCiudad: "+this.city);
		sb.append("\nPais: "+this.country);
		sb.append("\nServicios disponibles: ");
		for (int i=0;i<services.size();i++) {
			sb.append(services.get(i));
			if (i<services.size()-1) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}
}