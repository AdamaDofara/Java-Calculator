package opérateurs;

import expression.Expression;
import expression.ExpressionBinaire;


public class Division extends ExpressionBinaire {

	public Division(Expression terme_gauche, Expression terme_droit) {
		super(terme_gauche, terme_droit);
	}

	@Override
	public double evaluate()  {
		// TODO Auto-generated method stub
		return this.getTerme_gauche().evaluate()/this.getTerme_droit().evaluate();
	}
	


	
	
}
