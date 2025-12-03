package Calc;




public class OperationFactory {
    
    public static Operation create(String symbol) {
        if (symbol == null) {
            throw new IllegalArgumentException("Operator is null");}
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