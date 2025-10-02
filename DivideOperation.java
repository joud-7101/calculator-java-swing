package thecalculatorsystem;



public final class DivideOperation implements Operation {
    @Override
    public float applyOperation(float a, float b) {
        if (b == 0f) throw new ArithmeticException("Division by zero");
        return a / b;
    }
}