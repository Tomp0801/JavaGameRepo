package himmelskoerper;

/**
 * Ein Himmelskörper, der um einen Stern rotiert und der Monde besitzen kann
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
	
	
	@Override
	void bewegen(int zeitIntervall) {
		// TODO Auto-generated method stub
		
	}

}
