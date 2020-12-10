package calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class CalculatorTest {
	
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
	void testCalculator() {
		assertNotNull(calc);
	}
	
	@Test
	void testGetCurrentValue() {
		calc.setCurrentValue(10.0);
		assertEquals(Double.valueOf(10.0), calc.getCurrentValue());
	}
	
	@Test
	void testCurrentValue() {
		fail("Test designed to fail.");
	}
	
	@Test
	void testSetCurrentValue() {
		calc.setCurrentValue(5.0);
		assertEquals(Double.valueOf(5.0), calc.getCurrentValue());
	}
	
	//@Test(expected = Exception.class)
	
	
	//Aserts
	/*
	 * fail("poruka")
	 * assertTrue(uslov)
	 * assertFalse(uslov)
	 * assertEquals()- poredi reference
	 * assertSame() - poredi da li reference pokazuju na isti objekat
	 * 
	 */

}
