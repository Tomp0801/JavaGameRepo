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
public abstract class InOrbit extends SpaceObject {
	/**
	 * entfernung des Objekts zu seinem BezugsObjekt
	 * in km
	 */
	private double orbitRadius;
	
	/**
	 * Körper, um den das Objekt kreist
	 */
	private Orbitable bezugsKoerper; 
	
	/**
	 * Bewegungsvektor, Bezugspunkt ist das Objekt, 90° zu Positionsvektor
	 * Einheit: km (pro s)
	 */
	private Vector<Float> bewegungsVektor;
	
	/**
	 * Geschwindigkeit, mit der sich der Planet bewegt
	 * in km/s Länge des bewegungsVektors
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
	public InOrbit(Orbitable bezugsKoerper, double distanz, double masse) {
		this.setBezugsKoerper(bezugsKoerper);
		this.setOrbitRadius(distanz);
		this.setMasse(masse);
		
		/*
		 * Bewegungsgeschwindigkeit v:
		 * v = sqrt(masseBezugsStern * Gravitationskonstante / orbitRadius)
		 * ergibt sich aus der Gleichsetzung von Zentrifugal- und Gravitationskraft
		 * Einheit: km pro s
		 */
		float v = (float) Math.sqrt(((SpaceObject) bezugsKoerper).getMasse() * Constants.G / getOrbitRadius());
		//TODO für 3D abändern
		int random = (int)Math.round(Math.random()) * 2 - 1;	//zufallszahl: +1 oder -1
		setBewegungsVektor(random * v, (float)0); //für 2D nur x-Teil des Vektors einstellen 
		
		//TODO an zufälliger Position um den Stern herum platzieren
		this.setPosition(orbitRadius, 0, 0);
		
		//dem Bezugskörper hinzufügen
		bezugsKoerper.add(this);
	
		setLastRefresh(System.currentTimeMillis());	//last Refresh initialisieren
	}
	
	
	/**
	 * @return the orbitRadius
	 */
	public double getOrbitRadius() {
		return orbitRadius;
	}

	/**
	 * @param orbitRadius the orbitRadius to set
	 */
	protected void setOrbitRadius(double orbitRadius) {
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
		
		bewegungsVektor.add(bewegungX);
		bewegungsVektor.add(bewegungY);
		
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
		double angleX, angleY;
		double wegX, wegY;
		Vector<Double> position = this.getPosition(); 
		
		passedTime = lastRefresh - prevRefresh;
		
		if (passedTime > 0) {
			//Berechnung des zurückgelegten weges in x- und y-Richtung
			wegX = passedTime / 1000 * bewegungsVektor.get(0);
			wegY = passedTime / 1000 * bewegungsVektor.get(1);
			//Berechnung des Winkels in x-Richtung und y-Richtung
			//Prozentsatz von 2pi : weg / Gesamt orbit länge
			angleX = 2 * Math.PI * wegX / (orbitRadius * 2 * Math.PI);
			angleY = 2 * Math.PI * wegY / (orbitRadius * 2 * Math.PI);
			
			//Winkel auf aktuelle Position addieren
			this.setPosition(orbitRadius, position.get(1) + angleX, position.get(2) + angleY);
		}
		
	}
}
