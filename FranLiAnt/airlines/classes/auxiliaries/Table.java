package airlines.classes.auxiliaries;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import airlines.classes.objects.*;
import airlines.classes.persons.*;

public class Table{

	public static List<String> headerFlights;
	public static List<String> headerPlanes;
	public static List<String> headerEmployees;
	public static List<String> headerClients;
	
	public AirCompany company;

	public Table(AirCompany com){

		headerFlights=new ArrayList<>();
        headerFlights.add("Identificacion");
        headerFlights.add("Origen");
        headerFlights.add("Destino");
        headerFlights.add("Avion");
        headerFlights.add("Pilotos");
        headerFlights.add("Tripulacion");
        headerFlights.add("Precio Base");
        headerFlights.add("Duracion");

        headerPlanes=new ArrayList<>();
        headerPlanes.add("Matricula");
        headerPlanes.add("Fecha");
        headerPlanes.add("Modelo");

		headerEmployees=new ArrayList<>();
		headerEmployees.add("NumE");        
		headerEmployees.add("Tipo");
		headerEmployees.add("Nombre");
		headerEmployees.add("Apellido");
		headerEmployees.add("DNI");
		headerEmployees.add("Nacionalidad");          
		headerEmployees.add("FNac");
		headerEmployees.add("NumF");
		headerEmployees.add("Salario");
		headerEmployees.add("MdV");

		headerClients=new ArrayList<>();
		headerClients.add("Nombre");
		headerClients.add("Apellido");
		headerClients.add("DNI");
		headerClients.add("Nacionalidad");          
		headerClients.add("FNac");

        this.company=com;
	}

	/**
	*	Imprime la tabla con la matriz de string que se le pasa por
	*	parametro. Primero se calcula la anchura de la casilla y luego se 
	*   introduce el valor.
	*	@param table tabla a imprimir.
	*/
	public void printTable(String[][] table){
        List<Integer> lengths=new ArrayList<>();
        for (int i=0;i<table[0].length;i++) {
            int l=table[0][i].length();
            for (int j=0;j<table.length;j++) {
                if (table[j][i].length()>l) {
                    l=table[j][i].length();
                }
            }
            lengths.add(l);
        }
        System.out.println(this.generateSeparator(lengths));  
        for (int i=0;i<table.length;i++) {
            System.out.print("| ");
            for (int j=0;j<table[0].length;j++) {
                String aux = this.generateSpaces(lengths.get(j));
                aux = table[i][j]+aux.substring(table[i][j].length(),lengths.get(j));
                System.out.print(aux);
                System.out.print(" | ");
            }
            System.out.println("\n"+this.generateSeparator(lengths));
        }
    }

    /**
	*	Crea la tabla de aviones.
	*	@return devuelve la matriz con los datos de los aviones.
	*/
    public String[][] createTablePlane() throws Exception{
    String[][] tablePlanes=new String[company.planes.size()+1][headerPlanes.size()];
        for (int i=0;i<tablePlanes.length;i++) {
            for (int j=0;j<tablePlanes[0].length;j++) {
                if (i==0) {
                    tablePlanes[i][j]=headerPlanes.get(j);
                }else{
                    switch(j){
                        case 0: 
                            tablePlanes[i][j]=company.planes.get(i-1).register.id;
                        break;
                        case 1:
                            tablePlanes[i][j]=company.planes.get(i-1).acquisitionDate.toString();
                        break;
                        case 2:
                            if (company.planes.get(i-1) instanceof AirBusA320) {
                                tablePlanes[i][j]="AirBusA320";
                            }else if(company.planes.get(i-1) instanceof Boing787){
                                tablePlanes[i][j]="Boing787";
                            }else{
                                throw new Exception("Tipo de avion no valido");
                            } 
                        break;
                    }
                }
            }
        }
        return tablePlanes;
    }

    /**
	*	Crea la tabla de vuelos.
	*	@return devuelve la matriz con los datos de los vuelos.
	*/
    public String[][] createTableFlights(){
    	String[][] tableFlights=new String[company.flights.size()+1][headerFlights.size()];
    	boolean fullPilots=false, fullAircrews=false;
    	for (int i=0;i<tableFlights.length;i++) {
            for (int j=0;j<tableFlights[0].length;j++) {
            	if (i==0) {
                    tableFlights[i][j]=headerFlights.get(j);
                }else{
                    switch(j){   	
                        case 0: 
                            tableFlights[i][j]=company.flights.get(i-1).id.id;
                        break;
                        case 1:
                            tableFlights[i][j]=company.flights.get(i-1).originAirport.city;
                        break;
                        case 2:
                            tableFlights[i][j]=company.flights.get(i-1).destinationAirport.city;
                        break;
                        case 3:
                            tableFlights[i][j]=company.flights.get(i-1).plane.register.id;
                        break;
                        case 4:
                        	StringBuilder sb1=new StringBuilder();
	                        for (int l=0;l<company.flights.get(i-1).myPilots.length;l++) {
								if (company.flights.get(i-1).myPilots[l]!=null) {
										sb1.append(company.flights.get(i-1).myPilots[l].name);
									if (l<company.flights.get(i-1).myPilots.length-1) {
										sb1.append(", ");
									}
								}
							}
							tableFlights[i][j]=sb1.toString();
                        break;
                        case 5:
                        	StringBuilder sb2=new StringBuilder();
	                        for (int k=0;k<company.flights.get(i-1).myCrew.length;k++) {
								if (company.flights.get(i-1).myCrew[k]!=null) {
									sb2.append(company.flights.get(i-1).myCrew[k].name);
									if (k<company.flights.get(i-1).myCrew.length-1) {
										sb2.append(", ");
									}
								}
							}
							tableFlights[i][j]=sb2.toString();
                        break;
                        case 6:
                            tableFlights[i][j]=String.valueOf(company.flights.get(i-1).priceBase);
                        break;
                        case 7:
                            tableFlights[i][j]=Integer.toString(company.flights.get(i-1).duration);
                        break;
                    }
                }
            }
        }
        return tableFlights;
    }

