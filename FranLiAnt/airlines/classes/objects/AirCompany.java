package airlines.classes.objects;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import airlines.classes.auxiliaries.*;
import airlines.classes.persons.*;
import airlines.interfaces.IAirCompany;

/**
 * Clase para crear objetos Aircompany la cual va a ser
 * el nucleo principal del programa.
 * @author Lidia 
 * @version 1.0
 */
public class AirCompany implements IAirCompany{

    public static final String NAME_DEF = "Iberia";
 
    public static int nEmployees=1;
    public static int nAirBus=1;
    public static int nBoings=1;

    public String name;
    public IDs code;
    public CEO ceo;
    public Date fundationDate;
    public Date today=new Date(18,3,2019,10,0);

    public ArrayList<Airplane> planes= new ArrayList<Airplane>();
    public ArrayList<Employee> employees=new ArrayList<Employee>();
    public ArrayList<Airport> airports=new ArrayList<Airport>();
    public ArrayList<Flight> flights=new ArrayList<Flight>();
    public ArrayList<Client> clients=new ArrayList<Client>();
    public ArrayList<Ticket> tickets=new ArrayList<Ticket>();

    /** Constructor con parametros por defecto. */
    public AirCompany() throws Exception{
        this(NAME_DEF);
    }

    /**
     * Constructor con todos los parametros.
     * @param name nombre de la compañia.
     */
    public AirCompany(String name)throws Exception{
        this.name=name;
        this.setCode();
        this.ceo=new CEO();
        this.addClient(new Client(ceo.NAME_DEF,ceo.LASTANAME_DEF,ceo.DNI_DEF,
            ceo.NATIONALITY_DEF,ceo.birthdate));
        this.fundationDate=new Date(28,06,1970);
    }

    /**
     * Coge los 3 primeros caracteres del nombre de la compañia  
     * y crea un objeto de tipo IDs con ellos.
     */
    public void setCode() {
        IDs code=new IDs(this);
        this.code = code;
    }

    /**
     * Le da al empleado su numero de empleado de tipo IDs y
     * su salario dependiendo de si es piloto o aircrew.
     * @param em empleado a contratar.
     * @return devuelve true si contrata al empleado.
     */
    @Override
    public boolean hireEmployee(Employee em) throws Exception{
        em.numEmployee=new IDs(this.nEmployees);
        this.nEmployees++;
        if (em instanceof Pilot) {
            em.salary=Pilot.BASE_SALARY_DEF;
        }else if (em instanceof Aircrew){
            em.salary=Aircrew.BASE_SALARY_DEF;
        }
        return this.employees.add(em);
    }

    /**
     * Le quita al empleado su numero de empleado de tipo IDs y
     * su salario.
     * @param em empleado a despedir.
     * @return devuelve true si despide al empleado.
     */
    public boolean fireEmployee(Employee em) {
        em.numEmployee=null;
        em.salary=0;
        return this.employees.remove(em);
    }

    /** Lista empleados. */
    public void listEmployee()throws Exception {
        Table myTable=new Table(this);
        myTable.printTable(myTable.createTableEmployee());

        /*Iterator<Employee> myEmployees = this.employees.iterator();
        while(myEmployees.hasNext()){
            Employee em = myEmployees.next();
            System.out.println(em);
        }*/
    }

    /** 
    * Busca un empleado por su DNI. 
    * @param dni DNI del empleado.
    * @return devuelve el empleado si lo o encuentra o null.
    */
    public Employee searchEmployee(String dni) {
        boolean found=false;
        Employee em=null;
        for(int i=0;i<this.employees.size() && !found;i++){ 
            if(this.employees.get(i).getDNI().equals(dni)){
                em=this.employees.get(i);
                found=true;
            }
        }
        return em;
    }

    /** 
    * Calcula el salario de todos los empleados de la compañia. 
    * @return devuelve la cantidad del salario total.
    */
    public double totalSalary() {
        double total = 0;
        Iterator<Employee> myEmployees = this.employees.iterator();
        while(myEmployees.hasNext()){
            Employee em = myEmployees.next();
            total+=em.salary;
        }
        return total;
    }

