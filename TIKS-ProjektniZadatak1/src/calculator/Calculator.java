package calculator;

import exceptions.DivisionByZeroException;
import exceptions.NotSupportedOperationException;

public class Calculator {
	private Double currentValue;
	
	public void setCurrentValue(Double value) {
		this.currentValue = value;
	}
	public Double getCurrentValue() {
		return this.currentValue;
	}
	
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
				//throw exception if dividing by zero
				try {
					if(value == 0) {
						String message = "Division by zero!";
						var exc = new DivisionByZeroException(message);
						throw exc;
					}
				}catch(DivisionByZeroException exc) {
					exc.printStackTrace();
				}
				break;
			default:
				//throw exception
				try {
					String message = "Operation is not supported by the calculator!";
					var exc = new NotSupportedOperationException(message);
					throw exc;
				}catch(NotSupportedOperationException exc) {
					exc.printStackTrace();
				}
		}
	}
}
