package Calc;

import java.util.List;

public class CalculatorFacade {

    private static final Calculator calc = Calculator.getInstance();

    public static void appendDigit(String digit) {
        Command cmd = new AppendDigitCommand(calc, digit);
        cmd.execute();
    }

    public static void appendDot() {
        Command cmd = new DotCommand(calc);
        cmd.execute();
    }

    public static void chooseOperation(String op) {
        Command cmd = new ChooseOperationCommand(calc, op);
        cmd.execute();
    }

    public static void compute() {
        Command cmd = new ComputeCommand(calc);
        cmd.execute();
    }

    public static void clear() {
        Command cmd = new ClearCommand(calc);
        cmd.execute();
    }

    public static void backspace() {
        Command cmd = new BackspaceCommand(calc);
        cmd.execute();
    }

    public static void toggleSign() {
        Command cmd = new ToggleSignCommand(calc);
        cmd.execute();
    }

    public static boolean undo() {
        CalculatorMemento m = CalculatorCaretaker.undo();
        if (m == null) {
            return false;
        }
        calc.restoreState(m);
        return true;
    }

    public static String getCurrent() {
        return calc.getCurrent();
    }

    public static String getPrevious() {
        return calc.getPrevious();
    }

    public static String getOperation() {
        return calc.getOperation();
    }

    public static List<String> getHistory() {
        return HistoryDecorator.getHistory();
    }
}
