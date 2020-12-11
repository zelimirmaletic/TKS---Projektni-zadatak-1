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
		calc.calculateAdvanced(operator);
		assertThat(calc.getCurrentValue(), is(equalTo(expectedValue)));
	}
	private static Stream<Arguments> methodWithParameters1() {
		return Stream.of(
				Arguments.of(5.2540 ,'!', 120.0),
				Arguments.of(0.0,'!',1.00),
				Arguments.of(-5.320, '!',-5.320),
				Arguments.of(2.0, '2',4.00),
				Arguments.of(0.0, '0',1.00),
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
		Boolean result = calc.hasCharacteristic(operator);
		assertThat(result, is(equalTo(expectedValue)));
	}
	private static Stream<Arguments> methodWithParameters2() {
		return Stream.of(
				Arguments.of(5.0 ,'S', false),
				Arguments.of(371.00,'A',true),
				Arguments.of(-5.0, 'P',false),
				Arguments.of(0.0, 'A',false),
				Arguments.of(6.120, 'P',true),
				Arguments.of(1.0, '!',false));
		}

}
