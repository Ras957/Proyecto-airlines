package airlines.classes.persons;
import airlines.classes.auxiliaries.Date;

/**
*    Clase que guarda datos de los datos del CEO
*    @author Antonio Manuel Guerrero Trujillo
*    @version 1.0
*/


public class CEO extends Person{

/** Atributos y constantes */
  public final static double SALARY_DEF=120000;
  public final static String NAME_DEF="Antonio";
  public final static String DNI_DEF="14621451Y";
  public final static String LASTANAME_DEF="Guerrero";
  public final static String NATIONALITY_DEF="Espaniol";

  public double salary;

/** Constructor por defecto */

  public CEO() throws Exception{
    super(NAME_DEF,LASTANAME_DEF,DNI_DEF,NATIONALITY_DEF,null);
    this.birthdate=new Date(14,03,1998);
    this.salary=SALARY_DEF;
	}
}
