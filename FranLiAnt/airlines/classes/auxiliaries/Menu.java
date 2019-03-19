package airlines.classes.auxiliaries;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import airlines.classes.objects.*;
import airlines.classes.persons.*;
/**
*   Clase menu para controlar el programa.
*   @author Francisco Miguel Carrasquilla Rodríguez-Córdoba
*   @author Lidia Garrido Moreno
*   @version 1.0
*/
public class Menu {

	private static Menu instance;

	public AirCompany company;
	public Scanner sc;
	public List<String> principalMenu;

    /** Contructor singleton del Menu */
	private Menu(AirCompany company)throws Exception{
		this.company=company;
		sc=new Scanner(System.in);

		this.principalMenu=new ArrayList<>();
		this.principalMenu.add("Buscar vuelo");
        this.principalMenu.add("Consultar ticket");
        this.principalMenu.add("Eliminar ticket");
        this.principalMenu.add("Listar vuelos");
        this.principalMenu.add("Listar aeropuertos");
        this.principalMenu.add("Listar empleados");
        this.principalMenu.add("Listar clientes");
        this.principalMenu.add("Listar flota");
        this.principalMenu.add("Calcular salario total");
        this.principalMenu.add("Calcular la rentabilidad de un vuelo");
        this.principalMenu.add("Avanzar dia");

	} 

	public static Menu getInstance(AirCompany company) throws Exception{
		if(instance == null){
            instance=new Menu(company);
        }
        return instance;
	}

    /** Metodo que muestra el menu recorriendo el arraylist de opciones */
	public void showMenu(){
		System.out.println("\n-------AIRCOMPANY "+company.name+" "+company.today.toString()+"-----------");
		if(this.principalMenu!=null){
            Iterator<String> it=this.principalMenu.iterator();
            int i=1;
            while(it.hasNext()){
                String option=it.next();
                System.out.println(i+") "+option);
                i++;
            }
            System.out.println("0) Salir\n");
            System.out.println("Elija opcion");
            try{
                int option = sc.nextInt();
                if(option<0||option>this.principalMenu.size()){
                  System.out.println("Opcion no valida");
                  this.showMenu();
                }else{
                    this.optionMenu(option);
                }   
            }catch(Exception e){
                sc=new Scanner(System.in);
                System.out.println("Elija un numero correcto");
                this.showMenu();
            }
        }
	}

    /**
    * Metodo que segun la opcion elegida en el menu mostrado te 
    * redirecciona a la opcion indicada.
    * @param o opcion elegida.
    */
	public void optionMenu(int o)throws Exception{
		switch(o) {
            case 1:
                this.option1();
            break;
            case 2:
            	this.option2();
            break;
            case 3:
            	this.option3();
            break;
            case 4:
                this.option4();
            break;
            case 5:
                this.option5();
            break;
            case 6:
                this.option6();
            break;
            case 7:
               	this.option7();
            break;
            case 8:
            	this.option8();
            break;
            case 9:
            	this.option9();
            break;
            case 10:
                this.option10();
            break;
            case 11:
                this.option11();
            break;
            case 0:
                System.out.println("Hasta otra!");
            break;
            default:
            	System.out.println("Opcion no valida");
            	this.showMenu();
            break;
        }   
	}

