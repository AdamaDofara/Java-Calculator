package opérateurs;

public enum Operateurs {
	ADDITION('+', 1),
    SUBTRACTION('-', 1),
    MULTIPLICATION('*', 2),
    DIVISION('/', 2);

    private final char symbol;
    private final int priority;

    Operateurs(char symbol, int priority) {
        this.symbol = symbol;
        this.priority = priority;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getPriority() {
        return priority;
    }
	
}