    /**
     * Le da una matricula al avion segun el tipo de avion
     * y le da una fecha de adquisicion.
     * @param pl avion a añadir.
     * @return devuelve true si añade el avion.
     */
    public boolean addPlane(Airplane pl)throws Exception {
        if (pl instanceof AirBusA320) {
            pl.register=new IDs(this,pl,this.nAirBus);
            this.nAirBus++;
        }else if (pl instanceof Boing787){
            pl.register=new IDs(this,pl,this.nBoings);
            this.nBoings++;
        }
        pl.acquisitionDate=this.today;
        return this.planes.add(pl);
    }

    /**
     * Le quita la matricula y la fecha de adquisicion y 
     * la saca del arraylist de aviones.
     * @param pl avion a quitar.
     * @return devuelve true si quita el avion.
     */
    public boolean removePlane(Airplane pl) {
        pl.register=null;
        pl.acquisitionDate=null;
        return this.planes.remove(pl);
    }

    /** Lista aviones. */
    public void listAirplane() throws Exception {
        Table myTable=new Table(this);
        myTable.printTable(myTable.createTablePlane());
        /*Iterator<Airplane> myPlanes = this.planes.iterator();
        while(myPlanes.hasNext()){
            Airplane pl = myPlanes.next();
            System.out.println(pl);
        }*/
    }

    /** 
    * Busca un avion por su matricula. 
    * @param id matricula del avion.
    * @return devuelve el avion si lo encuentra o null.
    */
    public Airplane searchPlane(String id) {
        boolean found=false;
        Airplane plane=null;
        for(int i=0;i<this.planes.size() && !found;i++){ 
            if(this.planes.get(i).register.id.equals(id)){
                plane=this.planes.get(i);
                found=true;
            }
        }
        return plane;
    }

    /** 
    * Metodo para añadir aeropuertos al arraylist de aeropuertos.
    * @param ap aeropuerto a añadir.
    * @return devuelve true si añade el aeropuerto.
    */
    public boolean addAirport(Airport ap){
        return this.airports.add(ap);
    }

    /** 
    * Metodo para elimiar aeropuertos del arraylist de aeropuertos.
    * @param ap aeropuerto a eliminar.
    * @return devuelve true si elimina el aeropuerto.
    */
    public boolean removeAirport(Airport ap){
        return this.airports.remove(ap);
    }

    /** Lista aeropuertos */
    public void listAirport() {
        Iterator<Airport> myAirports = this.airports.iterator();
        while(myAirports.hasNext()){
            Airport ap = myAirports.next();
            System.out.println(ap);
        }
    }

    /** 
    * Metodo para buscar aeropuerto.
    * @param name nombre o ciudad del aeropuerto.
    * @return devuelve el aueropuerto si lo encuentra o null.
    */
    public Airport searchAirport(String name) {
        boolean found=false;
        Airport ap=null;
        for(int i=0;i<this.airports.size() && !found;i++){ 
            if(this.airports.get(i).name.equals(name) ||
                this.airports.get(i).city.equals(name)){
                ap=this.airports.get(i);
                found=true;
            }
        }
        return ap;
    }


    /**
     * Añade el vuelo con la fecha, le crea su id, le asigna 
     * sus pilotos y su tripulación y todos los tickets del 
     * vuelo se añaden al arraylist de tickets asignandole antes
     * su ID correspondiente.
     * @param fl vuelo a añadir.
     * @param date fecha y hora.
     * @return devuelve true si añade el vuelo.
     */
    public boolean addFlight(Flight fl, Date date) throws Exception{
        fl.date=date;
        fl.id=new IDs(this,date,fl.originAirport);
        Pilot[] pilots=new Pilot[fl.myPilots.length];
        Aircrew[] aircrews=new Aircrew[fl.myCrew.length];
        boolean fullPilots=false, fullAircrews=false, full=false;
        int j=0,k=0;
        do{
            int i=(int)Math.floor(Math.random()*this.employees.size());
            if (this.employees.get(i).setFlights()&&
                !this.employees.get(i).flights.contains(fl)) {
                if (this.employees.get(i) instanceof Pilot) {
                    if (k<pilots.length) {
                        pilots[k]=(Pilot)this.employees.get(i);
                        this.employees.get(i).flights.add(fl);
                        k++;
                        if (k==pilots.length) {
                            fullPilots=true;
                        }
                    }
                }else if (this.employees.get(i) instanceof Aircrew){
                    if (j<aircrews.length) {
                        aircrews[j]=(Aircrew)this.employees.get(i);
                        this.employees.get(i).flights.add(fl);
                        j++;
                        if (j==aircrews.length) {
                            fullAircrews=true;
                        }
                    }
                }
            }
            if (fullAircrews&&fullPilots) {
                full=true;
            }
        }while(!full);
        fl.myPilots=pilots;
        fl.myCrew=aircrews;
        for (int i=0;i<fl.myTickets.length;i++) {
            IDs idTicket=new IDs(fl,fl.myTickets[i].site.row,fl.myTickets[i].site.letter,date);
            fl.myTickets[i].id=idTicket;
            this.tickets.add(fl.myTickets[i]);
        }
        return this.flights.add(fl);
    }

