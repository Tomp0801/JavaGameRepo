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
	 * Berechnet position und ausrichtung, abhängig von einem vergangenen Zeitintervall
	 * 
	 * @param zeitIntervall : Zeit die vergangen ist, und für die Berechnungen gemacht werden sollem
	 */
	abstract void bewegen(int zeitIntervall);
}
