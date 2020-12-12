package calculator;
import exceptions.NotSupportedOperationException;
import exceptions.NumberNotInAreaException;

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
	 * ! or number in range from 0 to 9.
	 * @throws NumberNotInAreaException Thrown if we enter invalid action. Something different than '!'
	 * , or a digit from 0 to 9.
	 * @throws NotSupportedOperationException Thrown when invalid operation is entered.
	 */
	public void calculateAdvanced(char action) throws NumberNotInAreaException, NotSupportedOperationException {
		//Take integer value of currentValue
		Integer intCurrentValue = this.getCurrentValue().intValue();
		
		if(action == '!') {
				if(intCurrentValue < 0 || intCurrentValue > 10)
					throw new NumberNotInAreaException("Current value is out of range [0,10]!");
			//Calculate factorial 
			this.setCurrentValue((double)factorial(intCurrentValue));
			return;
		}
		else if(action < 0x30 || action > 0x39)
			throw new NotSupportedOperationException("Operation is not supported by the calculator!");
		else {
			//Calculate power
			this.setCurrentValue((double) power(intCurrentValue, Character.getNumericValue(action)));
			return;
		}
			
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
		//Take integer value of currentValue
		Integer intCurrentValue = this.getCurrentValue().intValue();
		
		if(intCurrentValue < 1)
			throw new NumberNotInAreaException("Number is out of range!");
		
		if(value == 'A') {
			//Check if Armstrong
			return (Boolean)isArmstrong(intCurrentValue);
		}
		else if(value == 'P') {
			//Check if Perfect
			return (Boolean)isPerfect(intCurrentValue);
		}
		else
			throw new NotSupportedOperationException("Operation is not supported by the calculator!");
		//In any other case return false
		//return (Boolean)false;
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
		if (exponent == 0)
			return 1;
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
	static Boolean isArmstrong(int number) {
		if(number == 1)
			return true;
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
	    return false;
	}
	
	/**
	 * Simple static method which checks if given number is perfect or not.
	 * @param number Number for which we check if it is a perfect one.
	 * @return Returns true if number is perfect, otherwise returns false.
	 */
	static Boolean isPerfect(int number) {
		if(number == 1)
			return false;
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
		return false;
	}
}
