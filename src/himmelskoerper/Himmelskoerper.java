package himmelskoerper;

import gameObject.SpaceObject;

/**
 * Nat�rliche Himmelsk�rper, z.B. Sterne, Planeten, Monde, etc.
 * Besitzt die Form einer Kugel
 *  
 * @author Thomas
 *
 */
public abstract class Himmelskoerper extends SpaceObject 
{
	/**
	 * Die Masse des K�rpers in Kg
	 */
	private float masse;
	
	/**
	 * Radius des K�rpers
	 */
	private float radius;
	
	/**
	 * gravitation (ergibt sich aus der Masse)
	 */
	private float gravitation;
	
	/**
	 * Zeit, die f�r eine Umdrehung um sich selbst ben�tigt wird.
	 * Bei 0: keine Rotation
	 */
	private float rotationsZeit;
	
	/**
	 * Berechnet position und ausrichtung, abh�ngig von einem vergangenen Zeitintervall
	 * 
	 * @param zeitIntervall : Zeit die vergangen ist, und f�r die Berechnungen gemacht werden sollem
	 */
	abstract void bewegen(int zeitIntervall);
}
