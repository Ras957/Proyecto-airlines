package airlines.interfaces;
import airlines.classes.persons.*;
import airlines.classes.objects.*;
import airlines.classes.auxiliaries.Date;

public interface IAirCompany {

    // contrata empleado-------------------
    boolean hireEmployee(Employee em) throws Exception;

    // despideEmpleado
    boolean fireEmployee(Employee em);

    // lista empleados
    void listEmployee()throws Exception;

    // busca empleados
    Employee searchEmployee(String dni);

    // salario total
    double totalSalary();

    // ayade un avion---------------------
    boolean addPlane(Airplane pl) throws Exception;

    // lista los aviones
    void listAirplane()throws Exception;

    // elimina un avion
    boolean removePlane(Airplane pl);

    // busca un avion que le pasa la matricula
    Airplane searchPlane(String id);

    // ayade vuelo----------------------
    boolean addFlight(Flight fl, Date date)  throws Exception;

    // lista vuelos
    void listFlight();

    // buscar vuelo
    Flight searchFlight(String id);

    // elimina vuelo
    boolean removeFlight(Flight fl);

    // comprar ticket------------------
    boolean buyTicket(Client cli,Flight fl,int row,char col) throws Exception;

    // eliminar ticket
    boolean removeTicket(String id ,String dni);

    // busca ticket
    Ticket searchTicket(String id);

    // ayade cliente-------------------
    boolean addClient(Client cli);

    // lista cliente
    void listClient();

    // busca cliente
    Client searchClient(String dni);

    // elimina cliente
    boolean removeClient(Client cli);

    // asientos libres----------------
    String getFreeSeatsFromFlight(Flight fl);

    // rentabilidad de vuelvo
    double getRentabilityOfFlight(Flight fl);

    void escalationFlight(String o, String d);
}