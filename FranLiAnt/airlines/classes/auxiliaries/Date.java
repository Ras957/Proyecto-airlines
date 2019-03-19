package airlines.classes.auxiliaries; 
/**
*   Clase que crea objetos tipo Date que nos servirán para 
*   controlar fecha y hora.
*   @author Francisco Miguel Carrasquilla Rodríguez-Córdoba
*   @version 1.0
*/
public class Date{

	private static final int DAY_DEF=1;
	private static final int DAY_MAX_DEF1=30;
	private static final int DAY_MAX_DEF2=31;
	private static final int DAY_MAX_DEF3=28;
	private static final int DAY_MAX_DEF4=29;
	private static final int MONTH_DEF=1;
	private static final int MONTH_MAX_DEF=12;
	private static final int YEAR_DEF=1900;
	private static final int YEAR_MAX_DEF=2100;
	private static final int HOUR_DEF=0;
	private static final int HOUR_MAX_DEF=23;
	private static final int MINUTE_DEF=0;
	private static final int MINUTE_MAX_DEF=59;

	private int day;
	private int month;
	private int year;
	private int hour;
	private int minute;
    public boolean withDate;
    public boolean withHour;

	public Date() throws Exception{
		this(DAY_DEF,MONTH_DEF,YEAR_DEF,HOUR_DEF,MINUTE_DEF);
	}
/** Constructor formato DD/MM/YYYY */
	public Date(int day, int month, int year) throws Exception{
		this(day,month,year,HOUR_DEF,MINUTE_DEF);
        this.withHour=false;
	}
/** Constructor formato DD/MM/YYYY HH:MM */
	public Date(int day, int month, int year, int hour, int minute) throws Exception{
		setDate(day,month,year);
		setTime(hour,minute);
        this.withDate=true;
        this.withHour=true;
	}
/** Constructor formato HH:MM */
    public Date(int hour, int minute) throws Exception{
        setTime(hour,minute);
        this.withDate=false;
        this.withHour=true;
    }

/**
*   Setter para comprobar que la fecha es correcta.
*   @param day día.
*   @param month mes.
*   @param year año.
*/
	public void setDate(int day, int month, int year) throws Exception{
		if ((validateYear(year)) && (validateMonth(month))) {
			this.year=year;
			this.month=month;
			if (validateDay(day,month,year)) {
				this.day=day;
			}
		}else{
			throw new Exception("Fecha no valida");
		}
	}
/**
*   Setter para comprobar que la hora es correcta.
*   @param hour horas.
*   @param min minutos.
*/
	public void setTime(int hour, int min) throws Exception{
		if (validateHour(hour) && validateMinute(min)) {
			this.hour=hour;
			this.minute=min;
		}else{
			throw new Exception("Hora no valida");
		}
	}

	public int getDay(){
		return this.day;
	}	
	public int getMonth(){
		return this.month;
	}	
	public int getYear(){
		return this.year;
	}
	public int getHour(){
		return this.hour;
	}
	public int getMinute(){
		return this.minute;
	}
/**
*   @param year año.
*   @return devuelve true si el año es válido.
*/
	public boolean validateYear(int year) {
        boolean validYear=false;
        if (year>=YEAR_DEF && year<=YEAR_MAX_DEF){
        	validYear=true;
        }
        return validYear;
    }
/**
*   @param month mes.
*   @return devuelve true si el mes es válido.
*/
    public boolean validateMonth(int month) {
        boolean validMonth=false;
        if (month>=MONTH_DEF && month<=MONTH_MAX_DEF){
        	validMonth=true;
        }
        return validMonth;
    }
/**
*   @param day día.
*   @param month mes.
*   @param year año.
*   @return devuelve true si el día es válido.
*/
    public boolean validateDay(int day, int month, int year) {
        boolean validDay=false;
        switch (month) {
            case 2:
                if (isLeap(year)) {
                	if (day>=DAY_DEF && day<=DAY_MAX_DEF4){
                		validDay=true;
                	}
                }else {
                    if (day>=DAY_DEF && day<=DAY_MAX_DEF3){
                		validDay=true;
                	}
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day>=DAY_DEF && day<=DAY_MAX_DEF1){
                		validDay=true;
                }
                break;
            default:
                if (day>=DAY_DEF && day<=DAY_MAX_DEF2){
                		validDay=true;
                	}
        }
        return validDay;
    }

/**
*   @param year año.
*   @return devuelve true si el año es bisiesto.
*/
    private boolean isLeap(int year) {
    	boolean validLeap=false;
        if ((year%4==0 && year%100!=0) || year%400==0){
        	validLeap=true;
        }
        return validLeap;
    }
/**
*   @param hour hora.
*   @return devuelve true si la hora es válida.
*/
    public boolean validateHour(int hour) {
        boolean validHour=false;
        if (hour>=HOUR_DEF && hour<=HOUR_MAX_DEF){
        	validHour=true;
        }
        return validHour;
    }
/**
*   @param min minuto.
*   @return devuelve true si el minuto es válido.
*/
    public boolean validateMinute(int min) {
        boolean validMinute=false;
        if (min>=MINUTE_DEF && min<=MINUTE_MAX_DEF){
        	validMinute=true;
        }
        return validMinute;
    }

    public void nextDay() {
        this.day++;
        if (!validateDay(this.day,this.month,this.year)) {
            this.day = 1;
            this.month++;
            if (!validateDay(this.day,this.month,this.year)) {
                this.month = 1;
                this.year++;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        if (this.withDate) {
            if (this.day < 10) {
                sb.append("0");
            }
            sb.append(this.day);
            sb.append("/");
            if (this.month < 10) {
                sb.append("0");
            }
            sb.append(this.month);
            sb.append("/");
            sb.append(this.year);
        }
        if (this.withHour) {
            sb.append(" ");
            if (this.hour < 10) {
                sb.append("0");
            }
            sb.append(this.hour);
            sb.append(":");
            if (this.minute < 10) {
                sb.append("0");
            }
            sb.append(this.minute);
        }
        return sb.toString();
    }


}