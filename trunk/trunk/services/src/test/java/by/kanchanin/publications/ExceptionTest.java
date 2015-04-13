package by.kanchanin.publications;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import by.kanchanin.ex.CatchableException;

public class ExceptionTest {
	
	private Logger LOGGER = LoggerFactory.getLogger(ExceptionTest.class);

	public static void main(String[] args) {
		ExceptionTest test = new ExceptionTest();
		test.testMethod();
	}

	private void testMethod() {
		try {
			readFile();
		} catch (CatchableException e) {

			throw new RuntimeException(e);
		}
	}

	private void readFile() throws CatchableException {

	}


}
