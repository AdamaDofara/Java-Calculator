package opérateurs;

import expression.Expression;
import expression.ExpressionBinaire;


public class Addition extends ExpressionBinaire {

	public Addition(Expression terme_gauche, Expression terme_droit) {
		super(terme_gauche, terme_droit);
	}

	@Override
	public double evaluate() throws ArithmeticException {
		// TODO Auto-generated method stub
		return this.getTerme_gauche().evaluate() - this.getTerme_droit().evaluate();
	}

	
	
}
