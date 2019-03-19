package airlines.classes.persons;
import java.util.Set;
import java.util.HashSet;
import airlines.classes.auxiliaries.Date;
import airlines.classes.objects.Flight;
import java.util.ArrayList;
/**
*    Clase que guarda los datos de los tripulantes y calcula su salario.
*    @author Antonio Manuel Guerrero Trujillo.
*    @version 1.0
*/

public class Aircrew extends Employee {

// Atributos y constantes
  public final static double BASE_SALARY_DEF=40000;
  public final static double PLUS_DEF=1000;

//Constructor que hereda de empleado
  public Aircrew(String n,String lm ,String d, String ny, Date bd, 
  	Set<String> l) throws Exception {
    super(n,lm,d,ny,bd,l);
    this.salary=BASE_SALARY_DEF;
   }


//Constructor  que calcula el salario de un tripulante
 public double getTotalSalary(){
      double total_salary=0;
      total_salary=BASE_SALARY_DEF + (PLUS_DEF * (double)this.numFlights);
      return total_salary;
  }

@Override
  public String toString(){
    return super.toString()+" "+this.salary;
  }


}
