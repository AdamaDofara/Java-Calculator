package expression;


public abstract class ExpressionBinaire extends Expression {		
		protected Expression terme_gauche;
		protected Expression terme_droit;
		
		public ExpressionBinaire(Expression terme_gauche, Expression terme_droit) {
			this.terme_gauche = terme_gauche;
			this.terme_droit = terme_droit;
		}
		public Expression getTerme_gauche() {
			return terme_gauche;
		}
		public void setTerme_gauche(Expression terme_gauche) {
			this.terme_gauche = terme_gauche;
		}
		public Expression getTerme_droit() {
			return terme_droit;
		}
		public void setTerme_droit(Expression terme_droit) {
			this.terme_droit = terme_droit;
		}
		public abstract double evaluate();

}
