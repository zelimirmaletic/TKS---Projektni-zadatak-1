import calculator.CalculatorAdvanced;
import exceptions.DivisionByZeroException;
import exceptions.NotSupportedOperationException;
import exceptions.NumberNotInAreaException;

public class Main {

	public static void main(String[] args) throws DivisionByZeroException, NotSupportedOperationException {
		var calc = new CalculatorAdvanced();
		
		calc.setCurrentValue(0.0);

		
		
	try {
		System.out.println(calc.hasCharacteristic('P'));
	} catch (NumberNotInAreaException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NotSupportedOperationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	
		
		
	}

}
