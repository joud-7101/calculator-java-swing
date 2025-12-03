/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calc;

/**
 *
 * @author Asus
 */
public class DotCommand implements Command {

    private final Calculator calc;

    public DotCommand(Calculator calc) {
        this.calc = calc;
    }


    @Override
    public void execute() {

        CalculatorCaretaker.save(calc.saveState());

        String current = calc.getCurrent();
        calc.clearCurrentIfError();

        if (current == null || current.isBlank()) {
            calc.appendNumber("0.");
        }
        else {
            calc.appendNumber(".");
        }
    }
}
