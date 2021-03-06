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
		//Set initial value to 0.0
		currentValue = 0.0;
	}
	
	/**
	 * Setter method for currentValue.
	 * @param value Value to be set.
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
				this.currentValue += value;
				break;
			case '-':
				this.currentValue -= value;
				break;
			case '*':
				this.currentValue *= value;
				break;
			case '/':
				if(value == 0)
					throw new DivisionByZeroException("An attpempt to divide by zero was executed!");
				//Divide currentValue by value
				this.currentValue /= value;
				break;
			default:
				throw new NotSupportedOperationException("Operation is not supported by the calculator!");
		}
	}
}
