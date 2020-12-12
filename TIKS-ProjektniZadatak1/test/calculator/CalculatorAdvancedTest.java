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

import exceptions.NotSupportedOperationException;
import exceptions.NumberNotInAreaException;

//Hamcrest
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThrows;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("CalculatorAdvanced Class Tests")
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class CalculatorAdvancedTest {
	
	CalculatorAdvanced calc = new CalculatorAdvanced();

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
	@DisplayName("Method calculateAdvanced() Test")
	@MethodSource("methodWithParameters1")
	void testCalculateAdvanced(Double current, char operator, Double expectedValue) throws NumberNotInAreaException, NotSupportedOperationException {
		calc.setCurrentValue(current);
		try {
			calc.calculateAdvanced(operator);
		} catch (NumberNotInAreaException e) {
			//e.printStackTrace();
		} catch (NotSupportedOperationException e) {
			//e.printStackTrace();
		}
		assertThat(calc.getCurrentValue(), is(equalTo(expectedValue)));
	}
	private static Stream<Arguments> methodWithParameters1() {
		return Stream.of(
				Arguments.of(5.2540 ,'!', 120.0),
				Arguments.of(0.0,'!',1.00),
				Arguments.of(1.0,'!',1.00),
				Arguments.of(10.0,'!',3628800.00),
				Arguments.of(-5.320, '!',-5.320),
				
				Arguments.of(3.0, '2',9.00),
				Arguments.of(2.0, ':',2.00),
				Arguments.of(2.0, '1',2.00),
				Arguments.of(1.0, '8',1.00),
				Arguments.of(2.0, '/',2.00),
				
				Arguments.of(0.0, '0',1.00),
				Arguments.of(1.0, (char)0x30,1.00),
				Arguments.of(1.0, (char)0x39,1.00),
				Arguments.of(1.0, (char)0x38,1.00),
				Arguments.of(1.0, (char)0x29,1.00),
				Arguments.of(1.0, (char)0x40,1.00),
				Arguments.of(1.0, (char)0x35,1.00),
				Arguments.of(1.0, '9',1.00),
				Arguments.of(-5.0, '3',-125.00),
				
				Arguments.of(-5.0, '0',1.00),
				Arguments.of(7.0, 'с',7.00),
				Arguments.of(1.0, '!',1.00));
		}
	
	@ParameterizedTest
	@DisplayName("Method hasCharacteristics() Test")
	@MethodSource("methodWithParameters2")
	void testHasCharacteristics(Double current, char operator, Boolean expectedValue) throws NumberNotInAreaException, NotSupportedOperationException {
		calc.setCurrentValue(current);
		Boolean result = false;
		try {
			result = calc.hasCharacteristic(operator);
		} catch (NumberNotInAreaException e) {
			//e.printStackTrace();
		} catch (NotSupportedOperationException e) {
			//e.printStackTrace();
		}
		assertThat(result, is(equalTo(expectedValue)));
	}
	private static Stream<Arguments> methodWithParameters2() {
		return Stream.of(
				Arguments.of(5.0 ,'S', false),
				Arguments.of(371.00,'A',true),
				Arguments.of(12.00,'A',false),
				Arguments.of(-1.0, 'P',false),
				Arguments.of(5.0, 'P',false),
				Arguments.of(0.0, 'A',false),
				Arguments.of(1.0, 'A',true),
				Arguments.of(1.0, 'P',false),
				Arguments.of(0.0, 'P',false),
				Arguments.of(2.0, 'P',false),
				Arguments.of(2.0, 'A',false),
				Arguments.of(-1.0, 'A',false),
				Arguments.of(6.120, 'P',true),
				Arguments.of(1.0, '!',false));
		}
	
	@Test
	@DisplayName("calculateAdvanced() Exception Test")
	void testCalculateAdvancedException() throws NumberNotInAreaException, NotSupportedOperationException{

		//Test NumberNotInAreaException
		calc.setCurrentValue(-8.00);
        Exception exception1 = assertThrows(NumberNotInAreaException.class,() -> calc.calculateAdvanced('!'));
        assertThat(exception1, is(instanceOf(NumberNotInAreaException.class)));
        
		calc.setCurrentValue(18.00);
        Exception exception2 = assertThrows(NumberNotInAreaException.class,() -> calc.calculateAdvanced('!'));
        assertThat(exception2, is(instanceOf(NumberNotInAreaException.class)));
        
        //Test NotSupportedOperationException
      	calc.setCurrentValue(8.00);
        Exception exception3 = assertThrows(NotSupportedOperationException.class,() -> calc.calculateAdvanced('A'));
        assertThat(exception3, is(instanceOf(NotSupportedOperationException.class)));
        
      	calc.setCurrentValue(8.00);
        Exception exception4 = assertThrows(NotSupportedOperationException.class,() -> calc.calculateAdvanced('$'));
        assertThat(exception4, is(instanceOf(NotSupportedOperationException.class)));
	}
	
	@Test
	@DisplayName("hasCharacteristics() Exception Test")
	void hasCharacteristicsException() {
		//Test NumberNotInAreaException
		calc.setCurrentValue(-8.00);
		Exception exception1 = assertThrows(NumberNotInAreaException.class,() -> calc.hasCharacteristic('A'));
		assertThat(exception1, is(instanceOf(NumberNotInAreaException.class)));
		
		calc.setCurrentValue(-1.00);
        Exception exception2 = assertThrows(NumberNotInAreaException.class,() -> calc.hasCharacteristic('P'));
        assertThat(exception2, is(instanceOf(NumberNotInAreaException.class)));
        
        //Test NotSupportedOperationException
      	calc.setCurrentValue(8.00);
        Exception exception3 = assertThrows(NotSupportedOperationException.class,() -> calc.hasCharacteristic('W'));
        assertThat(exception3, is(instanceOf(NotSupportedOperationException.class)));
        
		
	}

}