    /** 
    * Pide introducir el origen y el destino del vuelo y a continucion te muestra 
    * los vuelos posibles. Despues de elegir te pide identificarte y si lo haces 
    * correctamente procederas comprar el billete. En caso de que no haya vuelo te 
    * indica si quieres buscar escalas de vuelos 
    */
	public void option1() throws Exception{
		System.out.println("Introduzca la ciudad de origen: ");
        String origin = sc.next();
        origin=Character.toUpperCase(origin.charAt(0))+
        	origin.toLowerCase().substring(1,origin.length());
        System.out.println("Introduzca la ciudad de destino: ");
        String destiny = sc.next();
        destiny=Character.toUpperCase(destiny.charAt(0))+
        	destiny.toLowerCase().substring(1,destiny.length());
        List<Flight> myFlights = company.searchFlight(origin,destiny);
        if (!myFlights.isEmpty()) {
            int option;
            do{
                for (int i=0;i<myFlights.size();i++) {
                    System.out.println((i+1)+") "+myFlights.get(i).id.id);
                }
                System.out.println("Seleccione vuelo: ");
                option = sc.nextInt();
                if (option<=0 || option>myFlights.size()) {
                    System.out.println("Vuelo no valido\n");
                }
            }while(option<=0 || option>myFlights.size());
        	System.out.println("Para continuar debe identificarse\n");
        	System.out.println("Introduzca su DNI: ");
        	sc.nextLine();
        	String myDNI = sc.nextLine();
            myDNI=myDNI.toUpperCase();
        	try{
            if (Person.validateDNI(myDNI)) {
                Client cli = company.searchClient(myDNI);
                if (cli==null) {
                    cli = this.createClient(myDNI,1);
                }
                String sn = "";
                do{
                    System.out.println(company.getFreeSeatsFromFlight(myFlights.get(option-1)));
                    System.out.println("Elige la fila: ");
                    int row = sc.nextInt();
                    if (row<10 && Integer.toString(row).length()<2) {
                        row=00+row;
                    }
                    System.out.println("Elige la columna: ");
                    String col = sc.next();
                    char newcol=col.toUpperCase().charAt(0);
                    if (this.company.buyTicket(cli,myFlights.get(option-1),row,newcol)){
                        System.out.println("Su ticket es: "+
                            company.searchTicket(myFlights.get(option-1),row,newcol).id.id);
                    }else{
                        System.out.println("Asiento no disponible");
                    }
                    System.out.println("¿Quiere otro asiento para el vuelo? S/N");
                    sn = sc.next();
                }while(sn.equals("s")||sn.equals("S"));
                if (sn.equals("n")||sn.equals("N")) {
                    System.out.println("Que tenga buen viaje");
                }
                this.showMenu();
            }else{
                System.out.println("No has introducido un DNI valido");
                this.showMenu();
            }
            }catch(Exception e){
            	e.printStackTrace();
            	System.out.println(e.getMessage());
            } 	
        }else{
        	System.out.println("No hay vuelos directos\n");
        	System.out.println("¿Quiere buscar un vuelo por escalas? S/N");
        	String sn = sc.next();
        	if (sn.equals("s") || sn.equals("S")) {
                System.out.println("Los vuelos que debe coger son: ");
        		company.escalationFlight(origin,destiny);
        	}
            this.showMenu(); 
        }   
	}

    /** 
    * Pide identificarte y una vez conseguido te pide introducir el ID del ticket para
    * mostrarte los datos del vuelo.
    */
	public void option2()throws Exception{
		System.out.println("Primero debe identificarse como cliente, introduzca su DNI: ");
        String myDNI = sc.next();
        myDNI=myDNI.toUpperCase();
        Client cli = company.searchClient(myDNI);
        if (cli==null) {
        	cli = this.createClient(myDNI,2);
        }
        System.out.println("Introduzca el ID del ticket: ");
        String myTicket = sc.next();
       	Ticket tk = company.searchTicket(myTicket);
        if (tk!=null && tk.client==cli) {
	        System.out.println(tk.flight);
	    }else{
            System.out.println("El ticket no existe o no esta comprado");
        }
        this.showMenu(); 
	}

    /** 
    * Pide identificarte y una vez conseguido te pide introducir el ID del ticket para
    * reembolsarlo.
    */
	public void option3()throws Exception{
		System.out.println("Primero debe identificarse como cliente, introduzca su DNI: ");
        String myDNI = sc.next();
        myDNI=myDNI.toUpperCase();
        Client cli = company.searchClient(myDNI);
        if (cli==null) {
        	cli = this.createClient(myDNI,3);
        }
        System.out.println("Introduzca el ID del ticket: ");
        String myTicket = sc.next();
       	Ticket tk = company.searchTicket(myTicket);
       	if (tk!=null && tk.client==cli) {
	        company.removeTicket(tk.id.id,cli.getDNI());
	        System.out.println("Su ticket se ha reembolsado");
	    }else{
            System.out.println("El ticket no existe o no ha sido comprado");
        }
        this.showMenu();
	}

