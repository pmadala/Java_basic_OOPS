package learningJavabasic.generator;

import java.io.FileNotFoundException;
import java.util.List;

import learningJavabasic.model.Rental;

/**
 * A class representing PDF statement generator
 * @author priyambadam
 *
 */
public class PDFStatementGenerator extends StatementGeneratorAbstract{

	@Override
	public void generateStatement(List<Rental> rentals, String customerName) {
		System.out.println("PDF statement generated.");
		
		try {
			generateOutputStream(rentals, customerName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	protected String getType() {
		return StatementGeneratorType.Email.toString();
	}

}
