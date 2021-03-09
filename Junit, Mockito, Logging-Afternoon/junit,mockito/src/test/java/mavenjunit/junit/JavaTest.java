package mavenjunit.junit;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class JavaTest {
	
	
	int value1, value2;
	
	protected void setUp() {
		value1 = value2 = 3;
		
	}
	
	@Test
	public void testString() {
		String str = "Junit is working fine";
		assertEquals("Junit is working fine", str);
	}

	@Before
	public void testSum() {
		System.out.println("This is before every test case");
		
	}
	
	@AfterClass
	public static void checkAfterClass() {
		System.out.println("This will run after the test class");
	}

}
