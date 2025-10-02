package thecalculatorsystem;

/*
 * This class demonstrates the **Factory Method Design Pattern**.

 * Purpose in this project:
 *    - Instead of hardcoding 'new AddOperation()', 'new SubtractOperation()', etc.
 *      inside the Calculator class, we delegate object creation to this Factory.
 */

public class OperationFactory {
    
    public static Operation create(String symbol) {
        if (symbol == null) {
            throw new IllegalArgumentException("Operator is null");
        }
        symbol = symbol.trim();
        switch (symbol) {
            case "+":              return new AddOperation();
            case "-":              return new SubtractOperation();
            case "×": case "*":    return new MultiplyOperation();
            case "÷": case "/":    return new DivideOperation();
            default:
                throw new IllegalArgumentException(
                    "Unknown operator: " + symbol + " (expected +, -, ×, ÷, *, /)"
                );
        }
    }
}