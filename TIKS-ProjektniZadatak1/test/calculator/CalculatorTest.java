package calculator;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import exceptions.DivisionByZeroException;
import exceptions.NotSupportedOperationException;

//Hamcrest
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThrows;
import static org.hamcrest.MatcherAssert.assertThat;




@DisplayName("Calculator Class Tests")
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class CalculatorTest {
	
	//Create a calculator object
	private Calculator calc = new Calculator();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
		//System.out.println(calc.getCurrentValue());
	}

	@Test
	@DisplayName("Constructor Test")
	@EnabledOnOs({OS.LINUX, OS.WINDOWS, OS.MAC})
	void testCalculator() {
		assertThat(calc, is(not(equalTo(null))));
	}
	
	@Test
	@DisplayName("Getter Test")
	void testGetCurrentValue() {
		calc.setCurrentValue(10.0);
		assertThat(Double.valueOf(10.0), is(equalTo(calc.getCurrentValue())));
	}
	
	@Test
	@DisplayName("Setter test")
	void testSetCurrentValue() {
		calc.setCurrentValue(5.0);
		assertThat(Double.valueOf(5.0), is(equalTo(calc.getCurrentValue())));
	}
	
	@ParameterizedTest
	@DisplayName("Method calculate() Test")
	@MethodSource("methodWithParameters")
	void testCalculate(Double current, Double value, char operator, Double expectedValue) throws DivisionByZeroException, NotSupportedOperationException {
		calc.setCurrentValue(current);
		try {
			calc.calculate(value, operator);
		} catch (DivisionByZeroException e) {
			//e.printStackTrace();
		} catch (NotSupportedOperationException e) {
			//e.printStackTrace();
		}
		assertThat(calc.getCurrentValue(), is(equalTo(expectedValue)));
	}
	private static Stream<Arguments> methodWithParameters() {
		return Stream.of(
				Arguments.of(5.0 ,6.0,'+', 11.0),
				Arguments.of(5.32, 0.32,'-',5.00),
				Arguments.of(7.0,3.0,'*',21.00),
				Arguments.of(8.0,4.0,'/',2.00),
				Arguments.of(0.0,4.0,'/',0.00),
				Arguments.of(8.0,0.0,'/',8.00),
				Arguments.of(0.0,0.0,'/',0.00),
				Arguments.of(7.0,2.00,'С',7.00));
		}
	
	@Test
	@DisplayName("Calculator Exception Test")
	void testCalculateException() throws DivisionByZeroException, NotSupportedOperationException{
		
		//Test division by zero exception
		calc.setCurrentValue(8.00);
        Exception exception1 = assertThrows(DivisionByZeroException.class,() -> calc.calculate(0.0, '/'));
        assertThat(exception1, is(instanceOf(DivisionByZeroException.class)));
        
      //Test not supported operation exception
      		calc.setCurrentValue(8.00);
              Exception exception2 = assertThrows(NotSupportedOperationException.class,() -> calc.calculate(2.00, '$'));
              assertThat(exception2, is(instanceOf(NotSupportedOperationException.class)));
	}
}
