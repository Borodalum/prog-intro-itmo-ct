package expression;

public class Negated implements AbstractExpression {
    private final AbstractExpression exp;

    public Negated(AbstractExpression exp) {
        this.exp = exp;
    }

    public int evaluate(int x) {
        return -(exp.evaluate(x));
    }

    public int evaluate(int x, int y, int z) {
        return -(exp.evaluate(x, y, z));
    }

    protected AbstractExpression getInside() {
        return exp;
    }

    @Override
    public String toString() {
        return "-" + "(" + exp.toString() + ")";
    }

    @Override
    public boolean equals(Object exp) {
        return (exp instanceof AbstractExpression) && ((Negated) exp).getInside().equals(exp);
    }

    @Override
    public int hashCode() {
        return ("-".hashCode() * 31 + (exp.hashCode())) * 31;
    }

}
