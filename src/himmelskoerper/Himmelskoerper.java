package himmelskoerper;

import gameObject.SpaceObject;

/**
 * Natürliche Himmelskörper, z.B. Sterne, Planeten, Monde, etc.
 * Besitzt die Form einer Kugel
 *  
 * @author Thomas
 *
 */
public abstract class Himmelskoerper extends SpaceObject 
{
	/**
	 * Die Masse des Körpers in Kg
	 */
	private float masse;
	
	/**
	 * Radius des Körpers
	 */
	private float radius;
	
	/**
	 * gravitation (ergibt sich aus der Masse)
	 */
	private float gravitation;
	
	/**
	 * Zeit, die für eine Umdrehung um sich selbst benötigt wird.
	 * Bei 0: keine Rotation
	 */
	private float rotationsZeit;
	
	/**
	 * Speichert den letzten Zeitpunkt in dem die Position des Planeten berechnet wurde
	 */
	private long lastRefresh;
	
	
	/**
	 * Berechnet position und ausrichtung, seit dem letzten refresh
	 */
	abstract void refresh();
}
