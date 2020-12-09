package calculator;
import exceptions.NotSupportedOperationException;
import exceptions.NumberNotInAreaException;
import exceptions.PowerException;

public class CalculatorAdvanced extends Calculator{
	
	int factorial(int number) {
		int fact = 1;
		for(int i=1;i<=number;i++)
			fact *= i;
		return fact;
	}
	
	int power(int base, int exponent) {
		int power = 1; 
        for (int i = 1; i <= exponent; i++) 
            power *= base; 
        return power; 
	}
	
	public void calculateAdvanced(char action) {
		//Take integer value
		Integer intCurrentValue = this.getCurrentValue().intValue();
		
		if(action == '!') {
			try {
				if(intCurrentValue > 10 || intCurrentValue < 0)
				{
					String message = "Number is out of range!";
					var exc = new NumberNotInAreaException(message);
					throw exc;
				}
			}catch(NumberNotInAreaException exc) {
				exc.printStackTrace();
			}
			//Calculate factorial 
			this.setCurrentValue((double) this.factorial(intCurrentValue));
			return;
		}
		
		//Get numeric value of action
		int actionNumericValue = Character.getNumericValue(action);
		
		try {
			if(actionNumericValue < 1 || actionNumericValue > 100 || this.getCurrentValue() < 1) {
				String message = "Number not in allowed range!";
				var exc = new PowerException(message);
				throw exc;
			}
		}catch(PowerException exc) {
			exc.printStackTrace();
		}
		//Calculate power
		this.setCurrentValue((double) this.power(intCurrentValue, actionNumericValue));	
	}
	
	
	public Boolean hasCharacteristic(char value) {
		//Take integer value
		Integer intCurrentValue = this.getCurrentValue().intValue();
		
		if(value == 'A') {
			try {
				if(intCurrentValue < 1) {
					String message = "Number is out of range!";
					var exc = new NumberNotInAreaException(message);
					throw exc;
				}
			}catch(NumberNotInAreaException exc) {
				exc.printStackTrace();
				return false;
			}
			//CheckIfArmstrong
		}
		else if(value == 'P') {
			try {
				if(intCurrentValue < 1) {
					String message = "Number is out of range!";
					var exc = new NumberNotInAreaException(message);
					throw exc;
				}
			}catch(NumberNotInAreaException exc) {
				exc.printStackTrace();
				return false;
			}
			//CheckIfPerfect
		}
		else {
			try {
				String message = "Operation is not supported by the calculator!";
				var exc = new NotSupportedOperationException(message);
				throw exc;
			}catch(NotSupportedOperationException exc) {
				exc.printStackTrace();
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
