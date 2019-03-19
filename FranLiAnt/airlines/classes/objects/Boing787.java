package airlines.classes.objects;
import airlines.interfaces.IBoing787;
import airlines.classes.auxiliaries.IDs;
import airlines.classes.auxiliaries.Date;
/** 
*	Clase que crea aviones Boing787.
*	@author Francisco Miguel Carrasquilla Rodríguez-Córdoba
*	@version 1.0
*/
public class Boing787 extends Airplane implements IBoing787{

	public int nVehicles;

	public Boing787() throws Exception{
		this(N_VEHICLES_DEF);
	}

	public Boing787(int nVehicles) throws Exception{
		super(PRICE_DEF,AUTONOMY_DEF,CONSUMPTION_DEF,
			CAPACITY_DEF,NUM_ROWS_DEF, NUM_ROWS_VIP_DEF,
			NUM_LETTERS_DEF);
		this.setNVehicles(nVehicles);
	}

	/**
	*   Metodo para regular el numero de vehiculos.
	*   @param nVehicles numero de vehiculos.
	*/
	public void setNVehicles(int nVehicles) throws Exception{
		if (nVehicles<N_VEHICLES_MAX+1) {
			this.nVehicles=nVehicles;
		}else{
			throw new Exception("Maximo 4 vehiculos");
		}
	}

	public void addVehicle(int n){
		if (this.nVehicles<N_VEHICLES_MAX) {
			if (n>0 && n<N_VEHICLES_MAX) {
				this.nVehicles+=n;
				if (this.nVehicles>N_VEHICLES_MAX) {
					this.nVehicles=N_VEHICLES_MAX;
				}
			}
		}
	}

	@Override
	public String toString(){
		return "Boing787\n"+super.toString()+"\nVehiculos: "+
		this.nVehicles+" (4 max.)\n";
	}

}