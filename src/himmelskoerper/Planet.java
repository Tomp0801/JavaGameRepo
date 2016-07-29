package himmelskoerper;

/**
 * Ein Himmelskörper, der um einen Stern rotiert und der Monde besitzen kann
 * 
 * Der bezugsstern bildet den Ursprung des Koordinatensystems für 
 * dieses Sonnensystem
 * 
 * @author Thomas
 *
 */
public class Planet extends Himmelskoerper implements Bewohnbar, ImOrbit
{
	/**
	 * Art des Planeten. Möglichkeiten: "gas", "fest"
	 */
	private String typ; 
	
	/**
	 * Bezugsstern, um den der Planet rotiert
	 */
	private Stern sonne;
	
	/**
	 * Distanz zum Bezugsstern; Radius des Orbits
	 * in Km
	 */
	private float orbitRadius;
	
	/**
	 * Geschwindigkeit in m/s, wie schnell sich der Planet bewegt
	 */
	private float orbitSpeed;
	
	/**
	 * Winkel zu der positiven x-Achse. Für die Angabe der Position in Polarform
	 */
	private float orbitWinkel;
	
	/**
	 * Constructor
	 * 
	 * @param winkel : Winkel zur positiven x-Achse, bei dem der Planet startet
	 */
	public Planet(float winkel)
	{
		orbitWinkel = winkel;
		
		lastRefresh = System.currentTimeMillis();
	}
	
	@Override
	void refresh() {
		
		
		lastRefresh = System.currentTimeMillis();		//letzten Refreshzeitpunkt merken
	}

}
