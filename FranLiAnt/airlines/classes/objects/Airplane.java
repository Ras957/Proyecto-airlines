package airlines.classes.objects;
import airlines.classes.auxiliaries.IDs;
import airlines.classes.auxiliaries.Date;
/** 
*	Clase abstracta hecha para que hereden los tipos de aviones.
*	@author Francisco Miguel Carrasquilla Rodríguez-Córdoba
*	@version 1.0
*/
public class Airplane{

	public static final int ASCII_VALUE_A=65;
	
	public IDs register;
	public Date acquisitionDate;
	public double price;
	public float autonomy;  //Horas de vuelo sin repostar
	public float consumption;
	public int capacity;
	public Site[][] sites; //=new Site[this.numRows][(int)numLetters-ASCII_VALUE_A+1];

	protected Airplane(double price, float autonomy, float consumption, 
		int capacity, int numRows, int numRowsVIP, char numLetters){
		this.price=price;
		this.autonomy=autonomy;
		this.consumption=consumption;
		this.capacity=capacity;
		this.setSites(numRows,numRowsVIP,numLetters);
	}

	/** 
	* Setter para crear la matriz de asientos.
	* @param nr numero de filas. 
	* @param nrv numero de filas vip. 
	* @param letter letra de la ultima columna. 
	*/
	public void setSites(int nr, int nrv, char letter){
		Site[][] mySites=new Site[nr][(int)letter-ASCII_VALUE_A+1];
		for (int i=0;i<mySites.length;i++) {
			for (int j=0;j<mySites[0].length;j++) {
				int aux = ASCII_VALUE_A+j;
				mySites[i][j]=new Site(i+1,(char)aux,nrv);
			}
		}
		this.sites=mySites;
	}

	public Site[][] getSites(){
		return this.sites;
	}

	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		if (this.register!=null) {
			sb.append(this.register.id+"\n");
		}
		if (this.acquisitionDate!=null) {
			sb.append(this.acquisitionDate+"\n");
		}
		sb.append("Price: "+this.price);
		sb.append("\nAutnomy: "+this.autonomy);
		sb.append("\nConsumpton: "+this.consumption);
		sb.append("\nCapacity: "+this.capacity);
		return sb.toString();
	}
	
}