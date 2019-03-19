package airlines.classes.persons;
import java.util.Set;
import java.util.HashSet;
import airlines.classes.auxiliaries.Date;
import airlines.classes.objects.Flight;
import java.util.ArrayList;
/**
*    Clase que guarda datos de los pilotos y calcula el salario
*    @author Antonio Manuel Guerrero Trujillo
*    @version 1.0
*/

public class Pilot extends Employee {

  //Atributos y constructores
  public final static double BASE_SALARY_DEF=100000;
  public final static double PLUS_DEF=5000;
  public final static int MINUTES_DEF=0;

    public int flightminutes;

//Constructor que herada de empleados
  public Pilot(String n,String lm ,String d, String ny, Date bd, 
    Set<String> l) throws Exception {
    super(n,lm,d,ny,bd,l);
    this.salary=BASE_SALARY_DEF;
    this.flightminutes=MINUTES_DEF;
  }

//Constructor que calcula el salario de piloto

  public double getTotalSalary(){
      double total_salary=0;
      total_salary=BASE_SALARY_DEF + (PLUS_DEF * (double)this.numFlights);
      return total_salary;
  }

//Constructor que calcula las horas de vuelo
  public void calculateFlightMinutes(Flight f){
    this.flightminutes += f.duration;
  }

  @Override
  public String toString(){
    return super.toString()+" "+this.salary+" "+ this.flightminutes;
  }

}
