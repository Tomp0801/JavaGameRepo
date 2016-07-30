package himmelskoerper;

import java.util.LinkedList;
import java.util.Vector;

/**
 * Ein Himmelskörper, bewohnbar, wenn fest
 * Umkreist einen Stern
 * 
 * TODO rotation klären
 * 
 * @author Thomas
 * @version 1.0
 */
public class Planet extends InOrbit implements Orbitable
{
	/**
	 * Liste der Monde des Planeten
	 */
	LinkedList<Mond> monde;
	
	/**
	 * aktueller Winkel 
	 */
	private float rotationsWinkel;
	
	/**
	 * Typ des Planeten : Gas oder Fest 
	 */
	private String typ;
	
	/**
	 * Konstruktor 
	 * @param bezugsKoerper
	 * @param distanz
	 * @param masse
	 * @param typ der Typ des Planeten (gas oder fest)
	 */
	public Planet(Stern bezugsKoerper, double distanz, double masse, String typ) {
		super(bezugsKoerper, distanz, masse);
		this.typ = typ;
	}
	
	/**
	 * @return the typ
	 */
	public String getTyp() {
		return typ;
	}

	/**
	 * berechnet die aktuelle Position und Ausrichtung des Planeten neu
	 */
	public void refresh()
	{
		this.bewegen();  //position aktualisieren
		//TODO Rotation
	}

	@Override
	public void add(InOrbit objectInOrbit) {
		// TODO Auto-generated method stub
		
	}
	
	/**********************************************************************************/
	/**
	 * Methode für Testzwecke
	 */
	public void printStatus() {
		Vector<Double> posErde = getPosition();
		System.out.print(getLastRefresh()/1000 + ": ");
		System.out.println(posErde.get(0) + " " + posErde.get(1) + " " + posErde.get(2));
	}
}
