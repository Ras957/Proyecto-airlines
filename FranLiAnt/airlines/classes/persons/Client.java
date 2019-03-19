package airlines.classes.persons;
import java.util.Set;
import java.util.HashSet;
import airlines.classes.auxiliaries.Date;
import airlines.classes.objects.Ticket;

/**
*    Clase que crea objetos clientes 
*    @author Antonio Manuel Guerrero Trujillo
*    @version 1.0
*/
  public class Client extends Person{

    public static Set<String> dnis=new HashSet<>(); 

  //Constructor que le da valores a todos los atributos
    public Client(String n,String lm ,String d, String ny, Date bd) throws Exception{
      super(n,lm,d,ny,bd);
      if (this.dnis.add(d)) {
        this.dni=d;
      }else{
        this.dni=null;
        throw new Exception("Ya estas registrado como cliente.");
      } 
	  }

  /** 
  * Metodo que asigna el ticket al cliente.
  * @param tk ticket a comprar.
  * @return devuelve true si lo ha comprado.
  */
  public boolean buyTickets(Ticket tk){
    if(tk.client==null){
      tk.client=this;
      tk.bought=true;
    }
    return tk.bought;
  }

  @Override
  public String toString(){
    return super.toString();
  }

}
