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
	 * TODO Masse aus dem Radius des Objekts ermitteln
	 */
	private double masse;
	
	/**
	 * Radius des Kugelförmigen Objekts
	 */
	private float radius;
	
	/**
	 * Position der aktuellen Sektion (Sonnensystem) in Polarkoordinaten
	 */
	private Vector<Double> position;

	/**
	 * @return die masse
	 */
	public double getMasse() {
		return masse;
	}
	
	/**
	 * @param masse setzt die masse
	 */
	public void setMasse(double masse) {
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
	public Vector<Double> getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(double r, double angleXY, double angleYZ) {
		Vector<Double> positionsVektor = new Vector<Double>(3);
		
		positionsVektor.add(r);
		positionsVektor.add(angleXY);
		positionsVektor.add(angleYZ);
		
		this.position = positionsVektor;
	}
}
