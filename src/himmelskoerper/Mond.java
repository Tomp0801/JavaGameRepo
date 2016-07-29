package himmelskoerper;

/**
 * Ein Himmelskörper, der um einen Planeten rotiert 
 * 
 * @author Thomas
 *
 */
public class Mond extends Himmelskoerper implements Bewohnbar, ImOrbit
{
	/**
	 * Bezugsplanet, um den sich der Mond dreht
	 */
	private Planet planet;
	
	
	@Override
	void refresh() {
		// TODO Auto-generated method stub
		
	}

}