    /**
     * Le quita el id y la fecha al vuelo y deja libres a los
     * pilotos y la tripulación para otro vuelo.
     * @param fl vuelo a quitar.
     * @return devuelve true si quita el vuelo.
     */
    public boolean removeFlight(Flight fl) {
        fl.date=null;
        fl.id.id=null;
        for (int i=0;i<fl.myPilots.length;i++) {
            fl.myPilots[i].plusNFlight();
            fl.myPilots[i].calculateFlightMinutes(fl);
            fl.myPilots[i].flights.remove(fl);
        }
        for (int i=0;i<fl.myCrew.length;i++) {
            fl.myCrew[i].plusNFlight();
            fl.myCrew[i].flights.remove(fl);
        }
        for (int i=0;i<fl.myTickets.length;i++) {
            this.tickets.remove(fl.myTickets[i]);
        }
        return this.flights.remove(fl);
    }

    /** Lista vuelos. */
    public void listFlight() {
        Table myTable=new Table(this);
        myTable.printTable(myTable.createTableFlights());
    }

    /** 
    * Busca vuelos por su origen y su destino. 
    * @param origin ciudad de origen.
    * @param destination ciudad de destino.
    * @return devuelve un array de vuelos con los parametros de entrada.
    */
    public List<Flight> searchFlight(String origin, String destination) {
        List<Flight> flightsFound=new ArrayList<>();
        Iterator<Flight> myFlights = this.flights.iterator();
        while(myFlights.hasNext()){
            Flight fl = myFlights.next();
            if (fl.originAirport.city.equals(origin) && 
               fl.destinationAirport.city.equals(destination)){
                flightsFound.add(fl);
            }
        }
        return flightsFound;
    }

    /** 
    * Busca un vuelo por su id. 
    * @param id identificacion del vuelo.
    * @return devuelve el vuelo si lo encuentra o null.
    */
    public Flight searchFlight(String id) {
        boolean found=false;
        Flight fl=null;
        for(int i=0;i<this.flights.size() && !found;i++){ 
            if(this.flights.get(i).id.id.equals(id)){
                fl=this.flights.get(i);
                found=true;
            }
        }
        return fl;
    }

    /** 
    * Compra un ticket si el cliente es válido. 
    * @param cli cliente.
    * @param fl vuelo.
    * @param row numero de la fila.
    * @param col letra de la columna.
    * @return devuelve true si se compra el ticket.
    */
    public boolean buyTicket(Client cli,Flight fl,int row,char col){
        boolean buy=false;
        for (int i=0;i<fl.myTickets.length;i++) {
            if (!fl.myTickets[i].bought) {
                if (fl.myTickets[i].site.row==row &&
                  fl.myTickets[i].site.letter==col) {
                    if(!fl.myTickets[i].bought){
                        cli.buyTickets(fl.myTickets[i]);
                        buy=fl.myTickets[i].bought;
                    }
                }
            }
        }
        return buy;
    }

    /** 
    * Reembolsa el ticket de un cliente. 
    * @param dni DNI del cliente.
    * @param id identificador del vuelo.
    * @return devuelve true si se reembolsa el ticket.
    */
    public boolean removeTicket(String id ,String dni) {
        Client cli = this.searchClient(dni);
        Ticket tk = this.searchTicket(id);
        if (cli!=null && tk!=null){
            if (tk.client==cli) {
                tk.client=null;
                tk.bought=false;
            }
        }
        return true;
    }

    /** 
    * Busca un ticket por su id. 
    * @param id identificador del ticket.
    * @return devuelve el ticket si lo encuentra o null.
    */
    public Ticket searchTicket(String id) {
        boolean found=false;
        Ticket tk=null;
        for(int i=0;i<this.tickets.size() && !found;i++){ 
            if(this.tickets.get(i).id.id.equals(id)){
                tk=this.tickets.get(i);
                found=true;
            }
        }
        return tk;
    }

