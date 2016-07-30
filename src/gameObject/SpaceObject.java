package gameObject;

import java.util.Vector;

/**
 * Ein kugelförmiges Objekt mit Masse und einer Position im Raum;
 *  natürlichen Ursprungs oder auch nicht
 * 
 * @author Thomas
 * @version 1.0
 */
public class SpaceObject 
{
	/**
	 * Masse des Objekts in Kg 
	 */
	private float masse;
	
	/**
	 * Radius des Kugelförmigen Objekts
	 */
	private float radius;
	
	/**
	 * Position der aktuellen Sektion (Sonnensystem) in Polarkoordinaten
	 */
	private Vector<Float> position;

	/**
	 * @return die masse
	 */
	public float getMasse() {
		return masse;
	}
	
	/**
	 * @param masse setzt die masse
	 */
	public void setMasse(float masse) {
		this.masse = masse;
	}

	/**
	 * @return the radius
	 */
	public float getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(float radius) {
		this.radius = radius;
	}

	/**
	 * @return the position
	 */
	public Vector<Float> getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(float r, float angleXY, float angleYZ) {
		Vector<Float> positionsVektor = new Vector<Float>(3);
		
		positionsVektor.set(0, r);
		positionsVektor.set(1, angleXY);
		positionsVektor.set(2, angleYZ);
		
		this.position = positionsVektor;
	}
}
