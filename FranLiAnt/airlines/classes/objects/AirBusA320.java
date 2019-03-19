package airlines.classes.objects;
import airlines.interfaces.IAirBusA320;
import airlines.classes.auxiliaries.IDs;
import airlines.classes.auxiliaries.Date;
/** 
*	Clase que crea aviones AirBusA320.
*	@author Francisco Miguel Carrasquilla Rodríguez-Córdoba
*	@version 1.0
*/
public class AirBusA320 extends Airplane implements IAirBusA320{

	public AirBusA320(){
		super(PRICE_DEF,AUTONOMY_DEF,CONSUMPTION_DEF,
			CAPACITY_DEF,NUM_ROWS_DEF,NUM_ROWS_VIP_DEF,
			NUM_LETTERS_DEF);
	}

	@Override
	public String toString(){
		return "AirBusA320\n"+super.toString()+"\n";
	}
}