package Calc;

public class AppendDigitCommand implements Command {

    private final Calculator calc;


    private final String digit;

    public AppendDigitCommand(Calculator calc, String digit) {
        this.calc = calc;
        this.digit = digit;
    }

    @Override
    public void execute() {
        CalculatorCaretaker.save(calc.saveState());
        calc.clearCurrentIfError();
        calc.appendNumber(digit);
    }
}

