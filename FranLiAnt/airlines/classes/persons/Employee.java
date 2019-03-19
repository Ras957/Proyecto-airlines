package airlines.classes.persons;
import java.util.Set;
import java.util.HashSet;
import airlines.classes.auxiliaries.Date;
import airlines.classes.auxiliaries.IDs;
import airlines.classes.objects.Flight;

/**
*    Clase que guarda los datos de los empleados que hereda de cliente.
*    @author Antonio Manuel Guerrero Trujillo
*    @version 1.0
*/

abstract  public class Employee extends Person {
//Atributos y constatantes

   public static final int NUM_FLIGHTS_DEF=0;
   public static final double SALARY_DEF=0;

   public IDs numEmployee; //Número de empleado
   public Set<String> languages=new HashSet<>(); //Lenguajes
   public int numFlights; //Número de vuelos
   public double salary; //Salario base
   public Set<Flight> flights;

  
//Constructor que hereda de persona
   public Employee(String n,String lm ,String d, String ny, Date bd, 
    Set<String> l) throws Exception {
     super(n,lm,d,ny,bd);
     this.languages=l;
     this.numFlights=NUM_FLIGHTS_DEF;
     this.salary=SALARY_DEF;
     this.flights=new HashSet<>();
   }

   public void plusNFlight(){
    this.numFlights++;
   }

    public boolean setFlights(){
    boolean b=false;
    if (this.flights.size()<2) {
      b=true;
    }
    return b;
  }

//Constructor que clacula el salario de cada empleado
   abstract public double getTotalSalary();

   @Override
   public String toString(){
     return this.numEmployee+" "+super.toString()+" "+
      this.numFlights;
   }

 }
