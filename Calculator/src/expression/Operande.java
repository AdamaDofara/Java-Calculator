package expression;



public class Operande extends Expression {
	
	private int value;
	public Operande(int value) {
		this.value = value;
	}

	@Override
	public double evaluate() throws ArithmeticException {
		// TODO Auto-generated method stub
		return value;
	}
	
	
}
