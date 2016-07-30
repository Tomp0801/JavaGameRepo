package himmelskoerper;

import java.util.Vector;

import gameObject.SpaceObject;

/**
 * Eine abstrakte Klasse für Objekte, die sich im Orbit um ein anderes Objekt befinden
 * In dieser Klasse werden für den Orbit wichtige Parameter definiert
 * außerdem ist die Methode bewegen definiert
 *
 * TODO Rotation?
 *
 * @author Thomas
 * @version 2.0
 * @param <BezugsKoerperKlasse>	Körper, um den das Objekt sich kreist
 */
public abstract class InOrbit<Orbitable> extends SpaceObject {
	/**
	 * entfernung des Objekts zu seinem BezugsObjekt
	 */
	private float orbitRadius;
	
	/**
	 * Körper, um den das Objekt kreist
	 */
	private Orbitable bezugsKoerper; 
	
	/**
	 * Bewegungsvektor, Bezugspunkt ist das Objekt, 90° zu Positionsvektor
	 * Einheit: m/s
	 */
	private Vector<Float> bewegungsVektor;
	
	/**
	 * Geschwindigkeit, mit der sich der Planet bewegt
	 * in m/s Länge des bewegungsVektors
	 */
	private float bewegungsGeschwindigkeit;
	
	/**
	 * Zeitpunkt der Letzten Positions- und Zustandsberechnung
	 */
	private long lastRefresh;

	/**
	 * Standardkonstruktor für inOrbit Objekt
	 * 
	 * @param bezugsKörper der Körper, um den das Objekt kreist
	 * @param distanz die Distanz, mit der das Objekt den Körper umkreist
	 * @param masse Masse des Objekts
	 */
	public InOrbit(Orbitable bezugsKoerper, float distanz, float masse) {
		this.setBezugsKoerper(bezugsKoerper);
		this.setOrbitRadius(distanz);
		this.setMasse(masse);
		
		/*
		 * Bewegungsgeschwindigkeit v:
		 * v = sqrt(masseBezugsStern * Gravitationskonstante / orbitRadius)
		 * ergibt sich aus der Gleichsetzung von Zentrifugal- und Gravitationskraft
		 */
		float v = (float) Math.sqrt(((SpaceObject) bezugsKoerper).getMasse() * Constants.G / getOrbitRadius());
		//TODO für 3D abändern
		int random = (int)Math.round(Math.random()) * 2 - 1;	//zufallszahl: +1 oder -1
		setBewegungsVektor(random * v, (float)0); //für 2D nur x-Teil des Vektors einstellen 
		
		//TODO an zufälliger Position um den Stern herum platzieren
		
		//TODO add to bezugsKörper
	
		setLastRefresh(System.currentTimeMillis());	//last Refresh initialisieren
	}
	
	
	/**
	 * @return the orbitRadius
	 */
	public float getOrbitRadius() {
		return orbitRadius;
	}

	/**
	 * @param orbitRadius the orbitRadius to set
	 */
	protected void setOrbitRadius(float orbitRadius) {
		this.orbitRadius = orbitRadius;
	}

	/**
	 * @return the bezugsKoerper
	 */
	public Orbitable getBezugsKoerper() {
		return bezugsKoerper;
	}

	/**
	 * @param bezugsKoerper the bezugsKoerper to set
	 */
	protected void setBezugsKoerper(Orbitable bezugsKoerper) {
		this.bezugsKoerper = bezugsKoerper;
	}

	/**
	 * @return the bewegungsVektor
	 */
	public Vector<Float> getBewegungsVektor() {
		return bewegungsVektor;
	}

	/**
	 * @param bewegungsVektor the bewegungsVektor to set
	 */
	protected void setBewegungsVektor(float bewegungX, float bewegungY) {
		Vector<Float> bewegungsVektor = new Vector<Float>(2);
		
		bewegungsVektor.set(0, bewegungX);
		bewegungsVektor.set(1, bewegungY);
		
		this.bewegungsVektor = bewegungsVektor;
	}

	/**
	 * @return the bewegungsGeschwindigkeit
	 */
	public float getBewegungsGeschwindigkeit() {
		return bewegungsGeschwindigkeit;
	}
	
	/**
	 * @return lastRefresh
	 */
	protected long getLastRefresh() {
		return lastRefresh;
	}

	/**
	 * @param lastRefresh sets lastRefresh
	 */
	protected void setLastRefresh(long lastRefresh) {
		this.lastRefresh = lastRefresh;
	}

	/**
	 * bewegt das Objekt zur richtigen aktuellen Position
	 */
	public void bewegen() {
		long passedTime;
		long prevRefresh = lastRefresh;
		lastRefresh = System.currentTimeMillis();
		float angleX, angleY;
		float wegX, wegY;
		Vector<Float> position = this.getPosition(); 
		
		passedTime = lastRefresh - prevRefresh;
		
		
		//Berechnung des zurückgelegten weges in x-Richtung
		wegX = (float)passedTime / 1000 * bewegungsVektor.get(0);
		//Berechnung des Winkels in x-Richtung
		//Prozentsatz von 2pi : weg / Gesamt orbit länge
		angleX = 2 * (float)Math.PI * orbitRadius / wegX * 2 * (float)Math.PI;
		//Berechnung des zurückgelegten weges in x-Richtung		
		wegY = (float)passedTime / 1000 * bewegungsVektor.get(1);
		//Berechnung des Winkels in x-Richtung
		//Prozentsatz von 2pi : weg / Gesamt orbit länge
		angleY = 2 * (float)Math.PI * orbitRadius / wegY * 2 * (float)Math.PI;
		
		//Winkel auf aktuelle Position addieren
		this.setPosition(orbitRadius, position.get(1) + angleX, position.get(2) + angleY);
		
	}
}
