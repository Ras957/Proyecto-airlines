package airlines.classes.objects;
import airlines.classes.auxiliaries.IDs;
import airlines.classes.auxiliaries.Date;
import airlines.classes.persons.Pilot;
import airlines.classes.persons.Aircrew;
/** 
*	Clase que crea objetos Flight.
*	@author Francisco Miguel Carrasquilla Rodríguez-Córdoba
*	@version 1.0
*/
public class Flight{

	public static final double PRICE_DEF = 80;
	public static final int NUM_PILOTS_DEF=2;

	public IDs id;
	public Date date;
	public Pilot[] myPilots;
	public Aircrew[] myCrew;
	public Airport originAirport;
	public Airport destinationAirport;
	public int duration;
	public Airplane plane;
	public Ticket[] myTickets;
	public double priceBase;

	public Flight(Airport originAirport, Airport destinationAirport, 
		Airplane plane, int duration)throws Exception{
		this(originAirport,destinationAirport,plane,
			duration,PRICE_DEF);
	}

	public Flight(Airport originAirport, Airport destinationAirport, 
		Airplane plane, int duration, double priceBase)throws Exception{
		this.plane=plane;
		this.priceBase=priceBase;
		this.originAirport=originAirport;
		this.destinationAirport=destinationAirport;
		this.duration=duration;
		this.setPilots();
		this.setAircrews(plane);
		this.setTickets(plane);
	}
	/** Setter para los pilotos */
	public void setPilots(){
		Pilot[] pilots=new Pilot[NUM_PILOTS_DEF];
		this.myPilots=pilots;
	}
	/** Setter para los aircrews */
	public void setAircrews(Airplane plane){
		Aircrew[] crew=new Aircrew[(int)Math.ceil(plane.capacity*(0.02))];
		this.myCrew=crew;
	}
	/** Setter para los tickets */
	public void setTickets(Airplane plane){
		Ticket[] tickets=new Ticket[plane.sites.length*plane.sites[0].length];
		int k=0;
		for (int i=0;i<plane.sites.length;i++) {
			for (int j=0;j<plane.sites[0].length;j++) {
				tickets[k]=new Ticket(this,plane.sites[i][j]);
				k++;
			}
		}
		this.myTickets=tickets;
	}

	/** 
	* Metodo que muestra los asientos del avion del vuelo
	* dependiendo del tipo de avión.
	* @return devuelve la matriz de asientos. 
	*/
	public String showSites(){
		String sites="";
		if (this.plane instanceof AirBusA320) {
			sites=this.showSitesAirBus();
		}else if (this.plane instanceof Boing787) {
			sites=this.showSitesBoing();
		}
		return sites;
	}

	/** 
	* Metodo que muestra los asientos del AirBus
	* @return devuelve la matriz de asientos. 
	*/
	public String showSitesAirBus(){
		StringBuilder sb=new StringBuilder();
		sb.append(" ---- VIP ");
		sb.append(this.myTickets[0].price);
		sb.append("e ------");
		for (int i=0;i<this.plane.sites.length;i++) {
			sb.append("\n");
			if (i==AirBusA320.NUM_ROWS_VIP_DEF) {
				sb.append(" --- TURIST ");
				sb.append(this.myTickets[myTickets.length-1].price);
				sb.append("e ----\n");
			}
			sb.append("|");
			int k=0;
			for (int j=0;j<this.plane.sites[0].length;j++) {
				sb.append(this.plane.sites[i][j].toString());
				k++;
				if (k==2) {
					sb.append(" ");
				}
			}
			sb.append("|");
		}
		return sb.toString();
	}
	/** 
	* Metodo que muestra los asientos del Boing
	* @return devuelve la matriz de asientos. 
	*/
	public String showSitesBoing(){
		StringBuilder sb=new StringBuilder();
		sb.append(" ----------- VIP ");
		sb.append(this.myTickets[0].price);
		sb.append(" e --------------");
		for (int i=0;i<this.plane.sites.length;i++) {
			sb.append("\n");
			if (i==Boing787.NUM_ROWS_VIP_DEF) {
				sb.append(" ---------- TURIST ");
				sb.append(this.myTickets[myTickets.length-1].price);
				sb.append(" e ------------\n");
			}
			sb.append("|");
			int k=0;
			for (int j=0;j<this.plane.sites[0].length;j++) {
				sb.append(this.plane.sites[i][j].toString());
				k++;
				if (k==2 || k==5) {
					sb.append(" ");
				}
			}
			sb.append("|");
		}
		return sb.toString();
	}

	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		if (this.id!=null) {
			sb.append("\nID: "+this.id.id);
		}
		sb.append("\nDe "+this.originAirport.city+" a "+this.destinationAirport.city);
		sb.append("\nAvion: "+this.plane.register.id);
		sb.append("\nPilotos: ");
		for (int i=0;i<this.myPilots.length;i++) {
			if (this.myPilots[i]!=null) {
				sb.append(this.myPilots[i].name);
				if (i<this.myPilots.length-1) {
					sb.append(", ");
				}
			}
		}
		sb.append("\nAircrew: ");
		for (int i=0;i<this.myCrew.length;i++) {
			if (this.myCrew[i]!=null) {
				sb.append(this.myCrew[i].name);
				if (i<this.myCrew.length-1) {
					sb.append(",");
				}
			}
		}
		sb.append("\nPrecio base: "+this.priceBase+"e");
		sb.append("\nDuracion: "+this.duration+"'");
		return sb.toString();
	}
}	

	