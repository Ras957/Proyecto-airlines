package airlines.interfaces;
import airlines.classes.objects.Airplane;
import airlines.classes.objects.Site;
/** 
*	Interfaz con las características del Boing787
*	@author Francisco Miguel Carrasquilla Rodríguez-Córdoba
*	@version 1.0
*/
public interface IBoing787{

	public static final double PRICE_DEF=280000;
	public static final float AUTONOMY_DEF=8000;
	public static final float CONSUMPTION_DEF=160;
	public static final int CAPACITY_DEF=300;
	public static final int NUM_ROWS_DEF=50;
	public static final int NUM_ROWS_VIP_DEF=10;
	public static final char NUM_LETTERS_DEF='G';
	public static final int N_VEHICLES_MAX=4;
	public static final int N_VEHICLES_DEF=0;


	void setNVehicles(int nVehicles)throws Exception;
	void addVehicle(int n);

}