    /** 
    * Busca un ticket por su el vuelo y el asiento. 
    * @param fl vuelo del ticket.
    * @param row fila del asiento.
    * @param letter columna del asiento.
    * @return devuelve el ticket si lo encuentra o null.
    */
    public Ticket searchTicket(Flight fl, int row, char letter) {
        boolean found=false;
        Ticket tk=null;
        for(int i=0;i<this.tickets.size() && !found;i++){ 
            if(this.tickets.get(i).flight==fl){
                if (this.tickets.get(i).site.row==row &&
                    this.tickets.get(i).site.letter==letter) {
                    tk=this.tickets.get(i);
                    found=true;
                }
            }
        }
        return tk;
    }

    /** 
    * Metodo para añadir clientes al arraylist de clientes.
    * @param cli cliente a añadir.
    * @return devuelve true si añade al cliente.
    */
    public boolean addClient(Client cli) {
        return this.clients.add(cli);
    }

    /** 
    * Metodo para eleminar clientes del arraylist de clientes.
    * @param cli cliente a eliminar.
    * @return devuelve true si elimina al cliente.
    */
    public boolean removeClient(Client cli) {
        return this.clients.remove(cli);
    }

    /** Lista clientes. */
    public void listClient() {
        Table myTable=new Table(this);
        myTable.printTable(myTable.createTableClient());
    }

    /** 
    * Metodo para buscar clientes.
    * @param dni DNI del cliente a buscar.
    * @return devuelve al cliente si lo encuentra o null.
    */
    public Client searchClient(String dni) {
        boolean found=false;
        Client cli=null;
        for(int i=0;i<this.clients.size() && !found;i++){ 
            if(this.clients.get(i).getDNI().equals(dni)){
                cli=this.clients.get(i);
                found=true;
            }
        }
        return cli;
    }

    /** 
    * Metodo que recibe la matriz de asientos del vuelo y 
    * los sustituye por X si estan ocuapdos.
    * @param fl vuelo con los tickets y asientos.
    * @return devuelve la matriz de asientos disponibles.
    */
    public String getFreeSeatsFromFlight(Flight fl) {
        String mySites = fl.showSites();
        for (int i=0; i<fl.myTickets.length; i++) {
            if (fl.myTickets[i].bought) {
                String aux=fl.myTickets[i].site.toString();
                mySites = mySites.replace(aux,"[ X ]");
            }
        }
        return mySites;
    }

    /**
     * Metodo para calcular la rentabilidad del vuelo.
     * @param fl vuelo a comprobar.
     * @return devuelve los beneficios del vuelo.
     */
    public double getRentabilityOfFlight(Flight fl) {
        double ticketsSold = 0;
        for (int i = 0; i < fl.myTickets.length; i++) {
            if (fl.myTickets[i].bought) {
                ticketsSold+=fl.myTickets[i].price;
            }
        }
        double rentability = ticketsSold-((double)(fl.duration*fl.plane.consumption));
        return rentability;
    }

    /**
     * Metodo para buscar escalas en los vuelos, se separan los vuelos con
     * las ciudades de origen y destino indicadas y se busca otra vuelo
     * que las conecte.
     * @param o ciudad de origen.
     * @param d ciudad de destino.
     */
    public void escalationFlight(String o, String d) {
        ArrayList<Flight> origins=new ArrayList<Flight>();
        ArrayList<Flight> destinations=new ArrayList<Flight>();
        Iterator<Flight> myFlights = this.flights.iterator();
        while(myFlights.hasNext()){
            Flight fl = myFlights.next();
            if(fl.originAirport.city.equals(o)){
                origins.add(fl);
            }
            if(fl.destinationAirport.city.equals(d)){
                destinations.add(fl);
            }
        }
        Iterator<Flight> myOrigins = origins.iterator();
        while(myOrigins.hasNext()){
            Flight fl1 = myOrigins.next();
            String destinationCity = fl1.destinationAirport.city;
            Iterator<Flight> myDestinations = destinations.iterator();
            while(myDestinations.hasNext()){
                Flight fl2 = myDestinations.next();
                if (fl2.originAirport.city.equals(destinationCity)) {
                    System.out.println(fl1);
                    System.out.println(fl2);
                }
            }
        }
    }
}
