package learningJavabasic.generator;

import java.util.List;

import learningJavabasic.model.Rental;

/**
 * An interface for representing all the statement generators 
 * @author priyambadam
 *
 */
public interface StatementGenerator {

	/**
	 * 
	 * wrapper method to generate the customised statement 
	 *
	 * @param rentals
	 * @param customerName
	 */
	public void generateStatement(List<Rental> rentals, String customerName); 
}
