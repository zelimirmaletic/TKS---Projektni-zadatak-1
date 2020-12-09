package calculator;
import exceptions.NotSupportedOperationException;
import exceptions.NumberNotInAreaException;
import exceptions.PowerException;

/**
 * This class extends Calculator class and implements advanced 
 * operations.
 * @author Želimir Maletić
 * @version 1.0
 * @since 2020-12-9
 * @see calculator.Calculator
 */
public class CalculatorAdvanced extends Calculator{
	
	/**
	 * Method which calculates power and factorial.
	 * @param action Action to be performed. Allowed values are
	 * ! or number in range from 1 to 100.
	 */
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
				return;
			}
			//Calculate factorial 
			this.setCurrentValue((double) factorial(intCurrentValue));
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
			return;
		}
		//Calculate power
		this.setCurrentValue((double) power(intCurrentValue, actionNumericValue));	
	}
	
	/**
	 * Method which checks whether a number is Armstrong or perfect.
	 * @param value Value for which method checks if it is an Armstrong
	 * or a perfect number. Allowed values are 'P' and 'A'
	 * @return Returns true if number is Armstrong or perfect 
	 * according to operation chosen when the method is called.
	 * @throws NumberNotInAreaException If Calculator.currentValue is less than 1
	 * this exception is thrown.
	 * @see calculator.Calculator
	 * @throws NotSupportedOperationException This exception is thrown if
	 * we enter values that are different from allowed ones: {'A', 'P'}.
	 */
	public Boolean hasCharacteristic(char value) throws NumberNotInAreaException,NotSupportedOperationException {
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
			//Check if Armstrong
			return isArmstrong(intCurrentValue);
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
			//Check if Perfect
			return isPerfect(intCurrentValue);
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
	
	/**
	 * Simple static method which returns factorial of given number.
	 * @param number Number for which factorial is calculated.
	 * @return Returns calculated factorial value.
	 */
	static int factorial(int number) {
		int fact = 1;
		for(int i=1;i<=number;i++)
			fact *= i;
		return fact;
	}
	
	/**
	 * Simple static method which returns given number raised to desired power.
	 * @param number Number for which we calculate power.
	 * @param exponent Exponent on which we rise number.
	 * @return Returns number raised to exponent.
	 */
	static int power(int number, int exponent) {
		int power = 1; 
        for (int i = 1; i <= exponent; i++) 
            power *= number; 
        return power; 
	}
	
	/**
	 * Simple static method which checks if given number is Armstrong or not.
	 * @param number Number for which we check if it is an Armstrong one.
	 * @return Returns true if number is Armstrong, otherwise returns false.
	 */
	static boolean isArmstrong(int number) {
	    int c=0,a,temp;  
	    temp=number;  
	    while(number>0)  
	    {  
	    	a=number%10;  
	    	number=number/10;  
	    	c=c+(a*a*a);  
	    }  
	    if(temp==c)  
	    	return true;  
	    else  
	       return false;
	}
	
	/**
	 * Simple static method which checks if given number is perfect or not.
	 * @param number Number for which we check if it is a perfect one.
	 * @return Returns true if number is perfect, otherwise returns false.
	 */
	static boolean isPerfect(int number) {
		long sum=0;	   	 
		int i=1;
		while(i<=number/2)
		{
			if(number%i==0){
				sum+=i;
			}
			i++;
		}
		if(sum==number)
			return true;
		else
			return false;
	}
}
