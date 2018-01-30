package learningJavabasic.generator;

import java.io.FileNotFoundException;
import java.util.List;

import learningJavabasic.model.Rental;

/**
 * A class representing Email statement generator
 * @author priyambadam
 *
 */
public class EMailStatementGenerator extends StatementGeneratorAbstract{

	@Override
	public void generateStatement(List<Rental> rentals, String customerName) {
		System.out.println("Email statement generated.");
		
		try {
			generateOutputStream(rentals, customerName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected String getType() {
		return StatementGeneratorType.PDF.toString();
	}
}
