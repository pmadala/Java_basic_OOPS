package learningJavabasic.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import learningJavabasic.model.Rental;
import learningJavabasic.service.StatementService;

/**
 * Basic skeletal implementation of a statement generator 
 * @author priyambadam
 *
 */
public abstract class StatementGeneratorAbstract implements StatementGenerator {

	protected StatementService service = new StatementService();
	
	/**
	 * generate the statement with following details 
	 * @param rentals - list of rentals of a customer
	 * @param customerName
	 * @throws FileNotFoundException
	 */
	protected void generateOutputStream(List<Rental> rentals, String customerName) throws FileNotFoundException {

		FileOutputStream fop = null;
		File file;
		String content = service.fetchStatement(rentals, customerName);
		System.out.println(content);
		
		try {

			file = new File("statementFile"+getType()+".txt");

			if (!file.exists()) {
				file.createNewFile();
			}
			fop = new FileOutputStream(file);

			byte[] contentInBytes = content.getBytes();

			fop.write(contentInBytes);
			fop.flush();
			fop.close();

			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fop != null) {
					fop.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
	}

	protected String getType() {
		return "Basic";
	}
}
