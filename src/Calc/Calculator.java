package Calc;


public final class Calculator {

    private static Calculator instance = new Calculator();

    public static Calculator getInstance() { 
        return instance; 
    }

    private String currentOperand;

    private String previousOperand;

    private String operation;

    private Calculator() { 
        clear(); 
    }

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
            this.compute(); 
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
            Operation op = OperationFactory.create(this.operation);

            op = new HistoryDecorator(op);

            result = op.applyOperation(prev, curr);
        } catch (ArithmeticException ex) {
            clear();
            this.currentOperand = "Error";
            return;
        } catch (IllegalArgumentException ex) {
            return;
        }

        this.currentOperand = (result - (int) result) != 0
                ? Float.toString(result)
                : Integer.toString((int) result);

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
            this.currentOperand = (tmp - (int) tmp) != 0 
                    ? Float.toString(tmp) 
                    : Integer.toString((int) tmp);
        }
    }

    public String getCurrent()   { return currentOperand; }
    public String getPrevious()  { return previousOperand; }
    public String getOperation() { return operation; }

    public void clearCurrentIfError() {
        if ("Error".equals(currentOperand)) currentOperand = "";
    }

    public CalculatorMemento saveState() {
        return new CalculatorMemento(
            this.currentOperand,
            this.previousOperand,
            this.operation
        );
    }
    public void restoreState(CalculatorMemento memento) {
        if (memento == null) return;
        this.currentOperand   = memento.getCurrent();
        this.previousOperand  = memento.getPrevious();
        this.operation        = memento.getOperation();
    }
}
