package test;

import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import expression.AnalyseEquation;
import fr.lorraine.univ.tp.Calculator;
import junit.framework.TestCase;

public class TestJavaProject extends TestCase {
	Calculator calculatrice = new Calculator();
	@Test
	public void testValidationExpression(){
		assertThrows(ArithmeticException.class, ()->calculatrice.solve("(2+3") );
		assertThrows(ArithmeticException.class, ()->calculatrice.solve("+8*/7"));
		assertThrows(ArithmeticException.class, ()->calculatrice.solve("++8"));
		assertThrows(ArithmeticException.class, ()->calculatrice.solve("+8*"));
		assertThrows(ArithmeticException.class, ()->calculatrice.solve(")(0+1"));
		assertThrows(ArithmeticException.class, ()->calculatrice.solve(")127("));
		assertThrows(ArithmeticException.class, ()->calculatrice.solve("...+5"));
		assertThrows(ArithmeticException.class, ()->calculatrice.solve("2      3"));
		assertThrows(ArithmeticException.class, ()->calculatrice.solve("a+2*3"));
	    assertEquals(125.0, calculatrice.solve("122+3"));
	}
	@Test
	public void testConversionPolonaise() {
		assertEquals("[1.0, 8.0, 3.0, -, *, 3.0, *, 3.0, 1.0, -, 2.0, *, 3.0, *, +]", AnalyseEquation.conversionEnNotationPolonnaise("1*(8-3)*3+((3-1)*2)*3").toString());
		assertEquals("[5.0, 8.0, 3.0, -, *]", AnalyseEquation.conversionEnNotationPolonnaise("5*(8-3)").toString());
	}
	@Test
	public void testCaclul() {
		assertEquals(8.0, calculatrice.solve("5+3"));
		assertEquals(-6.0, calculatrice.solve("-(+6)"));
		assertEquals(27.0, calculatrice.solve("1*(8-3)*3+((3-1)*2)*3"));
		assertEquals(-7.0, calculatrice.solve("+(-7  )"));
		assertEquals(1.25, calculatrice.solve("5/4"));
		assertEquals(6.25, calculatrice.solve("25/4"));
		assertEquals(648.0, calculatrice.solve("50+(300-1)*2"));
	}
}
