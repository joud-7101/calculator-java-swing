package thecalculatorsystem;

/*
 * Calculator.java: the logic of the code
 *
 * PATTERNS USED HERE:
 *   1) **Singleton (Eager)**
 *        - Exactly one Calculator instance used across the app.
 *
 *   2) **Factory Method (via OperationFactory)**
 *        - The Calculator is the **Client** of the factory.
 *        - It asks the factory: “Given this operator symbol (‘+’, ‘-’, ‘×’, ‘÷’),
 *          give me the corresponding Operation object.”
 *        - The factory returns a **Concrete Product** (AddOperation, SubtractOperation, …),
 *          which implements the **Product** interface (Operation).
 */

public final class Calculator {

  
    // =========================
    // 1) SINGLETON (EAGER)
    // =========================
    private static Calculator instance = new Calculator();
    public static Calculator getInstance() { return instance; }

   
    private String currentOperand;   
    private String previousOperand;  
    private String operation;        

    // Private constructor
    private Calculator() { clear(); }


    public void clear() {
        this.currentOperand = "";
        this.previousOperand = "";
        this.operation = "";
    }


    public void appendNumber(String number) {
        if ("0".equals(this.currentOperand) && "0".equals(number)) return;
        if (".".equals(number) && this.currentOperand.contains(".")) return;
        if ("0".equals(this.currentOperand) && !number.equals("0") && !number.equals(".")) {
            this.currentOperand = "";
        }
        this.currentOperand += number;
    }

  
    public void chooseOperation(String operation) {
        if (this.currentOperand.equals("") && !this.previousOperand.equals("")) {
            this.operation = operation; // allow changing operator
            return;
        }
        if (this.currentOperand.equals("")) return;

        if (!this.previousOperand.equals("")) {
            this.compute(); // chain: e.g., "8 + 2 + 3"
        }

        this.operation = operation;
        this.previousOperand = this.currentOperand;
        this.currentOperand = "";
    }

 
    public void compute() {
        if (this.currentOperand.equals("") || this.previousOperand.equals("")) return;

        float curr = Float.parseFloat(this.currentOperand);
        float prev = Float.parseFloat(this.previousOperand);
        if (Float.isNaN(curr) || Float.isNaN(prev)) return;

        float result;
        try {
            // get correct operation from factory
            Operation op = OperationFactory.create(this.operation); 
            // "+", "-", "×", "÷"
            // wrap it with decorator to add history logging
            op = new HistoryDecorator(op);
            result = op.applyOperation(prev, curr);
        } catch (ArithmeticException ex) {
            // divide-by-zero -> show "Error", then clear next step
            clear();
            this.currentOperand = "Error";
            return;
        } catch (IllegalArgumentException ex) {
            // unknown operator -> do nothing
            return;
        }

        // show integers without ".0"
        this.currentOperand = (result - (int) result) != 0
                ? Float.toString(result)
                : Integer.toString((int) result);

        // reset pending state
        this.previousOperand = "";
        this.operation = "";
    }

  
    public void backspace() {
        if (!this.currentOperand.equals("")) {
            this.currentOperand = this.currentOperand.substring(0, this.currentOperand.length() - 1);
        }
    }

 
    public void toggleSign() {
        if (!this.currentOperand.isBlank()) {
            float tmp = -Float.parseFloat(this.currentOperand);
            this.currentOperand = (tmp - (int) tmp) != 0 ? Float.toString(tmp) : Integer.toString((int) tmp);
        }
    }

  

    public String getCurrent()   { return currentOperand; }
    public String getPrevious()  { return previousOperand; }
    public String getOperation() { return operation; }

 
    public void clearCurrentIfError() {
        if ("Error".equals(currentOperand)) currentOperand = "";
    }
}
