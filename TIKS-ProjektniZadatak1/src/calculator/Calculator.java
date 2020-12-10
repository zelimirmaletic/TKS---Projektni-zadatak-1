package calculator;

import exceptions.DivisionByZeroException;
import exceptions.NotSupportedOperationException;

/**
 * This class contains single method calculate() which performs
 * arithmetic operations.
 * @author Želimir Maletić
 * @version 1.0
 * @since 2020-12-9
 */
public class Calculator {
	private Double currentValue;
	
	/**
	 * Default constructor which sets initial value to 0.0.
	 */
	public Calculator() {
		currentValue = 0.0;
	}
	
	/**
	 * Setter method for currentValue.
	 * @param value Value to be set.
	 * @return void
	 */
	public void setCurrentValue(Double value) {
		this.currentValue = value;
	}
	
	/**
	 * Getter method for currentValue
	 * @return Returns current value stored in currentValue.
	 */
	public Double getCurrentValue() {
		return this.currentValue;
	}
	
	/**
	 * Method which performs basic arithmetic operations.
	 * Method also takes in account what values user has entered
	 * and responds to invalid inputs by resolving them through 
	 * exception handling.
	 * @param value Value for executing certain operation.
	 * @param operator Operator to be performed.
	 * @throws DivisionByZeroException Division by zero is not allowed.
	 * @throws NotSupportedOperationException If user enters invalid operator this exception is thrown.
	 */
	public void calculate(Double value, char operator) throws DivisionByZeroException, NotSupportedOperationException{
		switch(operator) {
			case '+':
				currentValue += value;
				break;
			case '-':
				currentValue -= value;
				break;
			case '*':
				currentValue *= value;
				break;
			case '/':
				//Throw an exception if dividing by zero
				try {
					if(value == 0) {
						String message = "Division by zero!";
						var exc = new DivisionByZeroException(message);
						throw exc;
					}
				}catch(DivisionByZeroException exc) {
					exc.printStackTrace();
					return;
				}
				currentValue /= value;
				break;
			default:
				//Throw an exception
				try {
					String message = "Operation is not supported by the calculator!";
					var exc = new NotSupportedOperationException(message);
					throw exc;
				}catch(NotSupportedOperationException exc) {
					exc.printStackTrace();
					return;
				}
		}
	}
}
