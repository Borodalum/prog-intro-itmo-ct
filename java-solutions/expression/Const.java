package expression;

public class Const implements AbstractExpression {
    private final int value;
    public Const(int value) {
        this.value = value;
    }

    public int evaluate(int x) {
        return value;
    }
    public String toString() {
        return String.valueOf(value);
    }
    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object otherExp) {
        return (otherExp instanceof Const) && ((Const)otherExp).getValue() == this.value;
    }
    @Override
    public int hashCode() {
        return value;
    }
}