import java.util.Scanner;
import airlines.classes.auxiliaries.*;
import airlines.classes.objects.*;
import airlines.classes.persons.*;
import java.util.Set;
import java.util.HashSet;
/**
* Main para controlar hacer simulaciones con el proyecto.
* @author Antonio Manuel Guerrero Trujillo
* @author Lidia Garrido Moreno
* @version 1.0
*/

public class Main{
    public static void main(String[] args) {

    try{
    /** Compañia */
    AirCompany company=new AirCompany();

    Menu menu=Menu.getInstance(company);

    /** Idiomas 
    */
    Set<String> lan1=new HashSet<>();
    lan1.add("Spanish");
    Set<String> lan2=new HashSet<>();
    lan2.add("English");
    Set<String> lan3=new HashSet<>();
    lan3.add("French");
    Set<String> lan4=new HashSet<>();
    lan4.add("Spanish");
    lan4.add("English");
    Set<String> lan5=new HashSet<>();
    lan5.add("Spanish");
    lan5.add("Romanian");
    Set<String> lan6=new HashSet<>();
    lan6.add("Arabe");
    Set<String> lan7=new HashSet<>();
    lan7.add("Italiano");
    lan7.add("Spanish");
    Set<String> lan8=new HashSet<>();
    lan8.add("Ruso");

    /** Pilotos */
    company.hireEmployee(new Pilot("Manolo","Martinez","25743599K",
        "Espaniol",new Date(23,9,1990),lan1));
    company.hireEmployee(new Pilot("Beatriz","Torres","84513364W",
        "Argentina",new Date(4,3,1987),lan4));
    company.hireEmployee(new Pilot("Pedro","Granados","79919767B",
        "Espaniol",new Date(19,7,1991),lan4));
    company.hireEmployee(new Pilot("Jeny","Jones","59308958P",
        "Inglesa",new Date(27,1,1989),lan2));
    company.hireEmployee(new Pilot("Regis","Ferrec","90535593A",
        "Frances",new Date(5,5,1992),lan3));
    company.hireEmployee(new Pilot("Olav","Abrahamsen","06702199E",
        "Escandinavo",new Date(1,3,1982),lan2));
    company.hireEmployee(new Pilot("Ramon","Urbano","79458783Q",
        "Espaniol",new Date(6,7,1984),lan4));
    company.hireEmployee(new Pilot("Abdul","Hammud","41121525D",
        "Iraqui",new Date(23,2,1985),lan6));


    /** Aircrews */
    company.hireEmployee(new Aircrew("Samuel","Moreno","84759118R",
        "Espaniol",new Date(23,10,1985),lan4));
    company.hireEmployee(new Aircrew("Vicente","Lodosa","17922250Y",
        "Rumano",new Date(17,12,1979),lan5));
    company.hireEmployee(new Aircrew("Patricio","De La Rosa","81653161X",
        "Rumano",new Date(7,10,1977),lan5));
    company.hireEmployee(new Aircrew("Ricardo","Retamosa","20002003F",
        "Espaniol",new Date(4,3,1987),lan1));
    company.hireEmployee(new Aircrew("Andres","Carmona","75843784L",
        "Espaniol",new Date(9,9,1990),lan4));
    company.hireEmployee(new Aircrew("Miguel","Aguilera","01410722V",
        "Espaniol",new Date(1,2,1993),lan1));
    company.hireEmployee(new Aircrew("Luz Marina","Gonzalez","03227826Y",
        "Colombiana",new Date(13,8,1971),lan4));
    company.hireEmployee(new Aircrew("Julian","Adams","81267420W",
        "Canadiense",new Date(1,9,1983),lan3));
    company.hireEmployee(new Aircrew("Carlos","Mosqueda","26954360Q",
        "Espaniol",new Date(23,12,1976),lan1));
    company.hireEmployee(new Aircrew("Ana","Perez","76478532J",
        "Cubana",new Date(3,1,1990),lan1));
    company.hireEmployee(new Aircrew("Bob","Laurie","68365612K",
        "Ingles",new Date(11,10,1983),lan4));
    company.hireEmployee(new Aircrew("Evezyan","Gariboglu","40405962E",
        "Iraqui",new Date(21,12,1993),lan6));
    company.hireEmployee(new Aircrew("Magdalena","Gomez","34776943T",
        "Espaniola",new Date(1,8,1994),lan4));
    company.hireEmployee(new Aircrew("Nina","Rossi","24320790S",
        "Italiana",new Date(3,5,1983),lan7));
    company.hireEmployee(new Aircrew("Meier","Fontana","76652029K",
        "Suizo",new Date(27,7,1982),lan2));
    company.hireEmployee(new Aircrew("Andrey","Sokolo","54465655E",
        "Ruso",new Date(31,12,1995),lan8));
    company.hireEmployee(new Aircrew("Alfonso","Cuyegkeng","44018008X",
        "Filipino",new Date(1,11,1978),lan4));
    company.hireEmployee(new Aircrew("Chloe","Briand","44829718G",
        "Francesa",new Date(5,5,1975),lan3));
    company.hireEmployee(new Aircrew("Francisco","Torres","03244823Y",
        "Espaniol",new Date(14,6,1983),lan1));
    company.hireEmployee(new Aircrew("Maria","Lopez","20088015E",
        "Espaniola",new Date(13,2,1993),lan4));
    company.hireEmployee(new Aircrew("Lilith","Mayer","01410722V",
        "Inglesa",new Date(15,8,1985),lan2));
    company.hireEmployee(new Aircrew("Giga","Albu","93902028C",
        "Rumana",new Date(8,9,1978),lan5));
    company.hireEmployee(new Aircrew("Megan","Campbell","06992755L",
        "Escocesa",new Date(1,1,1990),lan2));
    company.hireEmployee(new Aircrew("Lidia","Joyera","41957421Q",
        "Espaniola",new Date(1,11,1993),lan4));


    /** Clientes */
    company.addClient(new Client("Gabriel","Gutierrez","09840992M",
        "Espaniol",new Date(2,4,1970)));
    company.addClient(new Client("Agustin","Ponce","97392556E",
        "Argentino",new Date(8,5,1971)));
    company.addClient(new Client("Airton","Saravi","70148116W",
        "Portugues",new Date(21,8,1969)));
    company.addClient(new Client("Tina","Parissi","92672731G",
        "Italina",new Date(1,11,1968)));
    company.addClient(new Client("Stoica","Alexandrescu","94047025W",
        "Rumana",new Date(4,2,1996)));
    company.addClient(new Client("Yon","Song","41262340H",
        "Coreano",new Date(6,9,1987)));
    company.addClient(new Client("Victorie","Jussieu","31880562D",
        "Francesa",new Date(1,11,1993)));
    company.addClient(new Client("Jules","Regnault","02509114K",
        "Frances",new Date(4,3,1987)));
    company.addClient(new Client("Carmen","Castillo","34047788Z",
        "Espaniola",new Date(12,3,1980)));
    company.addClient(new Client("Vicente","Retamosa","56786283L",
        "Espaniol",new Date(2,4,1984)));
    company.addClient(new Client("Sandra","Ruiz","91796746C",
        "Espaniola",new Date(17,7,1982)));
    company.addClient(new Client("Samuel","Osuna","71909614E",
        "Espaniol",new Date(3,6,1967)));
    company.addClient(new Client("Francisco","Ramirez","44199133X",
        "Espaniol",new Date(16,10,1971)));
    company.addClient(new Client("Bruno","Castillo","59618578W",
        "Argentino",new Date(4,3,1987)));
    company.addClient(new Client("Amador","Rivas","27687565G",
        "Romano",new Date(9,6,1967)));
    company.addClient(new Client("Ana","Guerrero","00085708X",
        "Espaniola",new Date(4,3,2010)));
    company.addClient(new Client("Aaron","Jones","23213034P",
        "Ingles",new Date(17,9,2000)));
    company.addClient(new Client("April","Stone","40670390L",
        "Inglesa",new Date(1,6,2007)));
    company.addClient(new Client("Edwin","Lehner","41523458V",
        "Aleman",new Date(12,3,1999)));
    company.addClient(new Client("Giselle","Holbein","87757808C",
        "Alemana",new Date(1,1,2015)));
    company.addClient(new Client("Serguei","Petrov","91234590F",
        "Ruso",new Date(4,3,2013)));
    company.addClient(new Client("Svetlana","Morozov","35508352D",
        "Rusa",new Date(12,12,1961)));
    company.addClient(new Client("Vanesa","Navarro","97223630P",
        "Espaniola",new Date(23,11,1999)));
    company.addClient(new Client("Pedro","Mesa","85327909W",
        "Espaniol",new Date(1,3,1985)));
    company.addClient(new Client("Vladimir","Lebedev","55596810Z",
        "Ruso",new Date(3,7,1966)));
    company.addClient(new Client("Roman","Lemus","62591149F",
        "Espaniol",new Date(1,1,1998)));
    company.addClient(new Client("Juan","Gonzales","58934802Q",
        "Espaniol",new Date(4,3,1959)));
    company.addClient(new Client("Cristian","Cordoba","47873010M",
        "Espaniol",new Date(9,8,1987)));
    company.addClient(new Client("Danilo","Pereira","87582162W",
        "Portugues",new Date(5,4,1981)));
    company.addClient(new Client("Anilux","Hernandez","62881961F",
        "Cubana",new Date(13,5,1976)));

    /** Aeropuertos */
    company.addAirport(new Airport("Costa del Sol","Malaga","Spain"));
    company.airports.get(0).addService("cafeteria");
    company.addAirport(new Airport("El Prat","Barcelona","Spain"));
    company.airports.get(1).addService("cafeteria");
    company.airports.get(1).addService("restaurant");
    company.airports.get(1).addService("shop");
    company.addAirport(new Airport("Barajas","Madrid","Spain"));
    company.airports.get(2).addService("cafeteria");
    company.airports.get(2).addService("restaurant");
    company.airports.get(2).addService("shop");
    company.addAirport(new Airport("Aena","Bilbao","Spain"));
    company.addAirport(new Airport("Manises","Valencia","Spain"));
    company.airports.get(4).addService("cafeteria");
    company.addAirport(new Airport("Heathrow","Londres","United Kingdom"));
    company.airports.get(5).addService("reting car");
    company.addAirport(new Airport("Francfort del Meno","Frankfurt","Germany"));
    company.addAirport(new Airport("Hamad​","Doha","Qatar"));
    company.addAirport(new Airport("Haneda","Tokyo","Japan"));
    company.airports.get(8).addService("shop");

    /** Boing787 */
    company.addPlane(new Boing787());
    company.addPlane(new Boing787(1));
    company.addPlane(new Boing787(2));
    company.addPlane(new Boing787(3));
    company.addPlane(new Boing787(4));


    /** AirBusA320 */
    company.addPlane(new AirBusA320());
    company.addPlane(new AirBusA320());
    company.addPlane(new AirBusA320());
    company.addPlane(new AirBusA320());
    company.addPlane(new AirBusA320());

    /** Vuelos */
    //Malaga-Barcelona
    company.addFlight(new Flight(company.airports.get(0),company.airports.get(1),
        company.planes.get(5),246,90),new Date(18,03,2019,15,00));
    company.addFlight(new Flight(company.airports.get(6),company.airports.get(2),
        company.planes.get(1),540,250),new Date(22,03,2019,22,30));
    company.addFlight(new Flight(company.airports.get(5),company.airports.get(4),
        company.planes.get(6),367,115),new Date(20,03,2019,1,20));
    company.addFlight(new Flight(company.airports.get(3),company.airports.get(0),
        company.planes.get(4),123,80),new Date(22,03,2019,10,10));
    company.addFlight(new Flight(company.airports.get(2),company.airports.get(5),
        company.planes.get(8),369,180),new Date(19,03,2019,17,30));
    company.addFlight(new Flight(company.airports.get(0),company.airports.get(6),
        company.planes.get(8),369,180),new Date(23,03,2019,23,15));


    menu.showMenu();

    Table myTable=new Table(company);
    //myTable.printTable(myTable.createTableFlights());
    //myTable.printTable(myTable.createTablePlane());

    }catch(Exception e){
        e.printStackTrace();
        System.out.println(e.getMessage());
    }
  }
}