    /**
	*	Crea la tabla de empleados.
	*	@return devuelve la matriz con los datos de los empleados.
	*/
    public String[][] createTableEmployee()throws Exception{
    	String[][] tableEmployees=new String[company.employees.size()+1][headerEmployees.size()];
    	for (int i=0;i<tableEmployees.length;i++) {
            for (int j=0;j<tableEmployees[0].length;j++) {
            	if (i==0) {
                    tableEmployees[i][j]=headerEmployees.get(j);
                }else{
                	switch(j){
                		case 0:
                			tableEmployees[i][j]=String.valueOf(company.employees.get(i-1).numEmployee.id);
                		break;
                		case 1:
                			tableEmployees[i][j]=company.employees.get(i-1).getClass().getSimpleName();
                		break;
                		case 2:
                			tableEmployees[i][j]=company.employees.get(i-1).name;
                		break;
                		case 3:
                			tableEmployees[i][j]=company.employees.get(i-1).lastname;
                		break;
                		case 4:
                			tableEmployees[i][j]=company.employees.get(i-1).getDNI();
                		break;
                		case 5:
                			tableEmployees[i][j]=company.employees.get(i-1).nationality;
                		break;
                		case 6:
                			tableEmployees[i][j]=company.employees.get(i-1).birthdate.toString();
                		break;
                		case 7:
                			tableEmployees[i][j]=Integer.toString(company.employees.get(i-1).numFlights);
                		break;
                		case 8:
                			tableEmployees[i][j]=String.valueOf(company.employees.get(i-1).getTotalSalary());
                		break;
                		case 9:
                			if (company.employees.get(i-1) instanceof Pilot) {
                				Pilot tmp = (Pilot)company.employees.get(i-1);
                				tableEmployees[i][j]=Integer.toString(tmp.flightminutes);
                			}else if(company.employees.get(i-1) instanceof Aircrew){
                				tableEmployees[i][j]="";
                			}else{
                				throw new Exception("Empleado no valido");
                			}
                		break;
                	}
                }
            }
        }
        return tableEmployees;
    }

    /**
	*	Crea la tabla de clientes.
	*	@return devuelve la matriz con los datos de los empleados.
	*/
    public String[][] createTableClient(){
    	String[][] tableClients=new String[company.clients.size()+1][headerClients.size()];
    	for (int i=0;i<tableClients.length;i++) {
            for (int j=0;j<tableClients[0].length;j++) {
            	if (i==0) {
                    tableClients[i][j]=headerClients.get(j);
                }else{
                	switch(j){
                		case 0:
                			tableClients[i][j]=company.employees.get(i-1).name;
                		break;
                		case 1:
                			tableClients[i][j]=company.employees.get(i-1).lastname;
                		break;
                		case 2:
                			tableClients[i][j]=company.employees.get(i-1).getDNI();
                		break;
                		case 3:
                			tableClients[i][j]=company.employees.get(i-1).nationality;
                		break;
                		case 4:
                			tableClients[i][j]=company.employees.get(i-1).birthdate.toString();
                		break;
                	}
                }
            }
        }
        return tableClients;
    }

    /**
    *	Metodo que escribe espacios.
    *	@param n numero de espacios a impimir.
    *	@return devuelve el string de espacios.
    */
    public String generateSpaces(int n){
        String s="";
        for (int i=0;i<n;i++) {
            s+=" ";
        }
        return s;
    }

    /**
    *	Metodo que escribe -.
    *	@param n numero de - a impimir.
    *	@return devuelve el string de -.
    */
    public String generateStripes(int n){
        String s="";
        for (int i=0;i<n;i++) {
            s+="-";
        }
        return s;
    }

	/**
    *	Metodo que escribe el separador de la tabla dependiendo
    * 	del arraylist que se le pase.
    *	@param ns arraylist de la tabla.
    *	@return devuelve el separador de la tabla.
    */
    public String generateSeparator(List<Integer> ns){
        String s="+";
        for (int i=0;i<ns.size();i++) {
            s+=this.generateStripes(ns.get(i)+2)+"+";
        }
        return s;
    }
}