    /** Muestra los vuelos */
	public void option4(){
		company.listFlight();
        this.showMenu();
	}

    /** Muestra los aeropuertos */
    public void option5(){
        company.listAirport();
        this.showMenu();
    }
    /** Muestra los empleados */
	public void option6()throws Exception{
		company.listEmployee();
        this.showMenu();
	}

    /** Muestra los clientes */
	public void option7(){
		company.listClient();
        this.showMenu();
	}

    /** Muestra los aviones */
	public void option8()throws Exception{
		company.listAirplane();
        System.out.println("1) Informacion sobre AirBusA320");
        System.out.println("2) Informacion sobre Boing787");
        int option = sc.nextInt();
        switch(option){
            case 1:
                AirBusA320 ab=new AirBusA320();
                System.out.println(ab.toString());
            break;
            case 2:
                Boing787 bo=new Boing787();
                System.out.println(bo.toString());
            break;
            default:
                this.showMenu();
        }
        this.showMenu();
	}

    /** Muestra la suma de los salarios de todos los empleados */
	public void option9(){
		double mySalary = company.totalSalary();
        System.out.println("El salario total de todos los empleados es: "+
        	mySalary);
        this.showMenu();
	}

    /** Te pide un vuelo para mostrar su rentabilidad */
	public void option10(){
		System.out.println("Introduzca el ID del vuelo: ");
		String idFlight = this.sc.nextLine();
		Flight myFlight = company.searchFlight(idFlight);
		double rentability = company.getRentabilityOfFlight(myFlight);
        System.out.println("La rentabilidad del vuelo "+idFlight+" es: "+
        	rentability);
        this.showMenu();
	}

    public void option11()throws Exception{
        this.company.today.nextDay();
        Flight tmp = null;
        Date next = null;
        for (int i=0;i<company.flights.size();i++) {
            if (company.flights.get(i).date.getMonth()==this.company.today.getMonth()&&
                company.flights.get(i).date.getDay()<this.company.today.getDay()) {
                for (int j=0;j<7;j++) {
                    company.flights.get(i).date.nextDay();
                }
                tmp = company.flights.get(i);
                next = company.flights.get(i).date;
                if(company.removeFlight(company.flights.get(i))&&company.addFlight(tmp,next)){
                    System.out.println("Vuelos actualizados");
                }
            }
        }
        this.showMenu();
    }

    /** 
    * Metodo para crear un cliente.
    * @param dni dni introducido para identificarse.
    * @param n numero de la opcion desde la cual ha sido llamada.
    * @return devuelve el cliente si se ha creado correctamente o null.
    */
    public Client createClient(String dni,int n) throws Exception{
        Client mySelf=null;
        System.out.println("\nCreando nuevo cliente ");
        System.out.println("Introduzca su nombre: ");
        try{
	        String name = sc.next();
	        System.out.println("Introduzca su apellido: ");
	        String lastName = sc.next();
	        System.out.println("Introduzca su nacionalidad: ");
	        String nacionality = sc.next();
	        System.out.println("Introduzca su fecha de nacimiento:");
	        System.out.println("Dia: ");
	        int day = sc.nextInt();
	        System.out.println("Mes: ");
	        int month = sc.nextInt();
	        System.out.println("Anio: ");
	        int year = sc.nextInt();
	        Date myDate=new Date(day,month,year);
	        mySelf=new Client(name,lastName,dni,nacionality,myDate);
	        if(company.addClient(mySelf)){
                System.out.println("Cliente creado con exito\n");
            }
        }catch(Exception e){
            sc=new Scanner(System.in);
            System.out.println(e.getMessage());
            System.out.println("\n");
            switch(n){
            	case 1:
            		this.option1();
            	break;
            	case 2:
            		this.option2();
            	break;
            	case 3:
            		this.option3();
            	break;
            }
        }
        return mySelf;
    }
}