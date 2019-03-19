package airlines.classes.objects;
import airlines.classes.auxiliaries.IDs;
import airlines.classes.persons.Client;

/**
 * Clase para crear objetos Tickets.
 * @author Lidia Garrido Morenos
 * @version 1.0
 */
public class Ticket {

    public static final boolean BOUGHT_DEF = false;

    public IDs id;
    public Flight flight;
    public Site site;
    public double price;
    public Client client;
    public boolean bought;


    public Ticket(Flight fl, Site si) {
        this.flight = fl;
        this.site = si;
        this.setPrice(fl.priceBase,site);
        this.client = null;
        this.bought=BOUGHT_DEF;
        //this.setID(fl,si);
    }

    /** Setter para comprobar si el Tickest esta comprado */
    public void setBought() {  
        if (this.client != null) {
            this.bought = true;
        }
    }

    /** Setter para los precios del Ticket */
    public void setPrice(double price, Site site){
        if (site.vip) {
            price=price+(price*20/100);
            this.price=price;
        }else{
            this.price=price;
        }
    }

    //public void setID(Flight fl, Site si){
    //    IDs myid=new IDs(fl,si.row,si.letter);
    //    this.id=myid;
    //}

    @Override
    public String toString(){
        return this.id.id;
    }
}