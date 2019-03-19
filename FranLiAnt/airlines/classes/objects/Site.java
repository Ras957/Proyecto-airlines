package airlines.classes.objects;
/**
*	Clase que crea objetos tipo Site(sitio o asiento) del avión.
*	@author Francisco Miguel Carrasquilla Rodríguez-Córdoba
*	@version 1.0
*/

public class Site{
	
	public int row;
	public char letter;
	public boolean vip;

	public Site(int row, char letter, int nVIP){
		this.setRows(row,nVIP);
		this.setLetter(letter);
	}

	/**
	*	Método para validar que el número de filas sea un entero
	*	y lo mismo con el número de filas VIP.
	*	@param row número de filas.
	*	@param nVIP número de filas VIP.
	*/
	public void setRows(int row, int nVIP){
		this.row=row;
		if (this.row<=nVIP) {
			this.vip=true;
		}else{
			this.vip=false;
		}

	}

	/**
	*	Método para validar que el número de columnas.
	*	@param letter letra de la última columna.
	*/
	public void setLetter(char letter){
		String aux = Character.toString(letter);
		aux.toUpperCase();
		char l = aux.charAt(0);
		this.letter=l;
	}

	@Override
    public String toString() {
    	StringBuilder sb=new StringBuilder();
    	sb.append("[");
    	if (this.row < 10) {
                sb.append("0");
            }
        sb.append(this.row);
        sb.append(this.letter);
        sb.append("]");
        return sb.toString();
    }
}