package fr.lorraine.univ.tp;

import java.util.List;

import expression.AnalyseEquation;
import expression.Expression;

public class Calculator {
	
	public double solve(String equation) throws  ArithmeticException{
		new AnalyseEquation().analyseExpression(equation);
		List<Object> expression = AnalyseEquation.conversionEnNotationPolonnaise(equation);
		return AnalyseEquation.calculate(expression);
		
	}
}
